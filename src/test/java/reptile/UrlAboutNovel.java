package reptile;

public enum UrlAboutNovel {
	/**
	 * dss
	 */
	url0("http://down.jjxsw.com/d/file/p/txt/2018/%E5%8F%8D%E6%B4%BE%E4%BB%96%E5%A6%B9[%E5%BF%AB%E7%A9%BF].txt","dss"),
	/**
	 * 单个text文本小说下载地址
	 */
	url1("http://www.jjxsw.com/e/DownSys/doaction.php?enews=DownSoft&classid=47&id=28907&pathid=0&pass=ee247a67a5adcf1dfb1abecbd1ff5635&p=:::","单个text文本小说下载地址"),
	/**
	 * 单个压缩版小说下载地址
	 */
	url2("http://www.txt53.com/home/down/zip/id/44502","单个压缩版小说下载地址"),
	/**
	 * 单个txt小说下载地址2
	 */
	url21("http://txt.bookdown.com.cn/home/down/txt/id/4087","单个txt小说下载地址2"),
	/**
	 * 测试网站信息地址1
	 */
	url3("http://img.jjxsw.com/UploadPic/2018-07/heq0eao1ayn.jpg?x-oss-process=style/cover_m","测试网站信息地址1"),
	/**
	 * 测试网站信息地址2
	 */
	url4("http://www.sjtxt.la/soft/1/Soft_001_1.html","测试网站信息地址2"),
	/**
	 * 测试网站信息地址3
	 */
	url5("http://www.aqtxt.com/xuanhuan/","测试网站信息地址3"),
	/**
	 * 九九网站
	 */
	url6("http://www.jjxsw.com/e/DownSys/doaction.php?enews=DownSoft&classid=37&id=28944&pathid=0&pass=ee247a67a5adcf1dfb1abecbd1ff5635&p=:::","九九网站"),
	/**
	 * 下雪网
	 */
	url7("http://dd.sjtxt.la/down/85/85327/%E5%89%91%E5%A8%98.txt","下雪网"),
	/**
	 * safari5.1–MAC爬虫代理
	 */
	UserAgent1("Mozilla/5.0(Macintosh;U;IntelMacOSX10_6_8;en-us)AppleWebKit/534.50(KHTML,likeGecko)Version/5.1Safari/534.50","safari5.1–MAC爬虫代理"),
	/**
	 * IE8.0爬虫代理
	 */
	UserAgent2("Mozilla/4.0(compatible;MSIE8.0;WindowsNT6.0;Trident/4.0)","IE8.0爬虫代理"),
	UserAgent3("Mozilla/5.0(WindowsNT6.1;rv:2.0.1)Gecko/20100101Firefox/4.0.1","Firefox4.0.1–Windows爬虫代理"),
	/**
	 * 搜狗浏览器1.x爬虫代理
	 */
	UserAgent4("Mozilla/4.0(compatible;MSIE7.0;WindowsNT5.1;Trident/4.0;SE2.XMetaSr1.0;SE2.XMetaSr1.0;.NETCLR2.0.50727;SE2.XMetaSr1.0)","搜狗浏览器1.x爬虫代理"),
	/**
	 * 360浏览器爬虫代理
	 */
	UserAgent5("Mozilla/4.0(compatible;MSIE7.0;WindowsNT5.1;360SE)","360浏览器爬虫代理"),
	/**
	 * UC标准爬虫代理
	 */
	UserAgent6("NOKIA5700/UCWEB7.0.2.37/28/999","UC标准爬虫代理"),
	/**
	 * Chrome爬虫代理
	 */
	UserAgent7("Mozilla/5.0(Macintosh;IntelMacOSX10_7_0)AppleWebKit/535.11(KHTML,likeGecko)Chrome/17.0.963.56Safari/535.11","Chrome爬虫代理"),
	/**
	 * Opera爬虫代理
	 */
	UserAgent8("Opera/9.80(WindowsNT6.1;U;en)Presto/2.8.131Version/11.11","Opera爬虫代理"),
	/**
	 * Firefox爬虫代理
	 */
	UserAgent9("Mozilla/5.0 (Windows NT 5.1; rv:2.0b6) Gecko/2010010 Firefox/4.0b6","Firefox爬虫代理"),
	UserAgent10("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0","Firefox爬虫代理");
	
	private String url;
	private String name;
	private UrlAboutNovel(String url, String name) {
		this.url = url;
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
