/**
 * Han Lee - 01/25/2017
 */
package com.han.main;

import java.util.LinkedHashMap;
import java.util.Map;

import com.han.model.Item;
import com.han.model.Order;
import com.han.model.OrderLine;

public class MSCmain {
	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();

		Order c1 = new Order();
		Order c2 = new Order();
		Order c3 = new Order();

		c1.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c1.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c1);

		c2.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c2.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c2);

		c3.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c3.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c3.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c3.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c3);

		new Calculator().calculate(o);
	}
}
