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
     * ��Դ����
     */
    private Integer type;

    /**
     * ��Դ���ӵ�ַ(txt��ʽ)
     */
    @Column(name = "link_txt")
    private String linkTxt;

    /**
     * ��Դ����
     */
    private String name;

    /**
     * ��Դ����
     */
    private String intro;

    /**
     * ������վ��Դ
     */
    @Column(name = "link_resource_adress")
    private String linkResourceAdress;

    /**
     * ���ʱ��
     */
    @Column(name = "add_time")
    private Long addTime;

    /**
     * �ܻ�ӭ�̶�
     */
    private Long popular;

    /**
     * ��Դ���ӵ�ַ(zip��ʽ)
     */
    @Column(name = "link_zip")
    private String linkZip;

    /**
     * ��Դ���ӵ�ַ(������ʽ)
     */
    @Column(name = "link_other")
    private String linkOther;

    /**
     * ״̬0-��� 1������
     */
    private Integer status;

    /**
     * ��վ��ַ
     */
    @Column(name = "site_address")
    private String siteAddress;

    /**
     * ͼƬ���ӵ�ַ
     */
    @Column(name = "link_src")
    private String linkSrc;

    /**
     * �ļ���С
     */
    private Double size;

    /**
     * ����ʱ��
     */
    @Column(name = "turn_over_time")
    private Long turnOverTime;

    /**
     * ����
     */
    private String author;

    /**
     * ��ʼ��ȡ���������
     */
    @Column(name = "crawl_start_link")
    private String crawlStartLink;

    /**
     * �Ƿ����� 0-�� 1-��
     */
    @Column(name = "has_loaddown")
    private Boolean hasLoaddown;

    /**
     * ���ش��·��
     */
    @Column(name = "repository_path")
    private String repositoryPath;

}