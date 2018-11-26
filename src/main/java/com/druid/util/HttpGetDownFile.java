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
	 * �õ��ļ���ַ�������ļ�(�Ѿ��������������ַ)
	 * @param src
	 * @param imageFileName �����ļ��Ĵ����ַ(�����·�����ư����ļ��������׺)
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
	 * �����������ӣ�����ض��������а��������ַ����Ⲣ���ش洢�ļ�
	 * @param src
	 * @param imageFileName �����ļ��Ĵ����ַ(������ļ����Ʋ������ļ���)
	 * @throws IOException
	 */
	public static boolean filterLinkAndDownloadAndSave(String link,String storageAddress) throws IOException{
		

		Connection request = Jsoup.connect(link).referrer(link)
				.userAgent(UrlAboutNovelEnums.UserAgent7.getUrl())
				.timeout(5*60000)//����ʱʱ������
				.maxBodySize(1024*1024*20)//�õ����ļ����ֵ20M
				.ignoreContentType(true)//���Է�����������
				.followRedirects(false);//�������ض���
		
		Response req = request.execute();//��ʼִ��(������վ������)
		
		String location = req.header("Location");
		if(location==null) location = link;
		URL redir = StringUtil.resolve(req.url(), location);//ȡ����������������������
		
		//�õ����ӵĺ�׺���Ƽ��ļ�����
		String[] url = redir.toString().split("");//
		String names[] = redir.toString().split("/");
		String names2[] = link.split("/");
		String fileName = names[names.length-1];//�ļ�����
		String fileName2 = names2[names.length-1];//�ļ�����
		String resultUrl = "";
		
		//�������г��ֵ������ַ�����ɸѡ
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		for (String string : url) {
			Matcher matcher = pat.matcher(string);
			if(matcher.find()) string = URLEncoder.encode(string, "utf-8");
			resultUrl += string;
		}
		
		/*byte[] imgdata = request.bodyAsBytes();
					
		FileUtils.writeByteArrayToFile(new File(imageFileName), imgdata);*/
		//String timeName = (new DateTime().toLocalDateTime().toString("yyyy��MM��dd��hh��mm��ss��"))+ fileName;//���ݵ�ǰʱ��ϳɵ��ļ���		
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
