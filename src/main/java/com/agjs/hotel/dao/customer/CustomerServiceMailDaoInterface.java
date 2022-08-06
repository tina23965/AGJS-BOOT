package com.agjs.hotel.dao.customer;

import java.util.List;

import com.agjs.hotel.bean.customer.CustomerServiceMailVO;

public interface CustomerServiceMailDaoInterface {
	public void insert(CustomerServiceMailVO customerServiceMailVO);
	public void delete(Integer faqFormId);
	public List<CustomerServiceMailVO> getAll();
}
