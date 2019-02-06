package spring_bean_defination_inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDefinationInheritanceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_bean_defination_inheritance/spring_bean_defination_inheritance.xml");


        Car marutiCar = applicationContext.getBean("marutiCar", Car.class);
        System.out.println(marutiCar);

        System.out.println(applicationContext.getBean("nano",Car.class).toString());

        System.out.println(applicationContext.getBean("mar800",Car.class).toString());

    }
}
