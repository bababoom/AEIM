<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 Object username = session.getAttribute("username");  
  if(null == username){  
        
      response.sendRedirect("index.jsp");  
  }  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>办理入职</title>
    <script type="text/javascript">
			String.prototype.trim = function()
			{
				return this.replace(/^\s+/ , "")
					.replace(/\s+$/, "");
			}
			// 校验表单的JavaScript函数
			function validate(form)
			{
				
				
             	var str = "<s:property value="#request.EMPNO_str" />" ;
             	var arr = str.split(',') ;
				// 定义错误字符串
				var errStr = "";
				// 依次取出表单中的四个表单域的值
				var EMPNO = form.EMPNO.value.trim() ;
				var SAL = form.SAL.value.trim() ;
				var TEL = form.TEL.value.trim() ;
				var HEIGHT = form.HEIGHT.value.trim() ;
				var WEIGHT = form.WEIGHT.value.trim() ;
				var EMAIL = form.EMAIL.value.trim() ;
				var MGR = form.MGR.value.trim() ;
				var DEPTNO = form.DEPTNO.value.trim() ;
				var BIRTH = form.BIRTH.value.trim() ;
				
				if(EMPNO==""||EMPNO==null){
					errStr += "\n 员工编号不能为空"  ;
				}else if(!/[0-9]{4}/.test(EMPNO)){
					errStr += "\n 员工编号只能有数字组成且必须为4位数"
				}
				
				if(SAL!=null&&SAL!=""){
					if(!/[0-9]{0,}|^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/.test(SAL)){
						errStr += "\n 薪水只能是正整数或者正浮点数" ;
					}
				}
				
				
				if(TEL==""||TEL==null){
					errStr += "\n 电话号码为必填项" ;
				}else if(!/^1[3|4|5|8][0-9]\d{4,8}$/.test(TEL)){
					errStr += "\n 您输入的手机号码不合法" ;
				}
				
				if(BIRTH==""||BIRTH==null){
					errStr += "\n 生日是必填项" ;
				}
				else if(!/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))/.test(BIRTH)){
					errStr += "\n 输入的日期不合法" ;
				}
				
				if(WEIGHT==null||WEIGHT==""){
					errStr += "\n 体重为必填项" ;
				}
				else if(!/^[1-9]\d*$/.test(WEIGHT)){
					errStr += "\n 体重只能为正整数" ;
				}else if(parseInt(WEIGHT)>=170||parseInt(WEIGHT)<=30){
					errStr += "\n 您输入的体重超出范围" ;
				}
				
				if(HEIGHT==null||HEIGHT==""){
					errStr += "\n 身高为必填项" ;
				}
				else if(!/^[1-9]\d*$/.test(HEIGHT)){
					errStr += "\n 身高只能为正整数" ;
				}else if(parseInt(HEIGHT)>=230||parseInt(HEIGHT)<=130){
					errStr += "\n 您输入的身高超出范围" ;
				}
				
				if(EMAIL!=null&&EMAIL!=""){
					if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ .test(EMAIL)){
						errStr += "\n 邮箱格式不合法" ;
					}
				}
				
				if(EMPNO==null||EMPNO==""){
					errStr += "\n 员工编号不能为空" ;
				}else if(!/[0-9]{4}/.test(EMPNO)){
					errStr += "\n 员工编号只能由四位数字构成" ;
				}else{
					for(var i=0;i<arr.length;i++){
						if(EMPNO==arr[i]){
							errStr += "\n 此员工编号已存在，请重新输入" ;
							break ;
						}
					}
				}
				
				if(MGR==null||MGR==""){
					errStr += "\n 上司编号不能为空" ;
				}else if(!/[0-9]{4}/.test(MGR)){
					errStr += "\n 上司编号只能由四位数字构成" ;
				}else{
					for(var i=0;i<arr.length;i++){
						if(MGR==arr[i]) break ;
						if(i==arr.length-1&&MGR!=arr[i]){
							errStr += "\n 上司的编号不存在，请重新输入" ;
						}
					}
				}
				// 如果错误字符串为空，表明客户端校验通过
				if (errStr == "")
				{	
					return true ;
				}
				// 客户端校验没有通过，通过警告框输出校验失败提示
				else
				{
					alert(errStr);
					return false;
				}
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
	 <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

        <script src="lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>


    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
			
		
		
    </head>
<body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
    #a{
    		position: absolute;
    		top :100px ;
    		left: 100px ;
    		width: 760px ;
    		height: 600px ;
    	}
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    
 

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          
<span class="navbar-brand"><span class="fa fa-paper-plane"></span> 员工信息管理系统</span></div>	
<div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> <%=session.getAttribute("username")  %>
                    <i class="fa fa-caret-down"></i>
                </a>

            
            </li>
          </ul>

        </div>
       
      </div>
   
    <div class="sidebar-nav">
    <ul>
    <li><a data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 信息管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="Load.action"><span class="fa fa-caret-right"></span> 员工管理</a></li>
            <li ><a href = "Load_Dept.action"><span class="fa fa-caret-right"></span> 部门管理</a></li>
            <li ><a href="Load_Sal.action"><span class="fa fa-caret-right"></span> 薪资等级管理</a></li>
            
    </ul></li>
    <li><a data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 业务办理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href = "Pre_InEmp.action"><span class="fa fa-caret-right"></span> 就职办理</a></li>
             <li ><a href="Load_Rework.action"><span class="fa fa-caret-right"></span> 复职办理</a></li>
            <li ><a href="Pre_OutEmp.action"><span class="fa fa-caret-right"></span> 离职办理</a></li>
            
    </ul></li>
    <li><a  data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 职位调动<i class="fa fa-collapse"></i></a></li>
   	<li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="Load_Move.action"><span class="fa fa-caret-right"></span> 职位调动</a></li></ul></li>
    <li><a data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 记录查询<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href = "Load_In.action"><span class="fa fa-caret-right"></span> 入职记录</a></li>
             <li ><a href = "Load_Rework_Action.action"><span class="fa fa-caret-right"></span> 复职记录</a></li>
            <li ><a href = "Load_Out.action"><span class="fa fa-caret-right"></span> 离职记录</a></li>
            <li ><a href = "Load_Moved.action"><span class="fa fa-caret-right"></span> 调职记录</a></li>
            
    </ul></li>
    </div>

    <div class="content">
        <div class="header">
            

    

        </div>
        <div class="main-content">
            




    <div id="a">
    
<div class="row">
    
        <div class="panel panel-default">
            <div class="panel-heading no-collapse">入职办理<span class="label label-warning"></span></div>
            <center>
            <s:form  action="In_Emp" theme="simple" onsubmit="return validate(this);">
    			<table>
    				<tr>
    					<td>员工编号 : <input type="text" name="EMPNO"  class="form-controlspan12 form-control"></td><td></td>
    					<td>员工姓名 : <input type="text" name="ENAME"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr>
    					<td>工作岗位 : <input type="text" name="JOB"  class="form-controlspan12 form-control"></td><td></td>
    					<td>办公地点 : <input type="text" name="LOC"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				
    				<tr>
    					<td>部门编号 : <input type="text" name="DEPTNO"  class="form-controlspan12 form-control"></td><td></td>
    					<td>上司编号 : <input type="text" name="MGR"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr>
    					<td>身高(CM) : <input type="text" name="HEIGHT"  class="form-controlspan12 form-control"></td><td></td>
    					<td>体重(KG) : <input type="text" name="WEIGHT"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr>
    					<td>出生年月 : <input type="text" name="BIRTH"  class="form-controlspan12 form-control"></td><td></td>
    					<td>初始薪水 : <input type="text" name="SAL"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr>
    					<td>电话号码 : <input type="text" name="TEL"  class="form-controlspan12 form-control"></td><td></td>
    					<td>E-mail &nbsp; &nbsp;&nbsp;: <input type="text" name="EMAIL"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr>
    					<td>毕业院校 : <input type="text" name="GSCHOOL"  class="form-controlspan12 form-control"></td><td></td>
    					<td>家庭住址 : <input type="text" name="ADDRESS"  class="form-controlspan12 form-control"></td>
    				</tr>
    				<tr><td></td></tr>
    				<tr><td rowspan="3"><input type="submit" value="提交" class="btn btn-primary pull-right" ></td></tr>
    			</table>
    			<br>
    			
    		</s:form>
    		</center>
            
        </div>
   
    
</div>

</div>


            
        </div>
    </div>


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>

