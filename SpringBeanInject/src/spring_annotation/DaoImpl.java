package spring_annotation;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DaoImpl implements Dao {

    @Override
    public void display(String name) {
        System.out.println("Hello, " + name);
    }

    @Override
    public List<String> getStuList() {
        return Arrays.asList("Nitesh", "Himanshu", "Surendra");
    }
}
