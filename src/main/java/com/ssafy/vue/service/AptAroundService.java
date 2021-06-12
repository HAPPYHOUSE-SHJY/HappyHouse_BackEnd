package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.CoronaClinicDto;
import com.ssafy.vue.dto.EnvirInfoDto;
import com.ssafy.vue.dto.HospitalDto;
import com.ssafy.vue.dto.StoreInfoDto;


public interface AptAroundService {
	List<EnvirInfoDto> getEnvirInfo(String sigugun, String dong);
	List<StoreInfoDto> getAllStoreInfo(String gu, String dong);
	List<HospitalDto> getAllHospInGugun(String sido, String gugun);
	List<CoronaClinicDto> getAllCoronaClinicInGugun(String sido, String gugun);
}
