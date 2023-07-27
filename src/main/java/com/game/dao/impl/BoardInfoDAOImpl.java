package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		String sql = "select * from board_info";
		List<Map<String,String>> boardList = new ArrayList<>();
		
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				try(ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						boardList.add(map);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public Map<String, String> selectBoardinfo(String biNum) {
		String sql = "select * from board_info where BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				try(ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql ="insert into board_info(\n"
				+ "BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, \n"
				+ "CRETIM, LMODAT, LMOTIM) \n"
				+ "values(\n"
				+ "?, ?, ?, \n"
				+ "date_format(now(), '%Y%m%d'),\n"
				+ "date_format(now(), '%H%i%s'),\n"
				+ "date_format(now(), '%Y%m%d'),\n"
				+ "date_format(now(), '%H%i%s')\n"
				+ ")";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql = "update board_info\n"
				+ "set BI_TITLE=?,\n"
				+ "BI_CONTENT=?,\n"
				+ "UI_NUM=?,\n"
				+ "LMODAT=date_format(now(), '%Y%m%d'),\n"
				+ "LMOTIM=date_format(now(), '%H%i%s')\n"
				+ "where bi_num=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardinfo(String biNum) {
		String sql = "delete from board_info where bi_num=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, "biNum");
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
		// insert test
		
		Map<String,String> biMock = new HashMap<>();
//		biMock.put("biTitle", "피닉스");
//		biMock.put("biContent", "발로란트 타격대");
//		biMock.put("uiNum", "3");
//		int result = biDAO.insertBoardInfo(biMock);
//		System.out.println("결과: " + result);
		
		// select test
		
		System.out.println(biDAO.selectBoardInfoList(null));
		
		// update test
		biMock.put("biTitle", "사이퍼");
		biMock.put("biContent", "발로란트 감시자");
		
		int result = biDAO.updateBoardInfo(biMock);
		System.out.println(result);
		
		
	}

}
