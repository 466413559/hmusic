package com.hmusic.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hmusic.entity.FullMusic;

public interface FullMusicService {
	public List<FullMusic> findMusicByMusicName(@Param("musicname") String musicname, @Param("begin") Integer begin,
			@Param("end") Integer end);

	public List<FullMusic> findMusicByMusicTypeId(@Param("musictypeid") Integer musictypeid,
			@Param("begin") Integer begin, @Param("end") Integer end, @Param("order") String order);

	public List<FullMusic> findMusicBySingerId(@Param("singerid") Integer singerid, @Param("begin") Integer begin,
			@Param("end") Integer end, @Param("order") String order);

	public List<FullMusic> findMusicBySonglistid(@Param("songlistid") Integer songlistid, @Param("begin") Integer begin,
			@Param("end") Integer end);

	public List<FullMusic> findAllMusic(@Param("begin") Integer begin, @Param("end") Integer end,
			@Param("order") String order);
}
