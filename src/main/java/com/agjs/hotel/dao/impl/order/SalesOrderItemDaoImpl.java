package com.agjs.hotel.dao.impl.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.agjs.hotel.bean.order.SalesOrderItemPo;
import com.agjs.hotel.dao.order.SalesOrderItemDao;

@Repository
public class SalesOrderItemDaoImpl implements SalesOrderItemDao {
	@PersistenceContext
	private Session session;


	@Override
	public SalesOrderItemPo select(Integer salesOrderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalesOrderItemPo> select() {
		List<SalesOrderItemPo> salesOrderItemPoList = new ArrayList<SalesOrderItemPo>();
		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<SalesOrderItemPo> criteriaQuery = criteriaBuilder.createQuery(SalesOrderItemPo.class);

			Root<SalesOrderItemPo> root = criteriaQuery.from(SalesOrderItemPo.class);
			criteriaQuery.select(root);

			Query<SalesOrderItemPo> query = session.createQuery(criteriaQuery);
			salesOrderItemPoList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderItemPoList;
	}

	@Override
	public SalesOrderItemPo insert(SalesOrderItemPo salesOrderItem) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean delete(Integer salesOrderHeaderId, Integer roomStyleId, Integer orderRoomQuantity,
//			Integer orderRoomPrice, Integer salesOrderItemId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public SalesOrderItemPo update(Integer salesOrderHeaderId, Integer roomStyleId, Integer orderRoomQuantity,
			Integer orderRoomPrice, Integer salesOrderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer salesOrderHeaderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
