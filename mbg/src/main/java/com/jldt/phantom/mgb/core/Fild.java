package com.jldt.phantom.mgb.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fild {

	/**字段类型*/
	private String type;
	/** 字段*/
	private String fild;
	/** 字段注释*/
	private String fildComment;
	/** 属性*/
	private String property;
	/** 原始列名*/
	private String columnName;
	
}