package com.han.main;

import java.util.Map;

import com.han.model.Order;
import com.han.model.OrderLine;

public class Calculator {
	
	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity + taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = getCaculatedTax(r.get(i));

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() * r.get(i).getQuantity() + tax;

				// Print out the item's total price
				System.out.println(r.get(i).getQuantity() + " " + r.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice() * r.get(i).getQuantity();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
	}
	
	/**
	 * Rounding method
	 * @param value
	 * @return
	 */
	private double rounding(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
	
	/**
	 * Return calculated tax by description
	 * @param orderLine
	 * @return
	 */
	private double getCaculatedTax(OrderLine orderLine) {
		// imported items
		if (orderLine.getItem().getDescription().toUpperCase().contains("IMPORTED")) {
			return rounding(orderLine.getItem().getPrice() * orderLine.getQuantity() * 0.15); // Extra 5% tax on
		} else {
			return rounding(orderLine.getItem().getPrice() * orderLine.getQuantity() * 0.10);
		}
	}
}
