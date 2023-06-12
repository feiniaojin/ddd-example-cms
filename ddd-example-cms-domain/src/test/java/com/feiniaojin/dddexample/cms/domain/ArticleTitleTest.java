package com.feiniaojin.dddexample.cms.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArticleTitleTest {

    @Test
    @DisplayName("反例：测试业务规则，ArticleTitle为空抛异常")
    public void whenGivenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new ArticleTitle(null);
        });
    }

    @Test
    @DisplayName("反例：测试业务规则，ArticleTitle值长度大于64抛异常")
    public void whenGivenLengthGreaterThan64() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ArticleTitle("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        });
    }

    @Test
    @DisplayName("正例：测试业务规则，ArticleTitle等于64")
    public void whenGivenLengthEquals64() {
        ArticleTitle articleTitle = new ArticleTitle("1111111111111111111111111111111111111111111111111111111111111111");
        Assertions.assertEquals(64, articleTitle.getValue().length());
    }
}
