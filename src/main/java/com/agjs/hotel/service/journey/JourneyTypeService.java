package com.agjs.hotel.service.journey;

import java.util.List;

import com.agjs.hotel.bean.journey.JourneyTypePo;
import com.agjs.hotel.bean.journey.JourneyTypeVo;

public interface JourneyTypeService {

	List<JourneyTypeVo> getJourneyType();

	JourneyTypePo getJourneyType(Integer id);

}