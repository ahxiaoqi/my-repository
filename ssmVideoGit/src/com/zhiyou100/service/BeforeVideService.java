package com.zhiyou100.service;


import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;

public interface BeforeVideService {
	Subject getVideoBySubjectId(String subjectId);

	Video findVideoByVideoId(String videoId);

}
