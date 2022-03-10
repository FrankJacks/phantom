package com.jldt.phantom.facade.entity.admin;

import com.jldt.phantom.common.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: CmsHelpEntity.java
 * @Author: system
 * @Date: 2021年12月24日 16时23分37秒
 * @Description:
 * @email ==>> quzhigang@midaigroup.com | jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "cms_help")
public class CmsHelpEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
			 /** */
    @Column(name = "category_id")
    private Integer categoryId;
			 /** */
    @Column(name = "icon")
    private String icon;
			 /** */
    @Column(name = "title")
    private String title;
			 /** */
    @Column(name = "show_status")
    private Integer showStatus;
			 	 /** */
    @Column(name = "read_count")
    private Integer readCount;
			 /** */
    @Column(name = "content")
    private String content;
			 
		
}