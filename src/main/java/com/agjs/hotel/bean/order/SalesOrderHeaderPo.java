package com.agjs.hotel.bean.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DynamicUpdate
@Table(name = "SALES_ORDER_HEADER")
public class SalesOrderHeaderPo {
	
//	SALES_ORDER_HEADER_ID int AI PK 
//	USER_ID int 
//	CREATE_DATE date 
//	ORDER_START_DATE date 
//	ORDER_END_DATE date 
//	ORDER_CHANGE_DATE date 
//	SALES_ORDER_STATUS_ID int 
//	ORDER_REMARK varchar(50) 
//	ORDER_ROOM_PRICE int 
//	ORDER_JOURNEY_PRICE int
	
	@Id
	@Column(name = "SALES_ORDER_HEADER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesOrderHeaderId;
	
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "CREATE_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createDate;
	
	@Column(name = "ORDER_START_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date orderStartDate;
	
	@Column(name = "ORDER_END_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date orderEndDate;
	
	@Column(name = "ORDER_CHANGE_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date orderChangeDate;
	
	@Column(name = "SALES_ORDER_STATUS_ID")
	private Integer salesOrderStatusId;
	
	@Column(name = "ORDER_REMARK")
	private String orderRemark;
	
	@Column(name = "ORDER_ROOM_PRICE")
	private Integer roomPrice;
	
	@Column(name = "ORDER_JOURNEY_PRICE")
	private Integer journeyPrice;

	@Override
	public String toString() {
		return "SOHeaderVO [salesOrderHeaderId=" + salesOrderHeaderId + ", userId=" + userId + ", createDate="
				+ createDate + ", orderStartDate=" + orderStartDate + ", orderEndDate=" + orderEndDate
				+ ", orderChangeDate=" + orderChangeDate + ", salesOrderStatusId=" + salesOrderStatusId
				+ ", orderRemark=" + orderRemark + ", roomPrice=" + roomPrice + ", journeyPrice=" + journeyPrice + "]";
	}

	public Integer getSalesOrderHeaderId() {
		return salesOrderHeaderId;
	}

	public void setSalesOrderHeaderId(Integer salesOrderHeaderId) {
		this.salesOrderHeaderId = salesOrderHeaderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getOrderStartDate() {
		return orderStartDate;
	}

	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

	public Date getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(Date orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public Date getOrderChangeDate() {
		return orderChangeDate;
	}

	public void setOrderChangeDate(Date orderChangeDate) {
		this.orderChangeDate = orderChangeDate;
	}

	public Integer getSalesOrderStatusId() {
		return salesOrderStatusId;
	}

	public void setSalesOrderStatusId(Integer salesOrderStatusId) {
		this.salesOrderStatusId = salesOrderStatusId;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Integer getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Integer getJourneyPrice() {
		return journeyPrice;
	}

	public void setJourneyPrice(Integer journeyPrice) {
		this.journeyPrice = journeyPrice;
	}
	
	
}
