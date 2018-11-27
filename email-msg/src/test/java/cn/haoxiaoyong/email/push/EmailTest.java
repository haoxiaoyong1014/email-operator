package cn.haoxiaoyong.email.push;

import cn.haoxiaoyong.email.push.bean.EmailPattern;
import cn.haoxiaoyong.email.push.tool.EmailSend;
import cn.haoxiaoyong.email.push.utils.Base64Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoxy on 2018/11/27.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmailOperatorMain.class})
public class EmailTest {

    @Autowired
    private EmailSend emailSend;

    /**
     * 群发
     * 1:发送freemarker模板
     * 2:发送Thymeleaf模板
     * 3:发送纯文本
     * 4:发送附件
     * 5:发送图片
     * 内容经过base64加密发送
     */
    @Test
    public void testEmailsSend(){
        List<String> list = new ArrayList<String>();
        list.add("hxyHelloWorld@163.com");
        list.add("haoxiaoyong@huluwa.cc");
        EmailPattern emailPattern=new EmailPattern(1,list,Base64Util.encoder("这是邮件内容"),"我是主题");
        String handle = emailSend.handle(emailPattern);
        System.out.println(handle);
    }
    /**
     * 单独发送
     * 1:发送freemarker模板
     * 2:发送Thymeleaf模板
     * 3:发送纯文本
     * 4:发送附件
     * 5:发送图片
     * 内容经过base64加密发送
     */
    @Test
    public void testEmailSend(){
        EmailPattern emailPattern=new EmailPattern(1,"hxyHelloWorld@163.com", Base64Util.encoder("这是邮件内容"),"我是主题");
        String handle = emailSend.handle(emailPattern);
        System.out.println(handle);
    }

}
