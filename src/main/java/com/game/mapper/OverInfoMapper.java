package com.game.mapper;

import java.util.List;

import com.game.vo.OverInfoVO;

public interface OverInfoMapper {
	List<OverInfoVO> selectOverInfoList (OverInfoVO over);
}
