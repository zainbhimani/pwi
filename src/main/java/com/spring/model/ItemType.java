package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author zabbas
 *
 */
@Entity
@Table(name = "ItemType")
public enum ItemType {
	FINISHED_PRODUCT, COMPONENT, PACKAGING_MATERIAL;
	@Id
	public String name = toString();
}
