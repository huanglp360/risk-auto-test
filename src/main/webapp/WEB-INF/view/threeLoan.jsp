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
    <title>360jieqian</title>
<%--    <link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">--%>
</head>
<body>

<script type="text/javascript" src="<%=basePath%>/js/threeLoan.js"></script>
<%--<link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">--%>
<div id="manager_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false" onclick="manager_tool.add()">360授信放款请求</a>
<%--        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">修改</a>--%>
    </div>
</div>

<form id="manager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
    <div style="padding: 0;margin: 0;display: inline-block;width:300px;font-size: 10px">
    <p>放款请求流水号：<input type="text" id="loanReqNo" name="loanReqNo" class="textbox" style="width:100px;"></p>
    <p>请求方代码：<input type="text" id="sourceCode" name="sourceCode" class="textbox" style="width:100px;"></p>
    <p>客户名称：<input class="text" id="custName" name="custName" style="width:100px;"></p>
    <p>证件类型：<input class="text" id="idType" name="idType" style="width:100px;"></p>
    <p>证件号码：<input class="text" id="id" name="id" style="width:180px;"></p>
    <p>性别：<input class="text" id="sex" name="sex" style="width:100px;"></p>
    <p>放款银行代码：<input class="text" id="dbBankCode" name="dbBankCode" style="width:100px;"></p>
    <p>放款卡号：<input class="text" id="dbAcct" name="dbAcct" style="width:180px;"></p>
    <p>放款银行卡账户名：<input class="text" id="dbAcctName" name="dbAcctName" style="width:100px;"></p>
    <p>放款申请时间：<input class="text" id="loanDate" name="loanDate" style="width:150px;"></p>
    <p>放款金额：<input class="text" id="loanAmt" name="loanAmt" style="width:100px;"></p>
    <p>期数：<input class="text" id="lnTerm" name="lnTerm" style="width:100px;"></p>
    <p>贷款用途：<input class="text" id="loanPurpose" name="loanPurpose" style="width:100px;"></p>
    <p>解耦客户标识：<input class="text" id="pbocFlag" name="pbocFlag" style="width:100px;"></p>
    <p>费率：<input class="text" id="feeRate" name="feeRate" style="width:100px;"></p>
    <p>注册手机号：<input class="text" id="mobileNo" name="mobileNo" style="width:100px;"></p>
    <p>身份证有效期：<input class="text" id="idValidDateEnd" name="idValidDateEnd" style="width:100px;"></p>
    <p>身份证地址：<input class="text" id="idAddress" name="idAddress" style="width:200px;"></p>
    </div>
    <div style="padding: 0;margin: 0;display: inline-block;font-size: 10px;">
    <p>身份证签发机关：<input class="text" id="agency" name="agency" style="width:100px;"></p>
    <p>银行卡绑定手机号：<input class="text" id="cardMobileNo" name="cardMobileNo" style="width:100px;"></p>
    <p>是否呆帐、核销：<input class="text" id="creditCardSts" name="creditCardSts" style="width:100px;"></p>
    <p>是否贷款账户状态为呆帐、核销：<input class="text" id="loanAcctSts" name="loanAcctSts" style="width:100px;"></p>
    <p>信用卡180天以上的逾期：<input class="text" id="creditCardOverdueDays" name="creditCardOverdueDays" style="width:100px;"></p>
    <p>贷款在180天以上的逾期：<input class="text" id="loanOverDays" name="loanOverDays" style="width:100px;"></p>
    <p>是否命中同盾汇法黑名单：<input class="text" id="thirdPartyBlackList" name="thirdPartyBlackList" style="width:100px;"></p>
    <p>核身风险等级：<input class="text" id="idVerifyRisk" name="idVerifyRisk" style="width:100px;"></p>
    <p>是否有身份证或身份证明：<input class="text" id="idCert" name="idCert" style="width:100px;"></p>
    <p>满足年龄18至55岁：<input class="text" id="ageCheck" name="ageCheck" style="width:100px;"></p>
    <p>授信额度：<input class="text" id="creditAmt" name="creditAmt" style="width:100px;"></p>
    <p>公安信息不存在：<input class="text" id="policeInfoNotExist" name="policeInfoNotExist" style="width:100px;"></p>
    <p>公安信息不匹配：<input class="text" id="policeInfoNotMatch" name="policeInfoNotMatch" style="width:100px;"></p>
    <p>360平台上历史最大逾期天数：<input class="text" id="overdueHisMaxDays" name="overdueHisMaxDays" style="width:100px;"></p>
    <p>360平台上历史最大逾期金额：<input class="text" id="overdueHisMaxAmt" name="overdueHisMaxAmt" style="width:100px;"></p>
    <p>A卡分：<input class="text" id="ascore" name="ascore" style="width:100px;"></p>
    <p>B卡分：<input class="text" id="bscore" name="bscore" style="width:100px;"></p>
    <p>360平台授信时间：<input class="text" id="dateCredit" name="dateCredit" style="width:100px;"></p>
    </div>

</form>
<%--<div style="padding: 0;margin: 0;height: 298px;width: 6100px;display: inline-block;font-size: 14px;color:#333">--%>
<%--    <form>--%>

<%--        <label>放款请求流水号:</label><input type="text"  >--%>
<%--        <label>请求方代码:</label><input type="text" >--%>
<%--        <label>客户名称:</label><input type="text" >--%>
<%--        <label>证件类型:</label><input type="text" >--%>
<%--        <label>证件号码:</label><input type="text" >--%>
<%--        <label>性别:</label><input type="text" >--%>
<%--        <label>放款银行代码:</label><input type="text" >--%>
<%--        <label>放款卡号:</label><input type="text" >--%>
<%--        <label>放款银行卡账户名:</label><input type="text" >--%>
<%--        <label>放款申请时间:</label><input type="text" >--%>
<%--        <label>放款金额:</label><input type="text" >--%>
<%--        <label>期数:</label><input type="text" >--%>
<%--        <label>授信额度:</label><input type="text" >--%>
<%--        <label>贷款用途:</label><input type="text" >--%>
<%--        <label>解耦客户标识:</label><input type="text" >--%>
<%--        <label>费率:</label><input type="text" >--%>
<%--        <label>注册手机号:</label><input type="text" >--%>
<%--        <label>身份证有效期:</label><input type="text" >--%>
<%--        <label>身份证地址:</label><input type="text" >--%>
<%--        <label>身份证签发机关:</label><input type="text" >--%>
<%--        <label>银行卡绑定手机号:</label><input type="text" >--%>
<%--        <label>是否客户名下任一张信用卡状态为呆帐:</label><input type="text" >--%>
<%--        <label>是否贷款账户状态为呆帐:</label><input type="text" >--%>
<%--        <label>是否客户名下任一张信用卡在过去2年内有超过120天、150天、180天以上的逾期:</label><input type="text" >--%>
<%--        <label>是否客户有过贷款在过去2年内有超过120天、150天、180天以上的逾期:</label><input type="text" >--%>
<%--        <label>否命中同盾、百融、前海、汇法黑名单:</label><input type="text" >--%>
<%--        <label>核身风险等级:</label><input type="text" >--%>
<%--        <label>是否有身份证或身份证明:</label><input type="text" >--%>
<%--        <label>满足年龄18至55岁:</label><input type="text" >--%>
<%--        <label>公安信息不存在:</label><input type="text" >--%>
<%--        <label>公安信息不匹配:</label><input type="text" >--%>
<%--        <label>360平台上历史最大逾期天数:</label><input type="text" >--%>
<%--        <label>360平台上历史最大逾期金额:</label><input type="text" >--%>
<%--        <label>A卡分:</label><input type="text" >--%>
<%--        <label>B卡分:</label><input type="text" >--%>
<%--        <label>360平台授信时间:</label><input type="text" >--%>
<%--        <input type="submit" value="提交" >--%>

<%--    </form>--%>
<%--</div>--%>
<%--<div style="padding: 0;margin: 0;height: 298px;width: 6100px;display: inline-block;font-size: 14px;color:#333">--%>
<%--aa--%>
<%--</div>--%>

    




</body>
</html>
