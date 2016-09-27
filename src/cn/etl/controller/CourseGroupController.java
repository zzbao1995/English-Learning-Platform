package cn.etl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.etl.dao.BaseDao;
import cn.etl.entity.CourseGroup;
@Controller
@RequestMapping("/courseGroup")
public class CourseGroupController extends BaseController<CourseGroup> {
	@Override
	@Resource(name="courseGroupDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
	@RequestMapping("add")
	public String add(CourseGroup entity, Model model,String[] _urls, String[] _urlNames)
	{
		
		if(_urls!=null && _urlNames!=null)
		{
			String urls = "";
			String urlNames="";
			for(int i=0;i<_urls.length;i++)
			{
				urls+=_urls[i];
				urlNames+=_urlNames[i];
			}
			entity.setUrls(urls);
			entity.setUrlNames(urlNames);
		}
		add(entity,model);
		return "/admin/courseGroupForm.jsp";
	}
	public String delete(String[] id,Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("msg",super.delete(id));
		return "/admin/courseGroupList.jsp";
	}
	@RequestMapping("modify")
	public String modify(CourseGroup entity, Model model,String[] _urls, String[] _urlNames)
	{
		
		if(_urls!=null && _urlNames!=null)
		{
			String urls = "";
			String urlNames="";
			for(int i=0;i<_urls.length;i++)
			{
				urls+=_urls[i];
				urlNames+=_urlNames[i];
			}
			entity.setUrls(urls);
			entity.setUrlNames(urlNames);
		}
		modify(entity,model);
		return "/admin/courseGroupForm.jsp";
	}
}
