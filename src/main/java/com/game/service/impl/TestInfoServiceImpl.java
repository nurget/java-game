//package com.game.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//
//import com.game.common.MybatisSqlSessionFactory;
//import com.game.dao.UserInfoDao;
//import com.game.dao.impl.UserInfoDAOImpl;
//import com.game.mapper.TestInfoMapper;
//import com.game.service.TestInfoService;
//import com.game.vo.TestInfoVO;
//
//public class TestInfoServiceImpl implements TestInfoService {
//	private UserInfoDao uiDAO = new UserInfoDAOImpl();
//	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
//	@Override
//	public List<TestInfoVO> selectTestInfoList(TestInfoVO testInfo) {
//		try(SqlSession session = ssf.openSession()) {
//			TestInfoMapper tiMapper = session.getMapper(TestInfoMapper.class);
//			return tiMapper.selectTestInfoList(testInfo);
//		} catch(Exception e) {
//			throw e;
//		}
//	}
//
//	@Override
//	public TestInfoVO selectTestInfo(String tiNum) {
//		return tiDAO.selectTestInfo(tiNum);
//	}
//
//	@Override
//	public int insertUserInfo(Map<String, String> userInfo) {
//		return uiDAO.insertUserInfo(userInfo);
//	}
//
//	@Override
//	public int updateUserInfo(Map<String, String> userInfo) {
//		return uiDAO.updateUserInfo(userInfo);
//	}
//
//	@Override
//	public int deleteUserInfo(String uiNum) {
//		return uiDAO.deleteUserInfo(uiNum);
//	}
//
//	@Override
//	public Map<String, String> login(String uiId) {
//		return uiDAO.selectUserInfoById(uiId);
//	}
//
//}
