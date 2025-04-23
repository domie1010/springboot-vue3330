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
	<TITLE>销售信息查询</TITLE>
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
							<td colspan="17" background="images/table_header.gif">订单信息列表</td>
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
								<form action="xiaoshouxinxiList.do" name="myform" method="post">
									查询   订单编号：
									  <input name="xiaoshoubianhao" type="text" id="xiaoshoubianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品编号：<input name="yaopinbianhao" type="text" id="yaopinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品名称：<input name="yaopinmingcheng" type="text" id="yaopinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  销售时间：<input name="xiaoshoushijian1" type="text" id="xiaoshoushijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="xiaoshoushijian2" type="text" id="xiaoshoushijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />  企业：<input name="qiye" type="text" id="qiye" style='border:solid 1px #000000; color:#666666' size="12" />  地址：<input name="dizhi" type="text" id="dizhi" style='border:solid 1px #000000; color:#666666' size="12" />  联系手机：<input name="lianxishouji" type="text" id="lianxishouji" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>订单编号</td>
                            <td align='center'>药品编号</td>
    <td align='center'>药品名称</td>
    <td align='center'>库存</td>
    <td align='center'>销售价格</td>
    <td align='center'>销售数量</td>
    <td  width='65' align='center'>销售时间</td>
    <td  width='90' align='center'>单据</td>
    <td align='center'>企业</td>
    <td align='center'>地址</td>
    <td align='center'>联系手机</td>
    
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
                             <td>${u.xiaoshoubianhao}</td>
    <td>${u.yaopinbianhao}</td>
    <td>${u.yaopinmingcheng}</td>
    <td>${u.kucun}</td>
    <td>${u.xiaoshoujiage}</td>
    <td>${u.xiaoshoushuliang}</td>
    <td>${u.xiaoshoushijian}</td>
    <td width='90' align='center'><a href='${u.danju}' target='_blank'>下载</a></td>
    <td>${u.qiye}</td>
    <td>${u.dizhi}</td>
    <td>${u.lianxishouji}</td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateXiaoshouxinxi.do?id=${u.id }">编辑</a>  <a href="deleteXiaoshouxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="xiaoshouxinxiDetail.do?id=${u.id}">详细</a></td>
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
              <a href="xiaoshouxinxiList.do?page=1" >首页</a>
             <a href="xiaoshouxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xiaoshouxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="xiaoshouxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
