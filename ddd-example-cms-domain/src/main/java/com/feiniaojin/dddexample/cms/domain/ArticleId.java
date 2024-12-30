package com.feiniaojin.dddexample.cms.domain;


public class ArticleId {

    private final String value;

    public ArticleId(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
