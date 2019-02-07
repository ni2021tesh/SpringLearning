package spring_named_parameter_jdbc_dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNamedParameterJdbcDao {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_named_parameter_jdbc_dao/spring_named_parameter_jdbc_dao.xml");
        VenueDao venueDao = applicationContext.getBean(VenueDao.class);
        Venue venue = new Venue("shantashil", "palghar", "maharashtra", "india", "himanshu", "birthday party");
        //int insertVenue = venueDao.insertVenue(venue);
        //System.out.println(insertVenue);


        venueDao.getAllVenue().forEach(System.out::println);
    }
}
