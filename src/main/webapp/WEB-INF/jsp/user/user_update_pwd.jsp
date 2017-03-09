<%@ page import="com.jack.doormis.core.user.UserStateEnum" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
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
            <a class="brand" href="#">${sessionUserInfo.userName}-${sessionUserInfo.role}-${sessionUserInfo.realName}</a>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header"><i class="icon-wrench"></i> Administration</li>
                    <li><a href="${path}/client/goto_main_page">客户管理</a></li>
                    <li><a href="${path}/user/goto_main_page">用户管理</a></li>

                    <li class="nav-header"><i class="icon-user"></i> Profile</li>
                    <li class="active"><a href="${path}/user/goto_update_pwd_page">修改密码</a></li>
                    <li><a href="${path}/logout">退出</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <div class="row-fluid">
                <div class="page-header">
                    <h1>修改密码</h1>
                </div>
                <form class="form-horizontal">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label" for="oldPwd">原密码</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="oldPwd"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="pwd1">新密码</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="pwd1"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="pwd2">重复新密码</label>
                            <div class="controls">
                                <input type="text" class="input-xlarge" id="pwd2"/>
                            </div>
                        </div>

                        <div class="form-actions">
                            <input type="button" class="btn btn-success btn-large" onclick="update()" value="保  存"/>
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
    function update() {
        var oldPwd = $.trim($("#oldPwd").val());
        if (oldPwd == "") {
            alert("请输入原密码");
            return;
        }

        var pwd1 = $.trim($("#pwd1").val());
        if (pwd1 == "") {
            alert("请输入新密码");
            return;
        }

        var pwd2 = $.trim($("#pwd2").val());
        if (pwd2 == "") {
            alert("请输入确认密码");
            return;
        }

        if (pwd1 != pwd2) {
            alert("新密码与确认密码不一致，请重新输入");
            return;
        }

        $.ajax({
            url: "${path}/user/update_pwd",
            type: "post",
            data: {
                oldPwd: oldPwd,
                newPwd: pwd1
            },
            success: function (result) {
                var re = JSON.parse(result);
                if (re.returnCode == "0") {
                    window.location.href = "${path}/client/goto_main_page";
                } else {
                    alert(re.msg);
                }
            },
            error: function (request) {      // 设置表单提交出错
                alert(request);  //登录错误提示信息
            }
        });

        return false;
    }
</script>

</body>
</html>
