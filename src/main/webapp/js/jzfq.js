$(function () {


    $('#manager_add').dialog({
        width : 800,
        height: 300,
        title : '橘子分期授信',
        modal : true,
        closed : true,
        top:50,
        iconCls : 'icon-edit',
        // fit:true,
        //modal:true,
        onOpen:function(){
            if ($('#manager_add').form()){
                $.ajax({
                    url : getpreurl()+'/getjuzireq',
                    type : 'get',
                    success : function (data, response, status) {
                        if (data) {
                           // var json = eval('('+data+')');
                            //json = JSON.parse(data);
                           // var compo = json.comm;

                            $('input[name="data_area"]').val(data);

                        } else {
                            $.messager.alert('请求失败！', '未知错误导致失败，请重试！', 'warning');
                        }
                    }
                })
            }
        },


        buttons : [{
            text : '提交',
            iconCls : 'icon-edit',
            handler : function () {
                if ($('#manager_add').form()) {
                    $.ajax({
                        url : getpreurl()+'/reqJcredit',
                        type : 'post',
                        data : {
                            requestdata : $('input[name="data_area"]').val()

                        },
                        beforeSend : function () {
                            $.messager.progress({
                                text : '正在处理中...',
                            });
                        },
                        success : function (data, response, status) {
                            // alert(data.loanReqDesc+'|'+data.loanReqStatus);
                            $.messager.progress('close');
                            //var json = eval('('+data+')');
                            //console.log(typeof data);
                            //var json = JSON.parse(data);
                            if (data) {
                                alert(data);
                                $.messager.show({
                                    title : '提示',
                                    msg : '请求返回数据==>'+data

                                });
                                // $('#manager_add').dialog('close').form('reset');
                                //$('#manager').datagrid('reload');
                            } else {
                                alert(data);
                                $.messager.alert('请求失败！', '未知错误导致失败，请重试！>>', 'warning');
                            }



                        },
                        error : function () {
                            $.messager.progress('close');
                            $.messager.alert('请求失败！', '未知错误导致失败，请重试！>>', 'warning');
                        }
                    });
                }
            },
        },{
            text : '取消',
            iconCls : 'icon-redo',
            handler : function () {
                $('#manager_add').dialog('close').form('reset');
            },
        },
            {
                text:'数据更新',
                iconCls:'icon-back',
                handler:function () {
                    $.ajax({
                        url : getpreurl()+'/getjuzireq',
                        type : 'get',
                        success : function (data, response, status) {
                            if (data) {
                                $('input[name="data_area"]').val(data);
                            } else {
                                $.messager.alert('请求失败！', '未知错误导致失败，请重试！', 'warning');
                            }
                        }
                    })
                }

            }


        ],
    });
    // $('#manager_add').window('hcenter');



    manager_tool = {
        add : function () {
            $('#manager_add').dialog('open');
            $('input[name="manager"]').focus();
        },
    };
})

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