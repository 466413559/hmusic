package com.hmusic.entity;

public class SingerFull {
	private Integer singerid;
	private String singername;
	private String singerphoto;
	private String sex;
	private String introduction;
	private Integer singertypeid;
	private String singertypename;

	public Integer getSingertypeid() {
		return singertypeid;
	}

	public void setSingertypeid(Integer singertypeid) {
		this.singertypeid = singertypeid;
	}

	public String getSingertypename() {
		return singertypename;
	}

	public void setSingertypename(String singertypename) {
		this.singertypename = singertypename;
	}

	public Integer getSingerid() {
		return singerid;
	}

	public void setSingerid(Integer singerid) {
		this.singerid = singerid;
	}

	public String getSingername() {
		return singername;
	}

	public void setSingername(String singername) {
		this.singername = singername;
	}

	public String getSingerphoto() {
		return singerphoto;
	}

	public void setSingerphoto(String singerphoto) {
		this.singerphoto = singerphoto;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
