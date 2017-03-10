package com.hmusic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.hmusic.entity.FullMusic;
import com.hmusic.entity.MusicFull;
import com.hmusic.entity.MusicType;
import com.hmusic.entity.Singer;
import com.hmusic.entity.SingerFull;
import com.hmusic.service.FullMusicService;
import com.hmusic.service.MusicFullService;
import com.hmusic.service.MusicTypeService;
import com.hmusic.service.SingerFullService;
import com.hmusic.service.SingerService;

@Controller
@RequestMapping
public class SingerController {
	@Autowired
	private MusicFullService musicFullService;
	@Autowired
	private SingerFullService singerFullService;
	@Autowired
	private FullMusicService fullMusicService;
	@Autowired
	private MusicTypeService musictypeService;
	@Autowired
	private SingerService singerService;
	
	private Integer pageSize = 15;
	
	@RequestMapping("/singer")
	public String SingerInfo(Integer singerid, Integer curPage,Model model) {

		List<FullMusic> musicList = new ArrayList<FullMusic>();		
		Integer total = fullMusicService.findMusicBySingerId(singerid, 0, 100, FullMusic.NEW_MUSIC).size();
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findMusicBySingerId(singerid,(curPage-1)*pageSize, pageSize, FullMusic.NEW_MUSIC);
		Singer singer = singerService.findSingerById(singerid);
		model.addAttribute("musics", musicList);
		model.addAttribute("curPage",curPage);
		model.addAttribute("singer", singer);
		
		return "singer";
	}

	@RequestMapping("/singerlist1")
	public String SingeList(@RequestBody JSONObject json, Model model) {
		Integer typeid = (Integer) json.get("typeid");
		Integer curPage = (Integer) json.get("curPage");
		Integer pageSize = (Integer) json.get("pageSize");
		System.out.println("curPage:" + typeid);
		List<SingerFull> singeFullList = new ArrayList<SingerFull>();
		try {
			if (typeid != null) {
				singeFullList = singerFullService.findSingerByTypeid(typeid, (curPage - 1) * pageSize,
						curPage * pageSize - 1);
			} else {
				singeFullList = singerFullService.findAll(0, 19);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("singeFullList", singeFullList);
		System.out.println(singeFullList.size());
		return "singerlist";
	}

	@RequestMapping("/singerlist")
	public String SingeList(Integer curPage,Model model) {
		
		List<SingerFull> singeFullList = new ArrayList<SingerFull>();	
		Integer total = singerFullService.findAll(0, 100).size();
		
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		System.out.println("curPage"+curPage);
		model.addAttribute("totalPage",totalPage);
		singeFullList = singerFullService.findAll((curPage-1)*pageSize, pageSize);
		System.out.println("total"+totalPage);
		model.addAttribute("curPage",curPage);
		model.addAttribute("singeFullList", singeFullList);
		return "singerlist";
	}

	

	@RequestMapping(value="/songlist",params="type=new")
	public String SongList(Integer curPage,Model model) {
		
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		Integer total = fullMusicService.findAllMusic(0, 100, FullMusic.NEW_MUSIC).size();
		
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findAllMusic((curPage-1)*pageSize, pageSize,FullMusic.NEW_MUSIC);
		System.out.println("total"+totalPage);
		model.addAttribute("curPage",curPage);
		List<MusicType> musictypelist = new ArrayList<MusicType>();
		try {

			musictypelist = musictypeService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("musicList", musicList);
		model.addAttribute("musictypelist", musictypelist);
		model.addAttribute("type","new");
		System.out.println(musicList.size());
		return "songlist";
	}
	@RequestMapping(value="/songlist",params="type=hot")
	public String SongListHot(Integer curPage,Model model) {
		
		List<FullMusic> musicList = new ArrayList<FullMusic>();
		Integer total = fullMusicService.findAllMusic(0, 100, FullMusic.HOT_MUSIC).size();
		
		Integer totalPage = (total%pageSize)==0?total/pageSize:(total/pageSize)+1;		
		if(curPage==null || curPage<=1){
			curPage=1;				
		}
		model.addAttribute("totalPage",totalPage);
		musicList = fullMusicService.findAllMusic((curPage-1)*pageSize, pageSize,FullMusic.HOT_MUSIC);
		System.out.println("total"+totalPage);
		model.addAttribute("curPage",curPage);
		List<MusicType> musictypelist = new ArrayList<MusicType>();
		try {

			musictypelist = musictypeService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("musicList", musicList);
		model.addAttribute("musictypelist", musictypelist);
		model.addAttribute("type","hot");
		System.out.println("singerid:"+musicList.get(0).getSingerid());
		return "songlist";
	}

	@RequestMapping("/addplaylist1")
	public void PlayList1(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("playerlist success");
		List<FullMusic> musicList;
		JSONObject rspJson = new JSONObject();
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		if (musicList == null || musicList.size() == 0)
			musicList = new ArrayList<FullMusic>();
		Integer musicid = json.getInteger("musicid");
		try {
			FullMusic fullMusic = musicFullService.getMusicFullByMusicid(musicid).changeMusicFUll2FullMusic();
			musicList.add(fullMusic);
			request.getSession().setAttribute("playerlist", musicList);
			rspJson.put("playerlist", musicList);
			response.getWriter().print(rspJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@RequestMapping("/player1")
	public void Player1(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("playerlist success");
		List<FullMusic> musicList;
		JSONObject rspJson = new JSONObject();
		musicList = (List<FullMusic>) request.getSession().getAttribute("playerlist");
		if (musicList == null || musicList.size() == 0) {
			musicList = new ArrayList<FullMusic>();
			request.getSession().setAttribute("playerlist", musicList);
		}
		try {
			rspJson.put("playerlist", musicList);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(rspJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@RequestMapping("/index")
	public String getNewMusic1(Model model) {
		List<FullMusic> newIndexMusicList = new ArrayList<FullMusic>();
		List<FullMusic> newMusicList = new ArrayList<FullMusic>();
		List<FullMusic> hotMusicList = new ArrayList<FullMusic>();
		List<FullMusic> dlmMusicList = new ArrayList<FullMusic>();
		System.out.println("index success");
		newIndexMusicList = fullMusicService.findAllMusic(0, 12, FullMusic.NEW_MUSIC);
		newMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.NEW_MUSIC);
		hotMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.HOT_MUSIC);
		dlmMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.DOWNLOAD_MOST);
		System.out.println("musicid:" + newIndexMusicList.get(0).getMusicname());
		model.addAttribute("newIndexMusicList", newIndexMusicList);
		model.addAttribute("newMusicList", newMusicList);
		model.addAttribute("hotMusicList", hotMusicList);
		model.addAttribute("dlmMusicList", dlmMusicList);
		return "index";
	}

	@RequestMapping("/index1")
	public void getNewMusic(@RequestBody JSONObject json, HttpServletResponse response) {
		List<FullMusic> newIndexMusicList = new ArrayList<FullMusic>();
		List<FullMusic> newMusicList = new ArrayList<FullMusic>();
		List<FullMusic> hotMusicList = new ArrayList<FullMusic>();
		List<FullMusic> dlmMusicList = new ArrayList<FullMusic>();
		System.out.println("index success");
		newIndexMusicList = fullMusicService.findAllMusic(0, 12, FullMusic.NEW_MUSIC);
		newMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.NEW_MUSIC);
		hotMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.HOT_MUSIC);
		dlmMusicList = fullMusicService.findAllMusic(0, 3, FullMusic.DOWNLOAD_MOST);
		System.out.println("musicid:" + newIndexMusicList.get(0).getMusicname());
		JSONObject rejson = new JSONObject();
		rejson.put("newIndexMusicList", newIndexMusicList);
		rejson.put("newMusicList", newMusicList);
		rejson.put("hotMusicList", hotMusicList);
		rejson.put("dlmMusicList", dlmMusicList);

		try {

			response.getWriter().print(rejson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
