package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.spring.model.Item;
import com.spring.model.Warehouse;
import com.spring.service.ItemService;
import java.util.*;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	private ItemService itemService;

	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService is){
		this.itemService = is;
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String listItems(Model model) {
		Set<Warehouse> warehouses = new HashSet<Warehouse>();
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1);
		warehouse.setName("test");
		warehouse.setCountry("pakistan");
		warehouses.add(warehouse);
		Item item = new Item();
		item.setWarehouses(warehouses);
		model.addAttribute("item", item);
		model.addAttribute("listItems", this.itemService.listItems());
		return "item";
	}
	
	//For add and update item both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item i){

		if(i.getId() == 0){
			//new item, add it
			this.itemService.addItem(i);
		}else{
			//existing item, call update
			this.itemService.updateItem(i);
		}

		return "redirect:/item/items";
	}

	@RequestMapping("/remove/{id}")
	public String removeItem(@PathVariable("id") int id){

		this.itemService.removeItem(id);
		return "redirect:/item/items";
	}

	@RequestMapping("/edit/{id}")
	public String editItem(@PathVariable("id") int id, Model model){
		model.addAttribute("item", this.itemService.getItemById(id));
		model.addAttribute("listItems", this.itemService.listItems());
		return "item";
	}
	
}
