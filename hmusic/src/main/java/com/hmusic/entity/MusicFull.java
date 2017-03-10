package com.hmusic.entity;

public class MusicFull {
	private Music music;
	private MusicType musictype;
	private Singer singer;
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public MusicType getMusictype() {
		return musictype;
	}
	public void setMusictype(MusicType musictype) {
		this.musictype = musictype;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	public FullMusic changeMusicFUll2FullMusic(){
		FullMusic fullMusic = new FullMusic();
		fullMusic.setClickrate(this.getMusic().getClickrate());
		fullMusic.setDownloadrate(this.getMusic().getDownloadrate());
		fullMusic.setDuration(this.getMusic().getDuration().toString());
		fullMusic.setLyricspath(this.getMusic().getLyricspath());
		fullMusic.setMusicid(this.getMusic().getMusicid());
		fullMusic.setMusicname(this.getMusic().getMusicname());
		fullMusic.setMusicpath(this.getMusic().getMusicpath());
		fullMusic.setMusicphoto(this.getMusic().getMusicphoto());
		fullMusic.setMusictypeid(this.getMusictype().getMusictypeid());
		fullMusic.setMusictypename(this.getMusictype().getMusictypename());
		fullMusic.setSingerid(this.getSinger().getSingerid());
		fullMusic.setSingername(this.getSinger().getSingername());
		fullMusic.setUploadtime(this.getMusic().getUploadtime());
		return fullMusic;
	}

}
