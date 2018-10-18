package com.druid.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NovelResource {
    private Integer id;

    private Integer type;

    private String linkTxt;

    private String name;

    private String intro;

    private String linkResourceAdress;

    private Long addTime;

    private Long popular;

    private String linkZip;

    private String linkOther;

    private Integer status;

    private String siteAddress;

    private String linkSrc;

    private Double size;

    private Long turnOverTime;

    private String author;

    private String crawlStartLink;

}