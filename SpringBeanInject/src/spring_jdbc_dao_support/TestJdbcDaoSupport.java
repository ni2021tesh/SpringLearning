package spring_jdbc_dao_support;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcDaoSupport {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_jdbc_dao_support/spring-jdbc-dao-support.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
/*
        System.out.println("************************************************************************************");
        System.out.println("*****************Fetching Record From MySQL Database********************************");
        Student studentById = studentDao.getStudentById(1);
        System.out.println(studentById);
        studentDao.getAllStudent().forEach(System.out::println);*/

        System.out.println("************************************************************************************");
        System.out.println("*****************Fetching single Record From Oracle Database************************");
        SampleDao sampleDao = applicationContext.getBean(SampleDao.class);
        Sample sampleById = sampleDao.getSampleById(2);
        System.out.println(sampleById.toString());
    /*    System.out.println("*****************Inserting single Record into Oracle Database************************");
        Sample sample = new Sample();
        sample.setName("Nitesh Surendra Jha");
        sample.setState("Maharashtra");
        sample.setCountry("India");
        sample.setAddress("Palghar");
        sampleDao.saveSample(sample);*/

        System.out.println("*****************Fetching All Record From Oracle Database***************************");
        sampleDao.getAllSampleRecord().forEach(System.out::println);


        //sampleDao.getSampleMap().forEach((k, v) -> System.out.println("Key is::" + k + " value is ::" + v));
        sampleDao.getSampleList().forEach(stringObjectMap -> {
            System.out.println("-------------------------------------------------------------");
            stringObjectMap.forEach((s, o) -> {
                System.out.println("Key is :: " + s + " value is :: " + o);
            });
        });

        sampleDao.getSampleNames().forEach(System.out::println);

        System.out.println(sampleDao.getSampleByCity());

    }
}
