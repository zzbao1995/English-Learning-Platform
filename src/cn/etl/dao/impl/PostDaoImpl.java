package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.PostDao;
import cn.etl.entity.Post;
@Repository("postDaoImpl")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{

}
