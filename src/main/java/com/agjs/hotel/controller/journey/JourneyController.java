package com.agjs.hotel.controller.journey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agjs.hotel.bean.journey.JourneyFrontendVo;
import com.agjs.hotel.bean.journey.JourneyItemSelectVo;
import com.agjs.hotel.bean.journey.JourneyItemVo;
import com.agjs.hotel.bean.journey.JourneySearchVo;
import com.agjs.hotel.bean.journey.JourneyTypeVo;
import com.agjs.hotel.bean.journey.JourneyVo;
import com.agjs.hotel.service.journey.JourneyItemService;
import com.agjs.hotel.service.journey.JourneyService;
import com.agjs.hotel.service.journey.JourneyTypeService;

@RestController
@RequestMapping(path = { "/main/jrn", "/admin/jrn" })
public class JourneyController {

	@Autowired
	private JourneyTypeService journeyTypeService;
	@Autowired
	private JourneyItemService journeyItemService;
	@Autowired
	private JourneyService journeyService;

	// 回傳行程類型 journeyType
	@GetMapping("/type")
	public List<JourneyTypeVo> getTypes() {

		return journeyTypeService.getJourneyType();
	}

	// 訂單編號搜尋行程訂單
	@PostMapping("/item/sohid.item")
	public List<JourneyItemVo> searchJourneyItemBySohId(@RequestBody JourneyItemSelectVo JourneyItemSelectVo) {

		System.out.println("searchJourneyItemBySohId");
		System.out.println(JourneyItemSelectVo.getSohId());

		return journeyItemService.searchJourneyItemBySohId(JourneyItemSelectVo.getSohId());
	}

	@PostMapping("/item/date.item")
	public List<JourneyItemVo> searchJourneyItemByDate(@RequestBody JourneyItemSelectVo JourneyItemSelectVo) {

		System.out.println("searchJourneyItemByDate");

		return null;
//		return journeyItemService.searchJourneyItemByDateRange(JourneyItemSelectVo.getStartDate(),
//				JourneyItemSelectVo.getEndDate());
	}

//	@PostMapping("/add")
//	public List<JourneyItemVo> addJourney(@RequestBody JourneyItemSelectVo JourneyItemSelectVo) {
//
//		System.out.println("in");
//		System.out.println(JourneyItemSelectVo.getSohId());
//
//		return journeyItemService.searchJourneyItemBySohId(JourneyItemSelectVo.getSohId());
//	}
	
	// 新增行程
	@PostMapping("/add")
	public JourneyFrontendVo addJourney(@RequestBody JourneyFrontendVo journeyFrontendVo) {

		System.out.println("addJourney");
		System.out.println(journeyFrontendVo);
		System.out.println(journeyService.insertJourney(journeyFrontendVo));
		return journeyFrontendVo;

	}

	// 關鍵字搜尋行程
	@PostMapping("/search/keyword")
	public List<JourneyVo> searchJourneyByKeyword(@RequestBody JourneySearchVo journeySearchVo) throws Exception {

		System.out.println("add64");

		return journeyService.searchBykeyword(journeySearchVo);

	}

	// 更新行程
	@PostMapping("/update/jrn")
	public JourneyFrontendVo updateJourney(@RequestBody JourneyFrontendVo journeyFrontendVo) throws Exception {

		System.out.println("update");
		System.out.println(journeyFrontendVo);
		System.out.println(journeyService.updateJourney(journeyFrontendVo));
		return journeyFrontendVo;

	}

}
