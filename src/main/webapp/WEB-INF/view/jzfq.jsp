<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/3
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<%
    String path = request.getContextPath();
    String basePath = path;
%>
<head>
    <title>juzifenqi</title>
    <%--    <link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">--%>
</head>
<body>

<script type="text/javascript" src="<%=basePath%>/js/jzfq.js"></script>
<%--<link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">--%>
<div id="manager_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false" onclick="manager_tool.add();">橘子分期授信</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false" onclick="manager_tool.add();">橘子分期放款</a>
        <%--        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">修改</a>--%>
    </div>
</div>

<form id="manager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
    <div style="padding: 0;margin: 0;display: inline-block;width:600px;font-size: 10px">
        <input type="text">

    </div>

</form>




</body>
</html>
