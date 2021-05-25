package com.ssafy.vue.service;

import java.util.List;
import java.util.Map;

import com.ssafy.vue.dto.Member;

public interface UserService {

	public Member login(Member member) throws Exception;
	public String getServerInfo();
//	REST 
	public List<Member> userList();
	public Member userInfo(String userid);
	public int userRegister(Member memberDto);
	public int userModify(Member memberDto);
	public int userDelete(String userid);
}
