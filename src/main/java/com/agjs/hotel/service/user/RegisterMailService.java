package com.agjs.hotel.service.user;

import com.agjs.hotel.bean.user.UserPo;

public interface RegisterMailService {

	void sendMail(UserPo user);
	
	UserPo verifyJedis(UserPo user);

}