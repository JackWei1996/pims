/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: UserParameter.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年1月31日        | Aisino)Jack    | original version
 */
package com.pims.entity;

import lombok.Data;

/**
 * class name: UserParameter <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年1月31日 下午1:14:53
 * @author Aisino)weihaohao
 */
@Data
public class UserParameter extends BaseBean {
	/**
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String userName;
	private Integer post;
}
