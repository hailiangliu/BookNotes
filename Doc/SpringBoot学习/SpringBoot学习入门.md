#SpringBoot的学习笔记
##application.yml和application.properties
    1.application.yml和application.properties都是SpringBoot的配置文件，都可用#来注释properties的优先级高于yml文件
    2.application.properties文件以“.”分割（后面等号之间不能有空格，注解中通过@Value("${spring.datasource.name}")来获取）
        `server.port=8088
         spring.datasource.name=mydatasource
         spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource
        `
    3.application.yml文件是K-V格式，通过“:”进行赋值(注意：如果属性有值，冒号后面必须有个空格)
        server:
            port: 8088
        spring:
            datasource:
                name: mydatasource
                type: org.apache.tomcat.jdbc.pool.DataSource
##程序中获取自定义配置
    1. application.porperties配置如下：
        connect.timeout=1000
        connect.url=www.baidu.com
        
```java
        //1.1 通过以下方式单独获取各个属性：
         @Value("${connect.timeout}")
         private  String timeout;
         @Value("${connect.url}
         private  String url;
         
         //1.2 也可以定义一个bean
         @ConfigurationProperties(prefix="connect")
         public class ConnectCfgBean{
             private String timeout;
             private String url;
             //省略setter和getter
         }
         
         SpringBoot程序入口处增加
         @EnableConfigurationProperties({ConnectCfgBean.class})
         使用时候直接Autowired
         
```
        
        