package spring_datasource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class VenueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    int CallingConnectionCallBackInterface() {
        final String UPDATE_VENUE = "update venue set city='united state of ameriica' where id=1";
        this.getJdbcTemplate().execute(new ConnectionCallback<Integer>() {
            @Override
            public Integer doInConnection(Connection con) throws SQLException, DataAccessException {
                Statement statement = con.createStatement();
                int i = statement.executeUpdate(UPDATE_VENUE);
                return i;
            }
        });
        return 0;
    }

    public VenueDao() {
    }
}
