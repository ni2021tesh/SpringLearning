package spring_batch_update;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpringBatchInsert {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring_batch_update/spring_batch_update.xml");
        VenueDao bean = classPathXmlApplicationContext.getBean(VenueDao.class);
        List<Venue> venues = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            Venue venue = new Venue();
            venue.setName("Nitesh" + i);
            venue.setCity("Palghar" + i);
            venue.setCountry("India" + i);
            venue.setState("Maharashtra" + i);
            venue.setBookedBy("Code" + i);
            venue.setBookedFor("Testing batch ionsert" + i);
            venues.add(venue);
        }
        long l = System.currentTimeMillis();
        bean.insertBatchVenues(venues);
        long l1 = System.currentTimeMillis();

        System.out.println(l1 - l);
    }
}
