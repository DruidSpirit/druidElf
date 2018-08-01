package com.druid.control;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.druid.definedAnnotation.Interceptors;
import com.druid.entity.Invoice;
import com.druid.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;





@Controller
public class BusinessProcess implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1761453905592471784L;

	/**
	 * 
	 */
	
	@Autowired
	private  IStudentService istu;
	private List<Invoice> list=new ArrayList<Invoice>();
	//private Paging paging=new Paging();
	

	@RequestMapping(value="/updatestaff",method=RequestMethod.POST)
	@ResponseBody
	public List<Invoice> serviceCrossing(HttpServletRequest request,@RequestParam(value="fenye",required=false) Integer page){
		
		/*Paging paging=new Paging();
		System.out.println(istu.paging());
		Paging.setTotalCount(istu.paging());
		System.out.println("寮�濮嬬殑鏉℃暟鏄�:"+paging.startCout(page));
		System.out.println("缁撴潫鐨勬潯鏁版槸:"+paging.endCount(page));
		this.page=page;
		System.out.println("鎴愬姛浜嗭紝鍝堝搱!"+istu.findstu().get(0).getAddip());
		System.out.println("闈欐�侀〉鏁版槸"+this.page);*/
		
		if(page==null){
			page=1;
		}
		PageHelper.startPage(page, 10);
		list=istu.findstu();
		PageInfo<Invoice> p=new PageInfo<Invoice>(list);
		//request.setAttribute("pageInfo", p);
			return p.getList();
		}
	
	@Interceptors(name = "CrossDomainInterceptor")
	@RequestMapping(value="/updatestaff2",method=RequestMethod.GET)
	public String serviceCrossing2(HttpServletRequest request,
			@RequestParam(value="fenye",required=false) Integer page){
		String sql = "select * from yc_user where user_id in(1082,1083)";
		List obj = istu.findSqlObject(sql);
		System.out.println(obj.get(0));
		System.out.println(obj);
		/*List<Invoice> list2 = new ArrayList<Invoice>();*/
		//list2 = istu.findstu();
		PageHelper.startPage(1, 10);
		list=istu.findstu();
		PageInfo<Invoice> p=new PageInfo<Invoice>(list);
		request.setAttribute("pageInfo", p);
			return "service";
		}
	@RequestMapping(value="/updatestaff3",method=RequestMethod.GET)
	public String serviceCrossing3(HttpServletRequest request){

		PageHelper.startPage(1, 10);
		list=istu.findstu();
		PageInfo<Invoice> p=new PageInfo<Invoice>(list);
		request.setAttribute("list2", p.getList());
			return "serviceTwo";
		}
	@RequestMapping(value="/uploadto",method=RequestMethod.GET)	
	public String uploadtest(){	
			return "uploadtest";
		}
	/*@RequestMapping(value="/ajaxtest",method=RequestMethod.POST)
	@ResponseBody
	public Invoice ajaxtest(@RequestParam(value="test",required=false) Integer test){
		System.out.println(test);
		List<Invoice> list = new ArrayList<Invoice>();
		Invoice member =new Invoice();
		member.setGrade(3);
		list.add(member);
			return member;
		}*/
	
	/**
	 * 鎴浘鎻掍欢
	 * @return
	 */
	@RequestMapping(value="/screenshot",method=RequestMethod.GET)	
	public String screenshot(){	
			return "screenshot";
	}
	
	
	/**
	 * jQuery琛ㄥ崟鎻掍欢楠岃瘉杩涘叆椤甸潰
	 * @return
	 */
	@RequestMapping(value="/toJqueryForm",method=RequestMethod.GET)	
	public String toJQueryForm(){
			return "jqueryTest/toJqueryForm";
	}
	
	/**
	 * jQuery琛ㄥ崟鎻掍欢楠岃瘉琛ㄥ崟鎻愪氦
	 * @return
	 */
	@RequestMapping(value="/jqueryForm",method=RequestMethod.POST)
	@ResponseBody
	public Boolean jQueryForm(@RequestParam(value="textOne") Integer textOne,
							  @RequestParam(value="textTwo") Integer textTwo){
		System.out.println(textOne);
		System.out.println(textTwo);
			return true;
	}
	
	/**
	 * 鏂囨湰缂栬緫鍣�
	 * @return
	 */
	@RequestMapping(value="/textEdit",method=RequestMethod.GET)	
	public String textEdit(){	
			return "textEdit";
	}
}
