package cn.haoxiaoyong.email.push.annotation;

import cn.haoxiaoyong.email.push.EmailOperatorMain;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by haoxy on 2018/12/13.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({EmailOperatorMain.class})
public @interface MyEmailOperatorMain {
}
