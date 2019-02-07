package spring_jdbc_dao_support;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class StudentDao extends NamedParameterJdbcDaoSupport {

    private final String INSERT_INTO_STUDENT = "insert into student (name, lastName, profession, address) VALUES (?,?,?,?)";

    private final String SELECT_FROM_STUDENT = "select * from student where id=?";

    private static Student mapResultSetToStudent(ResultSet rs, int rowNum) {
        System.out.println("Mapping Result Set to Student..");
        Student student = new Student();
        try {
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setLastName(rs.getString("lastName"));
            student.setAddress(rs.getString("address"));
            student.setProfession(rs.getString("profession"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student getStudentById(int id) {
        Object[] param = new Object[]{id};
        int[] type = new int[]{Types.INTEGER};
        return this.getJdbcTemplate().queryForObject(SELECT_FROM_STUDENT, param, type, StudentDao::mapResultSetToStudent);

    }


    public List<Student> getAllStudent() {
        return this.getJdbcTemplate().query("Select * from student", StudentDao::mapResultSetToStudent);
    }
}
