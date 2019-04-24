package com.zhiyou100.model;

public class Speaker {
	private int id;
	private String speakerName;
	private String speakerJob;
	private String headImgUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speakerName=" + speakerName + ", speakerJob=" + speakerJob + ", headImgUrl="
				+ headImgUrl + "]";
	}
	
	
}
