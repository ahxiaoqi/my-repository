package com.zhiyou100.model;

public class Video {
	private int id;
	private String title;
	private String detail;
	private int time;
	private int speakerId;
	private int courseId;
	private String videoUrl;
	private String imageUrl;
	private int playNum;
	private Course course;
	private Speaker speaker;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPlayNum() {
		return playNum;
	}
	public void setPlayNum(int playNum) {
		this.playNum = playNum;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", detail=" + detail + ", time=" + time + ", speakerId="
				+ speakerId + ", courseId=" + courseId + ", videoUrl=" + videoUrl + ", imageUrl=" + imageUrl
				+ ", playNum=" + playNum + ", course=" + course + ", speaker=" + speaker + "]";
	}
	
	
	
	
}
