package cn.haoxiaoyong.email.push.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by haoxy on 2018/11/26.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class Base64Util {

    public static String encoder(String text) {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            byte[] textBytes = text.getBytes("UTF-8");
            return encoder.encode(textBytes).replaceAll("\\s","").replace("+","===");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decoder(String text){
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            text = text.replace("===","+");
            return new String(decoder.decodeBuffer(text),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}