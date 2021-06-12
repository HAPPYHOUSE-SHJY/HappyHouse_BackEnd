package com.ssafy.vue.dto;

public class StoreInfoDto { // 상가정보
	
	/*상호명*/
	private String name;
	/*분류*/
	private String section;
	/*구/군*/
	private String gu;
	/*동*/
	private String dong;
	/*도로명주소*/
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}