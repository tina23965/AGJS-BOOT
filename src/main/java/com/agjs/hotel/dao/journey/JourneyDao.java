package com.agjs.hotel.dao.journey;

import java.util.List;

import com.agjs.hotel.bean.journey.JourneyPo;
import com.agjs.hotel.dao.CoreDao;

public interface JourneyDao extends CoreDao<JourneyPo, Integer> {

	List<JourneyPo> selectByTypeId(Integer typeId);

	List<JourneyPo> selectBykeyword(String keyword);

}
