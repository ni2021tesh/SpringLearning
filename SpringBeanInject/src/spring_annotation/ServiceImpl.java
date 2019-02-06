package spring_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceImpl implements Service {

    private Dao dao;


    public Dao getDao() {
        return dao;
    }

    @Autowired
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void greet(String name) {
        dao.display(name);
    }

    @Override
    public List<String> getStudent() {
        return dao.getStuList();
    }
}
