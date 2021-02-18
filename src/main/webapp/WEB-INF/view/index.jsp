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
    <title>风险自动化测试系统</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css" />
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js" ></script>
    <script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
<%--    <script type="text/javascript" src="<%=basePath%>/js/testdata.js"></script>--%>

</head>
<body class="easyui-layout">

<div data-options="region:'north',title:'header',split:true,noheader:true" style="height:60px;background:#666;">
    <div class="logo">风险自动化测试系统</div>
    <div class="logout">您好，hh | <a href="#" onclick="window.location.href=exit()">退出</a></div>
</div>
<div data-options="region:'south',title:'footer',split:false,noheader:true" style="height:35px;line-height:30px;text-align:center;">
    &copy;2020-05 hh出品. Powered by Springboot and EasyUI+JSP.
</div>
<div data-options="region:'west',title:'导航',split:true,iconCls:'icon-world'" style="width:180px;padding:10px;">
    <ul id="navt"></ul>
</div>
<div data-options="region:'center'" style="overflow:hidden">
    <div id="tabss">
        <div title="起始页" iconCls="icon-house" style="padding:0 10px;display:block;">
            欢迎来到风险自动化测试系统！
        </div>
    </div>
</div>



</body>
<%--<script type="text/javascript" src="<%=basePath%>/js/testdata.js"></script>--%>
</html>
