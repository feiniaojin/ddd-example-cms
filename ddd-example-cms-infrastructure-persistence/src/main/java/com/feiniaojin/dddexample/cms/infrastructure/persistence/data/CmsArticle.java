package com.feiniaojin.dddexample.cms.infrastructure.persistence.data;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * @author zhengkai.blog.csdn.net
 * @description cms_article
 * @date 2023-05-23
 */
@Data
@Table("cms_article")
public class CmsArticle {

    /**
     * 自增主键
     */
    @Id
    private Long id;

    /**
     * article业务主键
     */
    private String articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布状态，[0-待发布；1-已发布]
     */
    private Integer publishState;

    /**
     * 逻辑删除标记[0-正常；1-已删除]
     */
    private int deleted;

    /**
     * 创建人
     */
    @CreatedBy
    private String createdBy;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createdTime;

    /**
     * 更新人
     */
    @LastModifiedBy
    private String modifiedBy;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date modifiedTime;

    /**
     * 乐观锁
     */
    @Version
    private Long version;

}