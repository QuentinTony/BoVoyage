package fr.adaming.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VoyageServiceImplTest {
	
	@Autowired
	private IVoyageService voService;
	
	@Test
	@Rollback(true)
	public void testAddVoyage() {
		
		Voyage voOut= new Voyage(2010/12/10, 2012/11/10, 150.0, 0.2, "Paris", 3, 5);
		
	}

}
