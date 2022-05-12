package com.ashspell.movie.post.bo;






import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.movie.post.dao.PostDAO;
import com.ashspell.movie.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	public int addPost(
			 String title,
			 String loginid,
			 String content
			 ) {
		
		
		
		return postDAO.insertpost(title,  loginid, content);
		
	}
	
	public List<Post> getpostlist() {
		
		return postDAO.selectPostList();	
		
	}
	
	public Post getpost(int id) {
		
		return postDAO.selectpost(id);
	}
	
	public int deletepost(int id) {
		
		return postDAO.deletepost(id);
	}
	
	public int updatepost(int id, String title, String content) {
		
		return postDAO.updatepost(id, title, content);
	}
	

 
	
	

		
	
}
