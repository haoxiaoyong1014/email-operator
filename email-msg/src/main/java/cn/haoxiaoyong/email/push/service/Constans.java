package cn.haoxiaoyong.email.push.service;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface Constans {

    /**
     * 常量
     */
    public static final String SF_FILE_SEPARATOR = System.getProperty("file.separator");

    public static final String SF_LINE_SEPARATOR = System.getProperty("line.separator");

    public static final String SF_PATH_SEPARATOR = System.getProperty("path.separator");

    public static final String SF_SYMBOL_END = "]";

    public static final String SF_SYMBOL_START = "[";

    public static final String MAIL_SMTP_TRUE = "true";

    public static final String MAIL_USER = "mail.user";

    public static final String MAIL_PASS_WORD = "mail.password";

    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    public static final String MAIL_SMTP_HOST = "mail.smtp.host";

    public static final String MAIL_SMTP_PORT = "mail.smtp.port";

    public static final String FK_MAIL_TEMPLATE = "welcome";

    public static final Integer SUCCESS_STATRT = 200;

    public static final String SUCCESS_MSG = "success";

    public static final Integer ERROR_STATRT = 500;

    public static final String ERROR_MSG = "error";

    public static final String ERROR_MESSAGE = "required parameter cannot be empty";
}
