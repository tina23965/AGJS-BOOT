package com.agjs.hotel.dao.order;

import java.util.List;

import com.agjs.hotel.bean.order.SalesOrderStatusPo;

public interface SalesOrderStatusDao_2 {

	//select * from SalesOrderStatus where salesOrderStatusId = ?
	SalesOrderStatusPo selectById(Integer id);
	
	List<Object[]> selectByUserIdAndHeaderId(Integer id);

}