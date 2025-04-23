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

import com.entity.Gonghuoshangxinxi;
import com.server.GonghuoshangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GonghuoshangxinxiController {
	@Resource
	private GonghuoshangxinxiServer gonghuoshangxinxiService;


   
	@RequestMapping("addGonghuoshangxinxi.do")
	public String addGonghuoshangxinxi(HttpServletRequest request,Gonghuoshangxinxi gonghuoshangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gonghuoshangxinxi.setAddtime(time.toString().substring(0, 19));
		gonghuoshangxinxiService.add(gonghuoshangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gonghuoshangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gonghuoshangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGonghuoshangxinxi.do")
	public String doUpdateGonghuoshangxinxi(int id,ModelMap map,Gonghuoshangxinxi gonghuoshangxinxi){
		gonghuoshangxinxi=gonghuoshangxinxiService.getById(id);
		map.put("gonghuoshangxinxi", gonghuoshangxinxi);
		return "gonghuoshangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gonghuoshangxinxiDetail.do")
	public String gonghuoshangxinxiDetail(int id,ModelMap map,Gonghuoshangxinxi gonghuoshangxinxi){
		gonghuoshangxinxi=gonghuoshangxinxiService.getById(id);
		map.put("gonghuoshangxinxi", gonghuoshangxinxi);
		return "gonghuoshangxinxi_detail";
	}
//	前台详细
	@RequestMapping("ghsxxDetail.do")
	public String ghsxxDetail(int id,ModelMap map,Gonghuoshangxinxi gonghuoshangxinxi){
		gonghuoshangxinxi=gonghuoshangxinxiService.getById(id);
		map.put("gonghuoshangxinxi", gonghuoshangxinxi);
		return "gonghuoshangxinxidetail";
	}
//	
	@RequestMapping("updateGonghuoshangxinxi.do")
	public String updateGonghuoshangxinxi(int id,ModelMap map,Gonghuoshangxinxi gonghuoshangxinxi,HttpServletRequest request,HttpSession session){
		gonghuoshangxinxiService.update(gonghuoshangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gonghuoshangxinxiList.do";
	}

//	分页查询
	@RequestMapping("gonghuoshangxinxiList.do")
	public String gonghuoshangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gonghuoshangxinxi gonghuoshangxinxi, String gonghuoshang, String lianxishouji, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghuoshang==null||gonghuoshang.equals("")){pmap.put("gonghuoshang", null);}else{pmap.put("gonghuoshang", gonghuoshang);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=gonghuoshangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gonghuoshangxinxi> list=gonghuoshangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gonghuoshangxinxi_list";
	}
	
	
	
	@RequestMapping("ghsxxList.do")
	public String ghsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gonghuoshangxinxi gonghuoshangxinxi, String gonghuoshang, String lianxishouji, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghuoshang==null||gonghuoshang.equals("")){pmap.put("gonghuoshang", null);}else{pmap.put("gonghuoshang", gonghuoshang);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=gonghuoshangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gonghuoshangxinxi> list=gonghuoshangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gonghuoshangxinxilist";
	}
	
	@RequestMapping("deleteGonghuoshangxinxi.do")
	public String deleteGonghuoshangxinxi(int id,HttpServletRequest request){
		gonghuoshangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gonghuoshangxinxiList.do";
	}
	
	@RequestMapping("quchongGonghuoshangxinxi.do")
	public void quchongGonghuoshangxinxi(Gonghuoshangxinxi gonghuoshangxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghuoshang", gonghuoshangxinxi.getGonghuoshang());
		   System.out.println("gonghuoshang==="+gonghuoshangxinxi.getGonghuoshang());
		   System.out.println("gonghuoshang222==="+gonghuoshangxinxiService.quchongGonghuoshangxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(gonghuoshangxinxiService.quchongGonghuoshangxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "供货商可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
