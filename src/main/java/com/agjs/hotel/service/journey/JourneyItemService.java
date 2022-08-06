package com.agjs.hotel.service.journey;

import java.util.List;

import com.agjs.hotel.bean.journey.JourneyItemVo;

public interface JourneyItemService {

	List<JourneyItemVo> searchJourneyItemBySohId(String sohId);

	List<JourneyItemVo> searchJourneyItemByDateRange(java.util.Date startDate, java.util.Date endDate);

}