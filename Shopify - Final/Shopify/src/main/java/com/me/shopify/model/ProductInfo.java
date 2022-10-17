package com.me.shopify.model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.me.shopify.pojo.Products;

public class ProductInfo {

    private int code;
    private String name;
    private double price;
 
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public ProductInfo() {
    }
    
    public ProductInfo(Products product) {
        this.code = product.getProdID();
        this.name = product.getProdName();
        this.price = product.getProdPrice();
    }
    

    public ProductInfo(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
    
    
}
