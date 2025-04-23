<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuangongxinxihsgb" scope="page" class="com.bean.YuangongxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuangongxinxi.xls");
%>
<html>
  <head>
    <title>员工信息</title>
  </head>

  <body >
 <%
			String sql="select * from yuangongxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>工号</td>    <td align='center'>姓名</td>    <td align='center'>密码</td>    <td  width='40' align='center'>性别</td>    <td  width='90' align='center'>照片</td>    <td align='center'>手机</td>    <td align='center'>身份证</td>    <td align='center'>基本月薪</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yuangongxinxihsgb.getAllYuangongxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td>${u.mima}</td>    <td align='center'>${u.xingbie}</td>    <td width='90' align='center'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.shouji}</td>    <td>${u.shenfenzheng}</td>    <td>${u.jibenyuexin}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

