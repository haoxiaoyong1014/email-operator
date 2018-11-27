package cn.haoxiaoyong.email.push.config;

import cn.haoxiaoyong.email.push.bean.EmailParams;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Configuration
public class EmailOperatorConfig {

    @Bean
    @ConfigurationProperties(prefix = "com.haoxy.email")
    public EmailParams emailParams(){
       EmailParams emailParams=new EmailParams();
       emailParams.setSmtpPort(80);
       emailParams.setSmtpHost("smtpdm.aliyun.com");
       return emailParams;
    }
}
