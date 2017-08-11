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
    
    
     
     <link href="<%=path%>/vendor/select-tree/base.css" rel="stylesheet" type="text/css" />
     <link href="<%=path%>/vendor/select-tree/style.css" rel="stylesheet" type="text/css" />
    
	 <link href="<%=path%>/vendor/easyui/themes/material/easyui.css" rel="stylesheet" type="text/css">
     <link href="<%=path%>/vendor/easyui/themes/icon.css" rel="stylesheet" type="text/css">
     
	<script src="<%=path%>/vendor/jquery/jquery.min.js"></script>
	
    <script src="<%=path%>/vendor/select-tree/select-tree.js" type="text/javascript"></script>
	<script src="<%=path%>/vendor/easyui/jquery.easyui.min.js"></script>

  </head>
  
 <body class="easyui-layout">
 	<div data-options="region:'north',border:false,showHeader:false"  style="height:40px" >
 		<span style="font-size: 22px;height:40px;line-height: 40px;margin: 0px">订单管理</span>
 		<a onclick="select_save()" id="select_save" style="background-color:#e05447;color:#fff;float: right;width:60px;height: 30px;line-height: 30px;text-align: center;margin-top: 5px">保存</a>
 	</div>
 	
	<div data-options="region:'center',border:false,showHeader:false" style="padding-bottom: 3px" class="production-menu" id="pro_datalist" fit="true">
 		<div class='menu' id='firstMenu'>

  		</div>
  		<div class="sub-menu easyui-panel" fit="true" id="secondMenu" style="padding-bottom: 20px" >

  		</div>
 	</div>
	<div data-options="region:'south',border:false"  style="height:20px" ></div>
    <script type="text/javascript">
     	var positiondata = "[{'name':'兼职|实习|社工|其他','children':[{'name':'实习生/培训生/储备干部','children':[{'name':'实习生','id':'01',selected:1},{'name':'培训生','id':'02'},{'name':'储备干部','id':'03'},{'name':'其他','id':'04'}]},{'name':'志愿者/社会工作者','children':[{'name':'志愿者/义工','id':'05'},{'name':'社会工作者/社工','id':'06'},{'name':'其他','id':'07'}]},{'name':'兼职/临时','children':[{'name':'兼职','id':'08'},{'name':'临时','id':'09'},{'name':'国外求职','id':'10'},{'name':'其他','id':'11'}]},{'name':'其他','children':[{'name':'其他','id':'11'}]}]}            ,{'name':'测试一级','children':[{'name':'测试二级1','children':[{'name':'测试三级11','id':'12'},{'name':'测试三级12','id':'13'}]},{'name':'测试二级2','children':[{'name':'测试三级21','id':'14'},{'name':'测试三级22','id':'15'}]},{'name':'其他','children':[{'name':'其他','id':'16'}]}]}]";
    	$(function(){
    		$.ajax({ 
			url: '${pageContext.request.contextPath}/productAction!loadAll.action',			
			dataType : 'json',
			success : function(obj){
				initMenu("pro_datalist", obj);
			}
		});
			
		});
		function select_save(){
			getSelected();
		}
    </script>
</body>
</html>
