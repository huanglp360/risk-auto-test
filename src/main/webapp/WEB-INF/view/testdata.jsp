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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js" ></script>
<%--    <script src="<%=basePath%>/js/testdata.js"></script>--%>
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
                <form id="search" class="form-horizontal" >
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
                    <div class="col-xs-3">
                        <div class="col-xs-12">
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" id="btn_search">搜 索</a>
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px" id="btn_clear">重  置</a>
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>



<table id="dg"></table>

<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',closed:true,title:'修改',modal:true">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center'">
            <div class="form-group">
                <label class="col-xs-2 control-label">id</label>
                <div class="col-xs-4">
                    <input class="form-control" type="text" name="add_varCode" id="user_id" maxlength="50" required="required">
                </div>
                 <label class="col-xs-2 control-label">姓名</label>
                     <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_name" maxlength="50" required="required">
                    </div>
            </div>

            <div class="form-group">
                <label class="col-xs-2 control-label">性别</label>
                <div class="col-xs-4">
                    <input class="form-control" type="text" name="add_varCode" id="user_sex" maxlength="50" required="required">
                </div>
                <label class="col-xs-2 control-label">民族</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_clan" maxlength="50" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-2 control-label">地址</label>
                <div class="col-xs-4">
                    <input class="form-control" type="text" name="add_varCode" id="user_addr" maxlength="50" required="required">
                </div>
                <label class="col-xs-2 control-label">身份证</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_idcard" maxlength="50" required="required">
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-2 control-label">手机</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_mobile" maxlength="50" required="required">
                </div>
                <label class="col-xs-2 control-label">银行卡</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_bankcard" maxlength="50" required="required">
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-2 control-label">反面地址</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_backpath" maxlength="50" required="required">
                </div>
                <label class="col-xs-2 control-label">正面地址</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_frontpath" maxlength="50" required="required">
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-2 control-label">活体地址</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_huotipath" maxlength="50" required="required">
                </div>
                <label class="col-xs-2 control-label">身份证有效期</label>
                <div class="col-xs-4">
                    <input class="form-control " type="text" name="add_varCode" id="user_idcardeffectivity" maxlength="50" required="required">
                </div>
            </div>

            <div class="form-group">
            <label class="col-xs-2 control-label">签发机关</label>
            <div class="col-xs-4">
                <input class="form-control" type="text" name="add_varCode" id="user_policedepartment" maxlength="50" required="required">
            </div>
            <label class="col-xs-2 control-label">是否已使用</label>
            <div class="col-xs-4">
                <input class="form-control" type="text" name="add_varCode" id="user_isused" maxlength="50" required="required">
            </div>
        </div>

            <div class="form-group">
                <label class="col-xs-2 control-label">业务流水号</label>
                <div class="col-xs-4">
                    <input class="form-control" type="text" name="add_varCode" id="user_businessno" maxlength="50" required="required">
                </div>
<%--                <label class="col-xs-2 control-label">修改？</label>--%>
                <div class="col-xs-4">
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" id="btn_updatauser">保  存</a>
                </div>
            </div>


        </div>
    </div>
</div>

</body>
</html>
