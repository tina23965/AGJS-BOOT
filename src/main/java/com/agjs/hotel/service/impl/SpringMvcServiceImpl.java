package com.agjs.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.agjs.hotel.bean.room.RoomUsedRecordPo;
import com.agjs.hotel.dao.SpringMvcDao;
import com.agjs.hotel.service.SpringMvcService;

@Service
public class SpringMvcServiceImpl implements SpringMvcService {

	@Autowired
	@Qualifier("SpringMvcDao1")
	private SpringMvcDao springMvcDao;

	@Override
	public List<RoomUsedRecordPo> getRoomUsedRecordAll() {
		return springMvcDao.selectRoomUsedRecord();
	}

}
