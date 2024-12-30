package com.feiniaojin.dddexample.cms.domain;


import java.util.Objects;

public class ArticleContent {

    private final String value;

    public ArticleContent(String value) {
        this.check(value);
        this.value = value;
    }

    private void check(String value) {
        Objects.requireNonNull(value, "正文内容不能为空");
        if (value.length() < 12) {
            throw new IllegalArgumentException("正文内容长度不得小于12");
        }
    }

    public String getValue() {
        return this.value;
    }
}
