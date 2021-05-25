package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.dao.HouseMapDAO;

@Service
public class HouseMapServiceImpl implements HouseMapService {

	@Autowired
	private HouseMapDAO sidoguguncodedto;
	
	@Override
	public List<SidoGugunCodeDto> getSido(){
		return sidoguguncodedto.selectSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido){
		return sidoguguncodedto.selectGugun(sido);
	}

	@Override
	public List<SidoGugunCodeDto> getDongInGugun(String gugun) {
		return sidoguguncodedto.selectDong(gugun);
	}

	@Override
	public String getSiName(String sidocode) {
		return sidoguguncodedto.selectSidoName(sidocode);
	}

	@Override
	public String getGugunName(String guguncode) {
		return sidoguguncodedto.selectGugunName(guguncode);
	}

	@Override
	public String getDongName(String dongcode) {
		return sidoguguncodedto.selectDongName(dongcode);
	}

	@Override
	public String getSiCode(String siname) {
		return sidoguguncodedto.selectSiCode(siname);
	}

	@Override
	public String getGugunCode(String gugunname, String sidocode) {
		return sidoguguncodedto.selectGugunCode(gugunname, sidocode);
	}


}
