<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script src="<%=path%>/vendor/easyui/jquery.min.js"></script>
<script src="<%=path%>/vendor/easyui/jquery.easyui.min.js"></script>
<link href="<%=path%>/vendor/easyui/themes/material/easyui.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/vendor/easyui/themes/icon.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="<%=path%>/vendor/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vendor/easyui/themes/icon.css">

    <script type="text/javascript" src="<%=path%>/vendor/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/vendor/easyui/jquery.easyui.min.js"></script>

  </head>
  
  <body>
  	<table id="table_info" class="easyui-datagrid " style="width: 800px;height: 400px"
            data-options="singleSelect:true,fitColumns:true,collapsible:true, pagination:'true',
              url:'${pageContext.request.contextPath}/orderAction!loadAll.action'" >
        <thead>
            <tr>
                <th data-options="field:'companyId',width:100,align:'center'"
						sortable="true">公司id</th>
			    <th data-options="field:'order',width:100,align:'center'">订单编号</th>
			    <th data-options="field:'startDate',width:100,align:'center'">下单时间</th>
			    <th data-options="field:'confirmDate',width:100,align:'center'">确认时间</th>
			    <th data-options="field:'pillDate',width:100,align:'center'">付款时间</th>
			    <th data-options="field:'endDate',width:100,align:'center'">结束时间</th>
			    <th data-options="field:'status',width:100,align:'center'">订单状态</th>
			    <th data-options="field:'amount',width:100,align:'center'">amount</th>
			    <th data-options="field:'remark',width:100,align:'center'">备注</th>
            </tr>
        </thead>
    </table>
  </body>
</html>
