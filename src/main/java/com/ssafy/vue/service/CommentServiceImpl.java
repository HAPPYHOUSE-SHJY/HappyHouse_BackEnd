package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dao.BoardDAO;
import com.ssafy.vue.dao.CommentDAO;
import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
	private CommentDAO commentDao;


	@Override
	public List<Comment> selectCommentByBoardno(int boardno) {
		return commentDao.selectCommentByBoardno(boardno);
	}

	@Override
	public boolean insertComment(Comment comment) {
		return commentDao.insertComment(comment) == 1;
	}

	@Override
	@Transactional
	public boolean updateComment(Comment comment) {
		return commentDao.updateComment(comment) == 1;
	}
	
	@Override
	@Transactional
	public boolean deleteComment(int no) {
		return commentDao.deleteComment(no) == 1;
	}

	
}