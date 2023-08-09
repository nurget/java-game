package com.game.vo;

public class OverInfoVO {

	private int oiNum;
	private String oiName;
	private String oiPos;
	private String oiNat;
	@Override
	public String toString() {
		return "OverInfoVO [oiNum=" + oiNum + ", oiName=" + oiName + ", oiPos=" + oiPos + ", oiNat=" + oiNat + "]";
	}
	public int getOiNum() {
		return oiNum;
	}
	public void setOiNum(int oiNum) {
		this.oiNum = oiNum;
	}
	public String getOiName() {
		return oiName;
	}
	public void setOiName(String oiName) {
		this.oiName = oiName;
	}
	public String getOiPos() {
		return oiPos;
	}
	public void setOiPos(String oiPos) {
		this.oiPos = oiPos;
	}
	public String getOiNat() {
		return oiNat;
	}
	public void setOiNat(String oiNat) {
		this.oiNat = oiNat;
	}
	
	public static void main(String[] args) {
		OverInfoVO oi = new OverInfoVO();
		oi.setOiName("안녕");
		oi.setOiPos("tissue");
		System.out.println(oi);
	}
}
