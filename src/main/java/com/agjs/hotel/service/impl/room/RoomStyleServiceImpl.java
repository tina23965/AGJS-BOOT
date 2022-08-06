package com.agjs.hotel.service.impl.room;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agjs.hotel.bean.room.RoomInformationFacilitiesId;
import com.agjs.hotel.bean.room.RoomInformationFacilitiesPo;
import com.agjs.hotel.bean.room.RoomStylePo;
import com.agjs.hotel.dao.room.RoomInformationFacilitiesDao;
import com.agjs.hotel.dao.room.RoomStyleDao;
import com.agjs.hotel.service.room.RoomStyleService;

@Service
public class RoomStyleServiceImpl implements RoomStyleService<RoomStylePo> {
	@Autowired
	private RoomStyleDao<RoomStylePo> roomStyleDao;
	@Autowired
	private RoomInformationFacilitiesDao roomInformationFacilitiesDao;

	@Override
	public List<RoomStylePo> getAll() {
		List<RoomStylePo> list = new ArrayList<RoomStylePo>();
		try {
			list = roomStyleDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional
	@Override
	public Integer addRoomStyle(RoomStylePo roomStylePo, List<Integer> roomFacilitiesIdList) {
		// 新增主要table
		Integer id = roomStyleDao.add(roomStylePo);
		System.out.println(id);
		// 新增相關FK的檔案(兩個表格的id，雙主鍵)
		for (Integer facilitiesId : roomFacilitiesIdList) {
			RoomInformationFacilitiesId roomInformationFacilitiesId = new RoomInformationFacilitiesId();
			roomInformationFacilitiesId.setRoomFacilitiesId(facilitiesId);
			roomInformationFacilitiesId.setRoomStyleId(id);

			RoomInformationFacilitiesPo roomInformationFacilitiesPo = new RoomInformationFacilitiesPo();
			roomInformationFacilitiesPo.setId(roomInformationFacilitiesId);

			roomInformationFacilitiesDao.add(roomInformationFacilitiesPo);
		}
		return id;
	}

	// 取得RoomStylePo中的Id
	@Override
	public RoomStylePo getById(Integer id) {
		return roomStyleDao.getId(id);
	}

	// 刪除ROOM_INFORMATION_FACILITIES與ROOM_STYLE資料
	@Override
	@Transactional
	public void delete(Integer[] roomStyleIds) {

		// 預設結果為刪除失敗
		if (roomStyleIds != null) {
			for (Integer id : roomStyleIds) {
				List<RoomInformationFacilitiesPo> list = roomInformationFacilitiesDao.findByRoomStyleId(id);
				for (RoomInformationFacilitiesPo po : list) {
					roomInformationFacilitiesDao.delete(po);
				}
				roomStyleDao.delete(id);
			}
		}
	}

	@Override
	public List<RoomInformationFacilitiesPo> findFacilitiesByRoomStyleId(Integer roomStyleId) {
		List<RoomInformationFacilitiesPo> list = roomInformationFacilitiesDao.findByRoomStyleId(roomStyleId);
		return list;
	}

}
