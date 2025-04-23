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
	<TITLE>采购信息查询</TITLE>
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
							<td colspan="17" background="images/table_header.gif">采购信息列表</td>
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
								<form action="caigouxinxiList.do" name="myform" method="post">
									查询   采购编号：<input name="caigoubianhao" type="text" id="caigoubianhao" style='border:solid 1px #000000; color:#666666' size="12" /> 供货商：<select name='gonghuoshang' id='gonghuoshang' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("gonghuoshangxinxi","gonghuoshang")%></select>  药品编号：<input name="yaopinbianhao" type="text" id="yaopinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品名称：<input name="yaopinmingcheng" type="text" id="yaopinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  库存：<input name="kucun" type="text" id="kucun" style='border:solid 1px #000000; color:#666666' size="12" />  采购日期：<input name="caigouriqi1" type="text" id="caigouriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="caigouriqi2" type="text" id="caigouriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>采购编号</td>
    <td align='center'>供货商</td>
    <td align='center'>药品编号</td>
    <td align='center'>药品名称</td>
    <td align='center'>库存</td>
    <td align='center'>价格</td>
    <td align='center'>采购数量</td>
    <td  width='65' align='center'>采购日期</td>
    <td  width='80' align='center'>是否发货</td>
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
                             <td>${u.caigoubianhao}</td>
    <td>${u.gonghuoshang}</td>
    <td>${u.yaopinbianhao}</td>
    <td>${u.yaopinmingcheng}</td>
    <td>${u.kucun}</td>
    <td>${u.jiage}</td>
    <td>${u.caigoushuliang}</td>
    <td>${u.caigouriqi}</td>
    <td align='center'>${u.issh} <input type="button" value="入库" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&yaopinbianhao=${u.yaopinbianhao}&caigoushuliang=${u.caigoushuliang}&tablename=caigouxinxi'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateCaigouxinxi.do?id=${u.id }">编辑</a>  <a href="deleteCaigouxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="caigouxinxiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caigouxinxiList.do?page=1" >首页</a>
             <a href="caigouxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caigouxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="caigouxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
