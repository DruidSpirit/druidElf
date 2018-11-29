package com.druid.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.druid.dto.CommonParam;
import com.druid.dto.Message;
import com.druid.enums.UrlAboutNovelEnums;
import com.druid.service.CommonService;
import com.druid.util.HttpGetDownFile;
import tk.mybatis.mapper.entity.Example;

@Controller
@Scope("prototype")
public class NovelCrawlerControl {
	@Autowired
	private DruidNovelResourceService novelResourceService;
	@Autowired
	private CommonService commonService;

	private Message message = new Message();
	private Map map = new HashMap<>();
	/**
	 * ????????????????§Ò?
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/novelCrawler/getSourceList.control",method=RequestMethod.GET)
	public String getSourceList(HttpServletRequest request,
								@RequestParam(value="fenye",required=false) Integer page){
		List<DruidNovelResource> list = new ArrayList<DruidNovelResource>();
		//PageHelper.startPage(1, 10);
		list=novelResourceService.selectByExample(null);
		//PageInfo<NovelResource> p=new PageInfo<NovelResource>(list);
		//request.setAttribute("pageInfo", p);
		return "service";
	}

	/**
	 * ?????????(????????????????????)
	 * @param url
	 * @param novelType
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value="/novelCrawler/startCrawlerWorkToDataBase.control")
	public Map startCrawlerWorkToDataBase(String url,Integer novelType){

		if(url==null||novelType==null){
			message.setStatus(false);
			message.setMessage("??????????????");
			map.put("message", message);
			return map;
		};

		CommonParam commonParam = new CommonParam();
		commonParam.setLink(url);

		commonParam.setType(novelType);
		commonParam.setSiteAddress(UrlAboutNovelEnums.urlSite0.getUrl());
		List<DruidNovelResource> tmp = novelResourceService.getResourceToDataBase(commonParam);
		List<DruidNovelResource> resultList = new ArrayList<DruidNovelResource>();

		for (int j = 0; j < tmp.size(); j++) {
			DruidNovelResource novelResource = tmp.get(j);

//			NovelResource novelTmp = NovelResource.builder().build();
			DruidNovelResource novelTmp =  DruidNovelResource.builder().build();
			if(novelResource.getLinkTxt()==null) continue;
			novelTmp.setLinkTxt(novelResource.getLinkTxt());
			Example example = new Example(DruidNovelResource.class);
			example.createCriteria().andEqualTo("linkTxt",novelTmp.getLinkTxt());
			List<DruidNovelResource> tmp2 = novelResourceService.selectByExample(example);
			if(tmp2.size()==0) resultList.add(novelResource);
		}

		if(resultList.size()==0){
			message.setStatus(false);
			message.setMessage("??§á?????????");
			String nextPageUrl = novelResourceService.nextPageUrl(url);
			message.setOtherMessage(nextPageUrl);
			map.put("message", message);
			return map;
		}

		if(novelResourceService.bulkInsert(resultList)){
			message.setStatus(true);
			message.setMessage("??????????");
			String nextPageUrl = novelResourceService.nextPageUrl(url);
			message.setOtherMessage(nextPageUrl);
		}else{
			message.setStatus(false);
			message.setMessage("???????????");
		}
		map.put("message", message);
		map.put("novelList", resultList);
		return map;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/novelCrawler/getCrawlStatus.control")
	public Map startCrawlerWorkToDataBase(){
		String sql = "select * from druid_novel_resource where add_time = (select max(add_time) from druid_novel_resource)";
		String sqlCount = "select count(*) count from druid_novel_resource";
		List list = commonService.findSqlObject(sql);
		Object count = commonService.findSqlObject(sqlCount).get(0);
		map.put("list", list);
		map.put("count", count);
		return map;

	}

	/**
	 * ?????????(?????????????????????¡¤????)
	 * @return
	 */
	@RequestMapping(value="/novelCrawler/startCrawlerWork.control",method=RequestMethod.GET)
	public void startCrawlerWork(){
		CommonParam commonParam = new CommonParam();
		commonParam.setLink(UrlAboutNovelEnums.url4.getUrl());
		String address = "C:\\Users\\Administrator\\Desktop\\testDwonload\\";
		commonParam.setAddress(address);
		novelResourceService.excavateResource(commonParam);

	}

	/**
	 * ???????????
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/novelCrawler/startCrawlerWorkSingle.control",method=RequestMethod.GET)
	public void startCrawlerWorkSingle() throws IOException{
		String link = "https://dd.sjtxt.la/down/89/89327/????????????.txt";
		//D:\\getPicFiles\\
		String address = "C:\\Users\\Administrator\\Desktop\\testDwonload\\";
		HttpGetDownFile.filterLinkAndDownloadAndSave(link, address,false);
	}

	/**
	 * ??????????
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/novelCrawler/startCrawlerWorkPage.control")
	public Map startCrawlerWorkPage(String previousUrl) throws IOException{
		String nextPageUrl = novelResourceService.nextPageUrl(previousUrl);
		map.put("nextPageUrl", nextPageUrl);
		return map;
	}
}
