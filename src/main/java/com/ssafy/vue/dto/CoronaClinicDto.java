package com.ssafy.vue.dto;

public class CoronaClinicDto {

	private int clinicID;
	private String sido;
	private String gungu;
	private String hospitalName;
	private String address;
	private String weekDayOp;
	
	public int getClinicID() {
		return clinicID;
	}
	public void setClinicID(int clinicID) {
		this.clinicID = clinicID;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGungu() {
		return gungu;
	}
	public void setGungu(String gungu) {
		this.gungu = gungu;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWeekDayOp() {
		return weekDayOp;
	}
	public void setWeekDayOp(String weekDayOp) {
		this.weekDayOp = weekDayOp;
	}
	public String getSatOp() {
		return satOp;
	}
	public void setSatOp(String satOp) {
		this.satOp = satOp;
	}
	public String getSunOp() {
		return sunOp;
	}
	public void setSunOp(String sunOp) {
		this.sunOp = sunOp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String satOp;
	private String sunOp;
	private String tel;
	
	
	
}
