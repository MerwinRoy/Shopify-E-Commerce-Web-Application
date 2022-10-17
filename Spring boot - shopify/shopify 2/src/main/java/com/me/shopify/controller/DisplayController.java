package com.me.shopify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.shopify.dao.ProductDAO;

import com.me.shopify.pojo.Products;

@Controller
public class DisplayController {

	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	

	@RequestMapping(value="/displayProducts.htm", method=RequestMethod.GET)
	public ModelAndView displayProducts(HttpServletRequest request) throws Exception{
		System.out.println("in pro controller");
	HttpSession session = request.getSession();
	session.getAttribute("user");
		Map<String, Object> map = new HashMap<String,Object>();
		
		 List<Products> productlist = pdao.displayProduct();
      if(productlist == null || productlist.size() == 0){
          map.put("msgfor", "error");
          map.put("msg", "No product found");
      }
          else{
          map.put("msgfor", "success");
          map.put("productlist", productlist);
      }
		
		return new ModelAndView("product-page", "map", map);
	}
	
	@RequestMapping(value = "/aboutUs.htm", method = RequestMethod.GET)
	public String aboutUs() {

		
	    return "aboutUs";
	}
	@RequestMapping(value = "/homeRedirect.htm", method = RequestMethod.GET)
	public String dislayHome() {

		
	    return "customer-dashboard";
	}
	@RequestMapping(value = "/getSearchPage.htm", method = RequestMethod.GET)
	public String displaySearchBox() {

		
	    return "user-dashboard";
	}
}
