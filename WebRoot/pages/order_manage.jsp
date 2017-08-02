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
    
    
   <jsp:include page="/common.jsp"></jsp:include>

  </head>
  
 <body class="easyui-layout">
 	<div data-options="region:'north',border:false,showHeader:false"  style="height:60px" >
 		<h3>订单管理</h3>
 	</div>
 	<div data-options="region:'center',border:false,showHeader:false" style="padding-bottom: 20px">
 		<table id="table_order" class="easyui-datagrid" fit="true" ></table>
 	</div>
	
    <script type="text/javascript">
    	$(function(){
			$('#table_order').datagrid({
				url:'${pageContext.request.contextPath}/orderAction!loadAll.action',
				pagination: true,
			
				
				fitColumns: true,
				singleSelect: true,
				columns:[[
					{field:'companyId',title:'公司ID',width:100,align:'center'},
					{field:'order',title:'订单编号',width:100,align:'center'},
					{field:'startDate',title:'下单时间',width:150,align:'center',
						formatter: function(value,row,index){
							return value.substring(0,16);
						}},
					{field:'confirmDate',title:'确认时间',width:150,align:'center',
						formatter: function(value,row,index){
							return value.substring(0,16);
						}},
					{field:'pillDate',title:'付款时间',width:150,align:'center',
						formatter: function(value,row,index){
							return value.substring(0,16);
						}},
					{field:'endDate',title:'结束时间',width:150,align:'center',
						formatter: function(value,row,index){
							return value.substring(0,16);
						}},
					{field:'status',title:'订单状态',width:100,align:'center'},
					{field:'amount',title:'amount',width:100,align:'center'},
					{field:'remark',title:'备注',width:100,align:'center'}
				]],
				
			});
		});
    </script>
</body>
</html>
