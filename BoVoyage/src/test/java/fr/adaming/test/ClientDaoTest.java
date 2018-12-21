package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

}
