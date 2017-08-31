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
 	<div  id="order_dlg" closed="true" class="easyui-dialog" style="width:800px;height: 450px"
			data-options="border:'thin',cls:'c1',collapsible:false,modal:true,closable:false,top:10,buttons: '#company_dlg_buttons'">
		    	<form id="order_form" role="form" style="margin: 0px">
					<input type="hidden"  id = "id"  name = "id">
		    	<!-- <div class="form-group col-md-6">
		            	<label class="col-md-4" style="display: inline-block;height: 34px;line-height: 34px;text-align: left;width: 30%">订单编号：</label>
		                <input name="orderNo" id="orderNo" class="form-control" style="display: inline-block;width: 30%">
		        </div>
		        <div class="form-group col-md-6">
		                	<label class="col-md-4" style="display: inline-block;height: 34px;line-height: 34px;text-align: left;width: 30%">下单时间：</label>
		                <input name="startDate" id = "startDate" class="easyui-datebox" style="display: inline-block;width: 30%">
		        </div> -->
		    	</form>   
			    	<table id="table_add" class="easyui-datagrid" fit="true" ></table>              
		</div>
	<div id="company_dlg_buttons" style="width:600px;height: 40px;text-align: center">
			<button id="company_save" type="button" class="btn btn-primary btn-dialog-left">保存</button>
			<button onclick="company_close()" type="button" class="btn btn-default btn-dialog-right">取消</button>
		</div>
    <script type="text/javascript">
    	$(function(){
    		
			$('#table_order').datagrid({
				url:'${pageContext.request.contextPath}/orderAction!loadAll.action',
				pagination: true,
				fitColumns: true,
				singleSelect: true,
				toolbar: [{
					text:'添加',
					iconCls: 'icon-add',
					handler: function(){order_add();}
				},'-',{
					text:'修改',
					iconCls: 'icon-edit',
					handler: function(){order_edit();}
				},'-',{
					text:'删除',
					iconCls: 'icon-remove',
					handler: function(){order_delete();}
				}],
				columns:[[
					{field:'id', hidden:'true',editor:'textbox' },
					{field:'companyId',title:'公司ID',width:100,align:'center'},
					{field:'orderNo',title:'订单编号',width:100,align:'center'},
					{field:'startDate',title:'下单时间',width:150,align:'center',
						formatter: function(value,row,index){
							if(value){
								return value.substring(0,16);
							}else{
								return "";
							}
							
						}},
					{field:'confirmDate',title:'确认时间',width:150,align:'center',
						formatter: function(value,row,index){
							if(value){
								return value.substring(0,16);
							}else{
								return "";
							}
						}},
					{field:'pillDate',title:'付款时间',width:150,align:'center',
						formatter: function(value,row,index){
							if(value){
								return value.substring(0,16);
							}else{
								return "";
							}
						}},
					{field:'endDate',title:'结束时间',width:150,align:'center',
						formatter: function(value,row,index){
							if(value){
								return value.substring(0,16);
							}else{
								return "";
							}
						}},
						{field:'amount',title:'订单总价',width:100,align:'center',editor:'textbox'},
					{field:'status',title:'订单状态',width:100,align:'center'},
					{field:'remark',title:'备注',width:100,align:'center'}
				]],
				
			});
		
			$('#dlg-frame').dialog( {
				title : '新增订单',
				width :  909,
				height : 600,
				top:50,
				left:100,
				closed : true,
				cache : false,
				modal : true,
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						if (confirm("确定执行下一步操作？")) {
							frameContent.window.doServlet();
						}
					}
				}, {
					text : '关闭',
					iconCls : 'icon-cancel',
					handler : function() {
						$('#dlg-frame').dialog("close");
					}
				} ]
			});
			
			$('#startDate').datebox({
			     formatter: function(date){
			    		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
			    	}
			   
			});
		});
    	
    	var editIndex = undefined;

    	$(function(){
    		   if("${roleId}" == '3'){
				$('#table_add').datagrid({
					url:'${pageContext.request.contextPath}/orderAction!searchDetail.action' ,
					pagination: true,
					fitColumns: true,
					singleSelect: true,
					onClickRow: onClickRow,//选中行是，调用onClickRow js方法（397行）
					toolbar: [{
						text:'添加',
						iconCls: 'icon-add',
						handler: function(){append();}
					},'-',{
						text:'删除',
						iconCls: 'icon-remove',
						handler: function(){removeit();}
					}/*  ,'-',{
						text:'保存',
						iconCls: 'icon-save',
						handler: function(){accept();}
					} */ ,'-',{
						text:'取消',
						iconCls: 'icon-undo',
						handler: function(){reject();}
					},'-',{
						text:'提交',
						iconCls: 'icon-ok',
						handler: function(){submitData();}
					}],
					columns:[[
						{field:'product',title:'产品大类',width:100,align:'center',
							editor : {    
		                        type : 'combobox',    
		                        options : {    
		                            url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
		                            valueField:'product' ,   
		                            textField:'product',  
		                            onSelect:function(data){  
		                                var row = $('#table_add').datagrid('getSelected');  
		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
		                                 var ed = $("#table_add").datagrid('getEditor', {  
		                                        index : rowIndex,  
		                                        field : 'unit'  
		                                    });  
		                                $(ed.target).textbox('setValue',  data.unit);   
		                                var thisTarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'product'}).target;  
		                                var value = thisTarget.combobox('getValue');  
		                                var target = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'type'}).target;  
		                                target.combobox('clear'); //清除原来的数据  
		                                var subtarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'sub_product'}).target;  
		                                subtarget.combobox('clear');
		                                var url = '${pageContext.request.contextPath}/orderAction!getProductType.action?product='+data.product;  
		                                target.combobox('reload', url);//联动下拉列表重载   */
		                            }  
		                        }    
		                    	}/* ,
							formatter : function (value, row, index) {
				                   
				                    return row.materail;
				                } */
						},
						{field:'type',title:'产品类型',width:100,align:'center',
							editor : {    
		                        type : 'combobox',    
		                        options : {    
		                           // url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
		                            valueField:'type' ,   
		                            textField:'type',  
		                            onSelect:function(data){  
		                                var row = $('#table_add').datagrid('getSelected');  
		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
		                                var thisTarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'type'}).target;  
		                                var value = thisTarget.combobox('getValue');  
		                                var idvalue = $("#table_add").datagrid('getEditor', {  
	                                        index : rowIndex,  
	                                        field : 'productId'  
	                                    });  
	                                $(idvalue.target).textbox('setValue',  data.id ); 
		                                var target = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'sub_product'}).target;  
		                                target.combobox('clear'); //清除原来的数据  
		                                var url = '${pageContext.request.contextPath}/orderAction!getProductDetail.action?productId='+data.id;  
		                                target.combobox('reload', url);//联动下拉列表重载   
		                            }  
		                        }    
		                    	}
						},
						{field:'sub_product',title:'产品规格',width:100,align:'center',
							editor : {    
		                        type : 'combobox',    
		                        options : {    
		                           // url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
		                            valueField:'subProduct' ,   
		                            textField:'subProduct',  
		                            onSelect:function(data){  
		                                var row = $('#table_add').datagrid('getSelected');  
		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
		                                 var ed = $("#table_add").datagrid('getEditor', {  
		                                        index : rowIndex,  
		                                        field : 'materail'  
		                                    });  
		                                $(ed.target).textbox('setValue',  data.material); 
		                                $(ed.target).combobox('disable');
		                                var idvalue = $("#table_add").datagrid('getEditor', {  
	                                        index : rowIndex,  
	                                        field : 'detailId'  
	                                    });  
	                                $(idvalue.target).textbox('setValue',  data.id );   
		                            }  
		                        }    
		                    	}},
						{field:'materail',title:'材质',width:100,align:'center',editor:'textbox'},
						{field:'acount',title:'数量',width:100,align:'center',editor:'textbox'},
						{field:'unit',title:'单位',width:100,align:'center',editor:'textbox'},
						{field:'detailId', hidden:'true',editor:'textbox' },
						{field:'productId', hidden:'true',editor:'textbox' },
						{field:'remark',title:'备注',width:100,align:'center',editor:'textbox'},
						{field:'id', hidden:'true',editor:'textbox' }
					]],
					
				});
    		   }else if("${roleId}" == '1'){
    			   $('#table_add').datagrid({
   					url:'${pageContext.request.contextPath}/orderAction!searchDetail.action' ,
   					pagination: true,
   					fitColumns: true,
   					singleSelect: true,
   					onClickRow: onClickRow,//选中行是，调用onClickRow js方法（397行）
   					toolbar: [{
   						text:'添加',
   						iconCls: 'icon-add',
   						handler: function(){append();}
   					},'-',{
   						text:'删除',
   						iconCls: 'icon-remove',
   						handler: function(){removeit();}
   					}/*  ,'-',{
   						text:'保存',
   						iconCls: 'icon-save',
   						handler: function(){accept();}
   					} */ ,'-',{
   						text:'取消',
   						iconCls: 'icon-undo',
   						handler: function(){reject();}
   					},'-',{
   						text:'提交',
   						iconCls: 'icon-ok',
   						handler: function(){submitData();}
   					}],
   					columns:[[
   						{field:'product',title:'产品大类',width:100,align:'center',
   							editor : {    
   		                        type : 'combobox',    
   		                        options : {    
   		                            url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
   		                            valueField:'product' ,   
   		                            textField:'product',  
   		                            onSelect:function(data){  
   		                                var row = $('#table_add').datagrid('getSelected');  
   		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
   		                                 var ed = $("#table_add").datagrid('getEditor', {  
   		                                        index : rowIndex,  
   		                                        field : 'unit'  
   		                                    });  
   		                                $(ed.target).textbox('setValue',  data.unit);   
   		                                var thisTarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'product'}).target;  
   		                                var value = thisTarget.combobox('getValue');  
   		                                var target = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'type'}).target;  
   		                                target.combobox('clear'); //清除原来的数据  
   		                                var subtarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'sub_product'}).target;  
   		                                subtarget.combobox('clear');
   		                                var url = '${pageContext.request.contextPath}/orderAction!getProductType.action?product='+data.product;  
   		                                target.combobox('reload', url);//联动下拉列表重载   */
   		                            }  
   		                        }    
   		                    	}/* ,
   							formatter : function (value, row, index) {
   				                   
   				                    return row.materail;
   				                } */
   						},
   						{field:'type',title:'产品类型',width:100,align:'center',
   							editor : {    
   		                        type : 'combobox',    
   		                        options : {    
   		                           // url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
   		                            valueField:'type' ,   
   		                            textField:'type',  
   		                            onSelect:function(data){  
   		                                var row = $('#table_add').datagrid('getSelected');  
   		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
   		                                var thisTarget = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'type'}).target;  
   		                                var value = thisTarget.combobox('getValue');  
   		                                var idvalue = $("#table_add").datagrid('getEditor', {  
   	                                        index : rowIndex,  
   	                                        field : 'productId'  
   	                                    });  
   	                                $(idvalue.target).textbox('setValue',  data.id ); 
   		                                var target = $('#table_add').datagrid('getEditor', {'index':rowIndex,'field':'sub_product'}).target;  
   		                                target.combobox('clear'); //清除原来的数据  
   		                                var url = '${pageContext.request.contextPath}/orderAction!getProductDetail.action?productId='+data.id;  
   		                                target.combobox('reload', url);//联动下拉列表重载   
   		                            }  
   		                        }    
   		                    	}
   						},
   						{field:'sub_product',title:'产品规格',width:100,align:'center',
   							editor : {    
   		                        type : 'combobox',    
   		                        options : {    
   		                           // url:'${pageContext.request.contextPath}/orderAction!getProduct.action',  
   		                            valueField:'subProduct' ,   
   		                            textField:'subProduct',  
   		                            onSelect:function(data){  
   		                                var row = $('#table_add').datagrid('getSelected');  
   		                                var rowIndex = $('#table_add').datagrid('getRowIndex',row);//获取行号  
   		                                 var ed = $("#table_add").datagrid('getEditor', {  
   		                                        index : rowIndex,  
   		                                        field : 'materail'  
   		                                    });  
   		                                $(ed.target).textbox('setValue',  data.material); 
   		                                $(ed.target).combobox('disable');
   		                                var idvalue = $("#table_add").datagrid('getEditor', {  
   	                                        index : rowIndex,  
   	                                        field : 'detailId'  
   	                                    });  
   	                                $(idvalue.target).textbox('setValue',  data.id );   
   		                            }  
   		                        }    
   		                    	}},
   						{field:'materail',title:'材质',width:100,align:'center',editor:'textbox'},
   						{field:'acount',title:'数量',width:100,align:'center',editor:'textbox'},
   						{field:'unit',title:'单位',width:100,align:'center',editor:'textbox'},
   						{field:'price',title:'单价',width:100,align:'center',editor:'textbox'},
   						{field:'detailId', hidden:'true',editor:'textbox' },
   						{field:'productId', hidden:'true',editor:'textbox' },
   						{field:'remark',title:'备注',width:100,align:'center',editor:'textbox'},
   						{field:'id', hidden:'true',editor:'textbox' }
   					]],
   					
   				});
    		   }
			//$("#table_add").datagrid("hideColumn","amount");
		});
    	
    	function order_add(){
    		$("#order_dlg").dialog({
				onOpen: function () {
					$("#id").val("");  
                }
			});
			$('#order_dlg').dialog('open');	
			$('#order_dlg').dialog('setTitle','添加订单');
			$('#table_add').datagrid('loadData', { total: 0, rows: [] });
			//$('#table_add').datagrid('reload');
			/* $("#company_save").click(function(){
  				$.ajax({
					url : '${pageContext.request.contextPath}/companyAction!add.action',
					data : $('#order_form').serialize(),
					dataType : 'json',
					success : function(obj) {
						if (obj.success) {
							alert(obj.msg);
							company_close();
						} else {
							alert(obj.msg);
						}
					}
				});
			});  */
		}
    	function order_delete(){
			var row = $('#table_order').datagrid('getSelected');
			
    		if(row){
    			$.messager.confirm(
    				'提示',
    				'确定要删除么?',
    				function(r) {
    					if (r) {
    						$.ajax({ 
    			    			url: '${pageContext.request.contextPath}/orderAction!deleteOrder.action',
    			    			data : {"id":row.id},
    			    			dataType : 'json',
    			    			success : function(obj){
    			    				if(obj.success){
    			    				 	alert(obj.msg);
    			    				 	$('#table_order').datagrid('reload');
    			    				}else{
    			    					alert(obj.msg);
    			    					$('#table_order').datagrid('reload');
    			    				}
    			    			}
    			    		});
    					}
    				});  		
    			}
		}
    	function order_edit(){
			var row = $('#table_order').datagrid('getSelected');
    		if(row){
    			$("#order_dlg").dialog({
    				onOpen: function () {
                        $("#startDate").textbox("setValue",row.startDate.split(" ")[0]);   
                        $("#orderNo").val(row.orderNo);   
                        $("#id").val(row.id); 
                    }
    			});
    			$('#order_dlg').dialog('open');	
    			$('#order_dlg').dialog('setTitle','编辑订单');
			$("#startDate").val(row.startDate);
			editIndex = undefined;
			$('#table_add').datagrid('reload', {
				 id: $("#id").val()
			});
				$("#company_save").click(function(){
  					$.ajax({
						url : '${pageContext.request.contextPath}/companyAction!update.action',
						data : $('#order_form').serialize(),
						dataType : 'json',
						success : function(obj) {
							if (obj.success) {
								alert(obj.msg);
								company_close();
							} else {
								alert(obj.msg);
							}
						}
					});
				});
			}
    	}
    	
    	function company_close(){
			document.getElementById('order_form').reset();
			$('#order_dlg').dialog('close');	
			$('#table_order').datagrid('reload');
		}
    </script>
    
    <script type="text/javascript">
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#table_add').datagrid('validateRow', editIndex)){
				$('#table_add').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#table_add').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#table_add').datagrid('selectRow', editIndex);
				}
			}
		}
		function append(){
			if (endEditing()){
				$('#table_add').datagrid('appendRow',{status:'P'});
				editIndex = $('#table_add').datagrid('getRows').length-1;
				$('#table_add').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		function removeit(){
			if (editIndex == undefined){return}
			$('#table_add').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		function accept(){
			if (endEditing()){
				$('#table_add').datagrid('acceptChanges');
			}
		}
		function reject(){
			$('#table_add').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function submitData() {
			if (endEditing()) { 
		                //利用easyui控件本身的getChange获取新添加，删除，和修改的内容  
		            if ($("#table_add").datagrid('getChanges').length) {  
		                    var inserted = $("#table_add").datagrid('getChanges', "inserted");  
		                    var deleted = $("#table_add").datagrid('getChanges', "deleted");  
		                    var updated = $("#table_add").datagrid('getChanges', "updated");
		                		var data = $('#order_form').serialize();
		                    var effectRow = new Object();  
		                    effectRow["formData"] = data;
		                    if (inserted.length) { 
		                        effectRow["inserted"] = JSON.stringify(inserted);  
		                    }  
		                    if (deleted.length) {  
		                        effectRow["deleted"] = JSON.stringify(deleted);  
		                    }  
		                    if (updated.length) {  
		                        effectRow["updated"] = JSON.stringify(updated);  
		                    } 
		                    $.post("${pageContext.request.contextPath}/orderAction!getChanges.action?"  + data  , effectRow, function(obj) {
		                				if(obj.success){
		    			    				 	alert(obj.msg);
		    			    				 	 $('#order_dlg').dialog('close');	
		    			    				 	$('#table_order').datagrid('reload');
		    			    				}else{
		    			    					alert(obj.msg);
		    			    					 $('#order_dlg').dialog('close');	
		    			    					$('#table_order').datagrid('reload');
		    			    				}
		                    }, "JSON");
		              }
				} 
			}
	 </script>
</body>
</html>
