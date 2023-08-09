package com.game.mapper;

import java.util.List;

import com.game.vo.TestInfoVO;

public interface TestInfoMapper {
	List<TestInfoVO> selectTestInfoList (TestInfoVO test);
}
