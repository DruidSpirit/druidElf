package com.druid.dto;

public class CommonParam {

	private String address;//存储位置
	private int count;	//todolist次数
	private String link; //执行链接
	private String src;  //图片链接
	private String siteAddress; //主网站地址
	private Integer type;  //小说分类
	
	public CommonParam() {
		super();
	}		
			
	public CommonParam(String address, int count, String link, String src) {
		super();
		this.address = address;
		this.count = count;
		this.link = link;
		this.src = src;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
