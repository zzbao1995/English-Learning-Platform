/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package cn.etl.util;

import java.io.Serializable;
import java.util.List;


public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = -3930180379790344299L;

	private List<T> data;              // List数据
	private int totalCount;      		//总记录数
    private int pageSize;             //每页的记录数
    private int pageIndex;
    private int mxIndex;
	public PageBean(int totalCount,List<T> data,int pageSize,int pageIndex){
		this.totalCount = totalCount;
		this.data = data;
		this.pageSize=pageSize;
		this.pageIndex=pageIndex;
		mxIndex=(totalCount-1)/pageSize+1;
	}
	
	

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	


	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	public int getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	public int getPageIndex() {
		
		return pageIndex;
	}
	public int getReasonableIndex(int index)
	{
		if(index>mxIndex)
			index=mxIndex;
		if(index<1) index=1;
		return index;
	}



	public int getMxIndex() {
		return mxIndex;
	}



	public void setMxIndex(int mxIndex) {
		this.mxIndex = mxIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getPrePage()
	{
		return getReasonableIndex(pageIndex-1);
	}
	public int getNextPage()
	{
		return getReasonableIndex(pageIndex+1);
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}