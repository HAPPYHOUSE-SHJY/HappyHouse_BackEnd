package com.ssafy.vue.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.MemberDAO;
import com.ssafy.vue.dto.Member;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Member> userList() {
		return sqlSession.getMapper(MemberDAO.class).userList();
	}

	@Override
	public Member userInfo(String userid) {
		return sqlSession.getMapper(MemberDAO.class).userInfo(userid);
	}

	@Override
	public int userRegister(Member memberDto) {
		return sqlSession.getMapper(MemberDAO.class).userRegister(memberDto);
	}

	@Override
	public int userModify(Member memberDto) {
		return sqlSession.getMapper(MemberDAO.class).userModify(memberDto);
	}

	@Override
	public int userDelete(String userid) {
		return sqlSession.getMapper(MemberDAO.class).userDelete(userid);
	}

	@Override
	public Member login(Member member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberDAO.class).login(member);
	}

	@Override
	public String getServerInfo() {
		// TODO Auto-generated method stub
		return "강철부대";
	}
}
