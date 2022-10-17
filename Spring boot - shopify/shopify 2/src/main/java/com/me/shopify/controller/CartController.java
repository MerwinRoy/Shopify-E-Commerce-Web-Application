package com.me.shopify.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.shopify.session.UserSession;
import com.me.shopify.dao.ProductDAO;
import com.me.shopify.model.AddToCart;
import com.me.shopify.model.ProductCart;
import com.me.shopify.model.ProductInfo;
import com.me.shopify.pojo.Products;

@Controller
public class CartController{
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	   @RequestMapping(value = "/displayCart.htm", method = RequestMethod.GET)
	    public String showCart() {
		   
	        return "shoppingCart";
	    }
	
	 @RequestMapping({ "/buyProduct.htm" })
	    public String listProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") int code) throws Exception {
		 Products product = null;
	  HttpSession session = request.getSession();
      if (code > 0) {
           try {
			product = pdao.findProduct(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      if (product != null) {
    	  
          // Cart info stored in Session.
    	  AddToCart cartInfo = UserSession.getCartInSession(request);

    	  ProductInfo productInfo = new ProductInfo(product);
          
          Products p = new Products();
          p = pdao.findProduct_trial(productInfo.getCode()); 
          cartInfo.addProduct(productInfo, 1, p);
          session.setAttribute("cartInfo", cartInfo);
          for(ProductCart c:cartInfo.getCartItems()) {
        	  System.out.println(c.getQuantity());
        	 
          }
   
          
          
          
      }
    
      // Redirect to shoppingCart page.
      
      return "shoppingCart";
  }
	 
	 @RequestMapping({ "/shoppingCartRemoveProduct.htm" })
	    public String removeProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") int code) {
		 Products product = null;
	        if (code > 0) {
	            try {
					product = pdao.findProduct(code);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if (product != null) {
	 
	            // Cart Info stored in Session.
	        	AddToCart cartInfo = UserSession.getCartInSession(request);
	 
	        	ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.removeProduct(productInfo);
	 
	        }
	        // Redirect to shoppingCart page.
	        
	        return "shoppingCart";
	    }
	 @RequestMapping({ "/clearCart.htm" })
	    public String clearCartHandler(HttpServletRequest request, Model model) {
		 AddToCart cartInfo = UserSession.getCartInSession(request);
	           cartInfo.getCartItems().clear();
	           HttpSession session = request.getSession();
	           session.setAttribute("cartInfo", cartInfo);
	       
	            return "customer-dashboard";
	        }
	        // Redirect to shoppingCart page.
	        
	      
} 
