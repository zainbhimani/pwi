package com.spring.dao;

import java.util.List;

import com.spring.model.Warehouse;

public interface WarehouseDAO {

	public void addWarehouse(Warehouse i);
	public List<Warehouse> listWarehouses();
	public void updateWarehouse(Warehouse p);
	public Warehouse getWarehouseById(int id);
	public void removeWarehouse(int id);
}
