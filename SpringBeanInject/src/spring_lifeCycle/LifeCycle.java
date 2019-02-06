package spring_lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle implements BeanFactoryAware, BeanNameAware {

    private BeanFactory beanFactory;
    private String name;

    public LifeCycle() {
        System.out.println("No-Arg cons....");
    }

    private String message;

    public String getMessage() {
        System.out.println("Bean Factory Object is ::" + beanFactory);
        System.out.println("Bean Name is ::" + name);
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Setter method called..");
        this.message = message;
    }


    public void destroy() throws Exception {
        System.out.println("Destroy method called..");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("initialize bean called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SetBeanFactory called.");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SetBeanName called.");
        this.name = name;
    }
}
