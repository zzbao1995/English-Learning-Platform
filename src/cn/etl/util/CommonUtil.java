package cn.etl.util;

import java.util.Date;

import cn.etl.entity.User;


public class CommonUtil {
	public static final String fLTLC(String s)
	{
		s=s.substring(0,1).toLowerCase()+s.substring(1,s.length());
		return s;
	}
	public static final String encode(User u)
	{
		return u.getClass().getSimpleName().charAt(0)+":"+u.getUsername();
	}
}
