<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%
            String path = request.getContextPath();
            path = "/".equals(path)?"":path;
            response.sendRedirect(path + "/client/list");
        %>
    </head>
    <body>
    </body>
</html>
