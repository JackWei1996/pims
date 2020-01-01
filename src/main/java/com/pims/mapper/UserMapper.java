package com.pims.mapper;

import com.pims.entity.User;
import com.pims.entity.UserExample;
import com.pims.entity.UserParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int countAllUserByRoleId(Integer roleId);
    
    List<User> getAllUserByRoleId(Integer roleId, Integer begin, Integer count);

	int countAllUserByNotRoleId(Integer roleId);

	List<User> getAllUserByNotRoleId(Integer roleId, Integer begin, Integer count);

	String getName(@Param("userId") String userId);

    List<User> getAllUserByLimit(UserParameter userParameter);

    int countAllUserByLimit(UserParameter userParameter);

    List<User> getAllDelUserByLimit(UserParameter userParameter);

    int countAllDelUserByLimit(UserParameter userParameter);

	List<User> selectAllTea();

	List<User> selectAllUser();

    User getByName(String username);

    User getUserByPhoneAndName(@Param("phone") String phone, @Param("name")String name);

    User selectByIdCard(@Param("idCard") String idCard);
}