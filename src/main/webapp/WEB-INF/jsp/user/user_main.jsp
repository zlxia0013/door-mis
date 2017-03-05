<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%
        String path = request.getContextPath();
        path = "/".equals(path)?"":path;
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
                    <li><a href="${path}/client/goto_main_page">客户管理</a></li>
                    <li class="active"><a href="${path}/user/goto_main_page">用户管理</a></li>

                    <li class="nav-header"><i class="icon-user"></i> Profile</li>
                    <li><a href="my-profile.html">修改密码</a></li>
                    <li><a href="#">退出</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <div class="row-fluid">
                <div class="page-header">
                    <h1>用户管理</h1>
                </div>
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>E-mail</th>
                        <th>Phone</th>
                        <th>City</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="list-users">
                        <td>1</td>
                        <td>Admin</td>
                        <td>travis@provider.com</td>
                        <td>xxx-xxx-xxxx</td>
                        <td>My City</td>
                        <td>Admin</td>
                        <td><span class="label label-success">Active</span></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">Actions <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                    <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                                    <li><a href="#"><i class="icon-user"></i> Details</a></li>
                                    <li class="nav-header">Permissions</li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>Admin</strong></a></li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>Moderator</strong></a></li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>User</strong></a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr class="list-users">
                        <td>2</td>
                        <td>Jose E. Jones</td>
                        <td>joseejones@provider.com</td>
                        <td>801-xxx-xxxx</td>
                        <td>Morgan, UT</td>
                        <td>Moderator</td>
                        <td><span class="label label-success">Active</span></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">Actions <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                    <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                                    <li><a href="#"><i class="icon-user"></i> Details</a></li>
                                    <li class="nav-header">Permissions</li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>Admin</strong></a></li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>Moderator</strong></a></li>
                                    <li><a href="#"><i class="icon-lock"></i> Make <strong>User</strong></a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="pagination">
                    <ul>
                        <li><a href="#">Prev</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </div>
                <a href="${path}/user/goto_add_page" class="btn btn-success">新增</a>
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
<script>
    $(document).ready(function() {
        $('.dropdown-menu li a').hover(
            function() {
                $(this).children('i').addClass('icon-white');
            },
            function() {
                $(this).children('i').removeClass('icon-white');
            });

        if($(window).width() > 760)
        {
            $('tr.list-users td div ul').addClass('pull-right');
        }
    });
</script>
</body>
</html>
