package com.me.shopify.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.shopify.session.UserSession;
import com.me.shopify.dao.OrderDAO;
import com.me.shopify.model.AddToCart;

import com.me.shopify.model.ProductCart;
import com.me.shopify.pojo.OrderDetails;
import com.me.shopify.pojo.Products;



@Controller
public class OrderController {
	@Autowired
	@Qualifier("orderDAO")
	OrderDAO odao;
	
	 @RequestMapping(value = "/displayOrderForm.htm", method = RequestMethod.GET)
	    public String createOrderForm(HttpServletRequest request) {
		
	        return "create-order";
	    }
	    @RequestMapping(value = "/displayOrderForm.htm", method = RequestMethod.POST)
	    public String handleCreateForm(HttpServletRequest request, ModelMap map) {
	    	
	    	
	    	AddToCart myCart = UserSession.getCartInSession(request);
	    	  if (myCart.isEmpty()) {
	              // Redirect to shoppingCart page.
	              return "redirect:/shoppingCart";
	          } 
	    	 	List<Products> productList = new ArrayList();
	    	 	
	    	 	for(ProductCart c : myCart.getCartItems()) {
	    	 		productList.add(c.getProduct());
	    	 		System.out.println(c.getProduct().getProdName());
	    	 	}
	    	 	
	            String customerName = request.getParameter("customerName");
	            String customerAddress = request.getParameter("customerAddress");
	            OrderDetails order = new OrderDetails();
	            order.setCaddress(customerAddress);
	            order.setCname(customerName);
	            order.settPrice(myCart.getAmountTotal());
	            order.setQuantity(myCart.getQuantityTotal());
	            order.setProductList(productList);
	            
	            try {
	            	Boolean saved = odao.addOrder(order);
	             
	             
	             
	                
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            UserSession.removeCartInSession(request);
	            return "order-success";
	    }
	    
	    @RequestMapping(value = "/userOrders.htm", method = RequestMethod.GET)
	    public String viewOrders() {
		 	
	        return "user-orders";
	    }
	    
}
