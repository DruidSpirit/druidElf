package com.druid.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.druid.service.impl.RequestWeChatService;
import com.druid.util.WeChat.CheckUtil;
import com.druid.util.WeChat.MessageUtil;



@Controller
@Scope("prototype")
public class FromWeChatServer {
	
	@Autowired
	private RequestWeChatService requestWeChatService;
	@RequestMapping(value="/weixintest")
	public String requestWeChat(HttpServletRequest request,HttpServletResponse response) throws IOException{
		requestWeChatService.centralControl(request, response);
		return null;
		
	}
	
	@RequestMapping(value="/fromWeChatServer/toStart.control")
	public String executeForWeChat(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 接收参数微信加密签名、 时间戳、随机数
				String signature = request.getParameter("signature");
				String timestamp = request.getParameter("timestamp");
				String nonce = request.getParameter("nonce");
				// 随机字符串
				String echostr = request.getParameter("echostr");
				// System.out.println(signature+"111");
				PrintWriter out = response.getWriter();
				// 请求校验
				if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
					String method = request.getMethod();
					if (method.equals("POST")) {
						// 调用核心服务类接收处理请求
						String respXml = weixinPost(request);
						System.out.println("测试"+respXml);
						out.print(respXml);
					} else {
						out.print(echostr);
					}
				}
				out.close();
				out = null;
				return null;
	}
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String weixinPost(HttpServletRequest request) {

		String message = null;
		try {

			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("" + "FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				if ("1".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.firstMenu());
				} else if ("2".equals(content)) {
					message = MessageUtil.initNewsMessage(toUserName,
							fromUserName);
				} else if ("3".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.threeMenu());
				}else if ("4".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.fourMenu());
				}else if ("红包".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.hongbaoMenu());
				} else if ("?".equals(content) || "？".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.sexMenu());
				} else if (content.startsWith("翻译")) {
					String word = content.replaceAll("^翻译", "").trim();
					if ("".equals(word)) {
						message = MessageUtil.initText(toUserName,
								fromUserName, MessageUtil.threeMenu());
					} else {
						// message = MessageUtil.initText(toUserName,
						// fromUserName, WeixinUtil.translate(word));
					}
				}
			} else if (MessageUtil.MESSAGE_EVNET.equals(msgType)) {
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							menuText(fromUserName));
				} else if (eventType.equals(MessageUtil.MESSAGE_CLICK)) {
					String eventKey = map.get("EventKey");
					if (eventKey.equals("Ledger")) {
						message = MessageUtil.initText(toUserName,
								fromUserName, menuText(fromUserName));
					}

					else if (eventKey.equals("company")) {
						message = MessageUtil.initNewsMessage(toUserName,
								fromUserName);
					} else if (eventKey.equals("manage")) {
						message = MessageUtil.initNewsMessage1(toUserName,
								fromUserName);
					}
					else if (eventKey.equals("hotline")) {
						message = MessageUtil.initText(toUserName, fromUserName,
								MessageUtil.firstMenu1());
					}
					
				} else if (MessageUtil.MESSAGE_VIEW.equals(eventType)) {
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName,
							url);
				} else if (MessageUtil.MESSAGE_SCANCODE.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName,
							key);
				}
			} else if (MessageUtil.MESSAGE_LOCATION.equals(msgType)) {
				String label = map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, label);
			}
			System.out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}

	/**
	 * 主菜单
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public String menuText(String fromUserName) {
		//user = userService.findByUnique("wechatOpenId", fromUserName);
		//if (user == null) {
			StringBuffer sb = new StringBuffer();
			sb.append("欢迎您的关注壹心贷！已有壹心贷账号，");
			sb.append("<a href='http://www.jxyh.yxp2p.com/weixinLog/loginPage.action?wechatOpenId="
					+ fromUserName + "'>请点击这里</a>。");
			sb.append("新用户<a href='http://www.jxyh.yxp2p.com/mobileRegister/toRegister.action?wechatOpenId="
					+ fromUserName + "'>请点击这里</a>");
			sb.append("注册并绑定。");
			//return sb.toString();
		//}
/*
		else {
			user = userService.findByUnique("userId", user.getUserId());
			account = accountService.findByUnique("userId", user.getUserId());
			userAccount = accountService.getUserAccount(user.getUserId());
			userBorrow = borrowService.getUserBorrow(user.getUserId());
			
			StringBuffer sb = new StringBuffer(); 	
			sb.append("我的账户:\n\n");
			sb.append(DateUtils.timestamp2Time(System.currentTimeMillis(),"yyyy-MM-dd"));
			sb.append("截止昨天，你的账户摘要如下：\n\n");
			sb.append("账户总额:" + account.getTotal() + "\n");
			sb.append("可用金额:" + account.getUseMoney() + "\n");
			sb.append("冻结金额:" + account.getNoUseMoney() + "\n");
			sb.append("理财账户:\n");
			sb.append("已赚总额:" + userAccount.getInterestYes() + "\n");
			sb.append("待收总额:" + account.getCollection() + "\n");
			sb.append("待收利息:" + userAccount.getInterestWait() + "\n");
			sb.append("最近待收金额:"+userAccount.getNearAccountWait()+"\n");
			sb.append("最近待收时间:"+DateUtils.timestamp2Time(userAccount.getNearTimeWait(),"yyyy-MM-dd")+"" +"\n\n");
			sb.append("借款账户:\n");
			sb.append("借款总额:" + userBorrow.getTotalBorrow() + "\n");
			sb.append("待还总额:" + userBorrow.getTotalBorrowWait() + "\n");
			sb.append("最近待还金额:" + userBorrow.getNearBorrwoWait() + "\n");
			if (userBorrow.getNearTimeBorrow() == null) {
				sb.append("最近待还时间:\n");
			} else {
				sb.append("最近待还时间:"+(DateUtils.timestamp2Time(userBorrow.getNearTimeBorrow(),"yyyy-MM-dd"))+"\n");
			}*/

			sb.append("温馨提示：点击“<a href='http://www.yxp2p.com/mobileIndex/index.action?wechatOpenId="
					+ fromUserName + "'>全文</a>”更多精彩等的您");
			return sb.toString();

		//}

	}
}
