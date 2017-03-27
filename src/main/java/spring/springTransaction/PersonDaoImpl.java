package spring.springTransaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getCount() {
		String sql = "select count(*) from person";
		int rowCount = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return rowCount;
	}

	public Person get(int id) {
		String sql = "SELECT * FROM person WHERE id=?";
		// Person person = jdbcTemplate.queryForObject(sql, Person.class, 1);
		RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(
				Person.class);
		Person person = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		return person;
	}

	public void del(int id) {
		String sql = "delete from person where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(Person person) {
		String sql = "update person set name=? where id=?";
		jdbcTemplate.update(sql,
				new Object[] { person.getName(), person.getId() });
	}

	public void add(Person person) {
		String sql = "INSERT INTO person (id,`name`,age) VALUE (?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] { person.getId(), person.getName(),
						person.getAge() });
	}

	public void batchAdd(final List<Person> persons) {
		String sql = "INSERT INTO person (id,`name`,age) VALUE (?,?,?)";
		BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				ps.setInt(1, persons.get(i).getId());
				ps.setString(2, persons.get(i).getName());
				ps.setInt(3, persons.get(i).getAge());
			}

			public int getBatchSize() {
				return persons.size();
			}
		};
		jdbcTemplate.batchUpdate(sql, pss);

	}

	public void batchUpdate(final List<Person> persons) {
		String sql = "update person set name=?,age=? where id=?";
		BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				ps.setString(1, persons.get(i).getName());
				ps.setInt(2, persons.get(i).getAge());
				ps.setInt(3, persons.get(i).getId());
			}

			public int getBatchSize() {
				return persons.size();
			}
		};
		jdbcTemplate.batchUpdate(sql, pss);
	}

	public List<Person> batchGet() {
		String sql = "select * from person";
		RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(
				Person.class);
		return jdbcTemplate.query(sql, rowMapper);
	}

	public void batchDel(final int[] ids) {
		String sql = "delete from person where id=?";
		BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				ps.setInt(1, ids[i]);
			}

			public int getBatchSize() {
				return ids.length;
			}
		};
		jdbcTemplate.batchUpdate(sql, pss);
	}

}
