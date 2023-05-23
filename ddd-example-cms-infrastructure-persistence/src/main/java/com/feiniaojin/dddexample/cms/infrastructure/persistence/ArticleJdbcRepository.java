package com.feiniaojin.dddexample.cms.infrastructure.persistence;


import com.feiniaojin.dddexample.cms.infrastructure.persistence.data.CmsArticle;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基于Spring Data Jdbc实现的数据表Repository
 */
@Repository
public interface ArticleJdbcRepository extends CrudRepository<CmsArticle, Long> {

    @Query("select * from cms_article limit :offset,:pageSize")
    List<CmsArticle> queryList(String title, Integer offset, Integer pageSize);

    @Query("select count(*) from cms_article")
    Long countForQueryList(String title);

    @Query("select * from cms_article where article_id = :articleId limit 1")
    CmsArticle queryOne(String articleId);
}
