package com.ashspell.movie.notice;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashspell.movie.notice.bo.NoticeBO;
import com.ashspell.movie.notice.model.Notice;

@Controller
@RequestMapping("/movie")
public class NoticeController {
	
	
	@Autowired
	private NoticeBO noticeBO;
	
	@GetMapping("/notice_view")
	public String noticeview(Model model ) {
		
		
		
		List<Notice> noticelist = noticeBO.getnoticelist();
		
		model.addAttribute("noticelist" ,noticelist);
		
		
		
		return"/project/notice/notice";
		
	}
	
	@GetMapping("/noticeupload_view")
	public String noticeupload() {
		return"/project/notice/noticeupload";
	}
	
	
	@GetMapping("/noticedetail_view") 
	public String noticedetail(@RequestParam("id") int id,Model model) {
			
		Notice noticedetail = noticeBO.getnotice(id);
		
		model.addAttribute("noticedetail", noticedetail);
		
		
		return "/project/notice/notice_detail";
	}
	
	@GetMapping("/noticeupdate_view")
	public String updatenotice(@RequestParam("id") int id, Model model)  {
	
		
		Notice noticeupdate = noticeBO.getnotice(id);
		
		model.addAttribute("noticedetail", noticeupdate);
		
		return "/project/notice/noticeupdate";
		}

	
}