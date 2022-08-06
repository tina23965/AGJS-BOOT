package com.agjs.hotel.dao.user;

import com.agjs.hotel.bean.user.AdministratorPo;

public interface AdministratorDao {

	AdministratorPo selectLogin(AdministratorPo administrator);

	AdministratorPo selectByAccount(AdministratorPo administrator);
	
	AdministratorPo updatePwd(AdministratorPo administrator);
}