<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caigouxinxihsgb" scope="page" class="com.bean.CaigouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caigouxinxi.xls");
%>
<html>
  <head>
    <title>�ɹ���Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from caigouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�ɹ����</td>    <td align='center'>������</td>    <td align='center'>ҩƷ���</td>    <td align='center'>ҩƷ����</td>    <td align='center'>���</td>    <td align='center'>�۸�</td>    <td align='center'>�ɹ�����</td>    <td  width='65' align='center'>�ɹ�����</td>    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=caigouxinxihsgb.getAllCaigouxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.caigoubianhao}</td>    <td>${u.gonghuoshang}</td>    <td>${u.yaopinbianhao}</td>    <td>${u.yaopinmingcheng}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.caigoushuliang}</td>    <td>${u.caigouriqi}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=caigouxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

