package cn.etl.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Unit extends BaseDomain{
	/**
	 * 单元id
	 */
	@Id
	private int id;
	/**
	 * 单元介绍
	 */
	private String uIntro;
	/**
	 * 单元名称(必）
	 */
	private String uName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuIntro() {
		return uIntro;
	}
	public void setuIntro(String uIntro) {
		this.uIntro = uIntro;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public Serializable key() {
		// TODO Auto-generated method stub
		return id;
	}
}
