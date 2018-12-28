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

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientServiceImplTest {
	
//	@Autowired
//	private IClientService clService;
	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testAddClient() {
//		Client clOut=new Client("toto", "titi", new Date(), "a@a", "05046125");
//		
//		clService.addClient(clOut);
//		
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals(new Integer(1), new Integer(liste.size()));
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testAddClient1() {
//		Client clOut=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		
//		clService.addClient(clOut);
//		
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals("toto", liste.get(0).getNom());
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testgetAllClient() {
//		Client clOut=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut1=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut2=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut3=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		clService.addClient(clOut);
//		clService.addClient(clOut1);
//		clService.addClient(clOut2);
//		clService.addClient(clOut3);
//		
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals(new Integer(4), new Integer(liste.size()));
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testgetAllClient1() {
//		Client clOut=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut1=new Client("lolo", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut2=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		Client clOut3=new Client("toto", "titi", new Date(), "a@a", "05046125"); 
//		clService.addClient(clOut);
//		clService.addClient(clOut1);
//		clService.addClient(clOut2);
//		clService.addClient(clOut3);
//		
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals("lolo", liste.get(1).getNom());
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testgetClient1() {
//		
//		
//	  Client clIn= clService.getClient(168);
//		
//		assertEquals(168, clIn.getId());
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testgetClient() {
//		
//		
//	  Client clIn= clService.getClient(168);
//		
//		assertEquals("lili", clIn.getNom());
//	}
//	
//	@Test
//	@Rollback(true)
//	@Transactional
//	public void testdeleteClient() {
//		
//		Client clOut2=clService.getClient(201);
//		clService.deleteClient(clOut2);
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals(1, liste.size());
//	}
	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testupdateClient() {
//		Client clIn=clService.getClient(201);
//		clIn.setNom("ronaldo");
//		clService.updateClient(clIn);
//		
//		List<Client> liste=clService.getAllClient();
//		
//		assertEquals("ronaldo", liste.get(1).getNom());
//	}


}
