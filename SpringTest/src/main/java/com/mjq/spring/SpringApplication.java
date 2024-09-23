package com.mjq.spring;

import com.mjq.spring.config.SpringConfig;
import com.mjq.spring.dao.AdminDao;
import com.mjq.spring.dao.UserDao;
import com.mjq.spring.service.AdminService;
import com.mjq.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan("com.mjq.spring")
public class SpringApplication {
    public static void main(String[] args) {
        //这里有两个工厂类可以用来获取Bean对象
        //1.1 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //1.2 创建读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //1.3 加载配置(xml)文件
        reader.loadBeanDefinitions("SpringBeans.xml");
        //1.4 获取bean对象
        UserService userServiceBean1 = (UserService) beanFactory.getBean("userServiceBean");
        System.out.println("BeanFactory工厂:\t"+userServiceBean1);

        //2.1 创建ApplicationContext          //ApplicationContext工厂xml命名默认为applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        UserService userServiceBean2 = (UserService) context.getBean("userServiceBean");
        System.out.println("ApplicationContext工厂:\t"+userServiceBean2);

        System.out.println("\n分界线:静态工厂方式实例化Bean");
        UserDao userDaoBeanStatic = (UserDao) context.getBean("userDaoBeanStatic");
        System.out.println(userDaoBeanStatic);

        System.out.println("\n分界线:实例工厂方式实例化Bean");
        UserDao userDaoBeanMeta = (UserDao) context.getBean("userDaoBeanMeta");
        System.out.println(userDaoBeanMeta);

        System.out.println("\n分界线:FactoryBean方式实例化Bean");
        UserDao myFactoryBean = (UserDao) context.getBean("myFactoryBean");
        System.out.println(myFactoryBean);

        System.out.println("\n分界线:下面为注解替代XML配置");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AdminDao adminDao=(AdminDao) applicationContext.getBean("adminDaoBean");
        System.out.println(adminDao);

        AdminService adminService= (AdminService) applicationContext.getBean("adminService");
        System.out.println("adminServiceBean:"+adminService);
        adminService.test();
        System.out.println("\nadminDao中test()方法");adminDao.test();
    }
}
