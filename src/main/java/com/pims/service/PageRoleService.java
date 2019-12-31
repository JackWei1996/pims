package com.pims.service;

public interface PageRoleService {

	boolean delPageRoleByRoleId(Integer id);

	boolean addPageRoles(Integer roleId, Integer[] pageIds);

}
