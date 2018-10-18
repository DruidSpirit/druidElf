package com.druid.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.druid.dto.CommonParam;
import com.druid.dto.Message;
import com.druid.entity.NovelResource;
import com.druid.enums.NovelType;
import com.druid.enums.UrlAboutNovelEnums;
import com.druid.service.CommonService;
import com.druid.service.NovelResourceService;
import com.druid.util.HttpGetDownFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@Scope("prototype")
public class NovelCrawlerControl {
	@Autowired
	private NovelResourceService novelResourceService;
	@Autowired
	private CommonService commonService;

	private Message message = new Message();
	private Map map = new HashMap<>();
	/**
	 * �õ�������ȡ��Դ���б�
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/novelCrawler/getSourceList.control",method=RequestMethod.GET)
	public String getSourceList(HttpServletRequest request,
								@RequestParam(value="fenye",required=false) Integer page){
		List<NovelResource> list = new ArrayList<NovelResource>();
		//PageHelper.startPage(1, 10);
		list=novelResourceService.selectByNovelResource(null);
		//PageInfo<NovelResource> p=new PageInfo<NovelResource>(list);
		//request.setAttribute("pageInfo", p);
		return "service";
	}

	/**
	 * ��ʼ��ȡ��Դ(����ȡ����Դ�ŵ����ݿ���)
	 * @param request
	 * @param page
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value="/novelCrawler/startCrawlerWorkToDataBase.control")
	public Map startCrawlerWorkToDataBase(String url,Integer novelType){

		if(url==null||novelType==null){
			message.setStatus(false);
			message.setMessage("���ӻ�������Ϊ��");
			map.put("message", message);
			return map;
		};

		CommonParam commonParam = new CommonParam();
		commonParam.setLink(url);

		commonParam.setType(novelType);
		commonParam.setSiteAddress(UrlAboutNovelEnums.urlSite0.getUrl());
		List<NovelResource> tmp = novelResourceService.getResourceToDataBase(commonParam);
		List<NovelResource> resultList = new ArrayList<NovelResource>();

		for (int j = 0; j < tmp.size(); j++) {
			NovelResource novelResource = tmp.get(j);

//			NovelResource novelTmp = NovelResource.builder().build();
			NovelResource novelTmp =  NovelResource.builder().build();
			if(novelResource.getLinkTxt()==null) continue;
			novelTmp.setLinkTxt(novelResource.getLinkTxt());

			List<NovelResource> tmp2 = novelResourceService.selectByNovelResource(novelTmp);
			if(tmp2.size()==0) resultList.add(novelResource);
		}

		if(resultList.size()==0){
			message.setStatus(false);
			message.setMessage("û�пɲ��������");
			String nextPageUrl = novelResourceService.nextPageUrl(url);
			message.setOtherMessage(nextPageUrl);
			map.put("message", message);
			return map;
		}

		if(novelResourceService.bulkInsert(resultList)){
			message.setStatus(true);
			message.setMessage("��������ɹ�");
			String nextPageUrl = novelResourceService.nextPageUrl(url);
			message.setOtherMessage(nextPageUrl);
		}else{
			message.setStatus(false);
			message.setMessage("��������ʧ��");
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
	 * ��ʼ��ȡ��Դ(����ȡ������Դ���ص�����·����)
	 * @param request
	 * @param page
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
	 * �����ļ�����
	 * @param request
	 * @param page
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/novelCrawler/startCrawlerWorkSingle.control",method=RequestMethod.GET)
	public void startCrawlerWorkSingle() throws IOException{
		String link = "https://dd.sjtxt.la/down/89/89327/���֮��������.txt";
		//D:\\getPicFiles\\
		String address = "C:\\Users\\Administrator\\Desktop\\testDwonload\\";
		HttpGetDownFile.filterLinkAndDownloadAndSave(link, address);
	}

	/**
	 * �����ҳ����
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
