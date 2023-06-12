package com.feiniaojin.dddexample.cms.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArticleEntityTest {


    @Test
    @DisplayName("创建草稿")
    public void testCreateDraft() {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(new ArticleTitle("title"));
        entity.setContent(new ArticleContent("content12345677890"));
        entity.createDraft();
        Assertions.assertEquals(PublishState.TO_PUBLISH.getCode(), entity.getPublishState());
    }

    @Test
    @DisplayName("修改标题")
    public void testModifyTitle() {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(new ArticleTitle("title"));
        entity.setContent(new ArticleContent("content12345677890"));
        ArticleTitle articleTitle = new ArticleTitle("new-title");
        entity.modifyTitle(articleTitle);
        Assertions.assertEquals(articleTitle.getValue(), entity.getTitle().getValue());
    }

    @Test
    @DisplayName("修改正文")
    public void testModifyContent() {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(new ArticleTitle("title"));
        entity.setContent(new ArticleContent("content12345677890"));
        ArticleContent articleContent = new ArticleContent("new-content12345677890");
        entity.modifyContent(articleContent);
        Assertions.assertEquals(articleContent.getValue(), entity.getContent().getValue());
    }

    @Test
    @DisplayName("发布")
    public void testPublishArticle() {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(new ArticleTitle("title"));
        entity.setContent(new ArticleContent("content12345677890"));
        entity.publishArticle();
        Assertions.assertEquals(PublishState.PUBLISHED.getCode(), entity.getPublishState());
    }
}
