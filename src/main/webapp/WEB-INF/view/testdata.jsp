<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/3
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = path;
%>
<head>
    <title>测试数据页面</title>
<%--    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/default/easyui.css" />--%>
<%--    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css" />--%>
<%--    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css" />--%>
<%--    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>--%>
<%--    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>--%>
<%--    <script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js" ></script>--%>
<%--    <script type="text/javascript" src="<%=basePath%>/js/testdata.js"></script>--%>
</head>
<body>


<%--<table id="dg" class="easyui-datagrid" fit="true">--%>
<%--</table>--
action="/uploadzip"
--%>
<script type="text/javascript" src="<%=basePath%>/js/testdata.js"></script>
<iframe name="frame1"  height="40" style="display: none"></iframe>
<form id="upload" action="/uploadzip" method="post" enctype="multipart/form-data" target="frame1">
    <label>上传压缩包</label>
    <input id="in" type="file" name="file"/>
    <input type="submit" value="上传" onclick="uploadfile()"/>
</form>

<div id="tb" class="datagrid-toolbar">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <form id="search" class="form-horizontal" method="get" enctype="text/plain">
                    <div class="col-xs-3 form-group">
                        <label class="col-xs-4 control-label">姓名：</label>
                            <div>
                                <input type="text" class="form-control" id="data_name">
                            </div>

                    </div>
                    <div class="col-xs-3 form-group">
                        <label class="col-xs-4 control-label">手机号：</label>
                        <div>
                            <input type="text" class="form-control"  id="data_phone">
                        </div>

                    </div>
                    <div class="col-xs-3 form-group">
                        <label class="col-xs-4 control-label">身份证：</label>
                        <div>
                            <input type="text" class="form-control" id="data_idcard">
                        </div>

                    </div>

                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" id="btn_search">搜 索</a>
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px" id="btn_clear">重  置</a>

                </form>
            </div>

        </div>

    </div>
</div>



<table id="dg"></table>

</body>
</html>
