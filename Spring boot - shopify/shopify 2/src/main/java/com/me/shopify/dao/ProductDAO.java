package com.me.shopify.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;


import com.me.shopify.model.Record;
import com.me.shopify.model.ProductInfo;
import com.me.shopify.pojo.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO extends DAO{

	public ProductDAO() {
    
    }

    public Boolean addProduct(Products mv) throws Exception{
        try {
        	System.out.println("in pro dao");
        	begin();
        	getSession().save(mv);
        	commit();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return false;
        } 

    }
    
    public void printThis(){
    	System.out.println("check");
    }
    
    public Products findProduct(int code) throws Exception {
    	Products product = new Products();
    	 String select_query= "from Shopify where prodID=:product_code";
    	
    	 try {
       begin();
             Query q=getSession().createQuery(select_query);
             q.setParameter("product_code", code);
            System.out.println(code+"This is code");
             product = (Products) q.uniqueResult();
             close(); 
              System.out.println(product.getProdName());
              System.out.println("1");
             return product;
     
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
         System.out.println("2");
         return null;
    
    }
    
    public Products findProduct_trial(int code) throws Exception {
    	Products product = new Products();
    	 String select_query= "from Shopify where prodID=:product_code";
    	
    	 try { 
       begin();
             Query q=getSession().createQuery(select_query);
             q.setParameter("product_code", code);
             System.out.println("in findproduct trial");
             product = (Products) q.uniqueResult();
          commit();
             return product;
     
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
      
         return null;
    
    }
    
    public Record<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage  ){
    	
				return null;
    	
    }

public Record<Products> queryProducts(int page, int maxResult,
            int maxNavigationPage, String likeName){
	 String sql = "Select new " + ProductInfo.class.getName() //
             + "(p.prod_id, p.prodName, p.prodPrice) " + " from "//
             + Products.class.getName() + " p ";
     if (likeName != null && likeName.length() > 0) {
         sql += " Where lower(p.prodName) like :likeName ";
     }
     sql += " order by p.createDate desc ";
     
     Session session = sessionFactory.getCurrentSession();

     Query query = session.createQuery(sql);
     if (likeName != null && likeName.length() > 0) {
         query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
     }
     return new Record<Products>(query, page, maxResult, maxNavigationPage);
	
}
    public List<Products> displayProduct() throws Exception{
        List<Products> productList = new ArrayList<Products>();
      
        
        String select_query= "from Shopify";
        try {
        begin();
            Query q=getSession().createQuery(select_query);
            
            productList = q.list();
            
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
    
    public List<Products> displayOrderProduct(int Id) throws Exception{
        List<Products> productList = new ArrayList<Products>();
        
        String select_query= "from OrderDetails where id=:ID";
        try {
        begin();
            Query q=getSession().createQuery(select_query);
            
            productList = q.list();
            
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
        
    
}
