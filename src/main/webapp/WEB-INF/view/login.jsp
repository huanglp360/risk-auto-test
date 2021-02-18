<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/1
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = path;
%>
<head>
    <title>风险自动化测试平台-登陆</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css" />

</head>
<body>
    <div id="login">
        <p>帐号：<input type="text" id="manager" class="textbox"></p>
        <p>密码：<input type="password" id="password" class="textbox"></p>
    </div>

    <div id="btn">
        <a href="#" class="easyui-linkbutton">登录</a>
    </div>


<script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/login.js"></script>

</body>
</html>
