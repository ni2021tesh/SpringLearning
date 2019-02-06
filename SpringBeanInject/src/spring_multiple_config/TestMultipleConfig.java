package spring_multiple_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleConfig {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_multiple_config/configMain.xml");
        Service bean = applicationContext.getBean(Service.class);
        bean.display();
        System.out.println(bean.greet("Nitesh Jha"));
        System.out.println(bean.getStudent("4"));
    }
}
