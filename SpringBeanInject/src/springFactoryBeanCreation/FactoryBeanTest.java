package springFactoryBeanCreation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springFactoryBeanCreation/FactoryBean.xml");
        System.out.println(applicationContext.getBean("factoryBean",FactoryBean.class).greetPeople("Nitesh"));
    }
}
