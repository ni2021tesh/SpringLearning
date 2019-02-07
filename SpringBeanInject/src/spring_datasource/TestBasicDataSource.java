package spring_datasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBasicDataSource {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring_datasource/spring_datasource.xml");
        VenueDao bean = classPathXmlApplicationContext.getBean(VenueDao.class);
        bean.CallingConnectionCallBackInterface();
    }
}
