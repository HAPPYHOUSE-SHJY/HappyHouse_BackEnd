package com.ssafy.vue.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.vue.dto.Member;

public interface MemberDAO {

	public Member login(Member member) throws SQLException;
	
//	REST
	public List<Member> userList();
	public Member userInfo(String userid);
	public int userRegister(Member memberDto);
	public int userModify(Member memberDto);
	public int userDelete(String userid);
	public int updatePassword(Member member);
}
