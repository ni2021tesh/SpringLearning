package spring_jdbc_template;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class StudentDao {

    private final String INSERT_INTO_STUDENT = "insert into student (name, lastName, profession, address) VALUES (?,?,?,?)";

    private final String SELECT_FROM_STUDENT = "select * from student where id=?";

    private JdbcTemplate jdbcTemplateMysql;

    private JdbcTemplate jdbcTemplateOracle;

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

    public JdbcTemplate getJdbcTemplateOracle() {
        return jdbcTemplateOracle;
    }

    public void setJdbcTemplateOracle(JdbcTemplate jdbcTemplateOracle) {
        this.jdbcTemplateOracle = jdbcTemplateOracle;
    }

    public JdbcTemplate getJdbcTemplateMysql() {
        return jdbcTemplateMysql;
    }

    public void setJdbcTemplateMysql(JdbcTemplate jdbcTemplateMysql) {
        this.jdbcTemplateMysql = jdbcTemplateMysql;
    }


    public Student getStudentById(int id) {
        Object[] param = new Object[]{id};
        int[] type = new int[]{Types.INTEGER};
        return this.jdbcTemplateMysql.queryForObject(SELECT_FROM_STUDENT, param, type, StudentDao::mapResultSetToStudent);

    }


    public List<Student> getAllStudent() {
        return this.jdbcTemplateMysql.query("Select * from student", StudentDao::mapResultSetToStudent);
    }
}
