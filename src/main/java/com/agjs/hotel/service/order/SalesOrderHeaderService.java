package com.agjs.hotel.service.order;

import java.util.Date;
import java.util.List;

import com.agjs.hotel.bean.order.SalesOrderHeaderPo;



public interface SalesOrderHeaderService {
	
	SalesOrderHeaderPo create(SalesOrderHeaderPo SalesOrderHeader);

	List<SalesOrderHeaderPo> getAll();
	
	List<SalesOrderHeaderPo> selectById(Integer id);
	
	List<SalesOrderHeaderPo> selectByUserId(Integer userId);
	
	List<SalesOrderHeaderPo> selecctByOrderStartDate(Date orderStartDate);
	
	boolean delete(Integer id);
}
