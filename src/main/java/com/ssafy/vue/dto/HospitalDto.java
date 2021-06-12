package com.ssafy.vue.dto;

public class HospitalDto {
	/*시도*/
	private String sido;
	/*구군*/
	private String gugun;
	/*안심병원 이름*/
	private String name;
	/*안심병원 도로명주소*/
	private String address;
	/*안심병원 전화번호*/
	private String tel;
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
