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

import com.entity.Caigouxinxi;
import com.server.CaigouxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaigouxinxiController {
	@Resource
	private CaigouxinxiServer caigouxinxiService;


   
	@RequestMapping("addCaigouxinxi.do")
	public String addCaigouxinxi(HttpServletRequest request,Caigouxinxi caigouxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caigouxinxi.setAddtime(time.toString().substring(0, 19));
		caigouxinxiService.add(caigouxinxi);
		
		//String sql="";
		//sql="update yaopinxinxi set kucun=kucun+"+caigouxinxi.getCaigoushuliang()+" where yaopinbianhao='"+caigouxinxi.getYaopinbianhao()+"'";
	//	db dbo = new db();
	//	dbo.hsgexecute(sql);

		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caigouxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caigouxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaigouxinxi.do")
	public String doUpdateCaigouxinxi(int id,ModelMap map,Caigouxinxi caigouxinxi){
		caigouxinxi=caigouxinxiService.getById(id);
		map.put("caigouxinxi", caigouxinxi);
		return "caigouxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("caigouxinxiDetail.do")
	public String caigouxinxiDetail(int id,ModelMap map,Caigouxinxi caigouxinxi){
		caigouxinxi=caigouxinxiService.getById(id);
		map.put("caigouxinxi", caigouxinxi);
		return "caigouxinxi_detail";
	}
//	前台详细
	@RequestMapping("cgxxDetail.do")
	public String cgxxDetail(int id,ModelMap map,Caigouxinxi caigouxinxi){
		caigouxinxi=caigouxinxiService.getById(id);
		map.put("caigouxinxi", caigouxinxi);
		return "caigouxinxidetail";
	}
//	
	@RequestMapping("updateCaigouxinxi.do")
	public String updateCaigouxinxi(int id,ModelMap map,Caigouxinxi caigouxinxi,HttpServletRequest request,HttpSession session){
		caigouxinxiService.update(caigouxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caigouxinxiList.do";
	}

//	分页查询
	@RequestMapping("caigouxinxiList.do")
	public String caigouxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String caigoubianhao, String gonghuoshang, String yaopinbianhao, String yaopinmingcheng, String kucun, String jiage1,String jiage2, String caigoushuliang1,String caigoushuliang2, String caigouriqi1,String caigouriqi2, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(caigoubianhao==null||caigoubianhao.equals("")){pmap.put("caigoubianhao", null);}else{pmap.put("caigoubianhao", caigoubianhao);}
		if(gonghuoshang==null||gonghuoshang.equals("")){pmap.put("gonghuoshang", null);}else{pmap.put("gonghuoshang", gonghuoshang);}
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}
		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
		if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
		
		int total=caigouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigouxinxi_list";
	}
	
	
	
	@RequestMapping("cgxxList.do")
	public String cgxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String caigoubianhao, String gonghuoshang, String yaopinbianhao, String yaopinmingcheng, String kucun, String jiage1,String jiage2, String caigoushuliang1,String caigoushuliang2, String caigouriqi1,String caigouriqi2, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(caigoubianhao==null||caigoubianhao.equals("")){pmap.put("caigoubianhao", null);}else{pmap.put("caigoubianhao", caigoubianhao);}
		if(gonghuoshang==null||gonghuoshang.equals("")){pmap.put("gonghuoshang", null);}else{pmap.put("gonghuoshang", gonghuoshang);}
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}
		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
		if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
		
		int total=caigouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigouxinxilist";
	}
	
	@RequestMapping("deleteCaigouxinxi.do")
	public String deleteCaigouxinxi(int id,HttpServletRequest request){
		caigouxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caigouxinxiList.do";
	}
	
	
}
