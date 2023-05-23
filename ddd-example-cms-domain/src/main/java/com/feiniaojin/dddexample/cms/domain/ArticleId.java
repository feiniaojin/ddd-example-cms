package com.feiniaojin.dddexample.cms.domain;

import com.feiniaojin.ddd.EntityId;

public class ArticleId implements EntityId<String> {

    private final String value;

    public ArticleId(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
