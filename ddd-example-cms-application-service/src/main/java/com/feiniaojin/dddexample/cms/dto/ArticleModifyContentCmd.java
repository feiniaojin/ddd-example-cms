package com.feiniaojin.dddexample.cms.dto;

import lombok.Data;

@Data
public class ArticleModifyContentCmd {
    private String articleId;
    private String content;
}
