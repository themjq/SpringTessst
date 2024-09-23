package com.mjq.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  //标识当前类是配置类(替代配置文件) +@Component注解
@ComponentScan("com.mjq.spring")  //扫描路径下的带有@Component注解的类   可指定多个 使用{"",""}
@PropertySource("classpath:application.properties") //替代标签<context:property-placeholder location="classpath:application.properties"></context:property-placeholder>
public class SpringConfig {
}
