package spring_lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization called..");
        if (bean instanceof LifeCycle) {
            ((LifeCycle) bean).setMessage("This is the new message configured from postProcessBeforeInitialization");
            return bean;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization called..");
        if (bean instanceof LifeCycle) {
            ((LifeCycle) bean).setMessage("This is the new message configured from postProcessAfterInitialization");
            return bean;
        }
        return bean;
    }
}
