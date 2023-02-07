package com.zaynsolution.ordermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// This class is mapped to the Order table. If you notice below in order object I have used `. 
// This is becuase order is a reserve word in JPA. If you table has the same name, then you need to use ` 

@Entity
@Table(name = "`order`")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer customer_id;

	private String order_detail;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrder_detail() {
		return order_detail;
	}

	public void setOrder_detail(String order_detail) {
		this.order_detail = order_detail;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}	


}
