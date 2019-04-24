package com.zhiyou100.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	// 查询所有video
	@SuppressWarnings("deprecation")
	@RequestMapping("/list.do")
	public String videoList(Model model){
		// 查询speaker
		List<Speaker> speakers =  videoService.findSpeaker();
		// 查询course
		List<Course> courses = videoService.findCourse();
		PageHelper.startPage(1,5);
		
		List<Video> videos =  videoService.videoList();
		PageInfo page = new PageInfo(videos);
		model.addAttribute("speakers", speakers);
		model.addAttribute("courses", courses);
		model.addAttribute("videos", videos);
		model.addAttribute("page",page);
		return"/behind/video/listVideo";
	}
	// 模糊查询
	@RequestMapping(value="findVedioByCondition.do",method= RequestMethod.POST)
	public String findVedioByCondition(Model model,Video video,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="",defaultValue="5")int pageCount) {
//		String speakerId,String courseId,String detail,String title
		System.out.println("页面封装的video为:"+video);
		// 查询speaker
		List<Speaker> speakers =  videoService.findSpeaker();
		// 查询course
		List<Course> courses = videoService.findCourse();
		PageHelper.startPage(pageNo,pageCount);
		List<Video> videos =  videoService.findVedioByCondition(video);
		PageInfo page = new PageInfo(videos);
		model.addAttribute("page",page);
		model.addAttribute("speakers", speakers);
		model.addAttribute("courses", courses);
		model.addAttribute("videos", videos);
		model.addAttribute("speakerId",video.getSpeakerId());
		model.addAttribute("courseId",video.getCourseId());
		model.addAttribute("detailInput",video.getDetail());
		model.addAttribute("titleInput",video.getTitle());
		return"/behind/video/listVideo";
	}
	// 跳转add页面
	@RequestMapping(value="/toadd.do",method=RequestMethod.GET)
	public String toadd(Model model){
		// 查询speaker
		List<Speaker> speakers =  videoService.findSpeaker();
		// 查询course
		List<Course> courses = videoService.findCourse();
		model.addAttribute("speakers", speakers);
		model.addAttribute("courses", courses);
		return"/behind/video/addVideo";
	}
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public String add(Video video,MultipartFile[] file) throws IllegalStateException, IOException{
		// 添加video
		System.out.println("页面获取的video对象为:"+video);
		if(file[0] != null) {
			// 上传的文件名,包括路径名
			String originalFilename = file[0].getOriginalFilename();
			if(!"".equals(originalFilename)||originalFilename==null) {
				String imageFilename = doFileName(originalFilename);
				String path = "H:\\fileUpload\\images\\"+imageFilename;
				System.out.println(path);
				file[0].transferTo(new File(path));
				video.setImageUrl(imageFilename);
			}
		}
		if(file[1] != null) {
			// 上传的文件名,包括路径名
			String path = "H:\\fileUpload\\video\\";
			InputStream inputStream = file[1].getInputStream();
			String originalFilename = file[1].getOriginalFilename();
			if(!"".equals(originalFilename)||originalFilename==null) {
				String videoFiledname = doFileName(originalFilename);
				FileOutputStream outputStream = new FileOutputStream(new File(path,videoFiledname));
				IOUtils.copy(inputStream, outputStream);
				inputStream.close();
				outputStream.close();
				video.setVideoUrl(videoFiledname);
			}
			
		}
		
		videoService.insertVideo(video);
		return "redirect:list.do";
	}
	@RequestMapping(value="/toUpdate.do",method=RequestMethod.GET)
	public String toupdate(String id,Model model){
		Video video = videoService.selectVideoById(id);
		// 查询speaker
		List<Speaker> speakers =  videoService.findSpeaker();
		// 查询course
		List<Course> courses = videoService.findCourse();
		model.addAttribute("speakers", speakers);
		model.addAttribute("courses", courses);
		model.addAttribute("video", video);
		System.out.println("要编辑的video信息为:"+video);
		return "/behind/video/updateVideo";
	}
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String updateVideo(Video video,MultipartFile[] file) throws IllegalStateException, IOException{
		// 编辑视频
		System.out.println("修改文件时文件数组长度为:"+file.length);
		System.out.println("修改时video信息为:"+video);
		System.out.println("文件上传的数组为:"+file);
		if(file.length!=0) {
			if(file[0] != null) {
				// 上传的文件名,包括路径名
				String originalFilename = file[0].getOriginalFilename();
				if(!"".equals(originalFilename)||originalFilename==null) {
					String imageFilename = doFileName(originalFilename);
					String path = "H:\\fileUpload\\images\\"+imageFilename;
					System.out.println(path);
					file[0].transferTo(new File(path));
					video.setImageUrl(imageFilename);
				}
			}
			if(file[1] != null) {
				// 上传的文件名,包括路径名
				String path = "H:\\fileUpload\\video\\";
				InputStream inputStream = file[1].getInputStream();
				String originalFilename = file[1].getOriginalFilename();
				if(!"".equals(originalFilename)||originalFilename==null) {
					String videoFiledname = doFileName(originalFilename);
					FileOutputStream outputStream = new FileOutputStream(new File(path,videoFiledname));
					IOUtils.copy(inputStream, outputStream);
					inputStream.close();
					outputStream.close();
					video.setVideoUrl(videoFiledname);
				}
			}
		}
		
		videoService.updateVideo(video);
		
		
		
		
		return "redirect:list.do";
	}
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public String deleteVedio(String id){
		// 删除视频
		videoService.deleteVedio(id);
		return "redirect:/video/list.do";
	}
	@RequestMapping(value="/deleteBatch.do",method=RequestMethod.POST)
	public String deleteBatchVedio(int[] checkId){
		// 删除视频
		System.out.println("页面保存的id数组为:"+checkId);
		if(checkId != null){
			videoService.deleteBatchVedio(checkId);
		}
		return "redirect:/video/list.do";
	}
	
	/*
	 * 自定义工具方法:为文件创建随机名
	 */
	private String doFileName(String originalFilename) {
		//获取文件的后缀名
		String extension  = FilenameUtils.getExtension(originalFilename);
		//获取uuid字符串-->随机数当做文件名
		String uuid = UUID.randomUUID().toString();
		// 随机数+后缀
		return uuid+"."+extension;
	}
	/*
	 * 自定义工具方法:获取项目路径
	 */
	private String getRealPath(HttpServletRequest request, String string) {
		// 通过请求对象获取当前项目路径
		String realPath = request.getServletContext().getRealPath(string);
		// 创建要上传的images文件夹
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		return realPath;
	}
	
	
	
	
	
	
}
