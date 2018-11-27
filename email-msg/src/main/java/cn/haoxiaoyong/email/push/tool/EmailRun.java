package cn.haoxiaoyong.email.push.tool;

import cn.haoxiaoyong.email.push.bean.EmailBody;
import cn.haoxiaoyong.email.push.bean.EmailPattern;
import cn.haoxiaoyong.email.push.service.Constans;
import cn.haoxiaoyong.email.push.service.IMailService;
import cn.haoxiaoyong.email.push.utils.Base64Util;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Component
public class EmailRun implements Constans {
    @Autowired
    private IMailService mailService;

    private static EmailRun emailRun;

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    @PostConstruct
    public void init() {
        emailRun = this;
        emailRun.mailService = this.mailService;
    }

    public void start(EmailPattern emailPattern) throws MessagingException, IOException, TemplateException {

        EmailBody mail = new EmailBody();
        mail.setTemplate(FK_MAIL_TEMPLATE);                   //模板
        mail.setEmail(emailPattern.getEmail());
        if (emailPattern.getEmails() != null) {
            mail.setEmails(emailPattern.getEmails());         //邮箱
        }
        mail.setTag(emailPattern.getTag());                   //标记
        String content = (String) emailPattern.getContent();
        mail.setContent(Base64Util.decoder(content));
        mail.setSubject(emailPattern.getSubject());           //标题
        Integer code = mail.getTag();

        switch (code) {
            case 1:
                //调用发送freemarker模板
                emailRun.mailService.sendFreemarker(mail);
                return;
            case 2:
                //调用Thymeleaf模板
                emailRun.mailService.sendThymeleaf(mail);
                return;
            case 3:
                //调用纯文本文件
                emailRun.mailService.send(mail);
                return;
            case 4:
                //调用发送附件
                emailRun.mailService.sendAffix(mail);
                return;
            case 5:
                //调用发送图片模板
                emailRun.mailService.sengImg(mail);
                break;
            default:
                return;
        }

    }

}
