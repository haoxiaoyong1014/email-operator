### springboot2-email-operator

#### 阿里邮件推送服务

**支持类型:**

    * 纯文本
    
    * 附件
    
    * 图片
    
    * freemarker模板
    
    * thymeleaf模板
    
**使用方式**

* 引入 maven 依赖

```
        <dependency>
           <groupId>cn.haoxiaoyong.ocr.email</groupId>
           <artifactId>email-msg</artifactId>
           <version>v1.0</version>
        </dependency> 
```
 
* 在SpringBoot启动类上通过注解引入Main Class
  
          @Import({
                  EmailOperatorMain.class
          })  
 
* 配置app key

        com:
          haoxy:
            email:
              user-name:
              pass-word:
 
* 使用 


        @Autowired
        private EmailSend emailSend;   
        
        //群发
        List<String> list = new ArrayList<String>();
        ist.add("hxxxxloWorld@163.com");
        list.add("hxxxyong@huluwa.cc");
        EmailPattern emailPattern=new EmailPattern(1,list,Base64Util.encoder("这是邮件内容"),"我是主题");
        String handle = emailSend.handle(emailPattern);   
        
        //单独发送
        EmailPattern emailPattern=new EmailPattern(1,"hxxxxloWorld@163.com",Base64Util.encoder("这是邮件内容"),"我是主题");
        String handle = emailSend.handle(emailPattern); 
        
        
* 返回结果   

    
    成功: 
    
        {"content":"success","status":200}    
    
    
    失败:
    
        情况一:
    
            {"content":"error","status":500}  
       
        情况二:
        
            {"content":"required parameter cannot be empty","status":500}
            
* 使用注意 

    * 对必要参数进行说明:
        
        EmailPattern对象中参数说明:
        
             tag: 发送什么样的数据,例如 1:freemarker模板,2: Thymeleaf模板,3: 发送纯文本,4,发送附件等等...
             emails: 群发邮件时的必要参数邮箱,集合形式  
             email:  单独发送时的邮箱,字符串形式
             content: 发送的内容,需要经过 base64加密
             subject: 邮件的主题  