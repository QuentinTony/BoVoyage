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
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ClientDaoTest {
	
	
	private IClientDao clDao;
	
	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
		clDao.setGeneric(Client.class);
	}

	@Test
	@Transactional(readOnly=true)
	public void testgetById() {
		Client clOut=clDao.getById(1);
		long idOut=clOut.getId();
		assertEquals(1, idOut);
	}

	@Test
	@Transactional(readOnly=true)
	public void testgetAllSize() {
		List<Client> liste=clDao.getAll();
		assertEquals(3, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testgetAllFirst() {
		List<Client> liste=clDao.getAll();
		Client cl1=liste.get(0);
		assertEquals(1, cl1.getId());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testgetAllLast() {
		List<Client> liste=clDao.getAll();
		Client clf=liste.get(liste.size()-1);
		assertEquals(3, clf.getId());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void testaddSizeListe() {
		Client cl=new Client("zdqefsg", "qdfsgdf", new Date(), "c@c", "0678943256");
		clDao.add(cl);
		List<Client> liste=clDao.getAll();
		assertEquals(4, liste.size());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void testaddObject() {
		Client cl=new Client("zdqefsg", "qdfsgdf", new Date(), "c@c", "0678943256");
		Client clOut=clDao.add(cl);
		List<Client> liste=clDao.getAll();
		assertEquals(clOut.getId(), liste.get(liste.size()-1).getId());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void testDeleteSizeListe() {
		Client clOut=clDao.getById(1);
		clDao.delete(clOut);
		List<Client> liste=clDao.getAll();
		assertEquals(2, liste.size());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void testupDate() {
		Client cl=new Client("ZOZO", "zizi", new Date(), "a@a", "0678754468");
		cl.setId(1);
		clDao.update(cl);
		Client clOut=clDao.getById(1);
		assertEquals("ZOZO", clOut.getNom());
	}
	
}
