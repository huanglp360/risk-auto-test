$(function () {


    $('#manager_add').dialog({
        width : 800,
        height: 300,
        title : '360授信放款请求',
        modal : true,
        closed : true,
        top:50,
        iconCls : 'icon-edit',
       // fit:true,
        //modal:true,
        onOpen:function(){
            if ($('#manager_add').form()){
                $.ajax({
                    url : getpreurl()+'/get360req',
                    type : 'get',
                    success : function (data, response, status) {
                         if (data) {
                            var json = eval('('+data+')');
                            json = JSON.parse(data);
                             $('input[name="loanReqNo"]').val(json.loanReqNo);
                             $('input[name="sourceCode"]').val(json.sourceCode);
                             $('input[name="custName"]').val(json.custName);
                             $('input[name="idType"]').val(json.idType);
                             $('input[name="id"]').val(json.id);
                             $('input[name="sex"]').val(json.sex);
                             $('input[name="dbBankCode"]').val(json.dbBankCode);
                             $('input[name="dbAcct"]').val(json.dbAcct);
                             $('input[name="dbAcctName"]').val(json.dbAcctName);
                             $('input[name="loanDate"]').val(json.loanDate);
                             $('input[name="loanAmt"]').val(json.loanAmt);
                             $('input[name="lnTerm"]').val(json.lnTerm);
                             $('input[name="creditAmt"]').val(json.creditAmt);
                             $('input[name="loanPurpose"]').val(json.loanPurpose);
                             $('input[name="pbocFlag"]').val(json.pbocFlag);
                             $('input[name="feeRate"]').val(json.feeRate);
                             $('input[name="mobileNo"]').val(json.mobileNo);
                             $('input[name="idAddress"]').val(json.idAddress);
                             $('input[name="agency"]').val(json.agency);
                             $('input[name="cardMobileNo"]').val(json.cardMobileNo);
                             $('input[name="creditCardSts"]').val(json.creditCardSts);
                             $('input[name="loanAcctSts"]').val(json.loanAcctSts);
                             $('input[name="creditCardOverdueDays"]').val(json.creditCardOverdueDays);
                             $('input[name="loanOverDays"]').val(json.loanOverDays);
                             $('input[name="thirdPartyBlackList"]').val(json.thirdPartyBlackList);
                             $('input[name="idVerifyRisk"]').val(json.idVerifyRisk);
                             $('input[name="idCert"]').val(json.idCert);
                             $('input[name="ageCheck"]').val(json.ageCheck);
                             $('input[name="policeInfoNotExist"]').val(json.policeInfoNotExist);
                             $('input[name="policeInfoNotMatch"]').val(json.policeInfoNotMatch);
                             $('input[name="overdueHisMaxDays"]').val(json.overdueHisMaxDays);
                             $('input[name="overdueHisMaxAmt"]').val(json.overdueHisMaxAmt);
                             $('input[name="idValidDateEnd"]').val(json.idValidDateEnd);
                             $('input[name="ascore"]').val(json.ascore);
                             $('input[name="bscore"]').val(json.bscore);
                             $('input[name="dateCredit"]').val(json.dateCredit);
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
                        url : getpreurl()+'/req360',
                        type : 'post',
                        data : {
                            loanReqNo : $('input[name="loanReqNo"]').val(),
                            sourceCode : $('input[name="sourceCode"]').val(),
                            custName : $('input[name="custName"]').val(),
                            idType : $('input[name="idType"]').val(),
                            id : $('input[name="id"]').val(),
                            sex : $('input[name="sex"]').val(),
                            dbBankCode : $('input[name="dbBankCode"]').val(),
                            dbAcct : $('input[name="dbAcct"]').val(),
                            dbAcctName : $('input[name="dbAcctName"]').val(),
                            loanDate : $('input[name="loanDate"]').val(),
                            loanAmt : $('input[name="loanAmt"]').val(),
                            lnTerm : $('input[name="lnTerm"]').val(),
                            creditAmt : $('input[name="creditAmt"]').val(),
                            loanPurpose : $('input[name="loanPurpose"]').val(),
                            pbocFlag : $('input[name="pbocFlag"]').val(),
                            feeRate : $('input[name="feeRate"]').val(),
                            mobileNo : $('input[name="mobileNo"]').val(),
                            idValidDateEnd : $('input[name="idValidDateEnd"]').val(),
                            idAddress : $('input[name="idAddress"]').val(),
                            agency : $('input[name="agency"]').val(),
                            cardMobileNo : $('input[name="cardMobileNo"]').val(),
                            creditCardSts : $('input[name="creditCardSts"]').val(),
                            loanAcctSts : $('input[name="loanAcctSts"]').val(),
                            creditCardOverdueDays : $('input[name="creditCardOverdueDays"]').val(),
                            loanOverDays : $('input[name="loanOverDays"]').val(),
                            thirdPartyBlackList : $('input[name="thirdPartyBlackList"]').val(),
                            idVerifyRisk : $('input[name="idVerifyRisk"]').val(),
                            idCert : $('input[name="idCert"]').val(),
                            ageCheck : $('input[name="ageCheck"]').val(),
                            policeInfoNotExist : $('input[name="policeInfoNotExist"]').val(),
                            policeInfoNotMatch : $('input[name="policeInfoNotMatch"]').val(),
                            overdueHisMaxDays : $('input[name="overdueHisMaxDays"]').val(),
                            overdueHisMaxAmt : $('input[name="overdueHisMaxAmt"]').val(),
                            ascore : $('input[name="ascore"]').val(),
                            bscore : $('input[name="bscore"]').val(),
                            dateCredit : $('input[name="dateCredit"]').val(),

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
                        url : getpreurl()+'/get360req',
                        type : 'get',
                        success : function (data, response, status) {
                            if (data) {
                                var json = eval('('+data+')');
                                json = JSON.parse(data);
                                $('input[name="loanReqNo"]').val(json.loanReqNo);
                                $('input[name="sourceCode"]').val(json.sourceCode);
                                $('input[name="custName"]').val(json.custName);
                                $('input[name="idType"]').val(json.idType);
                                $('input[name="id"]').val(json.id);
                                $('input[name="sex"]').val(json.sex);
                                $('input[name="dbBankCode"]').val(json.dbBankCode);
                                $('input[name="dbAcct"]').val(json.dbAcct);
                                $('input[name="dbAcctName"]').val(json.dbAcctName);
                                $('input[name="loanDate"]').val(json.loanDate);
                                $('input[name="loanAmt"]').val(json.loanAmt);
                                $('input[name="lnTerm"]').val(json.lnTerm);
                                $('input[name="creditAmt"]').val(json.creditAmt);
                                $('input[name="loanPurpose"]').val(json.loanPurpose);
                                $('input[name="pbocFlag"]').val(json.pbocFlag);
                                $('input[name="feeRate"]').val(json.feeRate);
                                $('input[name="mobileNo"]').val(json.mobileNo);
                                $('input[name="idAddress"]').val(json.idAddress);
                                $('input[name="agency"]').val(json.agency);
                                $('input[name="cardMobileNo"]').val(json.cardMobileNo);
                                $('input[name="creditCardSts"]').val(json.creditCardSts);
                                $('input[name="loanAcctSts"]').val(json.loanAcctSts);
                                $('input[name="creditCardOverdueDays"]').val(json.creditCardOverdueDays);
                                $('input[name="loanOverDays"]').val(json.loanOverDays);
                                $('input[name="thirdPartyBlackList"]').val(json.thirdPartyBlackList);
                                $('input[name="idVerifyRisk"]').val(json.idVerifyRisk);
                                $('input[name="idCert"]').val(json.idCert);
                                $('input[name="ageCheck"]').val(json.ageCheck);
                                $('input[name="policeInfoNotExist"]').val(json.policeInfoNotExist);
                                $('input[name="policeInfoNotMatch"]').val(json.policeInfoNotMatch);
                                $('input[name="overdueHisMaxDays"]').val(json.overdueHisMaxDays);
                                $('input[name="overdueHisMaxAmt"]').val(json.overdueHisMaxAmt);
                                $('input[name="idValidDateEnd"]').val(json.idValidDateEnd);
                                $('input[name="ascore"]').val(json.ascore);
                                $('input[name="bscore"]').val(json.bscore);
                                $('input[name="dateCredit"]').val(json.dateCredit);
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
function getElements(formId) {
    var form = document.getElementById(formId);
    var elements
    var tagElements = form.getElementsByTagName('input');
    for (var j = 0; j < tagElements.length; j++){
        elements=elements+tagElements[j].value

    }
    return elements;
}