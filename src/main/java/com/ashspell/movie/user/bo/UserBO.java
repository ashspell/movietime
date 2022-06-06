package com.ashspell.movie.user.bo;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.ashspell.movie.common.EncryptUtils;
import com.ashspell.movie.user.dao.UserDAO;
import com.ashspell.movie.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	

	
	public int addUser(
			String loginid,
			String password,
			String email,
			String name
			) {
		
		String encryptpassword =  EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginid, encryptpassword, email, name);
		
		
	}
	
	public User user(
			String loginid ,
			String password
			) {
	
		String encryptpassword =  EncryptUtils.md5(password);
		
		return userDAO.selectUser(loginid, encryptpassword);
	}
	
	public boolean isDuplicateId(String loginid) {
		
		int count = userDAO.selectCountByloginId(loginid);
			
		if(count == 0) { //아이디 중복체크를 해서 중복수가 0이면 
			return false;
		}else {
			return true;
		}
		
	}
	
	
	
	
}
