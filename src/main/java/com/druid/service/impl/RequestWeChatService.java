package com.druid.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RequestWeChatService {
	private static final String appid = "wx42012cdc6b36bfbd";
	private static final String secret = "9c576853bb0aebf1ed04489fc4184eea";
	private static final String grantType = "client_credential";
	public void centralControl(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url="https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type="+grantType+""
				+ "&appid="+appid+""
				+ "&secret="+secret+"";
		String testUrl ="https://9c221226.ngrok.io/ssm_druid/novelCrawler/getCrawlStatus.control";
		JSONObject  json = new JSONObject ();
		
		json = new JSONObject (getURLContent(url));
		
		System.out.println(json.get("count"));
		
		
	}
	
	
	/**
	 * 程序中访问http数据接口（获取微信返回的access_token）
	 */
	public static String getURLContent(String urlStr) {
		/** 网络的url地址 */
		URL url = null;
		/** http连接 */
		//HttpURLConnection httpConn = null;
		/**//** 输入流 */
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		System.out.println(result);
		return result;
	}

}
