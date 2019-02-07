package spring_callback_interface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringCallBackInterface {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring_callback_interface/spring_callback_interface.xml");
        VenueDao bean = classPathXmlApplicationContext.getBean(VenueDao.class);
        bean.CallingConnectionCallBackInterface();
    }
}
