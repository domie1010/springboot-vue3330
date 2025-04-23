<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caigouxinxihsgb" scope="page" class="com.bean.CaigouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caigouxinxi.xls");
%>
<html>
  <head>
    <title>采购信息</title>
  </head>

  <body >
 <%
			String sql="select * from caigouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>采购编号</td>    <td align='center'>供货商</td>    <td align='center'>药品编号</td>    <td align='center'>药品名称</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td align='center'>采购数量</td>    <td  width='65' align='center'>采购日期</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caigouxinxihsgb.getAllCaigouxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.caigoubianhao}</td>    <td>${u.gonghuoshang}</td>    <td>${u.yaopinbianhao}</td>    <td>${u.yaopinmingcheng}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.caigoushuliang}</td>    <td>${u.caigouriqi}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=caigouxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

