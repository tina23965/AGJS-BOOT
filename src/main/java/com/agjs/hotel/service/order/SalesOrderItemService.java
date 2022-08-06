package com.agjs.hotel.service.order;

import java.util.List;

import com.agjs.hotel.bean.order.SalesOrderItemPo;


public interface SalesOrderItemService {

	List<SalesOrderItemPo> getOrderItemByHeaderId(Integer headerId);

	SalesOrderItemPo getOrderItem(Integer id);
	
	boolean delete(Integer id);
	
	SalesOrderItemPo insert(SalesOrderItemPo bean);

	SalesOrderItemPo update(SalesOrderItemPo bean);
	
}
