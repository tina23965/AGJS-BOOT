package com.agjs.hotel.service.order;

import java.util.List;

import com.agjs.hotel.bean.order.SalesOrderStatusPo;


public interface SalesOrderStatusService {

	List<SalesOrderStatusPo> getAllStatus();
	
	SalesOrderStatusPo getOrderStatus(Integer id);
}
