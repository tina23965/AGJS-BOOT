package com.agjs.hotel.service.customer;

import java.sql.Date;
import java.util.List;

import com.agjs.hotel.bean.customer.CustomerServiceMailVO;
import com.agjs.hotel.dao.customer.CustomerServiceMailDaoInterface;
import com.agjs.hotel.dao.impl.customer.CustomerServiceMailJDBCDao;

public class CustomerServiceMailTableService {

	private CustomerServiceMailDaoInterface dao;

	public CustomerServiceMailTableService() {
		dao = new CustomerServiceMailJDBCDao();
	}

	public CustomerServiceMailVO addMail(String faqTypeName, String userName, String userPhone, String userEmail,
			String contentText, Date createDate) {

		CustomerServiceMailVO customerServiceMailVO = new CustomerServiceMailVO();

		customerServiceMailVO.setFaqTypeName(faqTypeName);
		customerServiceMailVO.setUserName(userName);
		customerServiceMailVO.setUserPhone(userPhone);
		customerServiceMailVO.setUserEmail(userEmail);
		customerServiceMailVO.setContentText(contentText);
		customerServiceMailVO.setCreateDate(createDate);
		dao.insert(customerServiceMailVO);

		return customerServiceMailVO;
	}

	public void deleteMail(Integer faqFormId) {
		dao.delete(faqFormId);
	}

	public List<CustomerServiceMailVO> getAll() {
		return dao.getAll();
	}
}
