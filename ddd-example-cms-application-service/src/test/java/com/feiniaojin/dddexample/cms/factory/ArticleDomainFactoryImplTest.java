package com.feiniaojin.dddexample.cms.factory;

import com.feiniaojin.dddexample.cms.domain.ArticleContent;
import com.feiniaojin.dddexample.cms.domain.ArticleEntity;
import com.feiniaojin.dddexample.cms.domain.ArticleFactory;
import com.feiniaojin.dddexample.cms.domain.ArticleTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = {ArticleDomainFactoryImpl.class})
@ExtendWith(SpringExtension.class)
public class ArticleDomainFactoryImplTest {

    @Resource
    private ArticleFactory articleFactory;

    @Test
    @DisplayName("Factory创建新实体")
    public void testNewInstance() {

        ArticleTitle articleTitle = new ArticleTitle("title");
        ArticleContent articleContent = new ArticleContent("content1234567890");

        ArticleEntity instance = articleFactory.newInstance(articleTitle, articleContent);

        Assertions.assertNotNull(instance);
        Assertions.assertNotNull(instance.getArticleId());
    }
}
