package com.hmusic.entity;

import java.sql.Time;
import java.util.Date;

public class FullMusic {
	private Integer musicid;
	private String musicname;
	private String musicpath;
	private String musicphoto;
	private String lyricspath;
	private String duration;
	private Date uploadtime;
	private Integer clickrate;
	private Integer downloadrate;
	private Integer musictypeid;
	private String musictypename;
	private Integer singerid;
	private String singername;
	
	public static final String NEW_MUSIC = "uploadtime";
	public static final String HOT_MUSIC = "clickrate";
	public static final String DOWNLOAD_MOST="downloadrate";
	
	public Integer getMusicid() {
		return musicid;
	}

	public void setMusicid(Integer musicid) {
		this.musicid = musicid;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public String getMusicpath() {
		return musicpath;
	}

	public void setMusicpath(String musicpath) {
		this.musicpath = musicpath;
	}

	public String getMusicphoto() {
		return musicphoto;
	}

	public void setMusicphoto(String musicphoto) {
		this.musicphoto = musicphoto;
	}

	public String getLyricspath() {
		return lyricspath;
	}

	public void setLyricspath(String lyricspath) {
		this.lyricspath = lyricspath;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getUploadetime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Integer getClickrate() {
		return clickrate;
	}

	public void setClickrate(Integer clickrate) {
		this.clickrate = clickrate;
	}

	public Integer getDownloadtate() {
		return downloadrate;
	}

	public void setDownloadrate(Integer downloadrate) {
		this.downloadrate = downloadrate;
	}

	public Integer getMusictypeid() {
		return musictypeid;
	}

	public void setMusictypeid(Integer musictypeid) {
		this.musictypeid = musictypeid;
	}

	public String getMusictypename() {
		return musictypename;
	}

	public void setMusictypename(String musictypename) {
		this.musictypename = musictypename;
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
}
