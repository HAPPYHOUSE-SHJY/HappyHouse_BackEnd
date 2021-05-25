package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.SidoGugunCodeDto;



public interface HouseMapService {
	/**
	 * 시도 리스트 반환
	 * @return
	 * @throws Exception
	 */
	List<SidoGugunCodeDto> getSido();
	/**
	 * 구군 리스트 반환
	 * @param sido
	 * @return
	 * @throws Exception
	 */
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	/**
	 * 구군 리스트 반환
	 * @param sido
	 * @return
	 * @throws Exception
	 */
	List<SidoGugunCodeDto> getDongInGugun(String gugun);
	String getSiName(String sidocode);
	String getGugunName(String guguncode);
	String getDongName(String dongcode);
	String getSiCode(String siName);
	String getGugunCode(String gugunName, String sidoCode);

}
