package com.game.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.BoardInfoMapper;
import com.game.vo.BoardInfoVO;

public class MybatisSqlSessionFactory {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	
	public static void main(String[] args) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		try {
			SqlSession session = ssf.openSession(true);
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBiNum(6);
			bi.setBiTitle("mapper test");
			bi.setBiContent("두번째로 하는 마이바티스트 인서트");
			bi.setUiNum(3);
			int result = biMapper.insertBoardInfo(bi);
			System.out.println("insert result : " + result);
			bi = biMapper.selectBoardInfo(bi);
			bi.setBiTitle("마이 바티스트 업데이트 테스트");
			result = biMapper.updateBoardInfo(bi);
			System.out.println("update result : " + result);
			
			List<BoardInfoVO> list = biMapper.selectBoardInfoList(null);
			for(BoardInfoVO board : list) {
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
