package spring_required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringRequired {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_required/spring_required.xml");
        System.out.println(applicationContext.getBean(Student.class).toString());

    }
}
