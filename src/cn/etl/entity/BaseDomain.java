package cn.etl.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 
 * @author Luckiee
 * @since 2016/3/15
 */
public class BaseDomain implements Serializable{
private static final long serialVersionUID = 1L;
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
		
	}
	public Serializable keyClass(){
		return Integer.class;
	}
	public Serializable key(){
		return null;
	}
}
