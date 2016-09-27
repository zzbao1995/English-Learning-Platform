package cn.etl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post extends News_Post{
	
	/**
	 * 对应课程的id（必）
	 */
	private int cId;

	/**
	 * 发给的人
	 */
	private String toPerson;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	
	public String getToPerson() {
		return toPerson;
	}
	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}
	
	
	
}
