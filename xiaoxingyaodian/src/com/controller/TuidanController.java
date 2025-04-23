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

import com.entity.Tuidan;
import com.server.TuidanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TuidanController {
	@Resource
	private TuidanServer tuidanService;


   
	@RequestMapping("addTuidan.do")
	public String addTuidan(HttpServletRequest request,Tuidan tuidan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tuidan.setAddtime(time.toString().substring(0, 19));
		tuidanService.add(tuidan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tuidanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tuidanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTuidan.do")
	public String doUpdateTuidan(int id,ModelMap map,Tuidan tuidan){
		tuidan=tuidanService.getById(id);
		map.put("tuidan", tuidan);
		return "tuidan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("tuidanDetail.do")
	public String tuidanDetail(int id,ModelMap map,Tuidan tuidan){
		tuidan=tuidanService.getById(id);
		map.put("tuidan", tuidan);
		return "tuidan_detail";
	}
//	前台详细
	@RequestMapping("tdDetail.do")
	public String tdDetail(int id,ModelMap map,Tuidan tuidan){
		tuidan=tuidanService.getById(id);
		map.put("tuidan", tuidan);
		return "tuidandetail";
	}
//	
	@RequestMapping("updateTuidan.do")
	public String updateTuidan(int id,ModelMap map,Tuidan tuidan,HttpServletRequest request,HttpSession session){
		tuidanService.update(tuidan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tuidanList.do";
	}

//	分页查询
	@RequestMapping("tuidanList.do")
	public String tuidanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuidan tuidan, String xiaoshoubianhao, String tuidanyuanyin, String tuidanshijian1,String tuidanshijian2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoubianhao==null||xiaoshoubianhao.equals("")){pmap.put("xiaoshoubianhao", null);}else{pmap.put("xiaoshoubianhao", xiaoshoubianhao);}		if(tuidanyuanyin==null||tuidanyuanyin.equals("")){pmap.put("tuidanyuanyin", null);}else{pmap.put("tuidanyuanyin", tuidanyuanyin);}		if(tuidanshijian1==null||tuidanshijian1.equals("")){pmap.put("tuidanshijian1", null);}else{pmap.put("tuidanshijian1", tuidanshijian1);}		if(tuidanshijian2==null||tuidanshijian2.equals("")){pmap.put("tuidanshijian2", null);}else{pmap.put("tuidanshijian2", tuidanshijian2);}		
		int total=tuidanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuidan> list=tuidanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuidan_list";
	}
	
	
	
	@RequestMapping("tdList.do")
	public String tdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuidan tuidan, String xiaoshoubianhao, String tuidanyuanyin, String tuidanshijian1,String tuidanshijian2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoubianhao==null||xiaoshoubianhao.equals("")){pmap.put("xiaoshoubianhao", null);}else{pmap.put("xiaoshoubianhao", xiaoshoubianhao);}		if(tuidanyuanyin==null||tuidanyuanyin.equals("")){pmap.put("tuidanyuanyin", null);}else{pmap.put("tuidanyuanyin", tuidanyuanyin);}		if(tuidanshijian1==null||tuidanshijian1.equals("")){pmap.put("tuidanshijian1", null);}else{pmap.put("tuidanshijian1", tuidanshijian1);}		if(tuidanshijian2==null||tuidanshijian2.equals("")){pmap.put("tuidanshijian2", null);}else{pmap.put("tuidanshijian2", tuidanshijian2);}		
		int total=tuidanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuidan> list=tuidanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuidanlist";
	}
	
	@RequestMapping("deleteTuidan.do")
	public String deleteTuidan(int id,HttpServletRequest request){
		tuidanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tuidanList.do";
	}
	
	
}
