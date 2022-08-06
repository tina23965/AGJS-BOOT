package com.agjs.hotel.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agjs.hotel.bean.restaurant.RestaurantPo;
import com.agjs.hotel.bean.user.UserPo;
import com.agjs.hotel.service.restaurant.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/select")
	public List<RestaurantPo> select() {
		return restaurantService.getRestaurantAll();
	}

	@PostMapping("/select2")
	public List<RestaurantPo> select2(@RequestBody UserPo user) {
		return restaurantService.getRestaurantAll();
	}

}
