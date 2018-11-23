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

	// 1.���÷����ʼ���һЩ����
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
	        String captcha = ""; // ������ɵ���֤��
	        Random random = new Random();
	        for(int i = 0; i < 6; i++) { // ѭ����ÿ����֤���ַ����Ƶ�ͼƬ��
	            int index = random.nextInt(codeChar.length);
	            captcha += codeChar[index];
	        }
	        ActionContext.getContext().getSession().put("yanZhengMa", captcha);
			
			// 2.����һ���Ự������ʼ�����������
			Session session = Session.getDefaultInstance(pro);
			// 3.����һ���ʼ�����
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("1433364718@qq.com")); // ������

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(recipients)); // �ռ���

			message.setSubject("�������˺ż����ʼ�");// �����ʼ��ı���

			message.setContent("�����ڽ����˺ż��������������֤���ǣ�"+captcha+"����Ǳ��˲���������Դ��ʼ�", "text/html;charset=UTF-8");// �����ʼ�������

			message.setSentDate(new Date());// ����ʱ��

			message.saveChanges(); // ��������

			Transport transport = session.getTransport();// ��ȡһ���������

			transport.connect("1433364718@qq.com", "gtremkehidspghbi");// ���÷����ʼ��û�������Ȩ��

			transport.sendMessage(message, message.getAllRecipients());// �����ʼ�

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
