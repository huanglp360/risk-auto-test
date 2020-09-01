package com.bytest.autotest.enums;

/***
 * Hbase表 枚举
 *
 */
public enum HbaseTableEnum {

	DCP_REQ_INFO("dcp_req_info", "req", "", "", 1, "保存dcp变量加工请求入参"), //
	DCP_RES_INFO("dcp_req_info", "res", "", "", 1, "保存dcp变量加工结果"), //
	RISK_PARAM_PRD_HIS_MAXOVDCNT("risk_param_cust", "info", "", "prdHistMaxOvdDCnt", 1, "账户历史最大逾期天数"), //
	RISK_PARAM_CUST_HMOD("risk_param_cust", "info", "", "histMaxOvdDCnt", 1, "客户历史最大逾期天数"), //
	RISK_PARAM_PRD_CURR_MAXOVDCNT("risk_param_cust", "info", "", "prdCurrMaxOvdDCnt", 1, "账户当前最大逾期天数"), //


    RISK_PARAM_IDCARD_AGGR_CRED_ZY("risk_param_idcard_aggr", "statistics", "00", "credApplBirPlacIdNo", 1, "同一身份证出生地授信申请数[自营]"),
    RISK_PARAM_IDCARD_AGGR_CRED_QD("risk_param_idcard_aggr", "statistics", "11", "credApplBirPlacIdNo", 1, "同一身份证出生地授信申请数[渠道]"),

    RISK_PARAM_BRE_DECISION("risk_param_bre_decision", "info", "", "", 1, "bre拒绝天数控制"),

    ;

	private String table;
	private String family;
	private String preRowKey;
	private String preColumn;
	private int version;
	private String desc;

	HbaseTableEnum(String table, String family, String preRowKey, String preColumn, int version, String desc) {
		this.table = table;
		this.family = family;
		this.preRowKey = preRowKey;
		this.desc = desc;
		this.preColumn = preColumn;
		this.version = version;
	}

	public String getTable() {
		return table;
	}

	public String getFamily() {
		return family;
	}

	public String getPreRowKey() {
		return preRowKey;
	}

	public String getDesc() {
		return desc;
	}

	public String getPreColumn() {
		return preColumn;
	}

	public int getVersion() {
		return version;
	}

	public static HbaseTableEnum judgeValue(String code) {
		HbaseTableEnum type = null;
		for (HbaseTableEnum t : HbaseTableEnum.values()) {
			if (t.getTable().equals(code)) {
				type = t;
				break;
			}
		}
		return type;
	}
}
