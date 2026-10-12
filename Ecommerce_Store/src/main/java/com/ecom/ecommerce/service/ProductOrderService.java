package com.ecom.ecommerce.service;

import com.ecom.ecommerce.entity.ProductOrder;
import com.ecom.ecommerce.entity.ProductOrderRequest;

public interface ProductOrderService {
	
	public ProductOrder saveProductOrder(Long id, ProductOrderRequest productOrderRequest);
}
