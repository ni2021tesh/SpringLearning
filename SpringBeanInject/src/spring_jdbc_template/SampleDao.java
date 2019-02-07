package spring_jdbc_template;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDao {

    private JdbcTemplate jdbcTemplateOracle;

    private static Sample mapRSTOSample(ResultSet rs, int rowNum) {
        Sample sample = new Sample();
        try {
            sample.setId(rs.getInt("ID"));
            sample.setAddress(rs.getString("ADDRESS"));
            sample.setName(rs.getString("NAME"));
            sample.setCountry(rs.getString("COUNTRY"));
            sample.setState(rs.getString("STATE"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return sample;
    }

    public JdbcTemplate getJdbcTemplateOracle() {
        return jdbcTemplateOracle;
    }

    public void setJdbcTemplateOracle(JdbcTemplate jdbcTemplateOracle) {
        this.jdbcTemplateOracle = jdbcTemplateOracle;
    }


    Sample getSampleById(int id) {
        final String SELECT_SAMPLE = "select * from sample where id = ?";
        Object[] param = new Object[]{id};
        int[] type = new int[]{Types.INTEGER};

        return this.jdbcTemplateOracle.queryForObject(SELECT_SAMPLE, param, type, SampleDao::mapRSTOSample);
    }


    List<Sample> getAllSampleRecord() {
        final String SELECT_ALL_SAMPLE = "select * from sample";
        List<Sample> samples = this.jdbcTemplateOracle.query(SELECT_ALL_SAMPLE, SampleDao::mapRSTOSample);
        return samples;
    }


    public int saveSample(Sample sample) {

        final String INSERT_SAMPLE = "insert into sample (NAME, ADDRESS, COUNTRY, STATE)" +
                " values (?,?,?,?)";

        Object[] param = new Object[]{sample.getName(), sample.getAddress(), sample.getCountry(), sample.getState()};
        int[] type = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};

        int update = this.jdbcTemplateOracle.update(INSERT_SAMPLE, param, type);

        if (update != 0) {
            System.out.println("Record Inserted Into Table Sample Successfully..");
        } else System.out.println("Error Occurred while saving the record..");

        return update;
    }


    Map<String, Object> getSampleMap() {
        final String SELECT_ALL_SAMPLE = "select * from sample where id = 6";
        return this.jdbcTemplateOracle.queryForMap(SELECT_ALL_SAMPLE);
    }


    List<Map<String, Object>> getSampleList() {
        final String SELECT_ALL_SAMPLE = "select * from sample";
        return this.jdbcTemplateOracle.queryForList(SELECT_ALL_SAMPLE);
    }

    List<String> getSampleNames() {
        final String SELECT_SAMPLE_NAMES = "select name from sample";
        return this.jdbcTemplateOracle.queryForList(SELECT_SAMPLE_NAMES, String.class);
    }


    public Map<String, List<Sample>> getSampleByCity() {
        final String SELECT_ALL_SAMPLE = "select * from sample";
        return this.jdbcTemplateOracle.query(SELECT_ALL_SAMPLE, rs -> {
            Map<String, List<Sample>> sampleMapOrderedByCity = new HashMap<>();
            List<Sample> samples = new ArrayList<>();
            while (rs.next()) {
                Sample sample = new Sample();
                sample.setId(rs.getInt("ID"));
                sample.setAddress(rs.getString("ADDRESS"));
                sample.setName(rs.getString("NAME"));
                sample.setCountry(rs.getString("COUNTRY"));
                sample.setState(rs.getString("STATE"));
                samples.add(sample);
            }
            samples.stream().forEach(sample -> {
                List<Sample> samples1 = sampleMapOrderedByCity.get(sample.getAddress());
                if (samples1 != null && !samples1.isEmpty())
                    samples1.add(sample);
                else {
                    samples1 = new ArrayList<>();
                    samples1.add(sample);
                }
                sampleMapOrderedByCity.put(sample.getAddress(), samples1);
            });
            return sampleMapOrderedByCity;
        });
    }
}
