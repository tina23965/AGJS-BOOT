package com.agjs.hotel.dao.journey;

import java.util.List;

import com.agjs.hotel.bean.journey.JourneyItemPo;
import com.agjs.hotel.dao.CoreDao;

public interface JourneyItemDao extends CoreDao<JourneyItemPo, Integer> {

	public List<JourneyItemPo> selectBySohId(String sohId);

	public List<JourneyItemPo> selectByDateRange(String startDate, String endDate);

}
