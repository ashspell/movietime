package com.ashspell.movie.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class NoticeController {
	
	@GetMapping("/notice_view")
	
	public String noticeview() {
		return "/movie/notice/notice";
	}
	
	@GetMapping("/noticedetail_view") 
	
	public String noticedetail() {
		return "/movie/notice/noticedetail";
	}
	
	
}
