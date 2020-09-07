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
            {field:'updatetime',title:'修改时间',formatter:DateTimeFormatter},
            {field:'operation',title:'操作',formatter:operation}
        ]],
        singleSelect: true,// 如果为True，表示单选
        pagination:true,// 如果为True，分页显示
        fitColumns:true// 如果为True，表格宽度自适应，不会出现水平滚动条
    });
       // console.log("dddd");
    $('#btn_search').on('click',function () {
        searchdata();
    });
    $('#btn_clear').on('click',function () {
        cleardata();
    });
    // $('#btn_updatauser').on('click',function () {
    //     var datas = $('#dg').datagrid('getSelections');
    //     if(datas==null || datas.length!=1 || datas==undefined){
    //         $.messager.alert("Warning","请选中一条记录进行修改操作!");
    //         return;
    //     }
    //
    //     var datasIndex = $('#dg').datagrid('getRowIndex',datas[0]);
    //     saveuserinfo(datasIndex);
    // });
    $('#btn_updatauser').on('click',function () {
        saveuser();

    });

}


)

/**
 * @return {string}
 */

function operation(value,row, index){
    var operations = "<a class=\"btn btn-info\" id=\"btn_save\" style=\"color: black\" href=\"javascript:saveuserinfo('"+index+"')\">修改</a>&nbsp;&nbsp;&nbsp;";

    return operations;
}

function saveuserinfo(updatasIndex) {
    $('#win').window('open');
    //console.log(JSON.parse(updatasIndex));
    var rows = $("#dg").datagrid("getRows");
    var row = rows[updatasIndex];
    $('#user_id').val(row.id);
    $('#user_name').val(row.name);
    $('#user_sex').val(row.sex);
    $('#user_clan').val(row.clan);
    $('#user_addr').val(row.address);
    $('#user_idcard').val(row.id_No);
    $('#user_mobile').val(row.mobile);
    $('#user_bankcard').val(row.bankcard);
    $('#user_backpath').val(row.backpath);
    $('#user_frontpath').val(row.frontpath);
    $('#user_huotipath').val(row.huotipath);
    $('#user_idcardeffectivity').val(row.idcardeffectivity);
    $('#user_policedepartment').val(row.policedepartment);
    $('#user_isused').val(row.isused);
    $('#user_businessno').val(row.businessno);


}

function saveuser() {
    $.ajax({
        url:'updateuser',
        type:'POST',
        datatype:'text',
        data:{
            'id':$('#user_id').val(),
            'name':$('#user_name').val(),
        }
    })
}

function searchdata(){
    console.log('开始查询');
        var username = $('#data_name').val();
        var mobileno = $('#data_phone').val();
        var idcardno = $('#data_idcard').val();
        $('#dg').datagrid('load',{
            "name":$.trim(username),
            "id_No":$.trim(idcardno),
            "mobile":$.trim(mobileno)
        });

}

function cleardata() {
    $('#data_name').val('');
    $('#data_phone').val('');
    $('#data_idcard').val('')
}




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