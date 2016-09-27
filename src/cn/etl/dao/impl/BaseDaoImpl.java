package cn.etl.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.etl.dao.BaseDao;
import cn.etl.entity.BaseDomain;
import cn.etl.settting.Constant;
import cn.etl.util.PageBean;


@Transactional
public  class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> entityClass;
	private Class<?> keyClass;
	private HibernateTemplate hibernateTemplate;//hibernateTemplate就是hibernate
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
		try{
			Method m = entityClass.getMethod("keyClass");
			T obj = entityClass.newInstance();
			keyClass = (Class<?>) m.invoke(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public T load(Serializable id) {//返回一个数据库里的实体，Serializable是一个接口，可序列化
		System.out.println("in the load(id)");
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	
	@Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
		Serializable key=id;
		if(id instanceof String&&keyClass == Integer.class)
			key = Integer.valueOf((String)id);
		return this.getHibernateTemplate().get(entityClass, key);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#loadAll()
	 */
	@Override
	public List<T> loadAll() {
		//使用这个方法会出BUG...调试中
		System.out.println("in the BaseDaoImpl");
		return this.getHibernateTemplate().loadAll(entityClass);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#save(T)
	 */
	@Override
	public boolean save(T entity) {                 //泛型
		System.out.println("in the baseDao Impl");
		try{
		this.getHibernateTemplate().save(entity);
		}catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#remove(T)
	 */
	@Override
	public boolean remove(T entity) {
		try{
		this.getHibernateTemplate().delete(entity);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean remove(Serializable id) {
		T t=get(id);
		if(t!=null) remove(t);
		return true;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#update(T)
	 */
	@Override
	public boolean update(T entity) {
		try{
		this.getHibernateTemplate().update(entity);
		}catch(Exception  e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#find(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		System.out.println("hql in the BaseDaoImpl:"+hql);
		return  (List<T>) this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gslab.dao.impl.BaseDao#find(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Object... params) {
		return (List<T>) this.getHibernateTemplate().find(hql, params);
	}

	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}



	public Query createQuery(String hql, Object[] values) {
		// TODO Auto-generated method stub
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	// ---
	public Session getSession() {
		// TODO Auto-generated method stub
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		return session;
	}

	private String removeSelect(String hql) {
		// TODO Auto-generated method stub
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, "hql:" + hql
				+ "must have a keyword 'from'");
		
		return hql.substring(beginPos);
	}

	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s * by[\\w\\W\\s\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}


	@Resource(name = "hibernateTemplate")//相当于set方法
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		//配置查询缓存
		//hibernateTemplate.setCacheQueries(true);
		this.hibernateTemplate = hibernateTemplate;
		
	}



	@Override
	public long getCount(String hql) {
		// TODO Auto-generated method stub
		hql="select count(*) "+hql; 
		List<Long> list=(List<Long>) hibernateTemplate.find(hql);
		return list.get(0);
	}



	@Override
	public Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		return entityClass;
	}



	@Override
	public PageBean<T> getPage(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		if(pageIndex==null) pageIndex=1;
		if(pageSize==null||pageSize.equals(0)) pageSize=Constant.PAGE_SIZE.get(entityClass.getSimpleName());
		if(null == pageSize) pageSize = 15;
		final String hql="from "+getEntityClass().getSimpleName();
		return getPage(hql,pageIndex,pageSize);
	}
	@Override
	public PageBean<T> getPage(final String hql, Integer pageIndex, final Integer pageSize)  {
		// TODO Auto-generated method stub
		int total=(int) getCount(hql);
		int mxIndex=(total-1)/pageSize+1;
		if(pageIndex>mxIndex) pageIndex=mxIndex;
		if(pageIndex<1) pageIndex=1;
		final int offset=(pageIndex-1)*pageSize;
		 @SuppressWarnings("unchecked")
		List<T> list = getHibernateTemplate().execute(new HibernateCallback() {     
			    public Object doInHibernate(Session session)     
			    {     
			     Query query = session.createQuery(hql);     
			     query.setFirstResult(offset);     
			     query.setMaxResults(pageSize);     
			     List<T> list = query.list();     
			     return list;     
			    }     
			   });     
		 return new PageBean<T>(total,list,pageSize,pageIndex);
	}
	public boolean saveOrUpdate(T entity){
		try{
			getHibernateTemplate().saveOrUpdate(entity);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
}
