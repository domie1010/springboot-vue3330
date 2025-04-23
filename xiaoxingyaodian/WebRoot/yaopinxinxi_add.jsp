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
		<TITLE>添加药品信息</TITLE>
	    

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
	document.location.href="yaopinxinxi_add.jsp?id=<%=id%>";
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
			<form action="addYaopinxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加药品信息</td>
						</tr>
						<tr ><td width="200">药品编号：</td><td><input name='yaopinbianhao' type='text' id='yaopinbianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyaopinbianhao' /></td></tr>
		<tr ><td width="200">药品名称：</td><td><input name='yaopinmingcheng' type='text' id='yaopinmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyaopinmingcheng' /></td></tr>
		<tr ><td width="200">规格：</td><td><input name='guige' type='text' id='guige' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('tupian')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">主要成分：</td><td><textarea name='zhuyaochengfen' cols='50' rows='5' id='zhuyaochengfen' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr ><td width="200">功能：</td><td><textarea name='gongneng' cols='50' rows='5' id='gongneng' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr ><td width="200">禁忌：</td><td><textarea name='jinji' cols='50' rows='5' id='jinji' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr style='display:none' ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='0' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelkucun' />必需数字型</td></tr>
		
		
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
		var yaopinbianhao = $("#yaopinbianhao").val();
		if(yaopinbianhao==""||(yaopinbianhao.length<6||yaopinbianhao.length>12)){
			 $("#clabelyaopinbianhao").html("<font color=red>药品编号不能为空且长度在3～12位之间！</font>");
			 $("input[id=yaopinbianhao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelyaopinbianhao").html("");
			$.ajax({
				url : "quchongYaopinxinxi.do",
				type : "post",
				data : "yaopinbianhao=" + yaopinbianhao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelyaopinbianhao").html("<font color=red>药品编号已存在，请更换！</font>");
					$("input[id=yaopinbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelyaopinbianhao").html("系统异常，请检查错误！");
					$("input[id=yaopinbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var yaopinbianhaoobj = document.getElementById("yaopinbianhao"); if(yaopinbianhaoobj.value==""){document.getElementById("clabelyaopinbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品编号</font>";return false;}else{document.getElementById("clabelyaopinbianhao").innerHTML="  "; } 
	var yaopinmingchengobj = document.getElementById("yaopinmingcheng"); if(yaopinmingchengobj.value==""){document.getElementById("clabelyaopinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品名称</font>";return false;}else{document.getElementById("clabelyaopinmingcheng").innerHTML="  "; } 
	var kucunobj = document.getElementById("kucun"); if(kucunobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(kucunobj.value)){document.getElementById("clabelkucun").innerHTML=""; }else{document.getElementById("clabelkucun").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  
