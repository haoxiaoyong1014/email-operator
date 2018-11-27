package cn.haoxiaoyong.email.push.service.impl;

import cn.haoxiaoyong.email.push.bean.EmailBody;
import cn.haoxiaoyong.email.push.service.Constans;
import cn.haoxiaoyong.email.push.service.IMailService;
import cn.haoxiaoyong.email.push.utils.EmailUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Service
public class IMailServiceImpl implements IMailService, Constans {
    @Autowired
    public Configuration configuration;         //freemarker
    @Autowired
    private SpringTemplateEngine templateEngine;//thymeleaf

    public void send(EmailBody mail) throws MessagingException {
        MimeMessage message = EmailUtils.getEmail(mail);
        message.setContent(mail.getContent(), "text/html;charset=UTF-8");
        Transport.send(message);
    }

    public void sendAffix(EmailBody mail) throws MessagingException, IOException {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setText(
                mail.getContent().toString(),
                true);
        File file = ResourceUtils.getFile("classpath:static"
                + SF_FILE_SEPARATOR + "file"
                + SF_FILE_SEPARATOR + "放心签文档.zip");
        helper.addAttachment("放心签", file);
        Transport.send(helper.getMimeMessage());

    }

    public void sendFreemarker(EmailBody mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        Map<String, Object> model = new HashMap<String, Object>();
        String replace = mail.getContent().toString().replace("-", ",");
        String emails = mail.getEmail();
        if (mail.getEmails() != null) {
            emails = mail.getEmails().get(0);
        }
        model.put("email", emails);
        model.put("content", replace);
        Template template = configuration.getTemplate(mail.getTemplate() + ".flt");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, model);
        helper.setText(text, true);
        Transport.send(helper.getMimeMessage());
    }

    public void sendThymeleaf(EmailBody mail) throws MessagingException {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        Context context = new Context();
        context.setVariable("email", mail);
        String text = templateEngine.process(mail.getTemplate(), context);
        helper.setText(text, true);
    }

    public void sengImg(EmailBody mail) throws MessagingException, IOException {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setText(
                "<html><body>美女</br><img src=\"cid:meinv\" ></body></html>",
                true);

        File file = ResourceUtils.getFile("classpath:static"
                + SF_FILE_SEPARATOR + "image"
                + SF_FILE_SEPARATOR + "meinv.jpg");
        helper.addInline("meinv", file);
        Transport.send(helper.getMimeMessage());
    }
}
