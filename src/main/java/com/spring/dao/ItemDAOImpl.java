package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.spring.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	public void addItem(Item i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(i);
		logger.info("Item saved successfully, Item Details="+i);
	}

	@SuppressWarnings("unchecked")
	public List<Item> listItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> itemList = session.createQuery("from Item").list();
		for(Item i : itemList){
			logger.info("Item List::"+i);
		}
		return itemList;
	}

	@Override
	public void updateItem(Item p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Item updated successfully, Item Details="+p);
	}

	@Override
	public Item getItemById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item i = (Item) session.load(Item.class, new Integer(id));
		logger.info("Item loaded successfully, Item details="+i);
		return i;
	}

	@Override
	public void removeItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item i = (Item) session.load(Item.class, new Integer(id));
		if(null != i){
			session.delete(i);
		}
		logger.info("Item deleted successfully, item details="+i);
	}

}
