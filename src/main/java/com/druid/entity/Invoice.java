package com.druid.entity;



/**
 * RdInvoice entity. @author MyEclipse Persistence Tools
 */

public class Invoice {

	// Fields


	
	/**
	 * 已认�?
	 */
	public static final Integer CERTIFIED = 0;
	/**
	 * 审核�?
	 */
	public static final Integer REVIEW = 1;
	/**
	 * 驳回
	 */
	public static final Integer REJECT = 2;
	private Integer id;
	private Integer userId;
	private String companyAddress;
	private String invoiceCall;
	private String depositBank;
	private String cardNo;
	private String contactName;
	private String contactCall;
	private Integer status;
	private long addTime;
	private String addIp;
	private String invoiceTitle;
	private String creditCode;
	private Integer showStatus;
	// Constructors

	/** default constructor */
	public Invoice() {
	}

	/** full constructor */
	
	public Invoice(Integer id, Integer userId, String companyAddress, String invoiceCall, String depositBank,
			String cardNo, String contactName, String contactCall, Integer status, long addTime, String addIp,
			String invoiceTitle, String creditCode,Integer showStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyAddress = companyAddress;
		this.invoiceCall = invoiceCall;
		this.depositBank = depositBank;
		this.cardNo = cardNo;
		this.contactName = contactName;
		this.contactCall = contactCall;
		this.status = status;
		this.addTime = addTime;
		this.addIp = addIp;
		this.invoiceTitle = invoiceTitle;
		this.creditCode = creditCode;
		this.showStatus=showStatus;
	}
	
	public Integer getId() {
		return this.id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	
	public String getInvoiceCall() {
		return this.invoiceCall;
	}

	public void setInvoiceCall(String invoiceCall) {
		this.invoiceCall = invoiceCall;
	}

	
	public String getDepositBank() {
		return this.depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	
	public String getContactCall() {
		return this.contactCall;
	}

	public void setContactCall(String contactCall) {
		this.contactCall = contactCall;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	
	public String getAddIp() {
		return this.addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	
	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	
	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	
	
	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}
	
	

}