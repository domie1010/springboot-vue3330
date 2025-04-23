<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 


<%
String yuan=request.getParameter("yuan");
String id=request.getParameter("id");
String tablename=request.getParameter("tablename");
String yaopinbianhao=request.getParameter("yaopinbianhao");
String caigoushuliang=request.getParameter("caigoushuliang");
String sql="";
String sql2="";
if(yuan.equals("是"))
{
	sql="update "+request.getParameter("tablename")+" set issh='否' where id="+request.getParameter("id");
	sql2="update yaopinxinxi set kucun=kucun-'"+caigoushuliang+"' where yaopinbianhao='"+yaopinbianhao+"'";
}
else
{
	sql="update "+request.getParameter("tablename")+" set issh='是' where id="+request.getParameter("id");
	sql2="update yaopinxinxi set kucun=kucun+'"+caigoushuliang+"' where yaopinbianhao='"+yaopinbianhao+"'";
}


connDbBean.hsgexecute(sql);
connDbBean.hsgexecute(sql2);
out.print("<script>javascript:alert('审核成功！');location.href='"+request.getParameter("tablename")+"List.do';</script>");


%>



