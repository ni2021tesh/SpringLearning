package spring_property_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionUtilTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring_property_demo/spring_property_demo.xml");
        System.out.println(applicationContext.getBean(ConnectionUtils.class).toString());
    }
}
