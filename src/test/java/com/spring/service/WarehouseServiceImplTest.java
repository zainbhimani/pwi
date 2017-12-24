package com.spring.service;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.spring.dao.WarehouseDAO;
import com.spring.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.mockito.Mockito.*;
import java.util.*;
import static org.assertj.core.api.Assertions.*;



@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
public class WarehouseServiceImplTest extends AbstractTestNGSpringContextTests {
	private WarehouseService warehouseService;

	@Autowired(required=true)
	@Qualifier(value="warehouseService")
	public void setWarehouseService(WarehouseService ws){
		this.warehouseService = ws;
	}

	@Test
	public void testListWarehouses() {
		WarehouseService warehouseServiceMock = mock(WarehouseService.class);
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1111);
		warehouse.setName("test");
		warehouse.setCountry("pakistan");
		List<Warehouse> warehouseList = new ArrayList<Warehouse>();
		warehouseList.add(warehouse);
		when(warehouseServiceMock.listWarehouses()).thenReturn(warehouseList);

		List<Warehouse> warehouseList1 = new ArrayList<Warehouse>();
		assertThat(warehouseServiceMock.listWarehouses()).isNotEqualTo(warehouseList1);
		assertThat(warehouseServiceMock.listWarehouses()).isEqualTo(warehouseList);
	}

	@Test
	public void testGetWarehouse() {
		WarehouseService warehouseServiceMock = mock(WarehouseService.class);
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1111);
		warehouse.setName("test");
		warehouse.setCountry("pakistan");
		when(warehouseServiceMock.getWarehouseById(1111)).thenReturn(warehouse);

		Warehouse warehouse1 = new Warehouse();
		warehouse1.setId(1112);
		warehouse1.setName("test1");
		warehouse1.setCountry("pakistan1");

		assertThat(warehouseServiceMock.getWarehouseById(1111)).isNotEqualTo(warehouse1);
		assertThat(warehouseServiceMock.getWarehouseById(1111)).isEqualTo(warehouse);
	}

	@Test
	public void testAddWarehouse() {
		WarehouseService warehouseServiceMock = mock(WarehouseService.class);

		doNothing().when(warehouseServiceMock).addWarehouse(isA(Warehouse.class));
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1111);
		warehouse.setName("test");
		warehouse.setCountry("pakistan");
		warehouseServiceMock.addWarehouse(warehouse);

		verify(warehouseServiceMock, times(1)).addWarehouse(warehouse);
	}

	@Test
	public void testRemoveWarehouse() {
		WarehouseService warehouseServiceMock = mock(WarehouseService.class);

		doNothing().when(warehouseServiceMock).removeWarehouse(isA(Integer.class));

		warehouseServiceMock.removeWarehouse(1111);

		verify(warehouseServiceMock, times(1)).removeWarehouse(1111);
	}

	@Test
	public void testUpdateWarehouse() {
		WarehouseService warehouseServiceMock = mock(WarehouseService.class);

		doNothing().when(warehouseServiceMock).updateWarehouse(isA(Warehouse.class));
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1111);
		warehouse.setName("test");
		warehouse.setCountry("pakistan");
		warehouseServiceMock.updateWarehouse(warehouse);

		verify(warehouseServiceMock, times(1)).updateWarehouse(warehouse);
	}

}
