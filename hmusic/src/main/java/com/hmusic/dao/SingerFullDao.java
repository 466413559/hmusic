package com.hmusic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hmusic.entity.SingerFull;

@Repository("singerFullDao")
public interface SingerFullDao {
	/**
	 * 根据歌手类型id 和分页信息获取歌手集合
	 * @param singertypeid  歌手类型id
	 * @param begin	起始记录
	 * @param end	终止记录
	 * @return
	 */
	
	public List<SingerFull> findSingerByTypeid(@Param("singertypeid")Integer singertypeid,@Param("begin")Integer begin,@Param("end")Integer end);
	/**
	 * 根据分页信息获取歌手集合
	 * @param begin 起始记录
	 * @param end 终止记录
	 * @return
	 */
	public List<SingerFull> findAll(@Param("begin")Integer begin,@Param("end")Integer end);
}
