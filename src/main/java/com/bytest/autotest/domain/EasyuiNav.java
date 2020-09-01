package com.bytest.autotest.domain;

import lombok.Data;

import java.util.List;


public class EasyuiNav {

    private Integer id;


    private String text;


    private String iconcls;

    private String state;


    private String url;


    private Integer nid;

    private List<EasyuiNav> children;

    public EasyuiNav(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public List<EasyuiNav> getChildren() {
        return children;
    }

    public void setChildren(List<EasyuiNav> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "EasyuiNav{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", nid=" + nid +
                ", children=" + children +
                '}';
    }
}