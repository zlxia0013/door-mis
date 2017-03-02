<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户管理</title>
<%@include file="/jsp/include/easyui.jsp"%>
<%@include file="/jsp/include/center.jsp"%>
<script type="text/javascript">
	//因为layout框架指向href时，只取html页面body中间的部分，所以该页面这样写即可
    //有datagrid包含属性较多，所以尽量使用js的方式初始化datagrid框架
    $(function () {
        $("#datagrid").datagrid({
            url:path+"/user/datagrid.do", //指向一个一般处理程序或者一个控制器，返回数据要求是Json格式，直接赋值Json格式数据也可，我以demo中自带的Json数据为例，就不写后台代码了，但是我会说下后台返回的注意事项
            iconCls: "icon-add",
            fitColumns: false, //设置为true将自动使列适应表格宽度以防止出现水平滚动,false则自动匹配大小
            idField: 'id', //标识列，一般设为id，可能会区分大小写，大家注意一下
            loadMsg: "正在努力为您加载数据", //加载数据时向用户展示的语句
            pagination: true, //显示最下端的分页工具栏
            rownumbers: true, //显示行数 1，2，3，4...
            pageSize: 10, //读取分页条数，即向后台读取数据时传过去的值
            pageList: [5, 10, 15], //可以调整每页显示的数据，即调整pageSize每次向后台请求数据时的数据
            //由于datagrid的属性过多，我就不每个都介绍了，如有需要，可以看它的API
            sortName: 'id', //初始化表格时依据的排序 字段 必须和数据库中的字段名称相同
            sortOrder: 'desc', //正序
            remoteSort:true,
            singleSelect:true,//是否单选
            frozenColumns:[[
            	{ field: 'id', title: '用户ID' , width : fillsize(0.08), sortable: true },
            	{ field: 'loginName', title: '手机号码' , width : fillsize(0.08), sortable: true },
            ]], 
            columns: [[
            	{ field: 'realName', title: '姓名' , width : fillsize(0.08), sortable: true },
            	{ field: 'lastAccessTime', title: '最后访问时间' , width : fillsize(0.1), formatter : formatterdate, sortable: true },
            	{ field: 'lastAccessPhoneType', title: '最后访问手机类型' , width : fillsize(0.08), sortable: true },
            	{ field: 'lastAccessAppVersion', title: '访问版本' , width : fillsize(0.08), sortable: true },
            	{ field: 'regFrom', title: '注册来源' , width : fillsize(0.08), sortable: true },
            	{ field: 'serviceHours', title: '总服务时长' , width : fillsize(0.08), sortable: true },
            	{ field: 'prestige', title: '信誉等级' , width : fillsize(0.08), sortable: true },
            	{ field: 'level', title: 'VIP等级' , width : fillsize(0.08), sortable: true },
            	{ field: 'flyPigeonCnt', title: '放鸽子次数' , width : fillsize(0.08), sortable: true },
            ]]//,//这里之所以有两个方括号，是因为可以做成水晶报表形式，具体可看demo
            //onSortColumn: function (sort, order) {
            //    alert("sort:"+sort+",order："+order+"");
            //},
            /* toolbar: [{//在dategrid表单的头部添加按钮
                text: "新增",
                iconCls: "icon-add",
                handler: function () {
                	userAdd();
                }
            }, '-', {
                text: "修改",
                iconCls: "icon-edit",
                handler: function () {
                	var row = $('#datagrid').datagrid('getSelected');
					if (row) {
						userEdit();
					} else {
						$.messager.alert('提示', '请选择要操作的记录！', 'error');
					}
                }
            }, '-'] */
        });
        //searchFunc();
    });
    
    /**
	* 新增
	*/
	function userAdd(obj){
		var _title = "新增";
        var _url = encodeURI(path + "/jsp/user/userAdd.jsp");
        
		$('#userEdit').dialog({
		    title: _title,
		    width: fillsize(0.8),
			height: fillsize(0.8),
		    cache: false,
		    collapsible: true,
		    maximizable: true,
		    resizable: true,
		    modal: true,
		    closed: true
		});
		$('#openUserIframe')[0].src=_url;
		$('#userEdit').dialog('open');
	}
	
    /**
	* 修改
	*/
	function userEdit(obj){
		var _title = "修改";
        var _url = encodeURI(path + "/jsp/user/userEdit.jsp");
        
		$('#userEdit').dialog({
		    title: _title,
		    width: fillsize(0.8),
			height: fillsize(0.8),
		    cache: false,
		    collapsible: true,
		    maximizable: true,
		    resizable: true,
		    modal: true,
		    closed: true
		});
		$('#openUserIframe')[0].src=_url;
		$('#userEdit').dialog('open');
	}

    //点击查找按钮出发事件
    function searchFunc() {
        $("#datagrid").datagrid("load", sy.serializeObject($("#searchForm").form()));//将searchForm表单内的元素序列为对象传递到后台
    }

    //点击清空按钮出发事件
    function clearSearch() {
        $("#datagrid").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
        $("#searchForm").find("input").val("");//找到form表单下的所有input标签并清空
    }
</script>

</head>
<body class="easyui-layout" fit="true">
	<!--由于查询需要输入条件，但是以toolbar的形式不好，所以我们在Layout框架的头部north中书写查询的相关信息-->
	<!-- 这里我们尽量使其展示的样式与toolbar的样式相似，所以我们先查找toolbar的样式，并复制过来-->
	<div data-options="region:'north',title:'客户查询'"
		style="height: 100px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
				<tr>
					<td>手机号码</td>
					<td colspan="2"><input name="loginName" />
					<td><a class="easyui-linkbutton" href="javascript:void(0);"
						onclick="searchFunc();">查找</a>
					</td>
					<td><a class="easyui-linkbutton" href="javascript:void(0);"
						onclick="clearSearch();">清空</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false" style="OVERFLOW:auto;">
		<!-- 信息列表 -->
		<table id="datagrid">
        </table>
	</div>
	<div id="userEdit" class="easyui-window" closed="true" modal="true" title="标题" style="width:500px;height:350px;">
		<iframe scrolling="auto" id='openUserIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
	</div>
</body>
</html>
