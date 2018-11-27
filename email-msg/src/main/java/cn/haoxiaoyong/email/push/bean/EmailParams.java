package cn.haoxiaoyong.email.push.bean;

import org.springframework.stereotype.Component;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Component
public class EmailParams {

    private String smtpHost;

    private Integer smtpPort;

    private String userName;

    private String passWord;

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "EmailParams{" +
                "smtpHost='" + smtpHost + '\'' +
                ", smtpPort=" + smtpPort +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

}
