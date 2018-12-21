package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Hotel;

@Service("hoService")
@Transactional
public class HotelServiceImpl implements IHotelService{
	
	private IGenericDao<Hotel> hoDao;
	
	 @Autowired
	public void setHoDao(IGenericDao<Hotel> hoDao) {
		this.hoDao = hoDao;
		hoDao.setGeneric(Hotel.class);
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		
		return hoDao.add(hotel);
	}

	@Override
	public List<Hotel> getAllHotel(long id) {
	
		return hoDao.getAll();
	}

	@Override
	public Hotel getHotel(long id) {
		
		return hoDao.getById(id);
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHotel(Hotel hotel) {
		
		return hoDao.update(hotel);
	}

}
