package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.OverInfoDAO;

public class OverInfoDAOImpl implements OverInfoDAO {

    @Override
    public List<Map<String, String>> selectOverInfoList(Map<String, String> overInfo) {
    	String sql ="SELECT OI_NUM, OI_NAME, OI_POS, OI_NAT FROM OVER_INFO";
		List<Map<String, String>> overList = new ArrayList<>();

		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("oiNum", rs.getString("OI_NUM"));
						map.put("oiName", rs.getString("OI_NAME"));
						map.put("oiPos", rs.getString("OI_POS"));
						map.put("oiNat", rs.getString("OI_NAT"));
						overList.add(map);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return overList;
    }

    @Override
    public Map<String, String> selectOverInfo(String oiNum) {
		String sql ="SELECT OI_NUM, OI_NAME, OI_POS, OI_NAT ,\r\n"
				+ "FROM OVER_INFO WHERE OI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, oiNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("oiNum", rs.getString("OI_NUM"));
						map.put("oiName", rs.getString("OI_NAME"));
						map.put("oiPos", rs.getString("OI_POS"));
						map.put("oiNat", rs.getString("OI_NAT"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    

    @Override
    public int insertOverInfo(Map<String, String> overInfo) {
        String sql = "INSERT INTO OVER_INFO(OI_NAME, OI_POS, OI_NAT) VALUES(?, ?, ?)";
        try (Connection con = DBCon.getCon()) {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, overInfo.get("oiName"));
                ps.setString(2, overInfo.get("oiPos"));
                ps.setString(3, overInfo.get("oiNat"));
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateOverInfo(Map<String, String> overInfo) {
    	String sql = "UPDATE OVER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "OI_POS=?,\r\n"
				+ "UI_NAT=?,\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, overInfo.get("oiName"));
				ps.setString(2, overInfo.get("oiPos"));
				ps.setString(3, overInfo.get("oiNat"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int deleteOverInfo(String oiNum) {
    	String sql = "DELETE FROM OVER_INFO WHERE OI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,oiNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
    }

}
