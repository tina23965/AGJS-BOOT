package com.agjs.hotel.dao.room;

import java.util.List;

public interface RoomStyleDao<T> {

	List<T> getAll();

	T getId(Integer id);

	Integer add(T roomStylePo);

	void delete(Integer roomStyleId);

}
