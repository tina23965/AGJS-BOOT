package com.agjs.hotel.service.impl.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agjs.hotel.bean.restaurant.RestaurantPo;
import com.agjs.hotel.dao.restaurant.RestaurantDao;
import com.agjs.hotel.service.restaurant.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao dao;

	@Override
	public List<RestaurantPo> getRestaurantAll() {
		return dao.selectRestaurant();
	}

}