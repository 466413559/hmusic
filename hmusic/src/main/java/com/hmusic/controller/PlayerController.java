package com.hmusic.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.hmusic.entity.FullMusic;
import com.hmusic.entity.MusicFull;
import com.hmusic.service.FullMusicService;
import com.hmusic.service.MusicFullService;
import com.hmusic.service.MusicService;
import com.hmusic.service.MusicTypeService;
import com.hmusic.service.SingerFullService;

@Controller
@RequestMapping
public class PlayerController {

	@Autowired
	private MusicFullService musicFullService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private FullMusicService fullMusicService;
	@Autowired
	private MusicTypeService musictypeService;
	
	@RequestMapping("/addplaylist")
	public void PlayList(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("playerlist success");
		List<Integer> musicidList;
		List<FullMusic> musicList;
		JSONObject rspJson = new JSONObject();
		musicidList = (List<Integer>) request.getSession().getAttribute("musicidlist");
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		if (musicidList == null || musicidList.size() == 0){
			musicidList = new ArrayList<Integer>();
			musicList= new ArrayList<FullMusic>();
		}
		Integer musicid = json.getInteger("musicid");
		if (musicid != null) {
			if (!musicidList.contains(musicid)) {
				musicidList.add(musicid);
				MusicFull musicFull =  musicFullService.getMusicFullByMusicid(musicid);
				FullMusic fullMusic =musicFull.changeMusicFUll2FullMusic();
				musicList.add(fullMusic);
				Integer clickrate = fullMusic.getClickrate();
				musicFull.getMusic().setClickrate(clickrate);
				musicService.update(musicFull.getMusic());
			}
		}
		request.getSession().setAttribute("musicidlist", musicidList);
		request.getSession().setAttribute("playerlist", musicList);
	}
	
	@RequestMapping("/player")
	public void Player(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("playerlist success");
		List<FullMusic> musicList;
		List<Integer> musicidList;
		JSONObject rspJson = new JSONObject();
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		musicidList = (List<Integer>) request.getSession().getAttribute("musicidlist");
		try {
			rspJson.put("playerlist", musicList);
			rspJson.put("musicidlist", musicidList);
			rspJson.put("curMusic", request.getSession().getAttribute("curMusic"));
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(rspJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/deleteCurMusic")
	public void deleteCurMusic( HttpServletRequest request, HttpServletResponse response){

		request.getSession().removeAttribute("curMusic");
	}
	
	@RequestMapping("/deletePlaylist")
	public void deletePlaylist(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response){
		Integer num = json.getInteger("num");
		List<FullMusic> musicList;
		List<Integer> musicidList;
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		musicidList = (List<Integer>) request.getSession().getAttribute("musicidlist");
		musicList.remove(num);
		musicidList.remove(num);
		request.getSession().setAttribute("musicidlist", musicidList);
		request.getSession().setAttribute("playerlist", musicList);
	}
	
	@RequestMapping("/playMusic")
	public void PlayMusic(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("playerlist success");
		List<Integer> musicidList;
		List<FullMusic> musicList;
		JSONObject rspJson = new JSONObject();
		musicidList = (List<Integer>) request.getSession().getAttribute("musicidlist");
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		if (musicList == null || musicidList == null || musicidList.size() == 0){
			musicidList = new ArrayList<Integer>();
			musicList= new ArrayList<FullMusic>();
		}
		Integer musicid = json.getInteger("musicid");
		if (musicid != null) {
			if (!musicidList.contains(musicid)) {
				musicidList.add(musicid);
				MusicFull musicFull =  musicFullService.getMusicFullByMusicid(musicid);
				FullMusic fullMusic =musicFull.changeMusicFUll2FullMusic();
				musicList.add(fullMusic);
				Integer clickrate = fullMusic.getClickrate();
				musicFull.getMusic().setClickrate(clickrate);
				musicService.update(musicFull.getMusic());
				request.getSession().setAttribute("curMusic", musicList.size());
			}else{
				Integer curMusic = musicidList.indexOf(musicid);
				request.getSession().setAttribute("curMusic",curMusic+1);
			}
		}
		System.out.println("request success 11111111111111111111");
		request.getSession().setAttribute("musicidlist", musicidList);
		request.getSession().setAttribute("playerlist", musicList);
		System.out.println("request success 1111111111112222222222222222222222222222222");
	}
}
