package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BeforeVideService;

@Controller
@RequestMapping("/web")
public class BeforeVideController {
	@Autowired
	BeforeVideService videoService;
	@RequestMapping("/toList.do")
	public String toVideoList(String SubjectId,Model model,@RequestParam(value="pageNo",defaultValue="1")int pageNo) {
		System.out.println("需要查询的专辑id为:"+SubjectId);
		PageHelper.startPage(pageNo,5);
		Subject subject = videoService.getVideoBySubjectId(SubjectId);
		
		System.out.println("查询到的Subject信息为"+subject);
		model.addAttribute("subject",subject);
		model.addAttribute("pageNo", pageNo);
		
		return "/before/course/beforeCourseIndex";
	}
	@RequestMapping("/tovideoById.do")
	public String findVideoByVideoId(String videoId,Model model) {
		Video video =  videoService.findVideoByVideoId(videoId);
		model.addAttribute("video",video);
		return "/before/video/beforeVideoIndex";
	}
	
}
