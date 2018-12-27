package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.dao.IHotelDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;

@Service("hoService")
@Transactional
public class HotelServiceImpl implements IHotelService{
	
	private IHotelDao hoDao;
	
	
	@Autowired
	public void setHoDao(IHotelDao hoDao) {
		this.hoDao = hoDao;
		hoDao.setGeneric(Hotel.class);
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		
		return hoDao.add(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
	
		return hoDao.getAll();
	}

	@Override
	public Hotel getHotel(long id) {
		
		return hoDao.getById(id);
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		try {
			hoDao.delete(hotel);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public int updateHotel(Hotel hotel) {
		
		return hoDao.update(hotel);
	}

}
