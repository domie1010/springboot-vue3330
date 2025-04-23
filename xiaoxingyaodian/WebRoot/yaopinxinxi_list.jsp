<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>药品信息查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">药品信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="yaopinxinxiList.do" name="myform" method="post">
									查询   药品编号：<input name="yaopinbianhao" type="text" id="yaopinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品名称：<input name="yaopinmingcheng" type="text" id="yaopinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>药品编号</td>    <td align='center'>药品名称</td>    <td align='center'>规格</td>    <td  width='90' align='center'>图片</td>                <td align='center'>库存</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.yaopinbianhao}</td>    <td>${u.yaopinmingcheng}</td>    <td>${u.guige}</td>    <td width='90' align='center'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>                <td>${u.kucun}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateYaopinxinxi.do?id=${u.id }">编辑</a>  <a href="deleteYaopinxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="yaopinxinxiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from yaopinxinxi where 1=1 ";
				if(request.getParameter("yaopinbianhao")=="" ||request.getParameter("yaopinbianhao")==null ){}else{String nyaopinbianhao=new String(request.getParameter("yaopinbianhao").getBytes("8859_1"));if(nyaopinbianhao.contains("?")){nyaopinbianhao=request.getParameter("yaopinbianhao");}sql=sql+" and yaopinbianhao like '%"+nyaopinbianhao+"%'";}if(request.getParameter("yaopinmingcheng")=="" ||request.getParameter("yaopinmingcheng")==null ){}else{String nyaopinmingcheng=new String(request.getParameter("yaopinmingcheng").getBytes("8859_1"));if(nyaopinmingcheng.contains("?")){nyaopinmingcheng=request.getParameter("yaopinmingcheng");}sql=sql+" and yaopinmingcheng like '%"+nyaopinmingcheng+"%'";}
			sql+=" order by id desc";

							
							int kucuntx=0;
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						
						if(Float.valueOf(RS_result.getString("kucun")).floatValue()<10){kucuntx=kucuntx+1;}
						
			 }
			%>
		 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="yaopinxinxiList.do?page=1" >首页</a>
             <a href="yaopinxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="yaopinxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="yaopinxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
 <%
 if(kucuntx>0)
{
%>
 <style>
#winpop { width:200px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #666; margin:0; padding:1px; overflow:hidden; display:none;} 
#winpop .title { width:100%; height:22px; line-height:20px; background:#FFCC00; font-weight:bold; text-align:center; font-size:12px;} 
#winpop .con { width:100%; height:90px; line-height:20px; font-weight:bold; font-size:12px; color:#FF0000; text-align:center} 
#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;} 
.close { position:absolute; right:4px; top:-1px; color:#FFF; cursor:pointer} 
</style> 
<script type="text/javascript"> 
function tips_pop(){ 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height);//将对象的高度转化为数字 
if (popH==0){ 
MsgPop.style.display="block";//显示隐藏的窗口 
show=setInterval("changeH('up')",2); 
} 
else { 
hide=setInterval("changeH('down')",2); 
} 
} 
function changeH(str) { 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height); 
if(str=="up"){ 
if (popH <=100){ 
MsgPop.style.height=(popH+4).toString()+"px"; 
} 
else{ 
clearInterval(show); 
} 
} 
if(str=="down"){ 
if (popH>=4){ 
MsgPop.style.height=(popH-4).toString()+"px"; 
} 
else{ 
clearInterval(hide);  
MsgPop.style.display="none"; //隐藏DIV 
} 
} 
} 
window.onload=function(){ //加载 
document.getElementById('winpop').style.height='0px'; 
setTimeout("tips_pop()",500); //3秒后调用tips_pop()这个函数 
} 
</script> <div id="silu"> 
<body>
</div> 
<div id="winpop"> 
<div class="title">系统提醒！ <span class="close" onClick="tips_pop()">X </span> </div> 
<div class="con">当前有<%=kucuntx%>条库存值记录小于10，谢谢！</div>
<%
}
%>