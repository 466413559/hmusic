package com.hmusic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hmusic.dao.FullMusicDao;
import com.hmusic.entity.FullMusic;
import com.hmusic.service.FullMusicService;

@Repository("fullMusicService")
@Transactional
public class FullMusicServiceImpl implements FullMusicService {
	@Autowired
	private FullMusicDao fullMusicDao;

	public List<FullMusic> findMusicByMusicName(String musicname, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		musicList = fullMusicDao.findMusicByMusicName(musicname, begin, end);
		return musicList;
	}

	public List<FullMusic> findMusicByMusicTypeId(Integer musictypeid, Integer begin, Integer end, String order) {
		// TODO Auto-generated method stub
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		musicList = fullMusicDao.findMusicByMusicTypeId(musictypeid, begin, end, order);
		return musicList;
	}

	public List<FullMusic> findMusicBySingerId(Integer singerid, Integer begin, Integer end, String order) {
		// TODO Auto-generated method stub
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		musicList = fullMusicDao.findMusicBySingerId(singerid, begin, end, order);
		return musicList;
	}

	public List<FullMusic> findMusicBySonglistid(Integer songlistid, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		musicList = fullMusicDao.findMusicBySonglistid(songlistid, begin, end);
		return musicList;
	}

	public List<FullMusic> findAllMusic(Integer begin, Integer end, String order) {
		// TODO Auto-generated method stub
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		musicList = fullMusicDao.findAllMusic(begin, end, order);
		for (FullMusic fullMusic : musicList) {
			System.out.println(fullMusic.getMusicname());
		}
		return musicList;
	}

}
