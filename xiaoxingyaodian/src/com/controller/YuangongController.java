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

import com.entity.Yuangong;
import com.server.YuangongServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuangongController {
	@Resource
	private YuangongServer yuangongService;


   
	@RequestMapping("addYuangong.do")
	public String addYuangong(HttpServletRequest request,Yuangong yuangong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yuangong.setAddtime(time.toString().substring(0, 19));
		yuangongService.add(yuangong);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuangongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuangongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuangong.do")
	public String doUpdateYuangong(int id,ModelMap map,Yuangong yuangong){
		yuangong=yuangongService.getById(id);
		map.put("yuangong", yuangong);
		return "yuangong_updt";
	}
	
	@RequestMapping("doUpdateYuangong2.do")
	public String doUpdateYuangong2(ModelMap map,Yuangong yuangong,HttpServletRequest request){
		yuangong=yuangongService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yuangong", yuangong);
		return "yuangong_updt2";
	}
	
@RequestMapping("updateYuangong2.do")
	public String updateYuangong2(int id,ModelMap map,Yuangong yuangong){
		yuangongService.update(yuangong);
		return "redirect:doUpdateYuangong2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yuangongDetail.do")
	public String yuangongDetail(int id,ModelMap map,Yuangong yuangong){
		yuangong=yuangongService.getById(id);
		map.put("yuangong", yuangong);
		return "yuangong_detail";
	}
//	前台详细
	@RequestMapping("ygDetail.do")
	public String ygDetail(int id,ModelMap map,Yuangong yuangong){
		yuangong=yuangongService.getById(id);
		map.put("yuangong", yuangong);
		return "yuangongdetail";
	}
//	
	@RequestMapping("updateYuangong.do")
	public String updateYuangong(int id,ModelMap map,Yuangong yuangong,HttpServletRequest request,HttpSession session){
		yuangongService.update(yuangong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuangongList.do";
	}

//	分页查询
	@RequestMapping("yuangongList.do")
	public String yuangongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuangong yuangong, String gonghao, String mima, String xingming, String xingbie, String lianxishouji, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yuangongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuangong> list=yuangongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuangong_list";
	}
	
	
	
	@RequestMapping("ygList.do")
	public String ygList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuangong yuangong, String gonghao, String mima, String xingming, String xingbie, String lianxishouji, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yuangongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuangong> list=yuangongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuangonglist";
	}
	
	@RequestMapping("deleteYuangong.do")
	public String deleteYuangong(int id,HttpServletRequest request){
		yuangongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuangongList.do";
	}
	
	@RequestMapping("quchongYuangong.do")
	public void quchongYuangong(Yuangong yuangong,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", yuangong.getGonghao());
		   System.out.println("gonghao==="+yuangong.getGonghao());
		   System.out.println("gonghao222==="+yuangongService.quchongYuangong(map));
		   JSONObject obj=new JSONObject();
		   if(yuangongService.quchongYuangong(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
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
