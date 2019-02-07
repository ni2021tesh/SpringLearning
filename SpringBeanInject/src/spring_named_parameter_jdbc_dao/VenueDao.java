package spring_named_parameter_jdbc_dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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
}
