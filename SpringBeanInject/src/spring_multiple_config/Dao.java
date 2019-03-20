package spring_multiple_config;

import java.util.HashMap;
import java.util.Map;

public class Dao {

    private static Map<String, String> studentMap = null;

    static {
        if (studentMap == null) {
            studentMap = new HashMap<>();
            studentMap.put("1", "Nitesh Jha");
            studentMap.put("2", "Anusha Jha");
            studentMap.put("3", "Himanshu Jha");
            studentMap.put("4", "Surendra Jha");
            studentMap.put("5", "Renu Jha");
        }
    }

    public String greet(String name) {
        return "Hello, " + name + " how are you.";
    }

    public void display() {
        System.out.println("Display method of Dao called..");
    }

    public String getStudentList(String id) {
        return Dao.studentMap.getOrDefault(id, "Not Present");
    }

}
