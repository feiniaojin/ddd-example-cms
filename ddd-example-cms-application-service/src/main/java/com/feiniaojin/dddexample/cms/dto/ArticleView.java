package com.feiniaojin.dddexample.cms.dto;

import lombok.Data;

@Data
public class ArticleView {
    private String articleId;
    private String title;
    private String content;
    private String publishState;
    private String createdTime;
    private String modifiedTime;
}
