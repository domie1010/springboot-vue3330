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
		<TITLE>添加供货商信息</TITLE>
	    

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
	document.location.href="gonghuoshangxinxi_add.jsp?id=<%=id%>";
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
			<form action="addGonghuoshangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加供货商信息</td>
						</tr>
						<tr ><td width="200">供货商：</td><td><input name='gonghuoshang' type='text' id='gonghuoshang' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgonghuoshang' /></td></tr>		<tr ><td width="200">联系手机：</td><td><input name='lianxishouji' type='text' id='lianxishouji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxishouji' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var gonghuoshang = $("#gonghuoshang").val();
		if(gonghuoshang==""||(gonghuoshang.length<6||gonghuoshang.length>12)){
			 $("#clabelgonghuoshang").html("<font color=red>供货商不能为空且长度在3～12位之间！</font>");
			 $("input[id=gonghuoshang]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelgonghuoshang").html("");
			$.ajax({
				url : "quchongGonghuoshangxinxi.do",
				type : "post",
				data : "gonghuoshang=" + gonghuoshang,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelgonghuoshang").html("<font color=red>供货商已存在，请更换！</font>");
					$("input[id=gonghuoshang]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelgonghuoshang").html("系统异常，请检查错误！");
					$("input[id=gonghuoshang]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var gonghuoshangobj = document.getElementById("gonghuoshang"); if(gonghuoshangobj.value==""){document.getElementById("clabelgonghuoshang").innerHTML="&nbsp;&nbsp;<font color=red>请输入供货商</font>";return false;}else{document.getElementById("clabelgonghuoshang").innerHTML="  "; } 	var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value==""){document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系手机</font>";return false;}else{document.getElementById("clabellianxishouji").innerHTML="  "; } 	var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxishoujiobj.value)){document.getElementById("clabellianxishouji").innerHTML=""; }else{document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
