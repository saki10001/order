<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<jsp:include page="common.jsp"></jsp:include>

  </head>
  
  <body>
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
      <div class="navbar-header">
          <a class="navbar-brand" href="<%=path%>">订单管理系统</a>
      </div>
      <!-- /.navbar-header -->
      <ul class="nav navbar-top-links navbar-right">
          <!-- /.dropdown -->
          <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                  <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
              </a>
              <ul class="dropdown-menu dropdown-user">
                  <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                  </li>
                  <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                  </li>
                  <li class="divider"></li>
                  <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                  </li>
              </ul>
              <!-- /.dropdown-user -->
          </li>
          <!-- /.dropdown -->
      </ul>
      <!-- /.navbar-top-links -->
      <!-- /.navbar-static-side -->
  </nav>

  <div class="easyui-layout" fit="true" style="position:absolute;top:0;left:0;">
      <div data-options="region:'north'" style="height:50px"></div>
      <div data-options="region:'west',border:false"  style="width:18%;background-color:#f8f8f8">
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li>
                <a href="#"  class="active" onclick="openTab('<%=path%>/pages/order_manage.jsp')">
                  <i class="fa fa-dashboard fa-fw"></i>订单管理</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>信息管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#"  onclick="openTab('<%=path%>/pages/company_manage.jsp')">公司管理</a>
                    </li>
                    <li>
                        <a href="#"  onclick="openTab('<%=path%>/pages/produce_select.jsp')">用户管理</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 一级标题<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#"  onclick="openTab('<%=path%>/pages/produce_select.jsp')">二级标题</a>
                    </li>
                    <li>
                        <a href="#">二级标题<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li>
                                <a href="#">三级标题</a>
                            </li>
                            <li>
                                <a href="#">三级标题1111</a>
                            </li>
                        </ul>
                        <!-- /.nav-third-level -->
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
      </div>
    </div>
      </div>
   <div data-options="region:'center',border:false,showHeader:false" class="easyui-tabs" style="padding:20px 20px 22px 20px">
        <iframe id="center-content" class="easyui-panel" frameborder="0"  scrolling="auto"    fit="true" data-options="border:false" src="http://www.baidu.com">

        </iframe>
      </div>
    <!-- /#wrapper -->

    <script type="text/javascript">
        function openTab(url){
          document.getElementById("center-content").src = url;
        };
    </script>
    <style type="text/css">
         .tabs-panels>.panel>.panel-body {  
    overflow: hidden;  
    } 
    </style>
  </body>
</html>
