package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.NewsDao;
import cn.etl.entity.News;
@Repository("newsDaoImpl")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

}
