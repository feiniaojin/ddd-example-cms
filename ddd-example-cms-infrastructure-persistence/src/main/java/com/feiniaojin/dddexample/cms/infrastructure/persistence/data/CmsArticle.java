package com.feiniaojin.dddexample.cms.infrastructure.persistence.data;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@Table("cms_article")
public class CmsArticle {

    /**
     * 自增主键
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * article业务主键
     */
    @Column("article_id")
    private String articleId;

    /**
     * 标题
     */
    @Column("title")
    private String title;

    /**
     * 内容
     */
    @Column("content")
    private String content;

    /**
     * 发布状态，[0-待发布；1-已发布]
     */
    @Column("publish_state")
    private Integer publishState;

    /**
     * 逻辑删除标记[0-正常；1-已删除]
     */
    @Column("deleted")
    private int deleted;

    /**
     * 创建人
     */
    @CreatedBy
    @Column("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column("created_time")
    private Date createdTime;

    /**
     * 更新人
     */
    @LastModifiedBy
    @Column("modified_by")
    private String modifiedBy;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column("modified_time")
    private Date modifiedTime;

    /**
     * 乐观锁
     */
    @Version
    @Column("version")
    private Long version;

}
