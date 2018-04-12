<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    
    <title>新增部门</title>
    
    <script type="text/javascript">
			String.prototype.trim = function()
			{
				return this.replace(/^\s+/ , "")
					.replace(/\s+$/, "");
			}
			// 校验表单的JavaScript函数
			function validate(form)
			{
				
				
             	var str = "<s:property value="#request.str" />" ;
             	var arr = str.split(',') ;
				// 定义错误字符串
				var errStr = "";
				// 依次取出表单中的三个表单域的值
				var DEPTNO = form.DEPTNO.value.trim();
				var DNAME = form.DNAME.value.trim();
				var LOC = form.LOC.value.trim();
				
				
				
				if (DEPTNO == "" || DEPTNO == null)
				{
					errStr += "\n您的部门编号不能为空";
				}
				else if(DEPTNO.length>2){
					errStr += "\n部门编号长度不能大于2";
				}
				
				else if (!/[1-9][0-9]*/.test(DEPTNO))
				{
					errStr += "\n您的用户名必须是数字";
				}else{
					for(var i = 0 ; i < arr.length;i++){
						if(arr[i]==DEPTNO){
							errStr += "\n此编号已存在，请检查后重试";
							break  ;
						}
					}
				}
				
				if(DNAME.length>14){
					errStr += "\n 部门名称过长，请控制在14个字符以内";
				}
				if(LOC.length>14){
					errStr += "\n 部门地址过长，请控制在14个字符以内";
				}
				// 如果错误字符串为空，表明客户端校验通过
				if (errStr == "")
				{	
					if((DNAME==""||DNAME==null)&&(LOC==""||LOC==null)){
						if(confirm("部门名称 和 部门地址为空，确定添加吗？")){
							return true ;
							
							}else return false ;
					}else if(DNAME==""||DNAME==null){
							if(confirm("部门名称为空，确定添加吗？")){
								return true ;
							} else return false ;
					}else if(LOC==""||LOC==null){
							if(confirm("部门地址为空，确定添加吗？")){
								return true ;
							} else return false ;
					}
					else return true;
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
    		left: 200px ;
    		width: 450px ;
    		height: 350px ;
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
 <center>
<div class="row">
    
        <div class="panel panel-default">
            <div class="panel-heading no-collapse">增加部门<span class="label label-warning"></span></div>
            <s:form action="Add_Dept" onsubmit="return validate(this);">
           <tr><th> <label>部门编号 : </label>
  			<input type="text"   name="DEPTNO"   class="form-controlspan12 form-control"/></th></tr>
  			 <tr><th><label>部门名称 : </label>
  			<input type="text"   name="DNAME"   class="form-controlspan12 form-control"/></th></tr>
  			<tr><th> <label>部门地址 : </label>
  			<input type="text"   name="LOC"   class="form-controlspan12 form-control"/></th></tr>
  			<br>
 			<tr><th><input type="submit" value="提交" class="btn btn-primary pull-right" /></th></tr>
 		</s:form>
            
        </div>
   
    
</div>
</center>
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
