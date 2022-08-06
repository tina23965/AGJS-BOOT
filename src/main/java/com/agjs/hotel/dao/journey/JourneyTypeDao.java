package com.agjs.hotel.dao.journey;

import com.agjs.hotel.bean.journey.JourneyTypePo;
import com.agjs.hotel.dao.CoreDao;

public interface JourneyTypeDao extends CoreDao<JourneyTypePo, Integer>{
	
	public int selectIdByName(String typeName);


}