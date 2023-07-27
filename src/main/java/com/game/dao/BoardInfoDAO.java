package com.game.dao;

import java.util.List;
import java.util.Map;

public interface BoardInfoDAO {

	List<Map<String,String>> selectBoardInfoList (Map<String,String> board);
	Map<String,String> selectBoardinfo(String biNum);
	int insertBoardInfo (Map<String,String> board);
	int updateBoardInfo (Map<String,String> board);
	int deleteBoardinfo(String biNum);
}
