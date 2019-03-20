package springFactoryBeanCreation;

import org.springframework.beans.factory.annotation.Autowired;

public class FactoryBean {

    private static FactoryBean FACTORY_BEAN = null;

    @Autowired
    private FactorySecondBean factorySecondBean;

    private FactoryBean() {
        System.out.println("Private Constructor called...");
    }


    public String greetPeople(String name) {
        return factorySecondBean.greet(name);
    }


    public void setFactorySecondBean(FactorySecondBean factorySecondBean) {
        this.factorySecondBean = factorySecondBean;
    }

    public FactoryBean getInstance() {
        System.out.println("GetInstance Method called.");
        if (FACTORY_BEAN == null) {
            FACTORY_BEAN = new FactoryBean();
            return FACTORY_BEAN;
        }
        return FACTORY_BEAN;
    }
}
