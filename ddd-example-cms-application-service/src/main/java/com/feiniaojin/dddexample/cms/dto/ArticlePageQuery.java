package com.feiniaojin.dddexample.cms.dto;

import lombok.Data;

@Data
public class ArticlePageQuery {
    
    /**
     * 当前页，自然顺序，从1开始
     */
    private Integer page = 1;
    
    /**
     * 分页大小
     */
    private Integer pageSize = 20;
    
    /**
     * title搜索关键字
     */
    private String keyword;

    /**
     * article的业务Id
     */
    private String articleId;
}
