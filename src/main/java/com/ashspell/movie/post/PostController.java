package com.ashspell.movie.post;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashspell.movie.post.bo.PostBO;
import com.ashspell.movie.post.model.Post;

@Controller
@RequestMapping("/movie")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/main_view")
	public String mainview() {
		return "/movie/post/mainview";
	}
	

	
	@GetMapping("/listupload_view")
	public String uploadview() {
		return"/movie/post/upload";
	}
	
	@GetMapping("/list_view")
	public String listview(Model model) {
		
		
		
			
			List<Post> postlist = postBO.getpostlist();
			
			model.addAttribute("postlist", postlist);
		
			
		return "/movie/post/list";
		
		
	}
	
	@GetMapping("/listdetail_view")
	public String listdetail(@RequestParam("id") int id, Model model) {
		
		Post postdetail = postBO.getpost(id);
		
		model.addAttribute("postdetail", postdetail);
		
		
		return "/movie/post/listdetail";
	}
	
	@GetMapping("/listupdate_view")
	public String listupdate(@RequestParam("id") int id, Model model) {
		
		Post postupdate = postBO.getpost(id);
		
		model.addAttribute("postupdate", postupdate);
		
		return "/movie/post/listupdate";
	}
	

	
	
	
}
