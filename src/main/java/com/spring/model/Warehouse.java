package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.*;
import java.util.*;
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author zabbas
 *
 */
@Entity
@Table(name="WAREHOUSE")
public class Warehouse {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String country;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "Item_Warehouse",
			joinColumns = { @JoinColumn(name = "warehouseId") },
			inverseJoinColumns = { @JoinColumn(name = "itemId") }
	)
	private Set<Item> items = new HashSet<Item>();

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
