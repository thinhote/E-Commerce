package com.ecom.ecommerce.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecommerce.entity.Cart;
import com.ecom.ecommerce.entity.ProductOrder;
import com.ecom.ecommerce.entity.ProductOrderRequest;
import com.ecom.ecommerce.repository.CartRepository;
import com.ecom.ecommerce.repository.ProductOrderRepository;
import com.ecom.ecommerce.service.ProductOrderService;
@Service
public class ProductOrderServiceImpl implements ProductOrderService{

	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public ProductOrder saveProductOrder(Long userId, ProductOrderRequest productOrderRequest) {
		
		//get which products are order by user
		List<Cart> listOfCarts = cartRepository.findByUserId(userId);
		for (Cart cart : listOfCarts) {
			
			ProductOrder order = new ProductOrder();
			
			order.setOrderId(UUID.randomUUID().toString());
			order.setOrderDate(new Date());
			
			order.setProduct(cart.getProduct());
			order.setPrice(cart.getProduct().getDiscountPrice());
			order.setQuantity(cart.getQuantity());
			
			order.setUser(cart.getUser());
			order.setStatus("In Progress");
			
			
			
		}
		
		return null;
	}

}
