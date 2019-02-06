package spring_lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_lifeCycle/spring_life_cycle.xml");
        System.out.println(context.getBean(LifeCycle.class).getMessage());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
