package cn.haoxiaoyong.email.push.utils;

import cn.haoxiaoyong.email.push.bean.EmailBody;
import cn.haoxiaoyong.email.push.bean.EmailParams;
import cn.haoxiaoyong.email.push.service.Constans;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;


/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Component
public class EmailUtils implements Constans {

    private static EmailParams emailParams;

    public static MimeMessage getEmail(EmailBody mail) {
        final Properties props = new Properties();                                          // 配置发送邮件的环境属性
        // 表示SMTP发送邮件，需要进行身份验证
        props.put(MAIL_SMTP_AUTH, MAIL_SMTP_TRUE);
        props.put(MAIL_SMTP_HOST, emailParams.getSmtpHost());
        props.put(MAIL_SMTP_PORT, emailParams.getSmtpPort());
        props.put(MAIL_USER, emailParams.getUserName());                                  //发起人账号
        props.put(MAIL_PASS_WORD, emailParams.getPassWord());                              // 访问SMTP服务时需要提供的密码
        Authenticator authenticator = new Authenticator() {                                 // 构建授权信息，用于进行SMTP进行身份验证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty(MAIL_USER);
                String password = props.getProperty(MAIL_PASS_WORD);
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);                    // 使用环境属性和授权信息，创建邮件会话
        MimeMessage message = new MimeMessage(mailSession);                                 // 创建邮件消息
        InternetAddress from = null;                                                        // 设置发件人
        try {
            from = new InternetAddress(emailParams.getUserName());
            message.setFrom(from);
            if (mail.getEmails()==null) {
                Address[] to = new InternetAddress[] {
                        new InternetAddress(mail.getEmail())
                };
                message.setRecipient(MimeMessage.RecipientType.TO, to[0]);  //单独发送
                message.setSubject(mail.getSubject());
                return message;
            }
            List<String> emails = mail.getEmails();
            Address[] a = new Address[emails.size()];
            for (int i = 0; i < emails.size(); i++) {
                String replace = emails.get(i).replace(SF_SYMBOL_START, "").replace(SF_SYMBOL_END, "");
                a[i] = new InternetAddress(replace);
            }
            message.addRecipients(MimeMessage.RecipientType.TO, a);//群发
            message.setSubject(mail.getSubject());
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static EmailParams getEmailParams() {
        return emailParams;
    }

    @Resource
    public void setEmailParams(EmailParams emailParams) {
        EmailUtils.emailParams = emailParams;
    }
}