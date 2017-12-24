package com.spring.service;

import java.util.List;

import com.spring.model.Item;

public interface ItemService {

	public void addItem(Item item);
	public List<Item> listItems();
	public void updateItem(Item i);
	public Item getItemById(int id);
	public void removeItem(int id);
	
}
