package com.jldt.phantom.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.jldt.phantom.admin.dto.UmsAdminParam;
import com.jldt.phantom.admin.dto.UpdateAdminPasswordParam;
import com.jldt.phantom.admin.mapper.UmsAdminMapper;
import com.jldt.phantom.admin.service.*;
import com.jldt.phantom.common.api.CommonResult;
import com.jldt.phantom.common.api.ResultCode;
import com.jldt.phantom.common.base.BaseServiceImpl;
import com.jldt.phantom.common.constant.AuthConstant;
import com.jldt.phantom.common.domain.UserDto;
import com.jldt.phantom.common.exception.Asserts;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminEntity;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminLoginLogEntity;
import com.jldt.phantom.common.facade.entity.admin.UmsAdminRoleRelationEntity;
import com.jldt.phantom.common.utils.BeanUtil;
import com.jldt.phantom.mgb.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @Copyright (C), 2018, 久瓴（上海）科技有限公
 * @ProjectName: Phantom
 * @FileName: UmsAdminService.java
 * @Author: system
 * @Date: 2022年03月14日 13时54分19秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | shijunpeng@jlkj.net
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends BaseServiceImpl<UmsAdminEntity> implements UmsAdminService {

    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsAdminLoginLogService umsAdminLoginLogService;

    @Autowired
    private AuthService authService;

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Autowired
    private HttpServletRequest request;

    private final UmsAdminMapper umsAdminMapper;

    public UmsAdminServiceImpl(UmsAdminMapper umsAdminMapper) {
        super(umsAdminMapper);
        this.umsAdminMapper = umsAdminMapper;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        Example example = new Example(UmsAdminEntity.class);
        example.createCriteria().andEqualTo(UmsAdminEntity.USER_NAME);
        List<UmsAdmin> adminList = BeanUtil.turnToDtos(UmsAdmin.class, umsAdminMapper.selectByExample(example));
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdminEntity> umsAdminEntities = umsAdminMapper.select(UmsAdminEntity.builder()
                .username(umsAdmin.getUsername())
                .build());
        if (umsAdminEntities.size() > 0) {
            return null;
        }
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminMapper.insertSelective(BeanUtil.turnToDto(UmsAdminEntity.class, umsAdmin));
        return umsAdmin;
    }

    @Override
    public CommonResult<?> login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        CommonResult<?> restResult = authService.getAccessToken(params);
        if (ResultCode.SUCCESS.getCode() == restResult.getCode() && restResult.getData() != null) {
            insertLoginLog(username);
        }
        return restResult;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) {
            return;
        }
        UmsAdminLoginLogEntity loginLog = new UmsAdminLoginLogEntity();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        umsAdminLoginLogService.insertSelective(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        UmsAdminEntity record = new UmsAdminEntity();
        record.setLoginTime(new Date());
        Example example = new Example(UmsAdminEntity.class);
        example.createCriteria().andEqualTo(UmsAdminEntity.USER_NAME, username);
        umsAdminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public UmsAdmin getItem(Long id) {

        return BeanUtil.turnToDto(UmsAdmin.class, umsAdminMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        return BeanUtil.turnToDtos(UmsAdmin.class, umsAdminMapper.selectByExample(example));
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdminEntity rawAdmin = umsAdminMapper.selectByPrimaryKey(id);
        if (rawAdmin.getPassword().equals(admin.getPassword())) {
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        } else {
            //与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(admin.getPassword())) {
                admin.setPassword(null);
            } else {
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = umsAdminMapper.updateByPrimaryKeySelective(BeanUtil.turnToDto(UmsAdminEntity.class, admin));
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = umsAdminMapper.deleteByPrimaryKey(id);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        umsAdminRoleRelationService.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            umsAdminRoleRelationService.insertList(BeanUtil.turnToDtos(UmsAdminRoleRelationEntity.class, list));
        }
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {

        return umsAdminRoleRelationService.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {

        return umsAdminRoleRelationService.getResourceList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if (StrUtil.isEmpty(param.getUsername())
                || StrUtil.isEmpty(param.getOldPassword())
                || StrUtil.isEmpty(param.getNewPassword())) {
            return -1;
        }
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        List<UmsAdminEntity> adminList = umsAdminMapper.selectByExample(example);
        if (CollUtil.isEmpty(adminList)) {
            return -2;
        }
        UmsAdminEntity umsAdmin = adminList.get(0);
        if (!BCrypt.checkpw(param.getOldPassword(), umsAdmin.getPassword())) {
            return -3;
        }
        umsAdmin.setPassword(BCrypt.hashpw(param.getNewPassword()));
        umsAdminMapper.updateByPrimaryKey(umsAdmin);
        adminCacheService.delAdmin(umsAdmin.getId());
        return 1;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsRole> roleList = getRoleList(admin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(admin, userDTO);
            if (CollUtil.isNotEmpty(roleList)) {
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }

    @Override
    public UmsAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StrUtil.isEmpty(userStr)) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsAdmin admin = adminCacheService.getAdmin(userDto.getId());
        if (admin == null) {
            admin = BeanUtil.turnToDto(UmsAdmin.class, umsAdminMapper.selectByPrimaryKey(userDto.getId()));
            adminCacheService.setAdmin(admin);
        }
        return admin;
    }

}
