package com.druid.service;

import java.util.List;

import com.druid.dto.CommonParam;
import com.druid.entity.NovelResource;
import com.druid.entity.NovelResourceExample;

public interface NovelResourceService {
	/**
	 * 查询爬虫存入数据库列表
	 * @param example
	 * @return
	 */
	List<NovelResource> selectByExample(NovelResourceExample example);
	/**
	 * 根据传入条件查询爬虫爬取的列表
	 * @param novelResource
	 * @return
	 */
	List<NovelResource> selectByNovelResource(NovelResource novelResource);
	/**
	 * 批量插入爬虫爬取的数据
	 * @param novelResourceList
	 * @return
	 */
	public boolean bulkInsert(List<NovelResource> novelResourceList);
	/**
	 * 将爬虫得到的资源存入数据库
	 * @param example
	 * @return
	 */
	List<NovelResource> getResourceToDataBase(CommonParam commonParam);
	/**
	 * 将爬虫获取的资源下载到本地路径
	 * @param commonParam
	 * @return
	 */
	List<NovelResource> excavateResource(CommonParam commonParam);
	/**
	 * 爬虫获取当前页面的下一个页面的路径地址
	 * @param atPresentUrl
	 * @return
	 */
	String nextPageUrl (String atPresentUrl);
}
