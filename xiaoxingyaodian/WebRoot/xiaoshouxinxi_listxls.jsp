<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshouxinxihsgb" scope="page" class="com.bean.XiaoshouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshouxinxi.xls");
%>
<html>
  <head>
    <title>销售信息</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>销售编号</td>    <td align='center'>药品编号</td>    <td align='center'>药品名称</td>    <td align='center'>库存</td>    <td align='center'>销售价格</td>    <td align='center'>销售数量</td>    <td  width='65' align='center'>销售时间</td>    <td  width='90' align='center'>单据</td>    <td align='center'>企业</td>    <td align='center'>地址</td>    <td align='center'>联系手机</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiaoshouxinxihsgb.getAllXiaoshouxinxi(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xiaoshoubianhao}</td>    <td>${u.yaopinbianhao}</td>    <td>${u.yaopinmingcheng}</td>    <td>${u.kucun}</td>    <td>${u.xiaoshoujiage}</td>    <td>${u.xiaoshoushuliang}</td>    <td>${u.xiaoshoushijian}</td>    <td width='90' align='center'><a href='${u.danju}' target='_blank'>下载</a></td>    <td>${u.qiye}</td>    <td>${u.dizhi}</td>    <td>${u.lianxishouji}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

