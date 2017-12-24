package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.*;
import java.util.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author zabbas
 *
 */
@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="typeId")
	private ItemType itemType;

	private int size;

	private int inStock;

	private int avgQty;

	private int inTransit;

	private int MOQ;

	private int QPB;

	private int reorderPoint;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getAvgQty() {
		return avgQty;
	}

	public void setAvgQty(int avgQty) {
		this.avgQty = avgQty;
	}

	public int getInTransit() {
		return inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public int getMOQ() {
		return MOQ;
	}

	public void setMOQ(int MOQ) {
		this.MOQ = MOQ;
	}

	public int getQPB() {
		return QPB;
	}

	public void setQPB(int QPB) {
		this.QPB = QPB;
	}

	public int getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "Item_Warehouse",
			joinColumns = { @JoinColumn(name = "itemId") },
			inverseJoinColumns = { @JoinColumn(name = "warehouseId") }
	)
	Set<Warehouse> warehouses = new HashSet<Warehouse>();

	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Set<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	@Override
	public String toString(){
		return "id="+id+", name="+name+", itemType="+itemType;
	}
}
