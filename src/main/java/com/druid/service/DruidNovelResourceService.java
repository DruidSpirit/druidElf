package com.druid.service;

import com.druid.dto.CommonParam;
import com.druid.entity.DruidNovelResource;

import java.util.List;

public interface DruidNovelResourceService extends IService<DruidNovelResource> {
    /**
     * 将爬虫得到的资源存入数据库
     * @param commonParam
     * @return
     */
    List<DruidNovelResource> getResourceToDataBase(CommonParam commonParam);
    /**
     * 爬虫获取当前页面的下一个页面的路径地址
     * @param atPresentUrl
     * @return
     */
    String nextPageUrl (String atPresentUrl);
    /**
     * 批量插入爬虫爬取的数据
     * @param novelResourceList
     * @return
     */
    public boolean bulkInsert(List<DruidNovelResource> novelResourceList);
    /**
     * 将爬虫获取的资源下载到本地路径
     * @param commonParam
     * @return
     */
    List<DruidNovelResource> excavateResource(CommonParam commonParam);
}