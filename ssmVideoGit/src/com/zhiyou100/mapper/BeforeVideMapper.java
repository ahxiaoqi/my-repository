package com.zhiyou100.mapper;


import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;


public interface BeforeVideMapper {

	Subject BeforeVideService(String subjectId);

	Video findVideoByVideoId(String videoId);

}
