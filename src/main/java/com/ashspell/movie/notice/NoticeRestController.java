package com.ashspell.movie.notice;




import java.util.HashMap;

import java.util.Map;


import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashspell.movie.notice.bo.NoticeBO;
import com.ashspell.movie.notice.model.Notice;
import com.mysql.cj.xdevapi.Result;

@RestController
@RequestMapping("/movietime")
public class NoticeRestController {

	
	
	@Autowired
	private NoticeBO noticeBO;
	
	
	@PostMapping("/adminupload")
	
	public Map<String, String> adminupload(
			@RequestParam("noticetitle") String noticetitle,
			@RequestParam("noticecontent") String noticecontent
			) {
		
		
		Map<String, String> result = new HashMap<>();
		
		int count = noticeBO.addAdminPost(noticetitle, noticecontent);
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	
	}
	
	

	@GetMapping("/delete")
	
	public Map<String,String> deletenotice(@RequestParam("id") int id) {
		
		int count = noticeBO.deletenotice(id);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "fail");
		}else {
			result.put("result", "fail");
		
	}		
		return result;
}
	
	
	@GetMapping("/deletenotice")
	
	public Map<String, String> deletenotice(
			@RequestParam("id") int id,
			HttpServletRequest request
			) {
		
		Map<String, String> result = new HashMap<>();
		
		HttpSession session = request.getSession();
		
		int count = noticeBO.deletenotice(id);
		
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/updatenotice")
	
	public Map<String, String> updatenotice(
			@RequestParam("id") int id,
			@RequestParam("noticetitle") String noticetitle,
			@RequestParam("noticecontent") String noticecontent
			) {
		
		
		Map<String, String> result = new HashMap<>();
		
		int count = noticeBO.updatenotice(id, noticetitle, noticecontent);
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	
	}
	

}
