<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <%
        String path = request.getContextPath();
        path = "/".equals(path)?"":path;
        request.setAttribute("path", path);
    %>
    <script type="text/javascript">
        var path = "${path}";
    </script>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>客户管理系统</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/htmleaf-demo.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/signin.css">
</head>
<body>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>客户管理系统</h1>
    </header>
    <div class="signin">
        <div class="signin-head"><img src="${path}/img/test/head_120.png" alt="" class="img-circle"></div>
        <form class="form-signin" role="form">
            <input type="text" class="form-control" placeholder="用户名" required autofocus />
            <input type="password" class="form-control" placeholder="密码" required />
            <button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
        </form>
    </div>
</div>

</body>
</html>