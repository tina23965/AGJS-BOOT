package com.agjs.hotel.service.room;

import java.util.List;

import com.agjs.hotel.bean.room.RoomInformationFacilitiesPo;
import com.agjs.hotel.bean.room.RoomStylePo;

public interface RoomStyleService<T> {

	List<T> getAll();

	Integer addRoomStyle(RoomStylePo roomStylePo, List<Integer> roomFacilitiesIdList);

	T getById(Integer id);
	
	void delete(Integer[] roomStyleIds);

	List<RoomInformationFacilitiesPo> findFacilitiesByRoomStyleId(Integer roomStyleId);

	

}
