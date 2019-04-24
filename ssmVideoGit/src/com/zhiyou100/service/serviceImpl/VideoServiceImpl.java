package com.zhiyou100.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.VideoMapper;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper videoMapper;
	
	// 查询所有video
	public List<Video> videoList() {
		List<Video> videos = videoMapper.videoList();
		return videos;
	}
	// 查询讲师
	public List<Speaker> findSpeaker() {
		List<Speaker> speakers =  videoMapper.findSpeaker();
		return speakers;
	}
	// 查询course
	public List<Course> findCourse() {
		List<Course> courses = videoMapper.findCourse();
		return courses;
	}
	// 添加video
	public void insertVideo(Video video) {
		videoMapper.insertVideo(video);
	}
	// 通过id查找要编辑的video信息
	public Video selectVideoById(String id) {
		return videoMapper.selectVideoById(id);
	}
	// 编辑视频
	public void updateVideo(Video video) {
		videoMapper.updateVideo(video);
	}
	public void deleteVedio(String id) {
		videoMapper.deleteVedio(id);
		
	}
	public void deleteBatchVedio(int[] checkId) {
		videoMapper.deleteBatchVedio(checkId);
		
	}
	// 模糊查询
	public List<Video> findVedioByCondition(Video video) {
		 return videoMapper.findVedioByCondition(video);
	}
	

}
