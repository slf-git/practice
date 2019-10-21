 Properties props = new Properties();//key value:配置参数。真正发送邮件时再配置
        props.setProperty("mail.transport.protocol", "smtp");//指定邮件发送的协议，参数是规范规定的
        props.setProperty("mail.host", "smtp.163.com");//指定发件服务器的地址，参数是规范规定的
//        props.setProperty("mail.debug", "true");//邮件发送的调试模式，参数是规范规定的
        props.setProperty("mail.smtp.auth", "true");//请求服务器进行身份认证。参数与具体的JavaMail实现有关
        
        Session session = Session.getInstance(props);//发送邮件时使用的环境配置
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        
        //设置邮件的头
        message.setFrom(new InternetAddress("xxx@163.com"));
        message.setRecipients(Message.RecipientType.TO, "xxx@qq.com");
        message.setSubject("This is second message");
        //设置正文
        message.setContent("<h1>hello</h1>", "text/html");
//        message.setText("<h1>hello</h1>");//纯文本
        
        message.saveChanges();
        
        //发送邮件
        Transport ts = session.getTransport();
        ts.connect("xxx@163.com", "123456");       // 密码为授权码不是邮箱的登录密码
        ts.sendMessage(message, message.getAllRecipients());//对象，用实例方法}
    }
}








康江涛 16:07:30
<dependency>
  <groupId>javax.mail</groupId>
  <artifactId>mail</artifactId>
  <version>1.4.5</version>
</dependency>
康江涛 16:07:54
 Properties props = new Properties();//key value:配置参数。真正发送邮件时再配置
        props.setProperty("mail.transport.protocol", "smtp");//指定邮件发送的协议，参数是规范规定的
        props.setProperty("mail.host", "smtp.163.com");//指定发件服务器的地址，参数是规范规定的
//        props.setProperty("mail.debug", "true");//邮件发送的调试模式，参数是规范规定的
        props.setProperty("mail.smtp.auth", "true");//请求服务器进行身份认证。参数与具体的JavaMail实现有关

        Session session = Session.getInstance(props);//发送邮件时使用的环境配置
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        //设置邮件的头
        message.setFrom(new InternetAddress("xxx@163.com"));
        message.setRecipients(Message.RecipientType.TO, "xxx@qq.com");
        message.setSubject("This is second message");
        //设置正文
        message.setContent("<h1>hello</h1>", "text/html");
//        message.setText("<h1>hello</h1>");//纯文本

        message.saveChanges();

        //发送邮件
        Transport ts = session.getTransport();
        ts.connect("xxx@163.com", "123456");       // 密码为授权码不是邮箱的登录密码
        ts.sendMessage(message, message.getAllRecipients());//对象，用实例方法}
		
		
		
		
		
		左右为男 16:39:19
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
        //做链接前的准备工作  也就是参数初始化
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");//发送邮箱服务器
        properties.setProperty("mail.smtp.port","465");//发送端口
        properties.setProperty("mail.smtp.auth","true");//是否开启权限控制
        properties.setProperty("mail.debug","true");//true 打印信息到控制台
        properties.setProperty("mail.transport","smtp");//发送的协议是简单的邮件传输协议
        properties.setProperty("mail.smtp.ssl.enable","true");
        //建立两点之间的链接
        System.out.println("执行了2");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1290315551@qq.com","zraquwqtxvvhfgda");
            }
        });
        System.out.println("执行了3");
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress("1290315551@qq.com"));

            //设置收件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress("1290315551@qq.com"));//收件人
            //设置主题
            message.setSubject("zraquwqtxvvhfgda");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent("2569658","text/html;charset=UTF-8");
            //发送一封邮件
            Transport transport = session.getTransport();
            transport.connect("1290315551@qq.com","zraquwqtxvvhfgda");
            Transport.send(message);
            System.out.println("执行了");
        } catch (MessagingException e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static void main(String[] args) {
        System.out.println("执行了1");
        SendMail SendMail = new SendMail();
    }
}

