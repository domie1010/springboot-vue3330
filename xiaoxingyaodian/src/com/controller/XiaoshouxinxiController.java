package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Xiaoshouxinxi;
import com.server.XiaoshouxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiaoshouxinxiController {
	@Resource
	private XiaoshouxinxiServer xiaoshouxinxiService;


   
	@RequestMapping("addXiaoshouxinxi.do")
	public String addXiaoshouxinxi(HttpServletRequest request,Xiaoshouxinxi xiaoshouxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoshouxinxi.setAddtime(time.toString().substring(0, 19));
		xiaoshouxinxiService.add(xiaoshouxinxi);
		
		String sql="";
		sql="update yaopinxinxi set kucun=kucun-"+xiaoshouxinxi.getXiaoshoushuliang()+" where yaopinbianhao='"+xiaoshouxinxi.getYaopinbianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);

		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoshouxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoshouxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoshouxinxi.do")
	public String doUpdateXiaoshouxinxi(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiaoshouxinxiDetail.do")
	public String xiaoshouxinxiDetail(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxi_detail";
	}
//	前台详细
	@RequestMapping("xsxxDetail.do")
	public String xsxxDetail(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxidetail";
	}
//	
	@RequestMapping("updateXiaoshouxinxi.do")
	public String updateXiaoshouxinxi(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi,HttpServletRequest request,HttpSession session){
		xiaoshouxinxiService.update(xiaoshouxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoshouxinxiList.do";
	}

//	分页查询
	@RequestMapping("xiaoshouxinxiList.do")
	public String xiaoshouxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouxinxi xiaoshouxinxi, String xiaoshoubianhao, String yaopinbianhao, String yaopinmingcheng, String kucun, String xiaoshoujiage1,String xiaoshoujiage2, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoushijian1,String xiaoshoushijian2, String danju, String qiye, String dizhi, String lianxishouji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoubianhao==null||xiaoshoubianhao.equals("")){pmap.put("xiaoshoubianhao", null);}else{pmap.put("xiaoshoubianhao", xiaoshoubianhao);}
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}
		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(xiaoshoujiage1==null||xiaoshoujiage1.equals("")){pmap.put("xiaoshoujiage1", null);}else{pmap.put("xiaoshoujiage1", xiaoshoujiage1);}
		if(xiaoshoujiage2==null||xiaoshoujiage2.equals("")){pmap.put("xiaoshoujiage2", null);}else{pmap.put("xiaoshoujiage2", xiaoshoujiage2);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoushijian1==null||xiaoshoushijian1.equals("")){pmap.put("xiaoshoushijian1", null);}else{pmap.put("xiaoshoushijian1", xiaoshoushijian1);}
		if(xiaoshoushijian2==null||xiaoshoushijian2.equals("")){pmap.put("xiaoshoushijian2", null);}else{pmap.put("xiaoshoushijian2", xiaoshoushijian2);}
		if(danju==null||danju.equals("")){pmap.put("danju", null);}else{pmap.put("danju", danju);}
		if(qiye==null||qiye.equals("")){pmap.put("qiye", null);}else{pmap.put("qiye", qiye);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		
		int total=xiaoshouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouxinxi> list=xiaoshouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouxinxi_list";
	}
	
	
	
	@RequestMapping("xsxxList.do")
	public String xsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouxinxi xiaoshouxinxi, String xiaoshoubianhao, String yaopinbianhao, String yaopinmingcheng, String kucun, String xiaoshoujiage1,String xiaoshoujiage2, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoushijian1,String xiaoshoushijian2, String danju, String qiye, String dizhi, String lianxishouji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoubianhao==null||xiaoshoubianhao.equals("")){pmap.put("xiaoshoubianhao", null);}else{pmap.put("xiaoshoubianhao", xiaoshoubianhao);}
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}
		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(xiaoshoujiage1==null||xiaoshoujiage1.equals("")){pmap.put("xiaoshoujiage1", null);}else{pmap.put("xiaoshoujiage1", xiaoshoujiage1);}
		if(xiaoshoujiage2==null||xiaoshoujiage2.equals("")){pmap.put("xiaoshoujiage2", null);}else{pmap.put("xiaoshoujiage2", xiaoshoujiage2);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoushijian1==null||xiaoshoushijian1.equals("")){pmap.put("xiaoshoushijian1", null);}else{pmap.put("xiaoshoushijian1", xiaoshoushijian1);}
		if(xiaoshoushijian2==null||xiaoshoushijian2.equals("")){pmap.put("xiaoshoushijian2", null);}else{pmap.put("xiaoshoushijian2", xiaoshoushijian2);}
		if(danju==null||danju.equals("")){pmap.put("danju", null);}else{pmap.put("danju", danju);}
		if(qiye==null||qiye.equals("")){pmap.put("qiye", null);}else{pmap.put("qiye", qiye);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		
		int total=xiaoshouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouxinxi> list=xiaoshouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouxinxilist";
	}
	
	@RequestMapping("deleteXiaoshouxinxi.do")
	public String deleteXiaoshouxinxi(int id,HttpServletRequest request){
		xiaoshouxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoshouxinxiList.do";
	}
	
	
}
