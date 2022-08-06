package com.agjs.hotel.controller.announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agjs.hotel.bean.announcement.AnnouncementPo;
import com.agjs.hotel.service.announcement.AnnouncementService;

@RestController
@RequestMapping("/admin/announcement")
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("/all")
	public List<AnnouncementPo> allAnm() {
		return announcementService.allAnm();
	}
	
	@PostMapping("/keyword")
	public List<AnnouncementPo> selectKeyword(String keyword) {
		return announcementService.selectKeyword(keyword);
	}
	
	@PutMapping("/insert")
	public AnnouncementPo insertAnm(@RequestBody AnnouncementPo announcementPo) {
		announcementService.insertAnm(announcementPo);
		return announcementPo;
	}
	
	@PostMapping("/searchAnm")
	public List<AnnouncementPo> getAnmInfo(@RequestBody AnnouncementPo announcementPo){
		return announcementService.getAnmInfo(announcementPo);
	}
	
	@DeleteMapping("/delete")
	public List<AnnouncementPo> delete(@RequestBody AnnouncementPo announcementPo){
		return announcementService.delete(announcementPo);
	}

}
