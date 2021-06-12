package com.ssafy.vue.dto;

import java.util.Date;

public class Comment {
	private int no;
	private int boardno;
	private String content;
	private Date regtime;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", boardno=" + boardno + ", content=" + content + ", regtime="
				+ regtime + "]";
	}
	
}	