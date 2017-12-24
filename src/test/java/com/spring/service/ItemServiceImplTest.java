package com.spring.service;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.spring.dao.ItemDAO;
import com.spring.model.Item;
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
public class ItemServiceImplTest extends AbstractTestNGSpringContextTests {
	private ItemService itemService;

	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService ws){
		this.itemService = ws;
	}

	@Test
	public void testListItems() {
		ItemService itemServiceMock = mock(ItemService.class);
		Item item = new Item();
		item.setId(1111);
		item.setName("test");
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		when(itemServiceMock.listItems()).thenReturn(itemList);

		List<Item> itemList1 = new ArrayList<Item>();
		assertThat(itemServiceMock.listItems()).isNotEqualTo(itemList1);
		assertThat(itemServiceMock.listItems()).isEqualTo(itemList);
	}

	@Test
	public void testGetItem() {
		ItemService itemServiceMock = mock(ItemService.class);
		Item item = new Item();
		item.setId(1111);
		item.setName("test");
		when(itemServiceMock.getItemById(1111)).thenReturn(item);

		Item item1 = new Item();
		item1.setId(1112);
		item1.setName("test1");

		assertThat(itemServiceMock.getItemById(1111)).isNotEqualTo(item1);
		assertThat(itemServiceMock.getItemById(1111)).isEqualTo(item);
	}

	@Test
	public void testAddItem() {
		ItemService itemServiceMock = mock(ItemService.class);

		doNothing().when(itemServiceMock).addItem(isA(Item.class));
		Item item = new Item();
		item.setId(1111);
		item.setName("test");
		itemServiceMock.addItem(item);

		verify(itemServiceMock, times(1)).addItem(item);
	}

	@Test
	public void testRemoveItem() {
		ItemService itemServiceMock = mock(ItemService.class);

		doNothing().when(itemServiceMock).removeItem(isA(Integer.class));

		itemServiceMock.removeItem(1111);

		verify(itemServiceMock, times(1)).removeItem(1111);
	}

	@Test
	public void testUpdateItem() {
		ItemService itemServiceMock = mock(ItemService.class);

		doNothing().when(itemServiceMock).updateItem(isA(Item.class));
		Item item = new Item();
		item.setId(1111);
		item.setName("test");
		itemServiceMock.updateItem(item);

		verify(itemServiceMock, times(1)).updateItem(item);
	}

}
