package spring.springTransaction;

import java.util.List;

public interface PersonDao {
	public int getCount();

	public Person get(int id);

	public void del(int id);

	public void update(Person person);

	public void add(Person person);

	public List<Person> batchGet();

	public void batchAdd(List<Person> persons);

	public void batchUpdate(List<Person> persons);

	public void batchDel(int[] ids);

}
