package com.feiniaojin.dddexample.cms.domain;

import com.feiniaojin.ddd.AbstractDomainMask;
import lombok.Data;

@Data
public class ArticleEntity extends AbstractDomainMask {

    /**
     * article业务主键
     */
    private ArticleId articleId;

    /**
     * 标题
     */
    private ArticleTitle title;

    /**
     * 内容
     */
    private ArticleContent content;

    /**
     * 发布状态，[0-待发布；1-已发布]
     */
    private Integer publishState;

    /**
     * 创建草稿
     */
    public void createDraft() {
        this.publishState = PublishState.TO_PUBLISH.getCode();
    }

    /**
     * 修改标题
     *
     * @param articleTitle
     */
    public void modifyTitle(ArticleTitle articleTitle) {
        this.title = articleTitle;
    }

    /**
     * 修改正文
     *
     * @param articleContent
     */
    public void modifyContent(ArticleContent articleContent) {
        this.content = articleContent;
    }

    public void publishArticle() {
        this.publishState = PublishState.PUBLISHED.getCode();
    }
}
