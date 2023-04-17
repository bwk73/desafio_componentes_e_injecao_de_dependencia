package com.bwk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwk.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;

	public double total(Order order) {
		return order.getBasic() 
				- (order.getBasic() * order.getDiscount()/ 100.0)
				+ shippingService.shipment(order);
	}
};