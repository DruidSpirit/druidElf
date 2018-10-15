package com.druid.entity;

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

    public NovelResource() {
    }

    public NovelResource(Integer id, Integer type, String linkTxt, String name, String intro, String linkResourceAdress, Long addTime, Long popular, String linkZip, String linkOther, Integer status, String siteAddress, String linkSrc, Double size, Long turnOverTime, String author, String crawlStartLink) {
        this.id = id;
        this.type = type;
        this.linkTxt = linkTxt;
        this.name = name;
        this.intro = intro;
        this.linkResourceAdress = linkResourceAdress;
        this.addTime = addTime;
        this.popular = popular;
        this.linkZip = linkZip;
        this.linkOther = linkOther;
        this.status = status;
        this.siteAddress = siteAddress;
        this.linkSrc = linkSrc;
        this.size = size;
        this.turnOverTime = turnOverTime;
        this.author = author;
        this.crawlStartLink = crawlStartLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLinkTxt() {
        return linkTxt;
    }

    public void setLinkTxt(String linkTxt) {
        this.linkTxt = linkTxt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLinkResourceAdress() {
        return linkResourceAdress;
    }

    public void setLinkResourceAdress(String linkResourceAdress) {
        this.linkResourceAdress = linkResourceAdress;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Long getPopular() {
        return popular;
    }

    public void setPopular(Long popular) {
        this.popular = popular;
    }

    public String getLinkZip() {
        return linkZip;
    }

    public void setLinkZip(String linkZip) {
        this.linkZip = linkZip;
    }

    public String getLinkOther() {
        return linkOther;
    }

    public void setLinkOther(String linkOther) {
        this.linkOther = linkOther;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getLinkSrc() {
        return linkSrc;
    }

    public void setLinkSrc(String linkSrc) {
        this.linkSrc = linkSrc;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Long getTurnOverTime() {
        return turnOverTime;
    }

    public void setTurnOverTime(Long turnOverTime) {
        this.turnOverTime = turnOverTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCrawlStartLink() {
        return crawlStartLink;
    }

    public void setCrawlStartLink(String crawlStartLink) {
        this.crawlStartLink = crawlStartLink;
    }
}