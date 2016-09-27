package cn.etl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
public class News_Post extends BaseDomain {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 帖子内容（必）
	 */
	@Column(name="_content")
	private String content;
	/**
	 * 帖子标题（必）
	 */
	@Column(name="_title")
	private String title;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="_time")
	private Date time;
	/**
	 * 发布人的username
	 */
	private String publisher;
	/**
	 * 发表人角色,0表示老师，1表示学生
	 */
	private int publishRole; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishRole() {
		return publishRole;
	}

	public void setPublishRole(int publishRole) {
		this.publishRole = publishRole;
	}
	
	@Override
	public Serializable key() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
