package cn.haoxiaoyong.email.push;

import cn.haoxiaoyong.email.push.config.EmailOperatorConfig;
import cn.haoxiaoyong.email.push.tool.EmailRun;
import cn.haoxiaoyong.email.push.tool.EmailSend;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@EnableAutoConfiguration
@Configuration
@Import({EmailOperatorConfig.class})
@ComponentScan(value = "cn.haoxiaoyong.email")
@PropertySources(@PropertySource("classpath:/application.properties"))
public class EmailOperatorMain {

    @Bean
    public EmailSend emailSend(){
        return new EmailSend();
    }
    @Bean
    public EmailRun emailRun(){
        return new EmailRun();
    }
}
