package com.agjs.hotel.controller.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agjs.hotel.bean.order.SalesOrderItemVo_2;
import com.agjs.hotel.bean.user.UserPo;
import com.agjs.hotel.dao.order.SalesOrderHeaderDao;
import com.agjs.hotel.service.order.SalesOrderHeaderService_2;

@RestController
@RequestMapping(path = {"/main/order"})
public class SalesOrderController_2 {
	@Autowired
	private SalesOrderHeaderDao dao;
	@Autowired
	private SalesOrderHeaderService_2 service;
	
	//查詢使用者的訂單，待完成
	@PostMapping("/search/byUser")
	public List<SalesOrderItemVo_2> selectByUserId(@RequestBody SalesOrderItemVo_2 vo,HttpSession session){
		UserPo user= (UserPo) session.getAttribute("login");
		System.out.println("SalesOrderController ID："+user.getUserId());
		return service.selectByUserId(user.getUserId());
	}
}
