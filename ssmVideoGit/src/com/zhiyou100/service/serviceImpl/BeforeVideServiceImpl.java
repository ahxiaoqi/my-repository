package com.zhiyou100.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.BeforeVideMapper;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BeforeVideService;
@Service
public class BeforeVideServiceImpl implements BeforeVideService{
	@Autowired
	BeforeVideMapper mapper;
	public Subject getVideoBySubjectId(String subjectId) {
		Subject subject = mapper.BeforeVideService(subjectId);
		return subject;
	}
	public Video findVideoByVideoId(String videoId) {
		return mapper.findVideoByVideoId(videoId);
	}

}
