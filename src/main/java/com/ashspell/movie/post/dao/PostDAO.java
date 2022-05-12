package com.ashspell.movie.post.dao;




import java.util.List;



import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.ashspell.movie.post.model.Post;



@Repository
public interface PostDAO {

	public int insertpost(
			@Param("title") String title,
			@Param("loginid") String loginid,
			@Param("content") String content
			
			);
	
	public List<Post> selectPostList();
	
	public Post selectpost (@Param("id") int id);
	
	public int deletepost(@Param("id") int id);
	
	public int updatepost(
			@Param("id") int id,
			@Param("title") String title,
			@Param("content") String content
			
			);
	
	
	
	

}
	
	
	

