package com.baizhi.util;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionContext;

public class MailUtil {

	// 1.设置发送邮件的一些参数
	private static Properties pro = new Properties();

	static {
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.host", "smtp.qq.com");
		pro.setProperty("mail.smtp.auth", "true");
		pro.setProperty("mail.smtp.port", "587");
	}

	public static int sendSimpleMail(String recipients) {
		int res = 0;
		try {
			char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
	        String captcha = ""; // 存放生成的验证码
	        Random random = new Random();
	        for(int i = 0; i < 6; i++) { // 循环将每个验证码字符绘制到图片上
	            int index = random.nextInt(codeChar.length);
	            captcha += codeChar[index];
	        }
	        ActionContext.getContext().getSession().put("yanZhengMa", captcha);
			
			// 2.创建一个会话对象和邮件服务器交互
			Session session = Session.getDefaultInstance(pro);
			// 3.创建一个邮件对象
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("1433364718@qq.com")); // 发送人

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(recipients)); // 收件人

			message.setSubject("当当网账号激活邮件");// 设置邮件的标题

			message.setContent("你正在进行账号激活操作，您的验证码是："+captcha+"。如非本人操作，请忽略此邮件", "text/html;charset=UTF-8");// 设置邮件的正文

			message.setSentDate(new Date());// 发送时间

			message.saveChanges(); // 保存设置

			Transport transport = session.getTransport();// 获取一个传输对象

			transport.connect("1433364718@qq.com", "gtremkehidspghbi");// 设置发送邮件用户名和授权码

			transport.sendMessage(message, message.getAllRecipients());// 发送邮件

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
