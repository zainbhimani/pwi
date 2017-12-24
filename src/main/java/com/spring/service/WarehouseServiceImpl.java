package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dao.WarehouseDAO;
import com.spring.model.Warehouse;


@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	private WarehouseDAO WarehouseDAO;

	public void setWarehouseDAO(WarehouseDAO WarehouseDAO) {
		this.WarehouseDAO = WarehouseDAO;
	}

	@Override
	@Transactional
	public void addWarehouse(Warehouse i) {
		this.WarehouseDAO.addWarehouse(i);
	}

	@Override
	@Transactional
	public List<Warehouse> listWarehouses() {
		return this.WarehouseDAO.listWarehouses();
	}


	@Override
	@Transactional
	public void updateWarehouse(Warehouse i) {
		this.WarehouseDAO.updateWarehouse(i);
	}

	@Override
	@Transactional
	public Warehouse getWarehouseById(int id) {
		return this.WarehouseDAO.getWarehouseById(id);
	}

	@Override
	@Transactional
	public void removeWarehouse(int id) {
		this.WarehouseDAO.removeWarehouse(id);
	}
}
