package com.me.shopify.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.shopify.dao.OrderDAO;
import com.me.shopify.dao.ProductDAO;
import com.me.shopify.dao.UserDAO;

import com.me.shopify.pojo.OrderDetails;
import com.me.shopify.pojo.Products;
import com.me.shopify.pojo.User;

@Controller
public class ShopifyController {
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	@Autowired
	@Qualifier("orderDAO")
	OrderDAO odao;
	
	@RequestMapping(value="/addProduct.htm", method=RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Products product, BindingResult result) throws Exception {
		
		String modelObject=null;
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(result.hasErrors()) {
			return new ModelAndView("admin-dashboard", "product", product);
		}
		
		Boolean saved = pdao.addProduct(product);
		int count = 1;
        map.put("msgtyp", "add");
        
        if(saved) {
          map.put("msgfor", "success");
          map.put("rowcount", count);}
        else {
        	map.put("msgfor", "error");
        	map.put("msg", "Could not save product");
        }
		return new ModelAndView("add-success", "map", map);
	}
	
	@RequestMapping(value="/viewOrders.htm", method=RequestMethod.GET)
	public ModelAndView viewOrderPage(Model model) {
		
		List<OrderDetails> orderList = null;
		try {
			orderList = odao.displayOrder();
		} catch (Exception e) {
				}
		
		model.addAttribute("orderList", orderList);
		
		return new ModelAndView("viewOrders");
		
	}
	
	@RequestMapping(value="/viewMyOrders.htm", method=RequestMethod.GET)
	public String viewMyOrdersPage(HttpServletRequest request, UserDAO userDao, Model model) throws Exception {
		HttpSession session = request.getSession();
		 User u =  (User) session.getAttribute("user");
		List<OrderDetails> orderList = null;
		try {
			orderList = odao.displayOrderForCustomer(u);
		} catch (Exception e) {
				}
		model.addAttribute("orderList", orderList);
		
		 return "user-myorders";
		
	}
	
	@RequestMapping(value="/addProducts.htm", method=RequestMethod.GET)
	public String disThis() {

		 return  "admin-dashboard";
		
	}
	
	
	 @RequestMapping({ "/detailProducts.htm" })
	    public String listOrderProducts(HttpServletRequest request, Model model, //
	            @RequestParam(value = "id", defaultValue = "") int id) throws Exception {
		 List<Products> productList = new ArrayList<Products>();
	 
  HttpSession session = request.getSession();
        try {
			productList = odao.displayOrderProducts(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
        for(Products p : productList) {
			System.out.println("Controller"+p.getProdName());
		}
       
       session.setAttribute("productList", productList);
    
   return "product-detail";
}
	
}
