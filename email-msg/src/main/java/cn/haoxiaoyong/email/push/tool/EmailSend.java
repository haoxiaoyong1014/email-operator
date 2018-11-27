package cn.haoxiaoyong.email.push.tool;

import cn.haoxiaoyong.email.push.bean.EmailPattern;
import cn.haoxiaoyong.email.push.bean.RespInfo;
import cn.haoxiaoyong.email.push.service.Constans;
import com.alibaba.fastjson.JSON;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;


/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Component
public class EmailSend implements Constans {

    @Autowired
    private EmailRun emailRun;

    public String handle(EmailPattern emailPattern) {

        if (emailPattern.getContent() != null
                && emailPattern.getSubject() != null
                && emailPattern.getTag() != null) {
            try {
                emailRun.start(emailPattern);
                return JSON.toJSONString(new RespInfo(SUCCESS_STATRT, SUCCESS_MSG));
            } catch (MessagingException me) {
                me.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            } catch (TemplateException te) {
                te.printStackTrace();
            }
        } else {
            return JSON.toJSONString(new RespInfo(ERROR_STATRT, ERROR_MESSAGE));
        }
        return JSON.toJSONString(new RespInfo(ERROR_STATRT, ERROR_MSG));
    }

}
