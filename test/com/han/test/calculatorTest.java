package com.han.test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.han.main.Calculator;
import com.han.model.Item;
import com.han.model.Order;
import com.han.model.OrderLine;

public class calculatorTest {

	private Item item1;
	private Item item2;
	
	private Order order1;
	private Order order2;
	
	private OrderLine orderLine1;
	private OrderLine orderLine2;
	
	private Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
		item1 = new Item("wine", (float) 15.22);
		item2 = new Item("imported wine", (float) 15.22);
		
		orderLine1 = new OrderLine(item1, 1);
		orderLine2 = new OrderLine(item2, 2);
		
		order1 = new Order();
		order2 = new Order();
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Ignore
	public void addNullOrderTest() throws Exception {
		order2.add(null);
	}
	
	@Test
	public void calculateTest() throws Exception {
		Map<String, Order> map = new LinkedHashMap<String, Order>();
		order1.add(orderLine1);
		map.put("Order 1", order1);
		
		order2.add(orderLine1);
		order2.add(orderLine2);
		
		map.put("Order 2", order2);
		
		calc.calculate(map);
		
		
	}
}
