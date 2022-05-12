package com.ashspell.movie.user;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashspell.movie.user.bo.UserBO;
import com.ashspell.movie.user.model.User;

@RestController
@RequestMapping("/movie	")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	
	@PostMapping("/sign_up")
	
	public Map <String, String> signup(
			@RequestParam("loginid") String loginid,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("name") String name
			) {
		
		int count = userBO.addUser(loginid, password, email, name);
		
		Map <String, String> signup = new HashMap<>();
		
		if(count == 1) {
			signup.put("result", "success");
		} else {
			signup.put("result", "fail");
		}
		
		
		return signup ;
	}

	@GetMapping("/duplicateid")
	
	public Map<String, Boolean> duplicateid (
			@RequestParam("loginid")String loginid
			){
		
		boolean duplicateid = userBO.isDuplicateId(loginid);
		
		Map<String, Boolean> isduplicate = new HashMap<>();
		
		isduplicate.put("duplicate", duplicateid);
		
		
		
		return isduplicate;
		
		
	}

	@PostMapping("/signin")
	
	public Map<String, String> signin(
			@RequestParam("loginid") String loginid,
			@RequestParam("password") String password,
			HttpServletRequest request
			) {
		
		
		Map<String, String> result = new HashMap<>();
		
		User user = userBO.user(loginid, password);
		
		if(user != null) {
			result.put("result", "success");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", user.getId());
			session.setAttribute("loginid", user.getLoginid());
			
			
			
			
		}else {
			result.put("result", "fail");
		}
		
		
		
		return result;
		
		
		
  }

}
