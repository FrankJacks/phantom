package com.jldt.phantom.service;

import com.jldt.phantom.dto.OssCallbackResult;
import com.jldt.phantom.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * Created by 史俊鹏 on 2021/12/17.
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
