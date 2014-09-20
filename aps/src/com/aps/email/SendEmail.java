package com.aps.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/****************************************************************
 * 1����QQ����ʹ�ã�����������ʹ�����Ƶ���Ӧ��Ҳ������ˣ�
 * 2�����Ȱ�QQ�����POP3 SMTP��
 * 3������ȷ����������������Ǵ���
 * 4��ȷ�����QQ���俪����SMTP
 * 5�����û�п�������ô����������
 * 6������->�˻� --������-- �����ѡ��    [��]SMTP���ź󱣴浽������ 
 * 7���õ�mail.jar�Ѿ��ŵ���Ŀ���ˣ��ļ�����JAR����Ϳ�����
 ****************************************************************/
public class SendEmail {

	//���÷�����
	private static String KEY_SMTP 		= "mail.smtp.host";
	private static String VALUE_SMTP 	= "smtp.qq.com";
	//��������֤
	private static String KEY_PROPS 	= "mail.smtp.auth";
	private static boolean VALUE_PROPS 	= true;
	//�������û���������
	private String SEND_USER 			= "184172133@qq.com";//���QQ����
	private String SEND_UNAME 			= "184172133";		 //���������
	private String SEND_PWD 			= "b8b6d5feceaf";	 //�����������
	//�����Ự
	private MimeMessage message;
	private Session s;
	
	/*
	 * ��ʼ������
	 * */
	public SendEmail(){
		Properties props = System.getProperties();
		props.setProperty(KEY_SMTP, VALUE_SMTP);
		props.put(KEY_PROPS, VALUE_PROPS);
		s = Session.getInstance(props);
		/*s.setDebug(true);�������е�����Ϣ*/
		message = new MimeMessage(s);  
	}
	
	/**
	 * �����ʼ�
	 * @param headName 		�ʼ�ͷ�ļ���
	 * @param sendHtml 		�ʼ�����
	 * @param receiveUser 	�ռ���184172133@qq.com
	 */
	public void doSendHtmlEmail(String headName,StringBuffer sendHtml,String receiveUser){
		try {
			// ������  
			InternetAddress from = new InternetAddress(SEND_USER);
			message.setFrom(from);  
			// �ռ���  
			InternetAddress to = new InternetAddress(receiveUser);  
			message.setRecipient(Message.RecipientType.TO, to);  
			// �ʼ�����  
			message.setSubject(headName);  
			String content = sendHtml.toString();  
			// �ʼ�����,Ҳ����ʹ���ı�"text/plain"  
			message.setContent(content, "text/html;charset=GBK");  
			message.saveChanges();  
            Transport transport = s.getTransport("smtp");  
            // smtp��֤���������������ʼ��������û�������  
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);  
            // ����  
            transport.sendMessage(message, message.getAllRecipients());  
            transport.close();  
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
	}
	/*//���Է���
	public static void main(String[] args) {
		new SendEmail().doSendHtmlEmail("����", new StringBuffer("�����ʼ�"), "184172133@qq.com");
	}
	*/
}

