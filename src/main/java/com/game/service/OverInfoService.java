package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.OverInfoVO;

public interface OverInfoService {

	List<OverInfoVO> selectOverInfoList (OverInfoVO over);
	Map<String,String> selectOverInfo(String oiNum);
	int insertOverInfo(Map<String,String> over);
	int updateOverInfo(Map<String,String> over);
	int deleteOverInfo(String oiNum);
}
