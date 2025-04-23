<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>药品信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  药品信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>药品编号：</td><td width='39%'>${yaopinxinxi.yaopinbianhao}</td><td  rowspan=4 align=center><a href=${yaopinxinxi.tupian} target=_blank><img src=${yaopinxinxi.tupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>药品名称：</td><td width='39%'>${yaopinxinxi.yaopinmingcheng}</td></tr><tr><td width='11%' height=44>规格：</td><td width='39%'>${yaopinxinxi.guige}</td></tr><tr><td width='11%' height=44>库存：</td><td width='39%'>${yaopinxinxi.kucun}</td></tr><tr><td width='11%' height=100  >主要成分：</td><td width='39%' colspan=2 height=100 >${yaopinxinxi.zhuyaochengfen}</td></tr><tr><td width='11%' height=100  >功能：</td><td width='39%' colspan=2 height=100 >${yaopinxinxi.gongneng}</td></tr><tr><td width='11%' height=100  >禁忌：</td><td width='39%' colspan=2 height=100 >${yaopinxinxi.jinji}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

