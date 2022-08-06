package com.agjs.hotel.dao.room;

import java.util.List;

import com.agjs.hotel.bean.room.RoomInformationFacilitiesPo;

public interface RoomInformationFacilitiesDao {
	void add(RoomInformationFacilitiesPo roomInformationFacilitiesPo);

	void delete(RoomInformationFacilitiesPo roomInformationFacilitiesPo);

	List<RoomInformationFacilitiesPo> findByRoomStyleId(Integer roomStyleId);
}
