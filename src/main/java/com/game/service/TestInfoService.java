package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.TestInfoVO;

public interface TestInfoService {

	List<TestInfoVO> selectTestInfoList (TestInfoVO test);
	TestInfoVO selectTestInfo(String tiNum);
	int insertTestInfo (Map<String,String> test);
	int updateTestInfo (Map<String,String> test);
	int deleteTestInfo(String tiNum);
	Map<String, String> login(String tiId);
}
