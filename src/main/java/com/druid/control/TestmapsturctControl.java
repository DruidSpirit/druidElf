/*
package com.druid.control;

import com.druid.dto.vm.testVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class TestmapsturctControl {

    @Autowired
    private NovelResourceService novelResourceService;
    @Autowired
    private TestMapStruct testMapStruct;
    */
/**
     * 得到爬虫爬取资源的列表
     * @param request
     * @param page
     * @return
     *//*

    @RequestMapping(value="/novelCrawler/test.control",method=RequestMethod.GET)
    public String testList(HttpServletRequest request,
                                @RequestParam(value="fenye",required=false) Integer page){
        List<NovelResource> list = new ArrayList<NovelResource>();
        //PageHelper.startPage(1, 10);
        list=novelResourceService.selectByNovelResource(null);
        List<testVm> testVms = testMapStruct.testTransformList(list);
        //PageInfo<NovelResource> p=new PageInfo<NovelResource>(list);
        //request.setAttribute("pageInfo", p);
        return "service";
    }
}
*/
