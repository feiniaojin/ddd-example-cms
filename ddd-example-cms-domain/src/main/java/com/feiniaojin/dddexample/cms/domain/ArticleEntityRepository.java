package com.feiniaojin.dddexample.cms.domain;


public interface ArticleEntityRepository {

    ArticleEntity load(ArticleId articleId);

    void save(ArticleEntity entity);
}
