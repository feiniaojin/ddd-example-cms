package com.feiniaojin.dddexample.cms.factory;

import com.feiniaojin.dddexample.cms.domain.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ArticleDomainFactoryImpl implements ArticleFactory {

    @Override
    public ArticleEntity newInstance(ArticleTitle title, ArticleContent content) {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(title);
        entity.setContent(content);
        entity.setArticleId(new ArticleId(UUID.randomUUID().toString()));
        entity.setPublishState(PublishState.TO_PUBLISH.getCode());
        entity.setDeleted(0);
        Date date = new Date();
        entity.setCreatedTime(date);
        entity.setModifiedTime(date);
        return entity;
    }
}
