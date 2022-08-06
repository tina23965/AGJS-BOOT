package com.agjs.hotel.dao;

import java.util.List;

import com.agjs.hotel.bean.room.RoomUsedRecordPo;

public interface SpringMvcDao {

	public List<RoomUsedRecordPo> selectRoomUsedRecord();

}