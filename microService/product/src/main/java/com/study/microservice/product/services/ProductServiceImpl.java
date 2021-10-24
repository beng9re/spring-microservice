package com.study.microservice.product.services;

import org.springframework.web.bind.annotation.RestController;

import com.study.microservice.api.core.product.Product;
import com.study.microservice.api.core.product.ProductService;
import com.study.microservice.core.util.http.ServiceUtil;

@RestController
public class ProductServiceImpl implements ProductService {

	private final ServiceUtil serviceUtil;


	public ProductServiceImpl(ServiceUtil serviceUtil){
		this.serviceUtil = serviceUtil;
	}

	@Override
	public Product getProduct(int productId) {
		return new Product(productId,"name-"+productId,123,serviceUtil.getServiceAddress());
	}
}
