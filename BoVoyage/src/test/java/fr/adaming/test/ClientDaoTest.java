package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ClientDaoTest {
	
	@Autowired
	private IClientDao clDao;
	
	@Test
	public void testgetById() {
		Client clOut=clDao.getById(1);
		long idOut=clOut.getId();
		assertEquals(1, idOut);
	}

	@Test
	public void testgetAllSize() {
		List<Client> liste=clDao.getAll();
		assertEquals(2, liste.size());
	}
	
	@Test
	public void testgetAllFirst() {
		List<Client> liste=clDao.getAll();
		Client cl1=liste.get(0);
		assertEquals(1, cl1.getId());
	}
	
	@Test
	public void testgetAllLast() {
		List<Client> liste=clDao.getAll();
		Client clf=liste.get(liste.size()-1);
		assertEquals(2, clf.getId());
	}
	
	@Test
	@Rollback
	public void testadd() {
		Client cl=new Client("zdqefsg", "qdfsgdf", new Date(), "c@c", "0678943256");
		Client clNew=clDao.add(cl);
		List<Client> liste=clDao.getAll();
		assertEquals(3, liste.size());
	}
}
