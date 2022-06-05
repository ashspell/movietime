package com.ashspell.movie.notice.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ashspell.movie.notice.model.Notice;

@Repository
public interface NoticeDAO {
	

	public int insertAdminPost(
			
			@Param("noticetitle") String noticetitle,
			@Param("noticecontent") String noticecontent
			);

	public List<Notice> selectNoticeList();
	
	public Notice selectnotice (@Param("id") int id);
	

	
	public int deletenotice(
			@Param("id") int id
			
			);
	
	public int updatenotice (
			@Param("id") int id,
			@Param("noticetitle") String noticetitle,
			@Param("noticecontent") String noticecontent					
			);

}