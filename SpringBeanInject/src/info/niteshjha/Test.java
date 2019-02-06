package info.niteshjha;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String[] args) {

        System.out.println("simple bean factory///////////////////////////////////////////////////////////////////");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("info/niteshjha/helloWorldBean.xml"));
        System.out.println(beanFactory.getBean(HelloWorldBean.class).getMessage());


        System.out.println("application context*****************************************************************");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("info/niteshjha/helloWorldBean.xml");

        System.out.println(applicationContext.getBean(HelloWorldBean.class).getMessage());
    }
}
