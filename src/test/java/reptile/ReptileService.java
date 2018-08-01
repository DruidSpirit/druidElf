package reptile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReptileService {
	
	List<String> toDoList = new ArrayList<String>();
	String basetitle;
	Integer count = 2;
	
	/**
	 * 得到源地址开始爬取链接
	 * @param baseHref
	 */
	public void crawlingHref(String baseHref){
		// TODO Auto-generated method stub
			
			String baseHrefs = baseHref.replace(".", "#");
			String content[] = baseHrefs.split("#");
			content[2] = (content[2].split("/"))[0];
			basetitle = content[0] +"."+ content[1]  +"."+ content[2];
		
		List<String> toDoListHref = new ArrayList<String>();
		
				try {
					Document doc = Jsoup.connect(baseHref).timeout(4000).get();
					Elements links = doc.select("a[href]");
					
					for (Element link : links) {
						Element imglink = link.getElementsByTag("img").first();
						Element alink = link.getElementsByTag("a").first();
						if (imglink==null) continue;
						if (alink==null) continue;
						
						String href = alink.attr("href");
						String src = imglink.attr("src");
						
						
						
						toDoListHref.add(basetitle+href);
						if (!src.contains("http://")&&!src.contains("https://")) continue;
												
						if (toDoList.contains(src)) continue;//todolist工作，将重复链接排除
					
						toDoList.add(src);
						
						String title = imglink.attr("alt");
						String imgFileAdre = "D:\\getPicFiles\\"+title+""+System.currentTimeMillis()+".jpg";
						
						//开始下载图片
						getImg(src,imgFileAdre);
						
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
				for(int i =0;i<1;i++){
					contentTmp = toDoList(contentTmp,i+1);
				}
				
	}
	
	/**
	 * toDoList 循环列队，将新发现的链接加入到工作列队中
	 * @param hrefs
	 * @param grade
	 * @return
	 */
    public List<String> toDoList(List<String> hrefs,Integer grade){
    	List<String> toDoListHref = new ArrayList<String>();
    	for (String string : hrefs) {
    		try {
    			Document doc = Jsoup.connect(string).timeout(2000).get();
    			Elements links = doc.select("a[href]");
    			
    			for (Element link : links) {
    				Element imglink = link.getElementsByTag("img").first();
    				Element alink = link.getElementsByTag("a").first();
    				if (imglink==null) continue;
    				if (alink==null) continue;
    				
    				String href = alink.attr("href");
    				String src = imglink.attr("src");
    				
    				
    				if (!src.contains("http://")&&!src.contains("https://")) continue;
    										
    				if (toDoList.contains(src)) continue;//todolist工作，将重复链接排除
    			
    				toDoList.add(src);
    				
    				String title = imglink.attr("alt");
    				String imgFileAdre = "D:\\getPicFiles\\"+title+""+System.currentTimeMillis()+".jpg";
    				toDoListHref.add(basetitle+href);
    				//开始下载图片
    				getImg(src,imgFileAdre);
    				System.out.println("所属链接地址是"+href);
    				System.out.println(src);
    				System.out.println(title);
    																	
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		}
		return toDoListHref;
    	
		
    }
	
	/**
	 * 得到文件地址并下载文件
	 * @param src
	 * @param imageFileName 下载文件的储存地址
	 * @throws IOException
	 * 代理1:"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31"
	 * 代理2:Mozilla/5.0 (Windows NT 5.1; rv:2.0b6) Gecko/2010010 Firefox/4.0b6
	 */
	public void getImg(String src,String imageFileName) throws IOException{
		
		Response request = Jsoup.connect(src).referrer(src)
				.userAgent(UrlAboutNovel.UserAgent7.getUrl())
				.timeout(60000)
				.maxBodySize(1024*1024*20)
				.ignoreContentType(true)
				.execute();
		
		System.out.println(request.url());
		byte[] imgdata = request.bodyAsBytes();
					
		FileUtils.writeByteArrayToFile(new File(imageFileName), imgdata);
	}
	
	/**
	 * 得到文件地址并下载文件
	 * @param src
	 * @param imageFileName 下载文件的储存地址
	 * @throws IOException
	 * 代理1:"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31"
	 * 代理2:Mozilla/5.0 (Windows NT 5.1; rv:2.0b6) Gecko/2010010 Firefox/4.0b6
	 */
	public void getFile(String src,String imageFileName) throws IOException{
		

		Connection request = Jsoup.connect(src).referrer(src)
				.userAgent(UrlAboutNovel.UserAgent7.getUrl())
				.timeout(60000)
				.maxBodySize(1024*1024*20)
				.ignoreContentType(true)
				.followRedirects(false);
		
		Response req = request.execute();
		String location = req.header("Location");
		URL redir = StringUtil.resolve(req.url(), location);
		String[] url = redir.toString().split("");//URLEncoder.encode("xxx", "utf-8");
		String names[] = redir.toString().split("/");
		String fileName = names[names.length-1];//文件名称
		String resultUrl = "";
		for (String string : url) {
			String regEx = "[\u4e00-\u9fa5]";
			Pattern pat = Pattern.compile(regEx);
			Matcher matcher = pat.matcher(string);
			if(matcher.find()) string = URLEncoder.encode(string, "utf-8");
			resultUrl += string;
		}
		
		/*byte[] imgdata = request.bodyAsBytes();
					
		FileUtils.writeByteArrayToFile(new File(imageFileName), imgdata);*/
		String timeName = (new DateTime().toLocalDateTime().toString("yyyy年MM月dd日hh点mm分ss秒"))
				+ fileName;//根据当前时间合成的文件名
		String storageAddress = "D:\\getPicFiles\\";//被下载的文件储存位置
		String fileSuffix = ".txt";//被下载的文件名称后缀
		String address = storageAddress + timeName;
					
		getImg(resultUrl,address);
	}
	
	
	 /**
     * 利用 commonio 库下载文件，依赖Apache Common IO ，官网 https://commons.apache.org/proper/commons-io/
     * @param url (官网：www.fhadmin.org)
     * @param saveDir
     * @param fileName
     */
    public void downloadByApacheCommonIO(String url, String saveDir, String fileName) {
        try {
        	URL uri = new URL(url);
        	uri.openConnection().setRequestProperty("User-Agent", UrlAboutNovel.UserAgent8.getUrl());
            FileUtils.copyURLToFile(uri, new File(saveDir, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   public void ipChange(String url){
	   
	 
      
	   
	   try {
		   Document doc = Jsoup.connect(url).referrer(url)
					.userAgent(UrlAboutNovel.UserAgent7.getUrl())
					.timeout(60000)
					.maxBodySize(1024*1024*20)
					.ignoreContentType(true)
					.get();
		   Elements links = doc.select("a[href]"); 
		   System.out.println(links);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
