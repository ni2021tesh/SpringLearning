package spring_multiple_config;

public class Service {

    private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public String getStudent(String id) {
        return this.dao.getStudentList(id);
    }

    public String greet(String name) {
        return this.dao.greet(name);
    }

    public void display() {
        this.dao.display();
    }
}
