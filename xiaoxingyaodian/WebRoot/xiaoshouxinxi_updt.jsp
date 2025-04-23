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
		<TITLE>修改销售信息</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="xiaoshouxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateXiaoshouxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改销售信息<input type="hidden" name="id" value="${xiaoshouxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">销售编号：</td><td><input name='xiaoshoubianhao' type='text' id='xiaoshoubianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">药品编号：</td><td><select name='yaopinbianhao' id='yaopinbianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("yaopinxinxi","yaopinbianhao")%></select>&nbsp;*<label id='clabelyaopinbianhao' /></td></tr>		<tr ><td width="200">药品名称：</td><td><input name='yaopinmingcheng' type='text' id='yaopinmingcheng' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">销售价格：</td><td><input name='xiaoshoujiage' type='text' id='xiaoshoujiage' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelxiaoshoujiage' />必需数字型</td></tr>		<tr ><td width="200">销售数量：</td><td><input name='xiaoshoushuliang' type='text' id='xiaoshoushuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelxiaoshoushuliang' />必需数字型</td></tr>		<tr ><td width="200">销售时间：</td><td><input name='xiaoshoushijian' type='text' id='xiaoshoushijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">单据：</td><td><input name='danju' type='text' id='danju' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('danju')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">企业：</td><td><input name='qiye' type='text' id='qiye' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr 0><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr 1><td width="200">联系手机：</td><td><input name='lianxishouji' type='text' id='lianxishouji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabellianxishouji' />必需手机格式</td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xiaoshoubianhao.value='${xiaoshouxinxi.xiaoshoubianhao}';</script>	<script language="javascript">document.form1.yaopinbianhao.value='${xiaoshouxinxi.yaopinbianhao}';</script>	<script language="javascript">document.form1.yaopinmingcheng.value='${xiaoshouxinxi.yaopinmingcheng}';</script>	<script language="javascript">document.form1.kucun.value='${xiaoshouxinxi.kucun}';</script>	<script language="javascript">document.form1.xiaoshoujiage.value='${xiaoshouxinxi.xiaoshoujiage}';</script>	<script language="javascript">document.form1.xiaoshoushuliang.value='${xiaoshouxinxi.xiaoshoushuliang}';</script>	<script language="javascript">document.form1.xiaoshoushijian.value='${xiaoshouxinxi.xiaoshoushijian}';</script>	<script language="javascript">document.form1.danju.value='${xiaoshouxinxi.danju}';</script>	<script language="javascript">document.form1.qiye.value='${xiaoshouxinxi.qiye}';</script>	<script language="javascript">document.form1.dizhi.value='${xiaoshouxinxi.dizhi}';</script>	<script language="javascript">document.form1.lianxishouji.value='${xiaoshouxinxi.lianxishouji}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var yaopinbianhaoobj = document.getElementById("yaopinbianhao"); if(yaopinbianhaoobj.value==""){document.getElementById("clabelyaopinbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品编号</font>";return false;}else{document.getElementById("clabelyaopinbianhao").innerHTML="  "; } 	        var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxishoujiobj.value)){document.getElementById("clabellianxishouji").innerHTML=""; }else{document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      if(parseInt(document.form1.kucun.value)<parseInt(document.form1.xiaoshoushuliang.value)){alert("对不起，库存必需大于销售数量");return false;}	


return true;   
}   
popheight=450;
</script>  
