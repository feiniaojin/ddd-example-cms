package com.feiniaojin.dddexample.cms.applicationservice;

import com.feiniaojin.dddexample.cms.domain.ArticleEntity;
import com.feiniaojin.dddexample.cms.domain.ArticleEntityRepository;
import com.feiniaojin.dddexample.cms.domain.ArticleId;
import com.feiniaojin.dddexample.cms.dto.ArticlePageQuery;
import com.feiniaojin.dddexample.cms.dto.ArticleView;
import com.feiniaojin.dddexample.cms.dto.ArticleViewAssembler;
import com.feiniaojin.dddexample.cms.infrastructure.persistence.ArticleJdbcRepository;
import com.feiniaojin.dddexample.cms.infrastructure.persistence.data.CmsArticle;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleQueryService {

    @Resource
    private ArticleEntityRepository entityRepository;

    @Resource
    private ArticleViewAssembler viewAssembler;

    @Resource
    private ArticleJdbcRepository jdbcRepository;

    /**
     * 直接通过数据模型查询并返回
     *
     * @param query
     * @return
     */
    public PageBean pageList(ArticlePageQuery query) {

        Long count = jdbcRepository.countForQueryList(query.getKeyword());
        if (count == 0) {
            return new PageBean();
        }

        List<CmsArticle> cmsArticles = jdbcRepository.queryList(query.getKeyword(), (query.getPage() - 1) * query.getPageSize(), query.getPageSize());
        List<ArticleView> viewList = this.toViewList(cmsArticles);
        PageBean<ArticleView> pageBean = new PageBean<>();
        pageBean.setTotal(count.intValue());
        pageBean.setList(viewList);
        pageBean.setPage(query.getPage());
        pageBean.setPageSize(query.getPageSize());
        return pageBean;
    }

    private List<ArticleView> toViewList(List<CmsArticle> cmsArticles) {

        List<ArticleView> viewList = cmsArticles.stream().map(a -> {
            ArticleView view = new ArticleView();
            view.setArticleId(a.getArticleId());
            view.setTitle(a.getTitle());
            view.setContent(a.getContent());
            return view;
        }).collect(Collectors.toList());

        return viewList;
    }

    public ArticleView articleDetail(String articleId) {
        ArticleEntity entity = entityRepository.load(new ArticleId(articleId));
        return viewAssembler.assembler(entity);
    }
}
