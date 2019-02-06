package spring_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_annotation/spring_annotation.xml");
        Service bean = applicationContext.getBean(Service.class);
        bean.getStudent().forEach(bean::greet);
    }
}
