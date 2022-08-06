package com.agjs.hotel.dao.restaurant;

import java.util.List;

import com.agjs.hotel.bean.restaurant.RestauranatIntroPo;

public interface RestaurantIntroDao_interface {

	public void insert(RestauranatIntroPo restauranatIntroPo);

	public void update(RestauranatIntroPo restauranatIntroPo);

	public void delete(Integer empno);

	public RestauranatIntroPo findByPrimaryKey(Integer empno);

	public List<RestauranatIntroPo> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//      public List<EmpVO> getAll(Map<String, String[]> map); 
}
