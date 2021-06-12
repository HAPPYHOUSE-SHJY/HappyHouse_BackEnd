package com.ssafy.vue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.Notice;
@Mapper
public interface NoticeDAO {
	public List<Notice> selectNotice();
	public Notice selectNoticeByNo(int no);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int no);
	public List<Notice> briefNotice();
}