package com.zhiyou100.model;

import java.util.List;

public class Subject {
	private int id;
	private String subjectName;
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	private List<Course> courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", courses=" + courses + "]";
	}
	
	
	
	
	
}
