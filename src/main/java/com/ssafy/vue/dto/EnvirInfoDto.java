package com.ssafy.vue.dto;

public class EnvirInfoDto {
	/*업체명*/
	private String name;
	/*업종코드*/
	private int scode;
	/*업종명*/
	private String sname;
	/*지도점검일*/
	private String mchkdate;
	/*시군구*/
	private String sigungu;
	/*지도점검구분*/
	private String mapgubun;
	/*지도점검일*/
	private String chkspec;
	/*소재지주소*/
	private String locaddr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMchkdate() {
		return mchkdate;
	}
	public void setMchkdate(String mchkdate) {
		this.mchkdate = mchkdate;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getMapgubun() {
		return mapgubun;
	}
	public void setMapgubun(String mapgubun) {
		this.mapgubun = mapgubun;
	}
	public String getChkspec() {
		return chkspec;
	}
	public void setChkspec(String chkspec) {
		this.chkspec = chkspec;
	}
	public String getLocaddr() {
		return locaddr;
	}
	public void setLocaddr(String locaddr) {
		this.locaddr = locaddr;
	}
}