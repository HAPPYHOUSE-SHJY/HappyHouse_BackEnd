package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.AptAroundDAO;
import com.ssafy.vue.dto.CoronaClinicDto;
import com.ssafy.vue.dto.EnvirInfoDto;
import com.ssafy.vue.dto.HospitalDto;
import com.ssafy.vue.dto.StoreInfoDto;

@Service
public class AptAroundServiceImpl implements AptAroundService{
	@Autowired
	private AptAroundDAO around;
	@Override
	public List<EnvirInfoDto> getEnvirInfo(String sigugun, String dong) {
		// TODO Auto-generated method stub
		return around.selectEnvInfoByDong(sigugun, dong);
	}
	@Override
	public List<StoreInfoDto> getAllStoreInfo(String gu, String dong) {
		// TODO Auto-generated method stub
		return around.selectStoreInfoByDong(gu, dong);
	}
	@Override
	public List<HospitalDto> getAllHospInGugun(String sido, String gugun) {
		// TODO Auto-generated method stub
		return around.selectHospitalByGugun(sido, gugun);
	}
	@Override
	public List<CoronaClinicDto> getAllCoronaClinicInGugun(String sido, String gugun) {
		// TODO Auto-generated method stub
		return around.selectCoronaClinicByGugun(sido,gugun);
	}

}

