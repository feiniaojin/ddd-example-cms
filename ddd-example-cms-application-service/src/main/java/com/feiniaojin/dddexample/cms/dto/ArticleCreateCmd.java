package com.feiniaojin.dddexample.cms.dto;

import lombok.Data;

@Data
public class ArticleCreateCmd {
    private String title;
    private String content;
}
