package com.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.spring.model.Warehouse;

@Repository
public class WarehouseDAOImpl implements WarehouseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(WarehouseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/**
	 * Function to add Warehouse
	 * @param i warehouse object to add
	 */
	public void addWarehouse(Warehouse i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(i);
		logger.info("Warehouse saved successfully, Warehouse Details="+i);
	}

	/**
	 * Function to list warehouses
	 * @return return list of warehouses
	 */
	@SuppressWarnings("unchecked")
	public List<Warehouse> listWarehouses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Warehouse> WarehouseList = session.createQuery("from Warehouse").list();
		for(Warehouse i : WarehouseList){
			logger.info("Warehouse List::"+i);
		}
		return WarehouseList;
	}

	/**
	 * Function to update warehouse
	 * @param p Function to update warehouse object
	 */
	@Override
	public void updateWarehouse(Warehouse p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Warehouse updated successfully, Warehouse Details="+p);
	}

	/**
	 * Function to get warehouse object
	 * @param id 
	 * @return
	 */
	@Override
	public Warehouse getWarehouseById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Warehouse i = (Warehouse) session.load(Warehouse.class, new Integer(id));
		logger.info("Warehouse loaded successfully, Warehouse details="+i);
		return i;
	}

	@Override
	public void removeWarehouse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Warehouse i = (Warehouse) session.load(Warehouse.class, new Integer(id));
		if(null != i){
			session.delete(i);
		}
		logger.info("Warehouse deleted successfully, Warehouse details="+i);
	}

}
