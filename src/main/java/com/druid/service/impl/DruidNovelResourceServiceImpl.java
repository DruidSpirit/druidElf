package com.druid.service.impl;

import com.druid.dao.DruidNovelResourceMapper;
import com.druid.dto.CommonParam;
import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import com.druid.util.HttpGetDownFile;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DruidNovelResourceServiceImpl extends BaseService<DruidNovelResource> implements DruidNovelResourceService {

    @Autowired
    private DruidNovelResourceMapper novelResourceMapper;
    @Autowired
    SqlSession sqlSession;

    private List<String> toDoList = new ArrayList<String>();
    private List<DruidNovelResource> novelResourceList = new ArrayList<DruidNovelResource>();


    @Override
    public List<DruidNovelResource> getResourceToDataBase(CommonParam commonParam) {
        toDoList.clear();
        List<DruidNovelResource> tmp = new ArrayList<DruidNovelResource>();

        List<String> toDoListHref = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(commonParam.getLink()).timeout(4000).get();
            Elements links = doc.select(".listBox a[href]");

            for (Element link : links) {
//				NovelResource novelResource =  NovelResource.builder().build();
                // NovelResource.builder().build()
                DruidNovelResource novelResource =  DruidNovelResource.builder().build();

                Element imglink = link.getElementsByTag("img").first();
                Element alink = link.getElementsByTag("a").first();
                if (imglink==null) continue;//?????????????????
                if (alink==null) continue;//????a??????????

                String href = alink.absUrl("href");//???????¡¤??
                String src = imglink.absUrl("src");//???????¡¤??
                novelResource.setCrawlStartLink(commonParam.getLink());//???????????
                novelResource.setLinkResourceAdress(href);
                novelResource.setLinkSrc(src);
                novelResource.setType(commonParam.getType());
                novelResource.setSiteAddress(commonParam.getSiteAddress());
                if (toDoList.contains(href)) continue;//??????????
                toDoList.add(href);

                String title = imglink.attr("alt");

                tmp.add(novelResource);
                //?????????
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

    /**
     * toDoList ????§Ø?????¡¤????????????????§Ø??§Ó???????????¡¤??
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

                    //???????????????????
                    String href = alink.toString();
                    href = href.replace("\"", "");
                    href = href.split(",")[1];

                    if (toDoList.contains(href)) continue;//todolist??????????????????
                    toDoList.add(href);
                    toDoListHref.add(href);
                    //?????????
                    HttpGetDownFile.filterLinkAndDownloadAndSave(href,storeAddress);
                    System.out.println("????????????"+href);
//					NovelResource novelResource = NovelResource.builder().build();
                    DruidNovelResource novelResource =  DruidNovelResource.builder().build();
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
     * toDoList ????§Ø?????¡¤????????????????§Ø??§Ó?????????????
     * @param grade
     * @param grade
     * @return
     */
    public List<DruidNovelResource> toDoList2(List<DruidNovelResource> tmp,Integer grade){

        List<String> toDoListHref = new ArrayList<String>();
        List<DruidNovelResource> resultList = new ArrayList<DruidNovelResource>();
        for (DruidNovelResource novel : tmp) {

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

                novel.setName(novelName.text());//???????????

                novel.setPopular(Long.parseLong((novelDetail.get(0).text()).split("£º")[1]));//??????????

                String sizeText = (novelDetail.get(1).text()).split("£º")[1];
                sizeText = sizeText.split("M")[0];
                novel.setSize(Double.parseDouble(sizeText));//?????????§³

                if((novelDetail.get(3).text()).split("£º").length>1) {
                    Long time = HttpGetDownFile.getTimeLong((novelDetail.get(3).text()).split("£º")[1],"yyyy-MM-dd HH:mm:ss");
                    novel.setTurnOverTime(time);//??????????
                }

                if((novelDetail.get(4).text()).split("£º").length>1){
                    Integer status = ((novelDetail.get(4).text()).split("£º")[1]).equals("??????")?1:0;
                    novel.setStatus(status);//?????????????????
                }

                if((novelDetail.get(5).text()).split("£º").length>1) novel.setAuthor((novelDetail.get(5).text()).split("£º")[1]);
                novel.setIntro(novelIntro.text());//???¨¹??
                novel.setAddTime(System.currentTimeMillis());//??????????
                //???????????????????(??????)
                String hrefZip = alinkZip.toString();
                hrefZip = hrefZip.replace("\"", "");
                hrefZip = hrefZip.split(",")[1];
                //???????????????????(txt???)
                String hrefTxt = alinkTxt.toString();
                hrefTxt = hrefTxt.replace("\"", "");
                hrefTxt = hrefTxt.split(",")[1];

                if (toDoList.contains(hrefTxt)) continue;//todolist??????????????????
                toDoList.add(hrefTxt);
                toDoListHref.add(hrefTxt);
                novel.setLinkTxt(hrefTxt);//??????????
                novel.setLinkZip(hrefZip);

                resultList.add(novel);
                System.out.println("????????????"+hrefTxt);

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
                if(element.text().equals("ÏÂÒ»Ò³")) return element.absUrl("href");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean bulkInsert(List<DruidNovelResource> novelResourceList) {
        // TODO Auto-generated method stub
        try {
            DruidNovelResourceMapper mapper = sqlSession.getMapper(DruidNovelResourceMapper.class);
            for (DruidNovelResource novelResource : novelResourceList) {
                mapper.insertSelective(novelResource);
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
    @Override
    public List<DruidNovelResource> excavateResource(CommonParam commonParam) {
        // TODO Auto-generated method stub

        List<String> toDoListHref = new ArrayList<String>();

        try {
            Document doc = Jsoup.connect(commonParam.getLink()).timeout(4000).get();
            Elements links = doc.select("a[href]");

            for (Element link : links) {
                Element imglink = link.getElementsByTag("img").first();
                Element alink = link.getElementsByTag("a").first();
                if (imglink==null) continue;//?????????????????
                if (alink==null) continue;//????a??????????

                String href = alink.absUrl("href");//???????¡¤??
                String src = imglink.absUrl("src");//???????¡¤??


                if (toDoList.contains(href)) continue;//??????????
                toDoList.add(href);

                String title = imglink.attr("alt");

                //?????????
                //getImg(src,imgFileAdre);
                toDoListHref.add(href);
                System.out.println("????????????"+href);
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
}