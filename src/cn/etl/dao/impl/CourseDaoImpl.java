package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.CourseDao;
import cn.etl.entity.Course;
@Repository("courseDaoImpl")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

}
