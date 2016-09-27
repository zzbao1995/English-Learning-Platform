package cn.etl.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
public class CourseGroup extends BaseDomain{
	@Id
	private String id;
	/**
	 * 课程组名称
	 */
	private String gName;
	/**
	 * 课程组学习链接,链接之间已分号分隔
	 */
	private String urls;
	/**
	 * 学习链接的名称,名称之间用分号分隔
	 */
	private String urlNames;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	
	public String getUrlNames() {
		return urlNames;
	}
	public void setUrlNames(String urlNames) {
		this.urlNames = urlNames;
	}
	@Override
	public Serializable keyClass() {
		// TODO Auto-generated method stub
		return String.class;
	}
	@Override
	public Serializable key() {
		// TODO Auto-generated method stub
		return id;
	}
}
