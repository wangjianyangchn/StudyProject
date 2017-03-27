package spring.springTransaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDaoImplTest {

	private ApplicationContext applicationContext = null;
	private JdbcTemplate jdbcTemplate = null;
	private PersonDao personDao;

	{
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/springTransaction/application.xml");
		jdbcTemplate = (JdbcTemplate) applicationContext
				.getBean("jdbcTemplate");
		personDao = applicationContext.getBean(PersonDao.class);
	}

	@Test
	public void testGetConnect() throws SQLException {
		DataSource dataSource = (DataSource) applicationContext
				.getBean("dataSource");
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

	@Test
	public void testGetCount() {
		int count = personDao.getCount();
		System.out.println(count);
	}

	@Test
	public void testGet() {
		Person person = personDao.get(1);
		System.out.println(person);
	}

	@Test
	public void testDel() {
		personDao.del(10);
	}

	@Test
	public void testUpdate() {
		Person person = personDao.get(1);
		System.out.println(person);
		person.setName("newName");
		personDao.update(person);
	}

	@Test
	public void testAdd() {
		Person person = new Person(10, "rose", 23);
		personDao.add(person);
	}

	@Test
	public void testBatchGet() {
		List<Person> persons = personDao.batchGet();
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	@Test
	public void testBatchUpdate() {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person(1, "updateName1", 10));
		persons.add(new Person(2, "updateName2", 10));

		personDao.batchUpdate(persons);
	}

	@Test
	public void testBathchAdd() {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person(12, "updateName12", 10));
		persons.add(new Person(13, "updateName13", 10));

		personDao.batchAdd(persons);
	}

	@Test
	public void testBatchDel() {

		int[] ids = { 12, 13 };
		personDao.batchDel(ids);
	}
}
