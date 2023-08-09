package com.game.dao;

import java.util.List;
import java.util.Map;

public interface OverInfoDAO {

	List<Map<String,String>> selectOverInfoList(Map<String,String> overInfo);
	
	Map<String,String> selectOverInfo(String oiNum);
	
	
	int insertOverInfo(Map<String,String> overInfo);
	
	int updateOverInfo(Map<String,String> overInfo);
	
	int deleteOverInfo(String oiNum);
}
