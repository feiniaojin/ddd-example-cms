package com.feiniaojin.dddexample.cms.domain;


import java.util.Objects;

public class ArticleTitle {

    private final String value;


    public ArticleTitle(String value) {
        this.check(value);
        this.value = value;
    }

    private void check(String value) {
        Objects.requireNonNull(value, "标题不能为空");
        if (value.length() > 64) {
            throw new IllegalArgumentException("标题过长");
        }
    }

    public String getValue() {
        return this.value;
    }
}
