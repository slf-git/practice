 Properties props = new Properties();//key value:���ò��������������ʼ�ʱ������
        props.setProperty("mail.transport.protocol", "smtp");//ָ���ʼ����͵�Э�飬�����ǹ淶�涨��
        props.setProperty("mail.host", "smtp.163.com");//ָ�������������ĵ�ַ�������ǹ淶�涨��
//        props.setProperty("mail.debug", "true");//�ʼ����͵ĵ���ģʽ�������ǹ淶�涨��
        props.setProperty("mail.smtp.auth", "true");//������������������֤������������JavaMailʵ���й�
        
        Session session = Session.getInstance(props);//�����ʼ�ʱʹ�õĻ�������
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        
        //�����ʼ���ͷ
        message.setFrom(new InternetAddress("xxx@163.com"));
        message.setRecipients(Message.RecipientType.TO, "xxx@qq.com");
        message.setSubject("This is second message");
        //��������
        message.setContent("<h1>hello</h1>", "text/html");
//        message.setText("<h1>hello</h1>");//���ı�
        
        message.saveChanges();
        
        //�����ʼ�
        Transport ts = session.getTransport();
        ts.connect("xxx@163.com", "123456");       // ����Ϊ��Ȩ�벻������ĵ�¼����
        ts.sendMessage(message, message.getAllRecipients());//������ʵ������}
    }
}








������ 16:07:30
<dependency>
  <groupId>javax.mail</groupId>
  <artifactId>mail</artifactId>
  <version>1.4.5</version>
</dependency>
������ 16:07:54
 Properties props = new Properties();//key value:���ò��������������ʼ�ʱ������
        props.setProperty("mail.transport.protocol", "smtp");//ָ���ʼ����͵�Э�飬�����ǹ淶�涨��
        props.setProperty("mail.host", "smtp.163.com");//ָ�������������ĵ�ַ�������ǹ淶�涨��
//        props.setProperty("mail.debug", "true");//�ʼ����͵ĵ���ģʽ�������ǹ淶�涨��
        props.setProperty("mail.smtp.auth", "true");//������������������֤������������JavaMailʵ���й�

        Session session = Session.getInstance(props);//�����ʼ�ʱʹ�õĻ�������
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        //�����ʼ���ͷ
        message.setFrom(new InternetAddress("xxx@163.com"));
        message.setRecipients(Message.RecipientType.TO, "xxx@qq.com");
        message.setSubject("This is second message");
        //��������
        message.setContent("<h1>hello</h1>", "text/html");
//        message.setText("<h1>hello</h1>");//���ı�

        message.saveChanges();

        //�����ʼ�
        Transport ts = session.getTransport();
        ts.connect("xxx@163.com", "123456");       // ����Ϊ��Ȩ�벻������ĵ�¼����
        ts.sendMessage(message, message.getAllRecipients());//������ʵ������}
		
		
		
		
		
		����Ϊ�� 16:39:19
package com.baizhi.kafaka.kafka;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by admin on 2018/6/24.
 */
public class SendMail {
    public SendMail(){
        //������ǰ��׼������  Ҳ���ǲ�����ʼ��
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");//�������������
        properties.setProperty("mail.smtp.port","465");//���Ͷ˿�
        properties.setProperty("mail.smtp.auth","true");//�Ƿ���Ȩ�޿���
        properties.setProperty("mail.debug","true");//true ��ӡ��Ϣ������̨
        properties.setProperty("mail.transport","smtp");//���͵�Э���Ǽ򵥵��ʼ�����Э��
        properties.setProperty("mail.smtp.ssl.enable","true");
        //��������֮�������
        System.out.println("ִ����2");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1290315551@qq.com","zraquwqtxvvhfgda");
            }
        });
        System.out.println("ִ����3");
        //�����ʼ�����
        Message message = new MimeMessage(session);
        //���÷�����
        try {
            message.setFrom(new InternetAddress("1290315551@qq.com"));

            //�����ռ���
            message.setRecipient(Message.RecipientType.TO,new InternetAddress("1290315551@qq.com"));//�ռ���
            //��������
            message.setSubject("zraquwqtxvvhfgda");
            //�����ʼ�����  �ڶ����������ʼ����͵�����
            message.setContent("2569658","text/html;charset=UTF-8");
            //����һ���ʼ�
            Transport transport = session.getTransport();
            transport.connect("1290315551@qq.com","zraquwqtxvvhfgda");
            Transport.send(message);
            System.out.println("ִ����");
        } catch (MessagingException e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static void main(String[] args) {
        System.out.println("ִ����1");
        SendMail SendMail = new SendMail();
    }
}

