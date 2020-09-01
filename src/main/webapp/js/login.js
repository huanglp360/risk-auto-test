$(function () {
    var contexturl = window.location.href;
    console.log(contexturl);
    var num = contexturl.lastIndexOf("/");
    var prefix;
    if (num === -1) {
        prefix = contexturl;
    } else {
        prefix = contexturl.slice(0, num);
    }
    //登录界面
    $('#login').dialog({
        title : '登录风险自动化测试服务',
        width : 300,
        height : 180,
        modal : true,
        iconCls : 'icon-login',
        buttons : '#btn',
    });

    //管理员帐号验证
    $('#manager').validatebox({
        required : true,
        missingMessage : '请输入帐号',
        invalidMessage : '帐号不得为空',
    });

    //管理员密码验证
    $('#password').validatebox({
        required : true,
        validType : 'length[6,30]',
        missingMessage : '请输入密码',
        invalidMessage : '密码不得为空',
    });

    //加载时判断验证
    if (!$('#manager').validatebox('isValid')) {
        $('#manager').focus();
    } else if (!$('#password').validatebox('isValid')) {
        $('#password').focus();
    }


    //单击登录
    $('#btn a').click(function () {
        if (!$('#manager').validatebox('isValid')) {
            $('#manager').focus();
        } else if (!$('#password').validatebox('isValid')) {
            $('#password').focus();
        } else {
            $.ajax({
                url : prefix+'/check',
                type : 'post',
                data : {
                    username : $('#manager').val(),
                    password : $('#password').val(),
                },
                beforeSend : function () {
                    $.messager.progress({
                        text : '正在登录中...',
                    });
                },
                success : function (data, response, status) {
                    $.messager.progress('close');
                     console.log("后台返回的数据："+data["username"]);
                    // console.log("后台返回的数据："+data["password"]);
                    // console.log("后台返回的数据："+response);

                    if (data["username"]==='no'||response !== 'success') {
                        $.messager.alert('登录失败！', '用户名或密码错误！', 'warning', function () {
                            $('#password').select();
                        });

                    } else {
                        location.href = prefix+'/index';
                    }
                }
            });
        }
    });

});
