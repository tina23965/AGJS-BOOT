package com.agjs.hotel.dao.order;

import java.util.List;

import com.agjs.hotel.bean.order.SalesOrderStatusPo;

public interface SalesOrderStatusDao {
	List<SalesOrderStatusPo> select();

	SalesOrderStatusPo select(Integer id);

	SalesOrderStatusPo insert(SalesOrderStatusPo salesOrderStatus);

	SalesOrderStatusPo update(SalesOrderStatusPo salesOrderStatus);

	SalesOrderStatusPo delete(Integer id);
}
