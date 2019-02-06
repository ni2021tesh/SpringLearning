package spring_scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringScope {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_scope/spring_scope.xml");

        System.out.println("Container Activated....");

        SingletonBean bean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println(bean1.hashCode());

        SingletonBean bean2 = applicationContext.getBean(SingletonBean.class);
        System.out.println(bean2.hashCode());

        SingletonBean bean3 = applicationContext.getBean(SingletonBean.class);
        System.out.println(bean3.hashCode());

        System.out.println(SingletonBean.getCount());
    }
}
