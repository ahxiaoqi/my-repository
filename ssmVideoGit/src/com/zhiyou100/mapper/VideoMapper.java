package com.zhiyou100.mapper;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;

public interface VideoMapper {
	// 查询所有video
	List<Video> videoList();
	// 查询讲师
	List<Speaker> findSpeaker();
	// 查询course
	List<Course> findCourse();
	void insertVideo(Video video);
	Video selectVideoById(String id);
	void updateVideo(Video video);
	void deleteVedio(String id);
	void deleteBatchVedio(int[] checkId);
	List<Video> findVedioByCondition(Video video);
}
