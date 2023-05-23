package com.feiniaojin.dddexample.cms.dto;

import lombok.Data;

@Data
public class ArticleModifyTitleCmd {
    private String articleId;
    private String title;
}
