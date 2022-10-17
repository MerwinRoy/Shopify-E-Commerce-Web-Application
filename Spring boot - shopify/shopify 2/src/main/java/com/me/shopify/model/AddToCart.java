package com.me.shopify.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.me.shopify.dao.ProductDAO;
import com.me.shopify.pojo.Products;
public class AddToCart {
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	 private int orderNum;
	
	   
	 
	    private final List<ProductCart> cartItems = new ArrayList<ProductCart>();
	 
	    public AddToCart() {
	 
	    }
	 
	    public int getOrderNum() {
	        return orderNum;
	    }
	 
	    public void setOrderNum(int orderNum) {
	        this.orderNum = orderNum;
	    }
	 
	  
	 
	    public List<ProductCart> getCartItems() {
	        return this.cartItems;
	    }
	 
	    public Boolean checkIfProductExists(int code){
	    	for (ProductCart item : this.cartItems) {
	            if (item.getProductInfo().getCode()==code) {
	            	System.out.println("In check");
	                return true;
	            }
	        }
	    	return false;
	    }
	    
	    public ProductCart findItemByCode(int code) {
	    	System.out.println("Called");
	        for (ProductCart item : this.cartItems) {
	            if (item.getProductInfo().getCode()==code) {
	            	System.out.println("In findItemByCart"+item.getAmount());
	                return item;
	            }
	        }
	        return null;
	    }
	 
	    public void addProduct(ProductInfo productInfo, int quantity, Products p) throws Exception {
	    	System.out.println("BEFORE CARTITEM LINE"+productInfo.getCode());

	    
	        	ProductCart line = new ProductCart();
	        	if (getCartItems().isEmpty()) {
		            line = new ProductCart();
		            line.setQuantity(1);
		            line.setProductInfo(productInfo);
		            line.setProduct(p);
		            this.cartItems.add(line);
		        }else {
		        	if (checkIfProductExists(productInfo.getCode())){
		        		line = findItemByCode(productInfo.getCode());
			        	
				        int newQuantity = line.getQuantity() + quantity;
				        if (newQuantity <= 0) {
				            this.cartItems.remove(line);
				        } else {
				            line.setQuantity(newQuantity);
				        }
		        	}else {
		        		System.out.println(p.getProdName()+"adding a new product");
		        		   line = new ProductCart();
				            line.setQuantity(1);
				            line.setProductInfo(productInfo);
				            line.setProduct(p);
				            this.cartItems.add(line);
		        	}
		        	
		        }
	        	
	    }
	 
	    public void validate() {
	 
	    }
	 
	    public void updateProduct(int code, int quantity) {
	    	ProductCart line = this.findItemByCode(code);
	 
	        if (line != null) {
	            if (quantity <= 0) {
	                this.cartItems.remove(line);
	            } else {
	                line.setQuantity(quantity);
	            }
	        }
	    }
	 
	    public void removeProduct(ProductInfo productInfo) {
	    	ProductCart line = this.findItemByCode(productInfo.getCode());
	        if (line != null) {
	            this.cartItems.remove(line);
	        }
	    }
	 
	    public boolean isEmpty() {
	        return this.cartItems.isEmpty();
	    }
	 
	  
	 
	    public int getQuantityTotal() {
	        int quantity = 0;
	        for (ProductCart line : this.cartItems) {
	            quantity += line.getQuantity();
	        }
	        return quantity;
	    }
	 
	  

		public double getAmountTotal() {
	        double total = 0;
	        for (ProductCart line : this.cartItems) {
	            total += line.getAmount();
	        }
	        return total;
	    }
	 
	    public void updateQuantity(AddToCart cartForm) {
	        if (cartForm != null) {
	            List<ProductCart> lines = cartForm.getCartItems();
	            for (ProductCart line : lines) {
	                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
	            }
	        }
	 
	    }
}