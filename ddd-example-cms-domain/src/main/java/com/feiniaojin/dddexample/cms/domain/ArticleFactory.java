package com.feiniaojin.dddexample.cms.domain;

public interface ArticleFactory {
    ArticleEntity newInstance(ArticleTitle title, ArticleContent content);
}
