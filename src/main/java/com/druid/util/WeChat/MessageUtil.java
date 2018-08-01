package com.druid.util.WeChat;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.druid.dto.Image;
import com.druid.dto.ImageMessage;
import com.druid.dto.News;
import com.druid.dto.NewsMessage;
import com.druid.dto.TextMessage;
import com.thoughtworks.xstream.XStream;






public class MessageUtil {

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	
	
	 
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins;
		try {
			ins = request.getInputStream();
			Document doc;
			
				doc = reader.read(ins);
			
			Element root = doc.getRootElement();
			
			List<Element> list = root.elements();
			
			for(Element e : list){
				map.put(e.getName(), e.getText());
			}
			ins.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return map;
	}


	
	



	
	
	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static  String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		//System.out.print(textMessage);
		return xstream.toXML(textMessage);
	}
	

	

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("关于壹心贷：\n\n");
		sb.append("壹心贷秉承“一心一意，普惠金融”的使命，为社会创造价值，为客户提供更好的服务。");
		sb.append("将专业的信贷管理方法与互联网技术相结合，在完善风险控制的基础上，" +
				"为投资者和借款者搭建一个最高效、最安全、最受尊重的互联网金融服务平台。");
		return sb.toString();
	}
	
	public static String firstMenu1(){
		StringBuffer sb = new StringBuffer();
		sb.append("客服热线：400-8763-118");
		return sb.toString();
	}
	
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎关注壹心贷，正在连线客服，请稍等！");
		return sb.toString();
	}
	
	public static String threeMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("投资年化收益 ：\n\n");
		sb.append("投资者进行投资，获得利息收益，平均年化收益达13%。");

		return sb.toString();
	}
	/**
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
/*	*//**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 *//*
	public static String musicMessageToXml(MusicMessage musicMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}*/
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("壹心贷介绍");
		news.setDescription("壹心贷（yxp2p.com）为江西懿懿投资咨询有限公司旗下专业从事P2P网络借贷平台，平台秉承“一心一意，普惠金融”的使命，将专业的信贷管理方法与互联网技术相结合，在完善的风险控制和信息透明基础上，为投资者和借款者搭建一个最高效、最安全、最受尊重的互联网金融服务平台");
		news.setPicUrl("http://www.yxp2p.com/theme/default/images/getimg.jpg");
		news.setUrl("http://www.yxp2p.com/wxIndex/aboutUs.go");
		
		newsList.add(news);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		return message;
	}
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage1(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("团队介绍");
		news.setDescription("让专业为您的财富增值保驾护航  涂强 董事长，首席执行官（CEO）  壹心贷（江西懿懿投资咨询有限公司）董事长，首席执行官（CEO）,江西财经大学金融科班出身。毕业后就职于世界500强三一重工融资部，担任国内信贷部融资经理，具备扎实的专业知识以及多年的信贷和风控经验。凭其对互联网金融行业敏锐的市场嗅觉与深刻入本的认识，婉拒某融资公司数十万年薪的橄榄枝，义无反顾辞职回到家乡，抢占市场先机，赤心烁烁，金融助赣，打造了南昌本地首家P2P贷款平台，旨在充分发挥金融杠杆对实体经济的助推作用，一心一意普惠江西企业。");
		news.setPicUrl("http://www.yxp2p.com/theme/default/images/0.jpg");
		news.setUrl("http://www.yxp2p.com/catalog/show.action?id=94");
		
		newsList.add(news);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		return message;
	}
	
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}






	public static String fourMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("投资者如何投资：\n\n");
		sb.append("1、注册\n");
		sb.append("2、充值\n");
		sb.append("3、投标\n");
		sb.append("4、获取本息");
		
		
		return sb.toString();
	}

	
	public static String hongbaoMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("亲！请转发活动文章至朋友圈积三个赞，截图发给我，您就可以领取支付宝红包号令，领取红包，快快行动吧！GO  ON!");
	
		
		return sb.toString();
	}

	public static String luwuMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("http://www.yxp2p.com//mobileUser/hongbao.action?user.inviteUserid=shulibao");
	
		
		return sb.toString();
	}

	public static String huodongMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("腾讯信用分开通步骤：1、<a href='http://a.vmall.com/uowap/index.html#/detailApp/C100054011' >请点击链接下载微信定位APP</a>；2、打开APP设置定位地点（广州）；3、登录微信关注“腾讯信用”查信用分");
	
		
		return sb.toString();
	}




	public static String sexMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您对壹心贷的支撑。您可以回复数字1～4获取详情，或者登录壹心贷官网：www.yxp2p.com了解更多。如需帮助，请致电：400-876-3118。");
		return sb.toString();
	}
	
/*	*//**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 *//*
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("WsHCQr1ftJQwmGUGhCP8gZ13a77XVg5Ah_uHPHVEAQuRE5FEjn-DsZJzFZqZFeFk");
		music.setTitle("see you again");
		music.setDescription("速7片尾曲");
		music.setMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
		music.setHQMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
		
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message = musicMessageToXml(musicMessage);
		return message;
	}*/
}
