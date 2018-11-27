package cn.haoxiaoyong.email.push.bean;

import java.util.List;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class EmailPattern {

    private Integer tag;              //标记

    private List<String> emails;      //群发邮箱

    private String email;             //单发邮箱

    private Object content;           //发送的内容

    private String subject;           //邮件的主题

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailPattern{" +
                "tag=" + tag +
                ", emails=" + emails +
                ", email='" + email + '\'' +
                ", content=" + content +
                ", subject='" + subject + '\'' +
                '}';
    }

    public EmailPattern(Integer tag, List<String> emails, Object content, String subject) {
        this.tag = tag;
        this.emails = emails;
        this.content = content;
        this.subject = subject;
    }
    public EmailPattern(Integer tag, String email, Object content, String subject) {
        this.tag = tag;
        this.email = email;
        this.content = content;
        this.subject = subject;
    }

    public EmailPattern() {
    }
}
