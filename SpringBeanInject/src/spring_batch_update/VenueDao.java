package spring_batch_update;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class VenueDao extends NamedParameterJdbcDaoSupport {

    int insertVenue(Venue venue) {
        final String INSERT_VENUE = "insert into venue (name, city, state, country, bookedby, bookedfor)" +
                " VALUES (:name,:city,:state,:country,:bookedby,:bookedfor)";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name", venue.getName())
                .addValue("state", venue.getState())
                .addValue("city", venue.getCity())
                .addValue("country", venue.getCountry())
                .addValue("bookedby", venue.getBookedBy())
                .addValue("bookedfor", venue.getBookedFor());

        return Objects.requireNonNull(this.getNamedParameterJdbcTemplate()).update(INSERT_VENUE, sqlParameterSource);
    }

    List<Venue> getAllVenue() {
        final String SELECT_ALL_VENUE = "Select * from venue";

        return this.getNamedParameterJdbcTemplate().query(SELECT_ALL_VENUE, (rs, rowNum) -> {
            Venue venue = new Venue();
            venue.setId(rs.getInt("id"));
            venue.setName(rs.getString("name"));
            venue.setCity(rs.getString("city"));
            venue.setState(rs.getString("state"));
            venue.setCountry(rs.getString("country"));
            venue.setBookedBy(rs.getString("bookedby"));
            venue.setBookedFor(rs.getString("bookedfor"));
            return venue;
        });
    }


    int insertBatchVenues(final List<Venue> venues) {
        final String INSERT_BATCH_ITEM = "insert into venue(name,city,state,country,bookedby,bookedfor) " +
                "values(?,?,?,?,?,?)";
        assert this.getJdbcTemplate() != null;
        int[] ints = this.getJdbcTemplate().batchUpdate(INSERT_BATCH_ITEM, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Venue venue = venues.get(i);
                ps.setString(1, venue.getName());
                ps.setString(2, venue.getCity());
                ps.setString(3, venue.getState());
                ps.setString(4, venue.getCountry());
                ps.setString(5, venue.getBookedBy());
                ps.setString(6, venue.getBookedFor());
            }

            @Override
            public int getBatchSize() {
                return venues.size();
            }
        });

        System.out.println(ints.length);
        return 0;
    }

}
