package spring_lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class LifeCycle implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware {

    private BeanFactory beanFactory;
    private String name;

    public LifeCycle() {
        System.out.println("No-Arg cons....");
    }

    private String message;

    public String getMessage() {
       System.out.println("Bean Factory Object is ::" + beanFactory);
      //  System.out.println("Bean Name is ::" + name);
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Setter method called..");
        System.out.println(message);
        this.message = message;
    }


    public void destry() throws Exception {
        System.out.println("Destroy method called..");
    }

    public void init() throws Exception {
        System.out.println("initialize bean called");
    }

    /*@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        
    }
*/

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory aware");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanmNameAware");
        System.out.println(name);
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
