package com.radiotherapy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.radiotherapy.model.User;
import com.radiotherapy.model.conditionModel.UserCondition;

/*
 * 用户Dao层接口
 * @author peach
 * @time 2017-09-20 11:09:40
 * @version 0.1
 */
public interface UserDao {
	/*
	 * 根据账号获取唯一用户
	 * 
	 * @param number the String 代表用户的账号
	 * 
	 * @return the User 该账号的用户，不存在返回null
	 */
	public User getUserByNumber(@Param("number") String number);

	/*
	 * 根据条件获取所有符合条件的用户
	 * 
	 * @param condition the UserCondition 用户条件
	 * 
	 * @return the User List 所有符合条件的用户
	 */
	public List<User> getAllUser(@Param("condition") UserCondition condition);

	/*
	 * 新增用户
	 * @param the User 待新增的用户
	 * @return 影响的条数，成功则为1
	 */
	public int addUser(@Param("user") User user);
	// public int updateUser(@Param("user")User user);
}
