package com.bytest.autotest.model;


import lombok.ToString;

@ToString
public class CommPO {
    private String encodg;
    private String invktm;
    private String txncd;
    private String ordrno;
    private String chanltp;
    private String chanlno;
    private String encrmd;
    private String signtp;
    private String signtx;
    private String version;
    private String needret;

    public String getEncodg() {
        return encodg;
    }

    public void setEncodg(String encodg) {
        this.encodg = encodg;
    }

    public String getInvktm() {
        return invktm;
    }

    public void setInvktm(String invktm) {
        this.invktm = invktm;
    }

    public String getTxncd() {
        return txncd;
    }

    public void setTxncd(String txncd) {
        this.txncd = txncd;
    }

    public String getOrdrno() {
        return ordrno;
    }

    public void setOrdrno(String ordrno) {
        this.ordrno = ordrno;
    }

    public String getChanltp() {
        return chanltp;
    }

    public void setChanltp(String chanltp) {
        this.chanltp = chanltp;
    }

    public String getChanlno() {
        return chanlno;
    }

    public void setChanlno(String chanlno) {
        this.chanlno = chanlno;
    }

    public String getEncrmd() {
        return encrmd;
    }

    public void setEncrmd(String encrmd) {
        this.encrmd = encrmd;
    }

    public String getSigntp() {
        return signtp;
    }

    public void setSigntp(String signtp) {
        this.signtp = signtp;
    }

    public String getSigntx() {
        return signtx;
    }

    public void setSigntx(String signtx) {
        this.signtx = signtx;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNeedret() {
        return needret;
    }

    public void setNeedret(String needret) {
        this.needret = needret;
    }
}
