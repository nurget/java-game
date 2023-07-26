package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDao;

public class UserInfoDAOImpl implements UserInfoDao {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql = "SELECT \n"
				+ "UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\n"
				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE\n"
				+ "FROM USER_INFO";
		List<Map<String,String>> userInfoList = new ArrayList<>();
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				try(ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						Map<String,String> user = new HashMap<>();
						user.put("uiNum", rs.getString("UI_NUM"));
						user.put("uiName", rs.getString("UI_NAME"));
						user.put("uiId", rs.getString("UI_ID"));
						user.put("uiPwd", rs.getString("UI_PWD"));
						user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						user.put("uiDesc", rs.getString("UI_DESC"));
						user.put("uiBirth", rs.getString("UI_BIRTH"));
						user.put("credat", rs.getString("CREDAT"));
						user.put("cretim", rs.getString("CRETIM"));
						user.put("lmodat", rs.getString("LMODAT"));
						user.put("lmotim", rs.getString("LMOTIM"));
						user.put("active", rs.getString("ACTIVE"));
						userInfoList.add(user);
					}
				}
			}
		} catch(SQLException e) {
			
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT \n"
				+ "UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\n"
				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE\n"
				+ "FROM USER_INFO\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				try(ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						Map<String,String> user = new HashMap<>();
						user.put("uiNum", rs.getString("UI_NUM"));
						user.put("uiName", rs.getString("UI_NAME"));
						user.put("uiId", rs.getString("UI_ID"));
						user.put("uiPwd", rs.getString("UI_PWD"));
						user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						user.put("uiDesc", rs.getString("UI_DESC"));
						user.put("uiBirth", rs.getString("UI_BIRTH"));
						user.put("credat", rs.getString("CREDAT"));
						user.put("cretim", rs.getString("CRETIM"));
						user.put("lmodat", rs.getString("LMODAT"));
						user.put("lmotim", rs.getString("LMOTIM"));
						user.put("active", rs.getString("ACTIVE"));
						return user;
					}
				}
			}
		} catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "insert into user_info (\n"
				+ "ui_name, ui_id, ui_pwd, ui_img_path,\n"
				+ "ui_desc, ui_birth, credat, cretim,\n"
				+ "lmodat, lmotim)\n"
				+ "values\n"
				+ "(\n"
				+ "?, ?, ?, ?,\n"
				+ "?, ?,\n"
				+ "date_format(now(), '%Y%m%d'), date_format(now(), '%H%i%s'),\n"
				+ "date_format(now(), '%Y%m%d'), date_format(now(), '%H%i%s')\n"
				+ ")";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "update user_info\n"
				+ "set ui_name=?,\n"
				+ "ui_pwd=?,\n"
				+ "ui_img_path=?,\n"
				+ "ui_desc=?,\n"
				+ "ui_birth=?,\n"
				+ "LMODAT=date_format(now(), '%Y%m%d'),\n"
				+ "LMOTIM=date_format(now(), '%H%i%s')\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiPwd"));
				ps.setString(3, userInfo.get("uiImgPath"));
				ps.setString(4, userInfo.get("uiDesc"));
				ps.setString(5, userInfo.get("uiBirth"));
				ps.setString(6, userInfo.get("uiNum"));
			}
		} catch(Exception e) {
			
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoDao uiDao = new UserInfoDAOImpl();
		System.out.println(uiDao.selectUserInfoList(null));
		System.out.println(uiDao.selectUserInfo("1"));
		
		Map<String,String> map = new HashMap<>();
		map.put("uiName", "추소정");
		map.put("uiId", "exy");
		map.put("uiPwd", "1106");
		map.put("uiDesc", "리더");
		map.put("uiBirth", "19951106");
		int result = uiDao.insertUserInfo(map);
		System.out.println(result);
	}
}
