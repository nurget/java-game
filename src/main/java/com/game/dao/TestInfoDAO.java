package com.game.dao;

import java.util.List;
import java.util.Map;

public interface TestInfoDAO {

	List<Map<String,String>> selectTestInfoList(Map<String,String> testInfo);
	
	Map<String,String> selectTestInfo(String tiNum);
	
	Map<String,String> selectTestInfoById(String tiName);
	
	int insertUserInfo(Map<String,String> testInfo);
	
	int updateUserInfo(Map<String,String> testInfo);
	
	int deleteUserInfo(String tiNum);
}
