$(function () {

    $('#navt').tree({
        url : getpreurl()+'/nav',
        lines : true,

        onClick : function (node) {


            if (node.url) {

                if ($('#tabss').tabs('exists', node.text)) {
                    $('#tabss').tabs('select', node.text);

                } else {
                    $('#tabss').tabs('add', {
                        title : node.text,
                        iconCls : node.iconCls,
                        closable : true,
                        href : getpreurl()+'/'+node.url
                    });

                    if(node.text=="testdata"){
                        $('#dg').datagrid({
                            url:getpreurl()+'list',
                            //toolbar: '#tb',
                            rownumbers: true,
                            iconCls:'icon-search',
                            title:'测试数据列表',
                            //idField: 'requestId',
                            // queryParams:formatParam(),
                            columns:[[
                                {field:'id',title:'编号',width:5},
                                {field:'name',title:'姓名',width:20},
                                {field:'sex',title:'性别',width:20},
                                {field:'clan',title:'民族',width:5},
                                {field:'birth',title:'出生日期'},
                                {field:'address',title:'地址',width:100},
                                {field:'id_no',title:'身份证号码',width:100},
                                {field:'mobile',title:'手机号',width:100},
                                {field:'bankcard',title:'银行卡号',width:50},
                                {field:'frontpath',title:'图片地址',width:100},
                                {field:'backpath',title:'背面地址',width:100},
                                {field:'idcardeffectivity',title:'身份证有效期'},
                                {field:'policedepartment',title:'发证机关',width:100},
                                // {field:'busnum',title:'案件号',width:100},
                                {field:'isused',title:'是否使用',width:100},
                                {field:'createdatetime',title:'创建时间',width:100}
                            ]],
                            singleSelect: true,// 如果为True，表示单选
                            pagination:true,// 如果为True，分页显示
                            fitColumns:true// 如果为True，表格宽度自适应，不会出现水平滚动条
                        });

                    }
                }
            }

        }


    });

    $('#tabss').tabs({
        fit : true,
        border : false
    });





    });


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


function getpreurl() {
    var contexturl = window.location.href;
    //console.log(contexturl);
    var num = contexturl.lastIndexOf("/");
    var prefix;
    if (num === -1) {
        prefix = contexturl;
    } else {
        prefix = contexturl.slice(0, num);
    }
    return prefix;
}


function exit() {
    //setCookie(name, "", -1);
    console.log("获取链接地址:"+getpreurl()+"/login");
    return getpreurl()+"/login";
}



//
// // 设置cookie
// function setCookie(c_name, value, expiredays) {
//     var exdate = new Date();
//     exdate.setDate(exdate.getDate() + expiredays);
//     document.cookie = c_name + "=" + escape(value) + ";expires=" + exdate.toGMTString() + ";path=/";
// }
//
// // 检查cookie
// function checkCookie(c_name) {
//     username = getCookie(c_name);
//     console.log(username);
//     if (username !== null && username !== ""){
//         return true;
//     }else{
//         return false;
//     }
// }
//
// // 读取cookie
// function getCookie(c_name) {
//     if (document.cookie.length > 0)     {
//         c_start = document.cookie.indexOf(c_name + "=");
//         if (c_start !== -1){
//             c_start = c_start + c_name.length + 1;
//             c_end = document.cookie.indexOf(";", c_start);
//             if (c_end === -1)
//                 c_end = document.cookie.length;
//             return unescape(document.cookie.substring(c_start, c_end))
//         }
//     }
//     return ""
// }