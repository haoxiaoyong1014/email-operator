package cn.haoxiaoyong.email.push.bean;

import java.io.Serializable;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class EmailBody extends EmailPattern implements Serializable {

    private static final long serialVersionUID = 6966414922270378255L;

    private String template;//模板

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
