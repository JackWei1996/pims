package com.pims.service;


import com.pims.entity.UserRole;
import com.pims.model.ResultMap;

import java.util.List;

public interface UserRoleService {
	List<UserRole> getRoleByUserId(String userId);

	boolean delUserRoleByRoleId(int id);

	ResultMap delUserRoleByUserIdAndRoleId(String userId, Integer roleId);

	String addUserRole(Integer roleId, String[] userIds);

	UserRole getUserRole(String userId);
}
