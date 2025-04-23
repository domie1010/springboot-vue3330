<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>采购信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  采购信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>采购编号：</td><td width='39%'>${caigouxinxi.caigoubianhao}</td>     <td width='11%'>供货商：</td><td width='39%'>${caigouxinxi.gonghuoshang}</td></tr><tr>     <td width='11%'>药品编号：</td><td width='39%'>${caigouxinxi.yaopinbianhao}</td>     <td width='11%'>药品名称：</td><td width='39%'>${caigouxinxi.yaopinmingcheng}</td></tr><tr>     <td width='11%'>库存：</td><td width='39%'>${caigouxinxi.kucun}</td>     <td width='11%'>价格：</td><td width='39%'>${caigouxinxi.jiage}</td></tr><tr>     <td width='11%'>采购数量：</td><td width='39%'>${caigouxinxi.caigoushuliang}</td>     <td width='11%'>采购日期：</td><td width='39%'>${caigouxinxi.caigouriqi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

