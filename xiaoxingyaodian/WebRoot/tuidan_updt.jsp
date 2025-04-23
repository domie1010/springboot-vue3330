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
		<TITLE>修改退单</TITLE>
	    
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
	document.location.href="tuidan_add.jsp?id=<%=id%>";
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
			<form action="updateTuidan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改退单<input type="hidden" name="id" value="${tuidan.id}" /></td>
						</tr>
						<tr ><td width="200">销售编号：</td><td><select name='xiaoshoubianhao' id='xiaoshoubianhao' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("xiaoshouxinxi","xiaoshoubianhao")%></select>&nbsp;*<label id='clabelxiaoshoubianhao' /></td></tr>		<tr ><td width="200">退单原因：</td><td><textarea name='tuidanyuanyin' cols='50' rows='5' id='tuidanyuanyin' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabeltuidanyuanyin' /></td></tr>		<tr ><td width="200">退单时间：</td><td><input name='tuidanshijian' type='text' id='tuidanshijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeltuidanshijian' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xiaoshoubianhao.value='${tuidan.xiaoshoubianhao}';</script>	<script language="javascript">document.form1.tuidanyuanyin.value='${tuidan.tuidanyuanyin}';</script>	<script language="javascript">document.form1.tuidanshijian.value='${tuidan.tuidanshijian}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xiaoshoubianhaoobj = document.getElementById("xiaoshoubianhao"); if(xiaoshoubianhaoobj.value==""){document.getElementById("clabelxiaoshoubianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入销售编号</font>";return false;}else{document.getElementById("clabelxiaoshoubianhao").innerHTML="  "; } 	var tuidanyuanyinobj = document.getElementById("tuidanyuanyin"); if(tuidanyuanyinobj.value==""){document.getElementById("clabeltuidanyuanyin").innerHTML="&nbsp;&nbsp;<font color=red>请输入退单原因</font>";return false;}else{document.getElementById("clabeltuidanyuanyin").innerHTML="  "; } 	var tuidanshijianobj = document.getElementById("tuidanshijian"); if(tuidanshijianobj.value==""){document.getElementById("clabeltuidanshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入退单时间</font>";return false;}else{document.getElementById("clabeltuidanshijian").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
