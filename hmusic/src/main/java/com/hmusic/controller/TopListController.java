package com.hmusic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmusic.entity.FullMusic;
import com.hmusic.service.FullMusicService;

@Controller
@RequestMapping
public class TopListController {
	
	@Autowired
	private FullMusicService fullMusicService;
	private Integer pageSize = 10;
	@RequestMapping(value="/toplist",params="type=new")
	public String getNewMusic(Integer curPage,Model model){
		List<FullMusic> musicList = new ArrayList<FullMusic>();		
		Integer total = fullMusicService.findAllMusic(0, 100, FullMusic.NEW_MUSIC).size();
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findAllMusic((curPage-1)*pageSize, pageSize, FullMusic.NEW_MUSIC);
		model.addAttribute("musicList", musicList);
		model.addAttribute("curPage",curPage);
		model.addAttribute("type","new");
		return "toplist";
	}
	
	@RequestMapping(value="/toplist",params="type=hot")
	public String getHotMusic(Integer curPage,Model model){			
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		Integer total = fullMusicService.findAllMusic(0, 100, FullMusic.HOT_MUSIC).size();
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findAllMusic((curPage-1)*pageSize, pageSize, FullMusic.HOT_MUSIC);
		model.addAttribute("musicList", musicList);
		model.addAttribute("curPage",curPage);
		model.addAttribute("type","hot");
		return "toplist";
	}
	
	@RequestMapping(value="/toplist",params="type=dlm")
	public String getDlmMusic(Integer curPage,Model model){
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		Integer total = fullMusicService.findAllMusic(0, 100, FullMusic.DOWNLOAD_MOST).size();
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findAllMusic((curPage-1)*pageSize, pageSize, FullMusic.DOWNLOAD_MOST);
		model.addAttribute("musicList", musicList);
		model.addAttribute("curPage",curPage);
		model.addAttribute("type","dlm");
		return "toplist";
	}
	
	@RequestMapping("/toplist")
	public String TopList(Model model) {
		List<FullMusic> newmMusicList = new ArrayList<FullMusic>();
		List<FullMusic> hotMusicList = new ArrayList<FullMusic>();
		List<FullMusic> dlmMusicList = new ArrayList<FullMusic>();
		try {

			newmMusicList = fullMusicService.findAllMusic(0, 10, FullMusic.NEW_MUSIC);
			hotMusicList = fullMusicService.findAllMusic(0, 10, FullMusic.HOT_MUSIC);
			dlmMusicList = fullMusicService.findAllMusic(0, 10, FullMusic.DOWNLOAD_MOST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("newmMsicList", newmMusicList);
		model.addAttribute("hotMusicList", hotMusicList);
		model.addAttribute("dlmMusicList", dlmMusicList);
		return "toplist";
	}
}
