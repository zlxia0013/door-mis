<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>新增客户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%
        String path = request.getContextPath();
        path = "/".equals(path) ? "" : path;
        request.setAttribute("path", path);
    %>
    <script type="text/javascript">
        var path = "${path}";
    </script>

    <link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/site.css">

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">${userInfo.userName}-${userInfo.role}-${userInfo.realName}</a>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header"><i class="icon-wrench"></i> Administration</li>
                    <li class="active"><a href="${path}/client/goto_main_page">客户管理</a></li>
                    <li><a href="${path}/user/goto_main_page">用户管理</a></li>

                    <li class="nav-header"><i class="icon-user"></i> Profile</li>
                    <li><a href="${path}/user/goto_update_pwd_page">修改密码</a></li>
                    <li><a href="${path}/logout">退出</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <div class="row-fluid">
                <div class="page-header">
                    <h1>新增客户</h1>
                </div>
                <form class="form-horizontal">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label" for="realName">姓名</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="realName"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="code">编号</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="code"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="phone">电话</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="phone"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="address">地址</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="address"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="wechat">微信号</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="wechat"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="logistics">货运部</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="logistics"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="remark">备注</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="remark"/>
                            </div>
                        </div>
                        <div class="form-actions">
                            <input type="button" class="btn btn-success btn-large"  onclick="add()" value="保  存"/>
                            <a class="btn" href="${path}/client/goto_main_page">Cancel</a>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <hr>

    <footer class="well">
        &copy; 客户管理系统
    </footer>

</div>

<script type="text/javascript" src="${path}/js/jquery.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function add(){
        var realName = $.trim($("#realName").val());
        if(realName == ""){
            alert("请输入姓名");
            return;
        }

        var code = $.trim($("#code").val());
        if(code == ""){
            alert("请输入编号");
            return;
        }

        var phone = $.trim($("#phone").val());
        if(phone == ""){
            alert("请输入电话");
            return;
        }

        var address = $.trim($("#address").val());
        if(address == ""){
            alert("请输入地址");
            return;
        }

        var wechat = $.trim($("#wechat").val());
        var logistics = $.trim($("#logistics").val());
        var remark = $.trim($("#remark").val());

        $.ajax({
            url:"${path}/client/add",
            type:"post",
            data:{
                realName:realName,
                code:code,
                phone:phone,
                address:address,
                wechat:wechat,
                logistics:logistics,
                remark:remark
            },
            success:function(result){
                var re = JSON.parse(result);
                if(re.returnCode=="0"){
                    window.location.href="${path}/client/goto_main_page";
                }else{
                    alert(re.msg);
                }
            },
            error:function(request) {      // 设置表单提交出错
                alert(request);  //登录错误提示信息
            }
        });

        return false;
    }
</script>

</body>
</html>
