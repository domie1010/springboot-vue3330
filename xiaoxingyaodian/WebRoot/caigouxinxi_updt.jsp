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
		<TITLE>修改采购信息</TITLE>
	    
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
	document.location.href="caigouxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateCaigouxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改采购信息<input type="hidden" name="id" value="${caigouxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">采购编号：</td><td><input name='caigoubianhao' type='text' id='caigoubianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">供货商：</td><td><select name='gonghuoshang' id='gonghuoshang' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("gonghuoshangxinxi","gonghuoshang")%></select>&nbsp;*<label id='clabelgonghuoshang' /></td></tr>		<tr ><td width="200">药品编号：</td><td><select name='yaopinbianhao' id='yaopinbianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("yaopinxinxi","yaopinbianhao")%></select></td></tr>		<tr ><td width="200">药品名称：</td><td><input name='yaopinmingcheng' type='text' id='yaopinmingcheng' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabeljiage' />必需数字型</td></tr>		<tr ><td width="200">采购数量：</td><td><input name='caigoushuliang' type='text' id='caigoushuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelcaigoushuliang' />必需数字型</td></tr>		<tr ><td width="200">采购日期：</td><td><input name='caigouriqi' type='text' id='caigouriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.caigoubianhao.value='${caigouxinxi.caigoubianhao}';</script>	<script language="javascript">document.form1.gonghuoshang.value='${caigouxinxi.gonghuoshang}';</script>	<script language="javascript">document.form1.yaopinbianhao.value='${caigouxinxi.yaopinbianhao}';</script>	<script language="javascript">document.form1.yaopinmingcheng.value='${caigouxinxi.yaopinmingcheng}';</script>	<script language="javascript">document.form1.kucun.value='${caigouxinxi.kucun}';</script>	<script language="javascript">document.form1.jiage.value='${caigouxinxi.jiage}';</script>	<script language="javascript">document.form1.caigoushuliang.value='${caigouxinxi.caigoushuliang}';</script>	<script language="javascript">document.form1.caigouriqi.value='${caigouxinxi.caigouriqi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var gonghuoshangobj = document.getElementById("gonghuoshang"); if(gonghuoshangobj.value==""){document.getElementById("clabelgonghuoshang").innerHTML="&nbsp;&nbsp;<font color=red>请输入供货商</font>";return false;}else{document.getElementById("clabelgonghuoshang").innerHTML="  "; } 	        


return true;   
}   
popheight=450;
</script>  
