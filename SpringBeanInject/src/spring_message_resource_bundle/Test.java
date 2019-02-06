package spring_message_resource_bundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_message_resource_bundle/messageResourceBundle.xml");
        System.out.println(applicationContext.getMessage("hello.message",null, new Locale("mr","np")));
    }
}
