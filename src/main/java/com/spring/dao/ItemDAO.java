package com.spring.dao;

import java.util.List;

import com.spring.model.Item;

public interface ItemDAO {

	public void addItem(Item i);
	public List<Item> listItems();
	public void updateItem(Item p);
	public Item getItemById(int id);
	public void removeItem(int id);
}
