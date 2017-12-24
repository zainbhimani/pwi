package com.spring.service;

import java.util.List;

import com.spring.model.Warehouse;

public interface WarehouseService {

	public void addWarehouse(Warehouse warehouse);
	public List<Warehouse> listWarehouses();
	public void updateWarehouse(Warehouse w);
	public Warehouse getWarehouseById(int id);
	public void removeWarehouse(int id);
	
}
