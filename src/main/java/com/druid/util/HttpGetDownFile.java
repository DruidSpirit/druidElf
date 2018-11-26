package com.druid.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.helper.StringUtil;

import com.druid.enums.UrlAboutNovelEnums;

public class HttpGetDownFile {
	/**
	 * 得到文件地址并下载文件(已经处理过的正常地址)
	 * @param src
	 * @param imageFileName 下载文件的储存地址(这里的路径名称包括文件名及其后缀)
	 * @throws IOException
	 */
	public static boolean downloadAndSaveFile(String link,String storageAddress) throws IOException{
		
		try {
			Response request = Jsoup.connect(link).referrer(link)
					.userAgent(UrlAboutNovelEnums.UserAgent7.getUrl())
					.timeout(60000)
					.maxBodySize(1024*1024*20)
					.ignoreContentType(true)
					.execute();
			
			System.out.println(request.url());
			byte[] fileData = request.bodyAsBytes();						
			FileUtils.writeByteArrayToFile(new File(storageAddress), fileData);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 过滤下载链接，清除重定向、链接中包含中文字符问题并下载存储文件
	 * @param src
	 * @param imageFileName 下载文件的储存地址(这里的文件名称不包括文件名)
	 * @throws IOException
	 */
	public static boolean filterLinkAndDownloadAndSave(String link,String storageAddress) throws IOException{
		

		Connection request = Jsoup.connect(link).referrer(link)
				.userAgent(UrlAboutNovelEnums.UserAgent7.getUrl())
				.timeout(5*60000)//请求超时时间设置
				.maxBodySize(1024*1024*20)//得到的文件最大值20M
				.ignoreContentType(true)//忽略返回数据类型
				.followRedirects(false);//不允许重定向
		
		Response req = request.execute();//开始执行(连接网站服务器)
		
		String location = req.header("Location");
		if(location==null) location = link;
		URL redir = StringUtil.resolve(req.url(), location);//取出服务器真正的下载链接
		
		//得到链接的后缀名称即文件名称
		String[] url = redir.toString().split("");//
		String names[] = redir.toString().split("/");
		String names2[] = link.split("/");
		String fileName = names[names.length-1];//文件名称
		String fileName2 = names2[names.length-1];//文件名称
		String resultUrl = "";
		
		//对链接中出现的中文字符进行筛选
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		for (String string : url) {
			Matcher matcher = pat.matcher(string);
			if(matcher.find()) string = URLEncoder.encode(string, "utf-8");
			resultUrl += string;
		}
		
		/*byte[] imgdata = request.bodyAsBytes();
					
		FileUtils.writeByteArrayToFile(new File(imageFileName), imgdata);*/
		//String timeName = (new DateTime().toLocalDateTime().toString("yyyy年MM月dd日hh点mm分ss秒"))+ fileName;//根据当前时间合成的文件名		
		Matcher matcher2 = pat.matcher(fileName);
		if(!matcher2.find()) fileName = fileName2;
		String address = storageAddress + fileName;
					
		return downloadAndSaveFile(resultUrl,address);
	}
	
	public static long getTimeLong(String time,String format){
		SimpleDateFormat sdFormat=new SimpleDateFormat(format);
		Date date=null;
		 try {
				date = sdFormat.parse(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return date.getTime();
	}
	
}
