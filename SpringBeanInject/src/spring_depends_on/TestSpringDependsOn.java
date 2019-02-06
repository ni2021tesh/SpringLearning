package spring_depends_on;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestSpringDependsOn {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_depends_on/Spring_depends_on.xml");

        System.out.println(applicationContext.getBean("student", Student.class).toString());

        Arrays.stream(applicationContext.getAliases("student")).forEach(System.out::println);

    }
}
