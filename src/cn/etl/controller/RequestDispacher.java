package cn.etl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.etl.dao.CourseDao;
import cn.etl.dao.CourseGroupDao;
import cn.etl.dao.UnitDao;
import cn.etl.settting.Constant;

@Controller
@RequestMapping("")
public class RequestDispacher {
	@Resource(name="courseDaoImpl")
	private CourseDao courseDao;
	@Resource(name="unitDaoImpl")
	private UnitDao unitDao;
	@Resource(name="courseGroupDaoImpl")
	private CourseGroupDao cGDao;
	@RequestMapping("/home")
	public String Home()
	{
		
		return Constant.HOME;
	}
	@RequestMapping("/loginPage")
	public String loginPage()
	{
		return Constant.LOGIN;
	}
	@RequestMapping("/admin")
	public String admin(){
		return "/admin/admin.jsp";
	}
	@RequestMapping("/header")
	public String header(Model model){
		model.addAttribute("cList", courseDao.find("from Course order by id asc"));
		model.addAttribute("cGList", cGDao.find("from CourseGroup order by id asc"));
		return "/header.jsp";
	}
	@RequestMapping("{key}.adm")
	public String AdmDispatcher(@PathVariable String key, Model model){
		return "/"+key+"/1/0.htm?view=/admin/"+key+"List.jsp";
	}
}
