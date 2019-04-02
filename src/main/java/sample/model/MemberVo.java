package sample.model;

public class MemberVo extends DefaultVo{
	
	private Integer mbrSeq;
	private String mbrId;
	private String mbrPasswd;
	private String mbrTel;
	private String mbrNm;
	
	public Integer getMbrSeq() {
		return mbrSeq;
	}
	public void setMbrSeq(Integer mbrSeq) {
		this.mbrSeq = mbrSeq;
	}
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrPasswd() {
		return mbrPasswd;
	}
	public void setMbrPasswd(String mbrPasswd) {
		this.mbrPasswd = mbrPasswd;
	}
	public String getMbrTel() {
		return mbrTel;
	}
	public void setMbrTel(String mbrTel) {
		this.mbrTel = mbrTel;
	}
	public String getMbrNm() {
		return mbrNm;
	}
	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}
	
}
