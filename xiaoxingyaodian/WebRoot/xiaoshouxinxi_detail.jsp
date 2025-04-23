<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>销售信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  销售信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>销售编号：</td><td width='39%'>${xiaoshouxinxi.xiaoshoubianhao}</td>     <td width='11%'>药品编号：</td><td width='39%'>${xiaoshouxinxi.yaopinbianhao}</td></tr><tr>     <td width='11%'>药品名称：</td><td width='39%'>${xiaoshouxinxi.yaopinmingcheng}</td>     <td width='11%'>库存：</td><td width='39%'>${xiaoshouxinxi.kucun}</td></tr><tr>     <td width='11%'>销售价格：</td><td width='39%'>${xiaoshouxinxi.xiaoshoujiage}</td>     <td width='11%'>销售数量：</td><td width='39%'>${xiaoshouxinxi.xiaoshoushuliang}</td></tr><tr>     <td width='11%'>销售时间：</td><td width='39%'>${xiaoshouxinxi.xiaoshoushijian}</td>     <td width='11%'>单据：</td><td width='39%'><a href="${xiaoshouxinxi.danju}">点此下载</a></td></tr><tr>     <td width='11%'>企业：</td><td width='39%'>${xiaoshouxinxi.qiye}</td>     <td width='11%'>地址：</td><td width='39%'>${xiaoshouxinxi.dizhi}</td></tr><tr>     <td width='11%'>联系手机：</td><td width='39%'>${xiaoshouxinxi.lianxishouji}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

