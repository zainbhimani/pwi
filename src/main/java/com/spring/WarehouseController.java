package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.WarehouseService;

import com.spring.model.Warehouse;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	private WarehouseService warehouseService;
	
	@Autowired(required=true)
	@Qualifier(value="warehouseService")
	public void setWarehouseService(WarehouseService ws){
		this.warehouseService = ws;
	}
	
	@RequestMapping(value = "/warehouses", method = RequestMethod.GET)
	public String listWarehouses(Model model) {
		model.addAttribute("warehouse", new Warehouse());
		model.addAttribute("listWarehouses", this.warehouseService.listWarehouses());
		return "warehouse";
	}
	
	//For add and update warehouse both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addWarehouse(@ModelAttribute("warehouse") Warehouse w){
		
		if(w.getId() == 0){
			//new warehouse, add it
			this.warehouseService.addWarehouse(w);
		}else{
			//existing warehouse, call update
			this.warehouseService.updateWarehouse(w);
		}
		
		return "redirect:/warehouse/warehouses";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeWarehouse(@PathVariable("id") int id){
		
        this.warehouseService.removeWarehouse(id);
        return "redirect:/warehouse/warehouses";
    }
 
    @RequestMapping("/edit/{id}")
    public String editWarehouse(@PathVariable("id") int id, Model model){
        model.addAttribute("warehouse", this.warehouseService.getWarehouseById(id));
        model.addAttribute("listWarehouses", this.warehouseService.listWarehouses());
        return "warehouse";
    }
	
}
