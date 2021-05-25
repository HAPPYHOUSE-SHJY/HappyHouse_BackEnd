package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.vue.dto.Member;
import com.ssafy.vue.service.JwtService;
import com.ssafy.vue.service.UserService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "모든 회원 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Member>> userList() throws Exception {
		logger.debug("userList - 호출");
		return new ResponseEntity<List<Member>>(userService.userList(), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보를 반환한다", response = Member.class)
	@GetMapping("{userid}")
	public ResponseEntity<Member> userInfo(@PathVariable String userid) {
		logger.debug("userInfo - 호출");
		return new ResponseEntity<Member>(userService.userInfo(userid), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보를 등록한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> userRegister(@RequestBody Member member) {
		logger.debug("userRegister - 호출");
		if (userService.userRegister(member) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원 정보를 수정한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> userModify(@RequestBody Member member) {
		logger.debug("userModify - 호출");
		if (userService.userModify(member) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{userid}")
	public ResponseEntity<String> userDelete(@PathVariable String userid) {
		logger.debug("userDelete - 호출");
		if (userService.userDelete(userid) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Member member, HttpServletResponse response,
			HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("로그인");
		HttpStatus status = null;
		try {
			Member loginUser = userService.login(member);

			if (loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);

//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
				resultMap.put("is-admin", loginUser.getIsAdmin());
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/info")
	public ResponseEntity<Member> getInfo(HttpServletRequest req) {
		Map<String, String> resultMap = new LinkedHashMap<>();
		resultMap.putAll((Map<? extends String, ? extends String>) jwtService.get(req.getHeader("auth-token")).get("user"));
		
		return new ResponseEntity<Member>(userService.userInfo(resultMap.get("userid")), HttpStatus.OK);
	}
}
