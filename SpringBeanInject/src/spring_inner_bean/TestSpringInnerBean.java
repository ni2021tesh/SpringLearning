package spring_inner_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestSpringInnerBean {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_inner_bean/spring_inner_beanb.xml");

        System.out.println(applicationContext.getBean("student",Student.class).toString());
        System.out.println(applicationContext.getBean("nitesh",Student.class).toString());
        System.out.println(applicationContext.getBean("jha",Student.class).toString());
        System.out.println(applicationContext.getBean("surendra",Student.class).toString());
        System.out.println(applicationContext.getBean("himanshu",Student.class).toString());

        Arrays.stream(applicationContext.getAliases("student")).forEach(System.out::println);

    }
}
