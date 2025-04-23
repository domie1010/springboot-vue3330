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

import com.entity.Yaopinxinxi;
import com.server.YaopinxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YaopinxinxiController {
	@Resource
	private YaopinxinxiServer yaopinxinxiService;


   
	@RequestMapping("addYaopinxinxi.do")
	public String addYaopinxinxi(HttpServletRequest request,Yaopinxinxi yaopinxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yaopinxinxi.setAddtime(time.toString().substring(0, 19));
		yaopinxinxiService.add(yaopinxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yaopinxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yaopinxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYaopinxinxi.do")
	public String doUpdateYaopinxinxi(int id,ModelMap map,Yaopinxinxi yaopinxinxi){
		yaopinxinxi=yaopinxinxiService.getById(id);
		map.put("yaopinxinxi", yaopinxinxi);
		return "yaopinxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yaopinxinxiDetail.do")
	public String yaopinxinxiDetail(int id,ModelMap map,Yaopinxinxi yaopinxinxi){
		yaopinxinxi=yaopinxinxiService.getById(id);
		map.put("yaopinxinxi", yaopinxinxi);
		return "yaopinxinxi_detail";
	}
//	前台详细
	@RequestMapping("ypxxDetail.do")
	public String ypxxDetail(int id,ModelMap map,Yaopinxinxi yaopinxinxi){
		yaopinxinxi=yaopinxinxiService.getById(id);
		map.put("yaopinxinxi", yaopinxinxi);
		return "yaopinxinxidetail";
	}
//	
	@RequestMapping("updateYaopinxinxi.do")
	public String updateYaopinxinxi(int id,ModelMap map,Yaopinxinxi yaopinxinxi,HttpServletRequest request,HttpSession session){
		yaopinxinxiService.update(yaopinxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yaopinxinxiList.do";
	}

//	分页查询
	@RequestMapping("yaopinxinxiList.do")
	public String yaopinxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yaopinxinxi yaopinxinxi, String yaopinbianhao, String yaopinmingcheng, String guige, String tupian, String zhuyaochengfen, String gongneng, String jinji, String kucun1,String kucun2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}		if(guige==null||guige.equals("")){pmap.put("guige", null);}else{pmap.put("guige", guige);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(zhuyaochengfen==null||zhuyaochengfen.equals("")){pmap.put("zhuyaochengfen", null);}else{pmap.put("zhuyaochengfen", zhuyaochengfen);}		if(gongneng==null||gongneng.equals("")){pmap.put("gongneng", null);}else{pmap.put("gongneng", gongneng);}		if(jinji==null||jinji.equals("")){pmap.put("jinji", null);}else{pmap.put("jinji", jinji);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		
		int total=yaopinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yaopinxinxi> list=yaopinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yaopinxinxi_list";
	}
	
	@RequestMapping("yaopinxinxiList2.do")
	public String yaopinxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yaopinxinxi yaopinxinxi, String yaopinbianhao, String yaopinmingcheng, String guige, String tupian, String zhuyaochengfen, String gongneng, String jinji, String kucun1,String kucun2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}
		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}
		if(guige==null||guige.equals("")){pmap.put("guige", null);}else{pmap.put("guige", guige);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(zhuyaochengfen==null||zhuyaochengfen.equals("")){pmap.put("zhuyaochengfen", null);}else{pmap.put("zhuyaochengfen", zhuyaochengfen);}
		if(gongneng==null||gongneng.equals("")){pmap.put("gongneng", null);}else{pmap.put("gongneng", gongneng);}
		if(jinji==null||jinji.equals("")){pmap.put("jinji", null);}else{pmap.put("jinji", jinji);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		
		int total=yaopinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yaopinxinxi> list=yaopinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yaopinxinxi_list2";
	}
	
	@RequestMapping("ypxxList.do")
	public String ypxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yaopinxinxi yaopinxinxi, String yaopinbianhao, String yaopinmingcheng, String guige, String tupian, String zhuyaochengfen, String gongneng, String jinji, String kucun1,String kucun2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yaopinbianhao==null||yaopinbianhao.equals("")){pmap.put("yaopinbianhao", null);}else{pmap.put("yaopinbianhao", yaopinbianhao);}		if(yaopinmingcheng==null||yaopinmingcheng.equals("")){pmap.put("yaopinmingcheng", null);}else{pmap.put("yaopinmingcheng", yaopinmingcheng);}		if(guige==null||guige.equals("")){pmap.put("guige", null);}else{pmap.put("guige", guige);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(zhuyaochengfen==null||zhuyaochengfen.equals("")){pmap.put("zhuyaochengfen", null);}else{pmap.put("zhuyaochengfen", zhuyaochengfen);}		if(gongneng==null||gongneng.equals("")){pmap.put("gongneng", null);}else{pmap.put("gongneng", gongneng);}		if(jinji==null||jinji.equals("")){pmap.put("jinji", null);}else{pmap.put("jinji", jinji);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		
		int total=yaopinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yaopinxinxi> list=yaopinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yaopinxinxilist";
	}
	
	@RequestMapping("deleteYaopinxinxi.do")
	public String deleteYaopinxinxi(int id,HttpServletRequest request){
		yaopinxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yaopinxinxiList.do";
	}
	
	@RequestMapping("quchongYaopinxinxi.do")
	public void quchongYaopinxinxi(Yaopinxinxi yaopinxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yaopinbianhao", yaopinxinxi.getYaopinbianhao());
		   System.out.println("yaopinbianhao==="+yaopinxinxi.getYaopinbianhao());
		   System.out.println("yaopinbianhao222==="+yaopinxinxiService.quchongYaopinxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(yaopinxinxiService.quchongYaopinxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "药品编号可以用！");
				  
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
