package com.druid.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
@Builder
@Data
@Table(name = "druid_novel_resource")
public class DruidNovelResource {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 资源链接地址(txt格式)
     */
    @Column(name = "link_txt")
    private String linkTxt;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源介绍
     */
    private String intro;

    /**
     * 链接网站来源
     */
    @Column(name = "link_resource_adress")
    private String linkResourceAdress;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Long addTime;

    /**
     * 受欢迎程度
     */
    private Long popular;

    /**
     * 资源链接地址(zip格式)
     */
    @Column(name = "link_zip")
    private String linkZip;

    /**
     * 资源链接地址(其他格式)
     */
    @Column(name = "link_other")
    private String linkOther;

    /**
     * 状态0-完结 1连载中
     */
    private Integer status;

    /**
     * 网站地址
     */
    @Column(name = "site_address")
    private String siteAddress;

    /**
     * 图片链接地址
     */
    @Column(name = "link_src")
    private String linkSrc;

    /**
     * 文件大小
     */
    private Double size;

    /**
     * 跟新时间
     */
    @Column(name = "turn_over_time")
    private Long turnOverTime;

    /**
     * 作者
     */
    private String author;

    /**
     * 开始爬取的起点链接
     */
    @Column(name = "crawl_start_link")
    private String crawlStartLink;

    /**
     * 是否下载 0-否 1-是
     */
    @Column(name = "has_loaddown")
    private Boolean hasLoaddown;

    /**
     * 下载存放路径
     */
    @Column(name = "repository_path")
    private String repositoryPath;

}