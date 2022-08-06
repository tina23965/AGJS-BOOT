package com.agjs.hotel.service.announcement;

import java.util.List;

import com.agjs.hotel.bean.announcement.AnnouncementPo;


public interface AnnouncementService {
	List<AnnouncementPo> allAnm();
	List<AnnouncementPo> selectKeyword(String keyword);
	List<AnnouncementPo> selectStartDate(AnnouncementPo announcementPo);
	List<AnnouncementPo> selectEndDate(AnnouncementPo announcementPo);
	List<AnnouncementPo> selectType(AnnouncementPo announcementPo);
	AnnouncementPo insertAnm(AnnouncementPo announcementPo);
	AnnouncementPo updateAnm(Integer anmId);
	List<AnnouncementPo> delete(AnnouncementPo announcementPo);
	List<AnnouncementPo> getAnmInfo(AnnouncementPo announcementPo);
}
