package com.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.OverInfoDAO;
import com.game.dao.impl.OverInfoDAOImpl;
import com.game.mapper.OverInfoMapper;
import com.game.service.OverInfoService;
import com.game.vo.OverInfoVO;

public class OverInfoServiceImpl implements OverInfoService {
	private OverInfoDAO oiDAO = new OverInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<OverInfoVO> selectOverInfoList(OverInfoVO over) {
		
		try(SqlSession session = ssf.openSession()) {
			OverInfoMapper oiMapper = session.getMapper(OverInfoMapper.class);
			return oiMapper.selectOverInfoList(over);
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Map<String, String> selectOverInfo(String oiNum) {
		return oiDAO.selectOverInfo(oiNum);
	}

	@Override
	public int insertOverInfo(Map<String, String> overInfo) {
		return oiDAO.insertOverInfo(overInfo);
	}

	@Override
	public int updateOverInfo(Map<String, String> overInfo) {
		return oiDAO.updateOverInfo(overInfo);
	}

	@Override
	public int deleteOverInfo(String oiNum) {
		return oiDAO.deleteOverInfo(oiNum);
	}
	
	public static void main(String[] args) {
		OverInfoDAO oiDAO = new OverInfoDAOImpl();
		Map<String, String> oiMock = new HashMap<>();
//		oiMock.put("biTitle", "test");
//		oiMock.put("biContent", "test");
//		oiMock.put("uiNum", "2");
//		int result = oiDAO.insertOverInfo(oiMock);
//		System.out.println("결과 : " + result);
		System.out.println(oiDAO.selectOverInfoList(null));
//		System.out.println(oiDAO.selectOverInfo("3"));
	}

}
