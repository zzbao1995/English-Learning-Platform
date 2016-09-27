package cn.etl.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.etl.dao.BaseDao;
import cn.etl.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController<Student>{
	@Override
	@Resource(name="studentDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
}
