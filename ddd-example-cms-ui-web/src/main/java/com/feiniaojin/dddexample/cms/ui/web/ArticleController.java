package com.feiniaojin.dddexample.cms.ui.web;

import com.feiniaojin.dddexample.cms.applicationservice.ArticleCommandService;
import com.feiniaojin.dddexample.cms.applicationservice.ArticleQueryService;
import com.feiniaojin.dddexample.cms.dto.*;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleQueryService queryService;

    @Resource
    private ArticleCommandService commandService;

    @RequestMapping("/get")
    public ArticleView get(String articleId) {
        return queryService.articleDetail(articleId);
    }

    @RequestMapping("/createArticleDraft")
    public void createArticleDraft(@RequestBody ArticleCreateCmd cmd) {
        commandService.newDraft(cmd);
    }

    @RequestMapping("/modifyTitle")
    public void modifyTitle(@RequestBody ArticleModifyTitleCmd cmd) {
        commandService.modifyTitle(cmd);
    }

    @RequestMapping("/publishArticle")
    public void publishArticle(@RequestBody ArticlePublishCmd cmd) {
        commandService.publishArticle(cmd);
    }
    @RequestMapping("/modifyContent")
    public void modifyTitle(@RequestBody ArticleModifyContentCmd cmd) {
        commandService.modifyContent(cmd);
    }

    @RequestMapping("/pageList")
    public PageBean<ArticleView> pageList(ArticlePageQuery pageQuery) {
        return queryService.pageList(pageQuery);
    }

}
