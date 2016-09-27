package cn.etl.entity;

import javax.persistence.Entity;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
public class Teacher extends User{
	/**
	 * 教师简介
	 */
	private String intro;

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
