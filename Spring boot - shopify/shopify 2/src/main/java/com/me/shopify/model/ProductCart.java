package com.me.shopify.model;

import com.me.shopify.pojo.Products;

public class ProductCart {

	 	private ProductInfo productInfo;
	    private int quantity;
	    private Products product;
	    
	    public ProductCart() {
	        this.quantity = 0;
	    }
	 
	    public Products getProduct() {
			return product;
		}

		public void setProduct(Products product) {
			this.product = product;
		}

		public ProductInfo getProductInfo() {
	        return productInfo;
	    }
	 
	    public void setProductInfo(ProductInfo productInfo) {
	        this.productInfo = productInfo;
	    }
	 
	    public int getQuantity() {
	        return quantity;
	    }
	 
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	 
	    public double getAmount() {
	        return this.productInfo.getPrice() * this.quantity;
	    }
}

