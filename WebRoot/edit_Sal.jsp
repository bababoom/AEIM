<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑薪资等级</title>
    <script type="text/javascript">
    	function add(){
    		var	url = "Pre_Edit.action?test="+"1";
    		location.href = url ;
    	}
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<table>
   		<tr>
   			<td>等  级</td><td>最 少</td><td>最 多</td>
   		</tr>
   			<s:iterator id="li" value="list" >
   				<tr>
					<td><input type="text" value="<s:property value="#li.GRADE"/>" readonly="true"></td> 
					<td><input type="text" value="<s:property value="#li.LOSAL"/>"></td> 
					<td><input type="text" value="<s:property value="#li.HISAL"/>" ></td> 
   				</tr>
              <tbody>
   			</s:iterator>
   			<tr><td colspan="3"><input type="button" value="增加" onclick="add()"></td></tr>
   		</table>
  </body>
</html>
