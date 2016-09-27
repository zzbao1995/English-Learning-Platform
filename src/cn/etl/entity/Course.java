package cn.etl.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Course extends BaseDomain {
	@Id
	private String id;
	/**
	 * 课程名称
	 */
	private String cName;
	/**
	 * 课程组名称
	 */
	private String gName;
	/**
	 * 课程介绍
	 */
	private String cIntro;
	/**
	 * 学分（必）
	 */
	private String credits;
	/**
	 * 负责上传课件，微课，作业的老师
	 */
	private String chief;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcIntro() {
		return cIntro;
	}
	public void setcIntro(String cIntro) {
		this.cIntro = cIntro;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
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
