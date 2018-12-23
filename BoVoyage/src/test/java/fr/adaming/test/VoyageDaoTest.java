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

import fr.adaming.dao.IDestinationDao;
import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class VoyageDaoTest {

	private IVoyageDao voDao;
	private IDestinationDao deDao;
	
	@Autowired
	public void setDeDao(IDestinationDao deDao) {
		this.deDao = deDao;
		deDao.setGeneric(Destination.class);
	}
	
	@Autowired
	public void setVoDao(IVoyageDao voDao) {
		this.voDao = voDao;
		voDao.setGeneric(Voyage.class);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByContinent() {
		Voyage vo=new Voyage();
		Destination de=new Destination();
		de.setContinent("Europe");
		Destination deOut=deDao.add(de);
		vo.setDestination(deOut);
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByContinent("Europe");
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByPays() {
		Voyage vo=new Voyage();
		Destination de=new Destination();
		de.setPays("France");
		Destination deOut=deDao.add(de);
		vo.setDestination(deOut);
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByPays("France");
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByPrix() {
		Voyage vo=new Voyage();
		vo.setPrix(200);
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByPrix(200);
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByDateDepart() {
		Voyage vo=new Voyage();
		vo.setDateDepart(new Date());
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByDateDepart(new Date());
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByDateRetour() {
		Voyage vo=new Voyage();
		vo.setDateRetour(new Date());
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByDateRetour(new Date());
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testVoyageByDateDepRet() {
		Voyage vo=new Voyage();
		vo.setDateRetour(new Date());
		vo.setDateDepart(new Date());
		voDao.add(vo);
		List<Voyage> liste=voDao.getVoyageByDateDepRet(new Date(), new Date());
		assertEquals(1, liste.size());
	}
}
