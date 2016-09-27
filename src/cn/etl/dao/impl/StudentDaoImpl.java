package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.StudentDao;
import cn.etl.entity.Student;
@Repository("studentDaoImpl")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

}
