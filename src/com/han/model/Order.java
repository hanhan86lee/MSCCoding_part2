package com.han.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderLine> orderLines;
	
	public Order() {
		this.orderLines = new ArrayList<>();
	}
	
	public Order(OrderLine orderLine) {
		this.orderLines = new ArrayList<>();
		orderLines.add(orderLine);
	}
	
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}
