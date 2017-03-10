package com.hmusic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hmusic.dao.SingerFullDao;
import com.hmusic.entity.SingerFull;
import com.hmusic.service.SingerFullService;
@Repository("singerFullService")
@Transactional
public class SingerFullServiceImpl implements SingerFullService{
	@Autowired
	private SingerFullDao singerFullDao;

	public List<SingerFull> findSingerByTypeid(Integer singertypeid, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		List<SingerFull> singerFullList = new ArrayList<SingerFull>();
		singerFullList = singerFullDao.findSingerByTypeid(singertypeid, begin, end);
		return singerFullList;
	}

	public List<SingerFull> findAll(Integer begin, Integer end) {
		// TODO Auto-generated method stub
		List<SingerFull> singerFullList = new ArrayList<SingerFull>();
		singerFullList = singerFullDao.findAll(begin, end);
		return singerFullList;
	}

}
