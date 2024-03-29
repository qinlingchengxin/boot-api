package net.ys.dao;

import net.ys.bean.Person;
import net.ys.mapper.PersonMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PersonDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Person> queryPersons(int page, int pageSize) {
        String sql = "SELECT `id`, `name`, `age`, `create_time` FROM `person` LIMIT ?,?";
        return jdbcTemplate.query(sql, new PersonMapper(), (page - 1) * pageSize, pageSize);
    }

    public List<Person> queryPersons(String name, int page, int pageSize) {

        if ("".equals(name)) {
            String sql = "SELECT `id`, `name`, `age`, `create_time` FROM `person` LIMIT ?,?";
            return jdbcTemplate.query(sql, new PersonMapper(), (page - 1) * pageSize, pageSize);
        }

        String sql = "SELECT `id`, `name`, `age`, `create_time` FROM `person` WHERE `name` LIKE ? LIMIT ?,?";
        return jdbcTemplate.query(sql, new PersonMapper(), name, (page - 1) * pageSize, pageSize);
    }

    public long queryPersonCount(String name) {
        if ("".equals(name)) {
            String sql = "SELECT COUNT(*) FROM `person`";
            return jdbcTemplate.queryForObject(sql, Long.class);
        }
        String sql = "SELECT COUNT(*) FROM `person` WHERE `name` LIKE ?";
        return jdbcTemplate.queryForObject(sql, Long.class, "%" + name + "%");
    }

    public Person queryPerson(String id) {
        String sql = "SELECT `id`, `name`, `age`, `create_time` FROM `person` WHERE `id` = ?";
        List<Person> list = jdbcTemplate.query(sql, new PersonMapper(), id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean savePerson(Person person) {
        String sql = "UPDATE `person` SET `name` = ?, `age` = ? WHERE `id` = ?";
        return jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getId()) >= 0;
    }

    public Person addPerson(final Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `person` (`name`, `age`, `create_time`) VALUES (?, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setLong(3, System.currentTimeMillis());
            return ps;
        }, keyHolder);
        long id = keyHolder.getKey().longValue();

        if (id > 0) {
            String tmp = "SELECT `id`, `name`, `age`, `create_time` FROM `person` WHERE `id` = ?";
            List<Person> persons = jdbcTemplate.query(tmp, new PersonMapper(), id);
            if (persons.size() > 0) {
                return persons.get(0);
            }
        }
        return null;
    }
}
