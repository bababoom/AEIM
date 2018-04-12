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
    
    <title>部门管理</title>
    
    <script type="text/javascript">
    	function do_update(DEPTNO,DNAME,LOC,NUM){
    		url="Pre_Load_Dept.action?DEPTNO="+DEPTNO+"&DNAME="+DNAME+"&LOC="+LOC+"&NUM="+NUM  ;
    		location.href = url ;
    	}
    	function dele(DEPTNO){
    		if(confirm("确定删除？")){
    			var url = "Delete_Dept.action?DEPTNO="+DEPTNO ;
    			location.href=url ;
    		}
    	}
    	function add(){
    		var tableId = document.getElementById("tab"); 
    		var arr = new Array() ;
    		for(var i=1;i<tableId.rows.length;i++) {
    			arr[i-1] = tableId.rows[i].cells[0].innerHTML.trim() ;
    		}
    		var url = "Pre_Add_Dept.action?Arr="+arr ;
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
    		top :120px ;
    		left: 280px ;
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
    </ul>
    </div>
     <div class="content">
        <div class="header">

        </div>
        <div class="main-content">
   
    <div class="row">
    
        <div class="panel panel-default">
            <div class="panel-heading no-collapse">部门信息<span class="label label-warning"></span></div>
            <table class="table table-bordered table-striped" id="tab">
   			 <thead>
   				<tr>
    				<th>部门编号</th> <th>部门名称</th> <th>所在地</th> <th>部门人数</th>
    			</tr>
   				 </thead>
              <tbody>
   				<s:iterator id="li" value="list" >
   				<tr>
					<th><s:property value="#li.DEPTNO"/> </th> 
					<th><s:property value="#li.DNAME"/> </th> 
					<th><s:property value="#li.LOC"/> </th> 
					<th><s:property value="#li.NUM"/> </th> 
					<th><input type="button" value="修改" class="btn btn-primary pull-right" onclick="do_update(<s:property value="#li.DEPTNO"/>,
					'<s:property value="#li.DNAME"/>','<s:property value="#li.LOC"/>',<s:property value="#li.NUM"/>)"/>
					<s:if test='#li.NUM=="0"'>
						
						<input type="button" value="删除" onclick="dele(<s:property value="#li.DEPTNO"/>)" class="btn btn-primary pull-right"/>
					</s:if>
					</th>
					
   				</tr>
              <tbody>
   			</s:iterator>
   			<tr>
	   			<th colspan="3"><input type="button" value="增  加  部  门" class="btn btn-primary pull-right" onclick="add()" /></th></tr>
   			</table>
            
        </div>
   

	</div>
	<footer>
                <hr>

                
                <p class="pull-right">计算机1504</p>
                
            </footer>
        </div>
    </div>
<script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>
