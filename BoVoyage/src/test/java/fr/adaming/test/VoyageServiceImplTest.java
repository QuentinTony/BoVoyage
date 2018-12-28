package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IVoyageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/application-context.xml"})
@Ignore
public class VoyageServiceImplTest {
	
//	@Autowired
//	private IVoyageService voService;
//	
//	@Autowired
//	private IDestinationService deService;
	
//	@Test
//	@Transactional // obligatoire et readonly et juste pour lire 
//	@Rollback(true)
//	public void testAddVoyage() {
//		
//		Voyage voOut= new Voyage(new Date(2010,12,10), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		Destination de= new Destination("fr", "ee", 11, 111, null, "paris");
//		deService.addDestination(de);
//		voOut.setDestination(de);
//		voService.addVoyage(voOut);
//		List<Voyage> liste = voService.getAllVoyage();
//		assertEquals(new Integer(1), new Integer(liste.size()));
//		
//	}
	
//	@Test
//	@Transactional // obligatoire et readonly et juste pour lire 
//	@Rollback(true)
//	public void testAddVoyage2() {
//		
//		Voyage voOut= new Voyage(new Date(2010,12,10), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		Destination de= new Destination("fr", "ee", 11, 111, null, "paris");
//		deService.addDestination(de);
//		voOut.setDestination(de);
//		voService.addVoyage(voOut);
//		List<Voyage> liste = voService.getAllVoyage();
//		assertEquals("fr", liste.get(1).getDestination().getContinent());
//		
//	}
	
//	@Test
//	@Transactional // obligatoire et readonly et juste pour lire 
//	@Rollback(true)
//	public void testAddVoyage3() {
//		
//		Voyage voOut= new Voyage(new Date(2010,12,10), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		
//		
//		voService.addVoyage(voOut);
//		List<Voyage> liste = voService.getAllVoyage();
//		assertEquals("Paris", liste.get(1).getVilleDepart());
//		
//	}
	
//	@Test
//	@Transactional // obligatoire et readonly et juste pour lire 
//	@Rollback(true)
//	public void testgetVoyageByDateDepart() {
//		
//		Voyage voOut= new Voyage(new Date(2010,10,12), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		Voyage voOut1= new Voyage(new Date(2010,9,10), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		Voyage voOut2= new Voyage(new Date(2010,10,11), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		Voyage voOut3= new Voyage(new Date(2010,9,10), new Date(2010, 12, 25), 150.0, 0.2, "Paris", 3, 5);
//		
//		
//		voService.addVoyage(voOut);
//		voService.addVoyage(voOut2);
//		voService.addVoyage(voOut3);
//		voService.addVoyage(voOut1);
//		List<Voyage> liste = voService.getVoyageByDateDepart(new Date(2010, 10, 11));
//		assertEquals(3, liste.size());
//		
//	}

}