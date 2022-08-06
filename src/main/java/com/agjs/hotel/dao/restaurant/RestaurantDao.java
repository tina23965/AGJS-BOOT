package com.agjs.hotel.dao.restaurant;

import java.util.List;

import com.agjs.hotel.bean.restaurant.RestaurantPo;

public interface RestaurantDao {
	public List<RestaurantPo> selectRestaurant();
}
