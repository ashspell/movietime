package com.ashspell.movie.user.dao;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import com.ashspell.movie.user.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("loginid") String loginid,
			@Param("password") String password,
			@Param("email") String email,
			@Param("name") String name
			);
	
	public User selectUser(
			@Param("loginid") String loginid,
			@Param("password") String password);
	
	
	public int selectCountByloginId(@Param("loginid")String loginid);
	
}
