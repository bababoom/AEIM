<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>update</title>
    
   
    
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
    	function sure(){
    		return confirm("确定修改?") ;
    	}
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
    		left: 500px ;
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
    
   <br><br>
   <div id = "a" >
  
  
  	<s:form action="Do_update" onsubmit="return sure() ;">
  		<tr>
  		<th><label>员工编号 : </label>
  		<input type="text"  name="EMPNO" readonly="true" value="<s:property value="#staff.EMPNO"/>" class="form-controlspan12 form-control"/></th>
  		<th><label>员工姓名 : </label>
  		<input type="text"  name="ENAME"  value="<s:property value="#staff.ENAME"/>" class="form-controlspan12 form-control"/></th>
  		</tr>
  		<tr>
  		<th><label>工作职位 : </label>
  		<input type="text"  name="JOB" readonly="true" value="<s:property value="#staff.JOB"/>" class="form-controlspan12 form-control"/></th>
 		<th><label>上司编号 : </label>
  		<input type="text"  readonly="true" name="MGR"  value="<s:property value="#staff.MGR"/>" class="form-controlspan12 form-control"/></th></tr>
  		<tr><th><label>目前状态 : </label>
  		<input type="text"  readonly="true" name="STATUS"  value="<s:property value="#staff.STATUS"/>" class="form-controlspan12 form-control"/></th>
  		<th><label> 薪     资 : </label>
  		<input type="text"  name="SAL"  value="<s:property value="#staff.SAL"/>" class="form-controlspan12 form-control"/></th></tr>
  		<tr><th><label>奖     金 : </label>
  		<input type="text"  readonly="true" name="COMM"  value="<s:property value="#staff.COMM"/>" class="form-controlspan12 form-control"/></th>
  		<th><label>部门编号 : </label>
  		<input type="text"  readonly="true" name="DEPTNO"  value="<s:property value="#staff.DEPTNO"/>" class="form-controlspan12 form-control"/></th></tr>
  		<tr rows="2"><label>入职日期 : </label>
  		<input type="text"  readonly="true" name="HIREDATE"  value="<s:property value="#staff.HIREDATE"/>" class="form-controlspan12 form-control"/></tr>
  		<tr><th><input type="submit" value="确定" class="btn btn-primary pull-right" /></th><tr>
  	</s:form>

  </div>
    </body>
</html>
	