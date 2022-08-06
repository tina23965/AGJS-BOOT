package com.agjs.hotel.service.journey;

import java.util.List;

import com.agjs.hotel.bean.journey.JourneyFrontendVo;
import com.agjs.hotel.bean.journey.JourneyPo;
import com.agjs.hotel.bean.journey.JourneySearchVo;
import com.agjs.hotel.bean.journey.JourneyVo;

public interface JourneyService {

	int insertJourney(JourneyFrontendVo journeyFrontendVo);

	int updateJourney(JourneyFrontendVo journeyFrontendVo);

	List<JourneyPo> searchByTypeId(JourneySearchVo journeySearchVo);
	
	List<JourneyVo> searchBykeyword(JourneySearchVo journeySearchVo);

}