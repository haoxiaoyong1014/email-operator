package cn.haoxiaoyong.email.push.service;

import cn.haoxiaoyong.email.push.bean.EmailBody;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface IMailService {

    /**
     * 纯文本
     *
     * @param mail
     * @throws Exception void
     * @Author 放心签
     * @Date 2018年1月25日
     */
     void send(EmailBody mail) throws MessagingException;

    /**
     * 附件
     * @param mail
     * @throws Exception void
     * @Author 放心签
     * @Date 2018年1月25日
     */
    void sendAffix(EmailBody mail)throws MessagingException, IOException;

    /**
     * freemarker
     * @Author 放心签
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
     void sendFreemarker(EmailBody mail)throws MessagingException, IOException, TemplateException;

    /**
     * thymeleaf
     * @Author 放心签
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
     void sendThymeleaf(EmailBody mail)throws MessagingException;

    /**
     *  图片
     * @Author 放心签
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
     void sengImg(EmailBody mail) throws MessagingException, IOException;
}
