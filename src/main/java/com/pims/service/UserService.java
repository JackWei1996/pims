package com.pims.service;

import com.pims.entity.User;
import com.pims.entity.UserParameter;
import com.pims.model.ResultMap;

import java.util.List;

public interface UserService {
	User selectUserByUserId(String userId);

	public ResultMap login(String username, String password);

	public boolean checkUserPassword(String password);

	public String updatePassword(String password);

	Object getAllUserByRoleId(Integer roleId, Integer page, Integer limit);

	Object getAllUserByNotRoleId(Integer roleId, Integer page, Integer limit);

	User selectByPrimaryKey(String userId);

	List<User> getAdmins();

	Object getAllUserByLimit(UserParameter userParameter);

	void delUserById(String id);

	void addUser(User user) throws Exception;

	String updateUser(String oldId, User user);

	String updateUser(User user);

	List<User> getAllUser();

	User getAdminById(String userId);

	Object getAllDelUserByLimit(UserParameter userParameter);

	String getName(String issueReporter);

	List<User> selectAllUser();

	User getUserByPhoneAndName(String phone, String name);
}
