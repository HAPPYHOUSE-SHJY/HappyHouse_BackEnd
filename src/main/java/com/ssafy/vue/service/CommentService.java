package com.ssafy.vue.service;

import java.util.List;
import com.ssafy.vue.dto.Comment;

public interface CommentService {
	public List<Comment> selectCommentByBoardno(int boardno);
	public boolean insertComment(Comment comment);
	public boolean updateComment(Comment comment);
	public boolean deleteComment(int no);
}
