package com.druid.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druid.dao.EmployeeMapper;
import com.druid.dao.NovelResourceMapper;
import com.druid.dto.CommonParam;
import com.druid.entity.Employee;
import com.druid.entity.NovelResource;
import com.druid.entity.NovelResourceExample;
import com.druid.service.NovelResourceService;
import com.druid.util.HttpGetDownFile;

@Service
public class NovelResourceServiceImpl implements NovelResourceService{
	@Autowired
	private NovelResourceMapper novelResourceMapper;
	@Autowired
	SqlSession sqlSession;
	
	private List<String> toDoList = new ArrayList<String>();
	private List<NovelResource> novelResourceList = new ArrayList<NovelResource>();

	@Override
	public List<NovelResource> selectByExample(NovelResourceExample example) {
		// TODO Auto-generated method stub
		return novelResourceMapper.selectByExample(example);
	}
	
	@Override
	public boolean bulkInsert(List<NovelResource> novelResourceList) {
		// TODO Auto-generated method stub
		try {
				NovelResourceMapper mapper = sqlSession.getMapper(NovelResourceMapper.class);
				for (NovelResource novelResource : novelResourceList) {
					mapper.insertSelective(novelResource);
				}
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}						
		return false;
	}
	

	@Override
	public List<NovelResource> selectByNovelResource(NovelResource novelResource) {
		// TODO Auto-generated method stub
		return novelResourceMapper.selectByNovelResource(novelResource);
	}
	
	@Override
	public List<NovelResource> getResourceToDataBase(CommonParam commonParam) {
		// TODO Auto-generated method stub
		toDoList.clear();
		List<NovelResource> tmp = new ArrayList<NovelResource>();
		
		List<String> toDoListHref = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(commonParam.getLink()).timeout(4000).get();
			Elements links = doc.select(".listBox a[href]");
			
			for (Element link : links) {
				NovelResource novelResource = new NovelResource();
				Element imglink = link.getElementsByTag("img").first();
				Element alink = link.getElementsByTag("a").first();
				if (imglink==null) continue;//过滤图片链接为空的元素
				if (alink==null) continue;//过滤a标签为空的元素
				
				String href = alink.absUrl("href");//得到绝对路径
				String src = imglink.absUrl("src");//得到绝对路径
				novelResource.setCrawlStartLink(commonParam.getLink());//记录爬取源链接
				novelResource.setLinkResourceAdress(href);					
				novelResource.setLinkSrc(src);
				novelResource.setType(commonParam.getType());
				novelResource.setSiteAddress(commonParam.getSiteAddress());
				if (toDoList.contains(href)) continue;//剔除重复链接	
						toDoList.add(href);
				
				String title = imglink.attr("alt");
				
				tmp.add(novelResource);
				//开始下载图片
				//getImg(src,imgFileAdre);
				toDoListHref.add(href);
				List<String> contentTmp = new ArrayList<String>();
				contentTmp = toDoListHref;													
				
			}
			return toDoList2(tmp,2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						 
		return null;
	}
	
	@Override
	public List<NovelResource> excavateResource(CommonParam commonParam) {
		// TODO Auto-generated method stub
	
	List<String> toDoListHref = new ArrayList<String>();
	
			try {
				Document doc = Jsoup.connect(commonParam.getLink()).timeout(4000).get();
				Elements links = doc.select("a[href]");
				
				for (Element link : links) {
					Element imglink = link.getElementsByTag("img").first();
					Element alink = link.getElementsByTag("a").first();
					if (imglink==null) continue;//过滤图片链接为空的元素
					if (alink==null) continue;//过滤a标签为空的元素
					
					String href = alink.absUrl("href");//得到绝对路径
					String src = imglink.absUrl("src");//得到绝对路径
										
											
					if (toDoList.contains(href)) continue;//剔除重复链接	
							toDoList.add(href);
					
					String title = imglink.attr("alt");
					
					//开始下载图片
					//getImg(src,imgFileAdre);
					toDoListHref.add(href);
					System.out.println("所属链接地址是"+href);
					System.out.println(src);
					System.out.println(title);
																		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<String> contentTmp = new ArrayList<String>();
			contentTmp = toDoListHref;
			
			 toDoList1(contentTmp,2,commonParam.getAddress());
			
		return novelResourceList;
	}
	
	/**
	 * toDoList 循环列队，将新发现的链接加入到工作列队中并下载至本地路径
	 * @param hrefs
	 * @param grade
	 * @return
	 */
    public List<String> toDoList1(List<String> hrefs,Integer grade,String storeAddress){
    	List<String> toDoListHref = new ArrayList<String>();
    	for (String string : hrefs) {
    		try {
    			Document doc = Jsoup.connect(string).timeout(2000).get();
    			Elements links = doc.select(".showDown li:eq(3) script");
    			
    			for (Element link : links) {
    				
    				Element alink = link.getElementsByTag("script").first();
    			
    				if (alink==null) continue;
    				
    				//该网站链接的字符串处理
    				String href = alink.toString();
    				href = href.replace("\"", "");
    				href = href.split(",")[1];   				
    										
    				if (toDoList.contains(href)) continue;//todolist工作，将重复链接排除
    					toDoList.add(href);
    				toDoListHref.add(href);
    				//开始下载图片
    				HttpGetDownFile.filterLinkAndDownloadAndSave(href,storeAddress);
    				System.out.println("所属链接地址是"+href);
    				NovelResource novelResource = new NovelResource();
    				novelResource.setLinkResourceAdress(href);
    				novelResourceList.add(novelResource);
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		}
		return toDoListHref;
    	
		
    }

    /**
	 * toDoList 循环列队，将新发现的链接加入到工作列队中并将其存入数据库
	 * @param hrefs
	 * @param grade
	 * @return
	 */
    public List<NovelResource> toDoList2(List<NovelResource> tmp,Integer grade){
    	
    	List<String> toDoListHref = new ArrayList<String>();
    	List<NovelResource> resultList = new ArrayList<NovelResource>();
    	for (NovelResource novel : tmp) {
    		
    		try {
    			Document doc = Jsoup.connect(novel.getLinkResourceAdress()).timeout(2000).get();
    			Elements links = doc.select(".showBox");
    			//Elements links2 = doc.select(".showDown li:eq(2) script");
    			
    				if(links.size()<3) continue;
    				if(links.get(2).getElementsByTag("script").size()<2) continue;
    				
    				Element alinkZip = links.get(2).getElementsByTag("script").get(0);
    				Element alinkTxt = links.get(2).getElementsByTag("script").get(1);
    				
    				if (alinkZip==null) continue;
    				if (alinkTxt==null) continue;
    				
    				Elements novelDetail = links.get(0).getElementsByTag("li");	
    				Elements novelName = links.get(0).getElementsByTag("h1");
    				Element novelIntro = links.get(1).getElementsByTag("p").get(0);
    				
    				novel.setName(novelName.text());//设置文件名称
    				
    				novel.setPopular(Long.parseLong((novelDetail.get(0).text()).split("：")[1]));//设置点击次数
    				
    				String sizeText = (novelDetail.get(1).text()).split("：")[1];
    				sizeText = sizeText.split("M")[0];
    				novel.setSize(Double.parseDouble(sizeText));//设置文件大小
    				   				
    				if((novelDetail.get(3).text()).split("：").length>1) {
    					Long time = HttpGetDownFile.getTimeLong((novelDetail.get(3).text()).split("：")[1],"yyyy-MM-dd HH:mm:ss");
        				novel.setTurnOverTime(time);//设置跟新时间
    				}
    				
    				if((novelDetail.get(4).text()).split("：").length>1){
    					Integer status = ((novelDetail.get(4).text()).split("：")[1]).equals("连载中")?1:0;
        				novel.setStatus(status);//设置连载还是完结的状态
    				} 
    				
    				if((novelDetail.get(5).text()).split("：").length>1) novel.setAuthor((novelDetail.get(5).text()).split("：")[1]);
    				novel.setIntro(novelIntro.text());//设置简介
    				novel.setAddTime(System.currentTimeMillis());//设置添加时间
    				//该网站链接的字符串处理(解压文件)
    				String hrefZip = alinkZip.toString();
    				hrefZip = hrefZip.replace("\"", "");
    				hrefZip = hrefZip.split(",")[1];   				
    				//该网站链接的字符串处理(txt文件)
    				String hrefTxt = alinkTxt.toString();
    				hrefTxt = hrefTxt.replace("\"", "");
    				hrefTxt = hrefTxt.split(",")[1]; 
    				
    				if (toDoList.contains(hrefTxt)) continue;//todolist工作，将重复链接排除
    					toDoList.add(hrefTxt);
    				toDoListHref.add(hrefTxt);
    				novel.setLinkTxt(hrefTxt);//下载地址链接
    				novel.setLinkZip(hrefZip);
    				
    				resultList.add(novel);
    				System.out.println("所属链接地址是"+hrefTxt);  				
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		}
		return resultList;
    	
		
    }
    
	@Override
	public String nextPageUrl(String atPresentUrl){
		Document doc;
		try {
			doc = Jsoup.connect(atPresentUrl).timeout(2000).get();
			Elements links = doc.select(".tspage a[href]");
			for (Element element : links) {
				if(element.text().equals("下一页")) return element.absUrl("href");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<NovelResource> dealWithDocment(CommonParam commonParam){
		return novelResourceList;
		
	}


	
}
