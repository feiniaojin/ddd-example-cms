package com.feiniaojin.dddexample.cms.applicationservice;

import com.feiniaojin.dddexample.cms.domain.*;
import com.feiniaojin.dddexample.cms.dto.ArticleCreateCmd;
import com.feiniaojin.dddexample.cms.dto.ArticleModifyContentCmd;
import com.feiniaojin.dddexample.cms.dto.ArticleModifyTitleCmd;
import com.feiniaojin.dddexample.cms.dto.ArticlePublishCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleCommandService {

    @Resource
    private ArticleFactory factory;

    @Resource
    private ArticleEntityRepository repository;

    /**
     * 创建草稿
     *
     * @param cmd
     */
    public void newDraft(ArticleCreateCmd cmd) {
        ArticleEntity articleEntity = factory.newInstance(new ArticleTitle(cmd.getTitle()),
                new ArticleContent(cmd.getContent()));
        articleEntity.createDraft();
        repository.save(articleEntity);
    }

    /**
     * 发布草稿
     *
     * @param cmd
     */
    public void publishArticle(ArticlePublishCmd cmd) {
        ArticleEntity entity = repository.load(new ArticleId(cmd.getArticleId()));
        entity.publishArticle();
        repository.save(entity);
    }


    /**
     * 修改标题
     *
     * @param cmd
     */
    public void modifyTitle(ArticleModifyTitleCmd cmd) {
        ArticleEntity entity = repository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyTitle(new ArticleTitle(cmd.getTitle()));
        repository.save(entity);
    }

    /**
     * 修改正文
     *
     * @param cmd
     */
    public void modifyContent(ArticleModifyContentCmd cmd) {
        ArticleEntity entity = repository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyContent(new ArticleContent(cmd.getContent()));
        repository.save(entity);
    }

}
