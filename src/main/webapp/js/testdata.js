$(function () {
    $('#dg').datagrid({
        //width:1354,
        url:getpreurl()+'/'+'list',
        //toolbar: '#tb',
        rownumbers: true,
        iconCls:'icon-search',
        title:'测试数据列表',
        //idField: 'requestId',
       // queryParams:formatParam(),
        columns:[[
            {field:'id',title:'编号'},
            {field:'name',title:'姓名'},
            {field:'sex',title:'性别'},
            {field:'clan',title:'民族'},
            {field:'birth',title:'出生日期'},
            {field:'address',title:'地址'},
            {field:'id_No',title:'身份证号码'},
            {field:'mobile',title:'手机号'},
            {field:'bankcard',title:'银行卡号'},
            {field:'frontpath',title:'正面图片地址'},
            {field:'backpath',title:'背面地址'},
            {field:'huotipath',title:'活体地址'},
            {field:'idcardeffectivity',title:'身份证有效期'},
            {field:'policedepartment',title:'发证机关'},
            // {field:'busnum',title:'案件号',width:100},
            {field:'isused',title:'是否使用',formatter:statusFormat},
            {field:'businessno',title:'业务流水号'},
            {field:'createdatetime',title:'创建时间',formatter:DateTimeFormatter},
            {field:'updatetime',title:'修改时间',formatter:DateTimeFormatter}
        ]],
        singleSelect: true,// 如果为True，表示单选
        pagination:true,// 如果为True，分页显示
        fitColumns:true// 如果为True，表格宽度自适应，不会出现水平滚动条
    });


});

/**
 * @return {string}
 */
function DateTimeFormatter(value) {
    if (value == null || value === '') {
        return '';
    }
    var dt;
    if (value instanceof Date) {
        dt = value;
    } else {
        dt = new Date(value);
    }

    return dt.format("yyyy-MM-dd hh:mm:ss");
}

function statusFormat(value, row, index){
    if (row.isused === "0"){
        return "未启用";
    }else{
        return "已使用";
    }
}


Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))format = format.replace(RegExp.$1,RegExp.$1.length === 1 ? o[k] :("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

function uploadfile() {
    $('#upload').form({
        // url:getpreurl()+"/uploadzip",
        success:function(data){

            alert('上传成功');
            document.getElementById('in').value='';
        }
    });
    //document.getElementById("in").value = "";
   // document.getElementById('in')&&document.getElementById('in').reset();

}

function getpreurl() {
    var contexturl = window.location.href;
    console.log(contexturl);
    var num = contexturl.lastIndexOf("/");
    var prefix;
    if (num === -1) {
        prefix = contexturl;
    } else {
        prefix = contexturl.slice(0, num);
    }
    return prefix;
}

/**
 * @return {string}
 */
// function DateTimeFormatter(value) {
//     if (value == null || value === '') {
//         return '';
//     }
//     var dt;
//     if (value instanceof Date) {
//         dt = value;
//     } else {
//         dt = new Date(value);
//     }
//
//     return dt.format("yyyy-MM-dd hh:mm:ss");
// }