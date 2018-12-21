package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Client;
import fr.adaming.model.Voyage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class VoyageDaoTest {

	private IVoyageDao voDao;
	
	@Autowired
	public void setVoDao(IVoyageDao voDao) {
		this.voDao = voDao;
		voDao.setGeneric(Voyage.class);
	}

	@Test
	@Transactional(readOnly=true)
	public void testVoyageByContinent() {
		List<Voyage> liste=voDao.getVoyageByContinent("Europe");
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testVoyageByPays() {
		List<Voyage> liste=voDao.getVoyageByPays("France");
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testVoyageByPrix() {
		List<Voyage> liste=voDao.getVoyageByPrix(200);
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testVoyageByDateDepart() {
		List<Voyage> liste=voDao.getVoyageByDateDepart(new Date(2018, 01, 01));
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testVoyageByDateRetour() {
		List<Voyage> liste=voDao.getVoyageByDateRetour(new Date(2018, 01, 02));
		assertEquals(1, liste.size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testVoyageByDateDepRet() {
		System.out.println(voDao.getById(1).getDateDepart());
		System.out.println(voDao.getById(1).getDateRetour());
		List<Voyage> liste=voDao.getVoyageByDateDepRet(new Date(2018, 01, 01), new Date(2018, 01, 02));
		assertEquals(1, liste.size());
	}
}
