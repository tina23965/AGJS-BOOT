package com.agjs.hotel.service.impl.journey;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agjs.hotel.bean.journey.JourneyTypePo;
import com.agjs.hotel.bean.journey.JourneyTypeVo;
import com.agjs.hotel.dao.journey.JourneyTypeDao;
import com.agjs.hotel.service.journey.JourneyTypeService;

@Service
public class JourneyTypeServiceImpl implements JourneyTypeService {

	@Autowired
	private JourneyTypeDao journeyTypeDao;

	@Override
	@Transactional(readOnly = true)
	public List<JourneyTypeVo> getJourneyType() {

		List<JourneyTypeVo> journeyTypeVoList = new ArrayList<JourneyTypeVo>();
		List<JourneyTypePo> journeyTypePoList = new ArrayList<JourneyTypePo>();
		journeyTypePoList = journeyTypeDao.select();

		if (journeyTypePoList.size() != 0) {

			for (JourneyTypePo po : journeyTypePoList) {

				JourneyTypeVo vo = new JourneyTypeVo();
				vo.setJourneyType(po.getTypeName());
				journeyTypeVoList.add(vo);
				System.out.println(vo.getJourneyType());
			}
			
			return journeyTypeVoList;
		} else {
			return null;
		}

	}

	@Override
	public JourneyTypePo getJourneyType(Integer id) {

		return null;
	}

}
