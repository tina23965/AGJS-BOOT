package com.agjs.hotel.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agjs.hotel.bean.order.SalesOrderStatusPo;
import com.agjs.hotel.service.order.SalesOrderStatusService;

@RestController
@RequestMapping(path = {"/main/order", "/admin/order"})
public class SalesOrderStatusController {
	
	@Autowired
	private SalesOrderStatusService service;
	
	@GetMapping("/search/status")
	public List<SalesOrderStatusPo> getallStatus() {
		return service.getAllStatus();
	}

}

