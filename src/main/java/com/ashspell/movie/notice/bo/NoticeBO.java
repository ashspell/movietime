package com.ashspell.movie.notice.bo;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.movie.notice.dao.NoticeDAO;
import com.ashspell.movie.notice.model.Notice;

@Service
public class NoticeBO {
	
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int addAdminPost(
			
			String noticetitle,
			String noticecontent
			
			) {
		
		return noticeDAO.insertAdminPost(noticetitle, noticecontent);
	}
	
	public List<Notice> getnoticelist() {
		
		return noticeDAO.selectNoticeList();
	}
	

	public Notice getnotice(int id) {
		
		return noticeDAO.selectnotice(id);
	}
	
	public int deletenotice(int id) {
		
		return noticeDAO.deletenotice(id);
	}

	public int updatenotice( int id, String noticetitle, String noticecontent) {
		
		return noticeDAO.updatenotice(id, noticetitle, noticecontent);
	}
}