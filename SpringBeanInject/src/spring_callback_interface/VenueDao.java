package spring_callback_interface;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class VenueDao extends NamedParameterJdbcDaoSupport {

    int CallingConnectionCallBackInterface() {
        final String UPDATE_VENUE = "update venue set city='New York' where id=1";
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
}
