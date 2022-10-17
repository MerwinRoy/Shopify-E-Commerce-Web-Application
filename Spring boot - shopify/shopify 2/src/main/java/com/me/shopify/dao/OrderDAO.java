package com.me.shopify.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;


import com.me.shopify.pojo.OrderDetails;
import com.me.shopify.pojo.Products;
import com.me.shopify.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends DAO{

	
	public OrderDAO() {
    
    }
    
    

    public Boolean addOrder(OrderDetails o) throws Exception{
        try {
   begin();
getSession().save(o);
commit();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return false;
        } 

    }
    
    
    public OrderDetails findOrder(int id) throws Exception {
    	OrderDetails order = new OrderDetails();
    	 String select_query= "from Order where ID=:ID";
    	 
    	 try {
         	
 
             Query q=getSession().createQuery(select_query);
             q.setParameter("id", id);
             
             order = (OrderDetails) q.uniqueResult();
      //here 
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
         
         return order;
    
    }
    
    public List<OrderDetails> displayOrder() throws Exception{
        List<OrderDetails> ordertList = new ArrayList<OrderDetails>();
        begin();
        String select_query= "from OrderDetails";
        try {
        	
        	
            Query q=getSession().createQuery(select_query);
            
            ordertList = q.list();
            commit(); 
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return ordertList;
    }
    
    public List<OrderDetails> displayOrderForCustomer(User u) throws Exception{
    	System.out.println("hereeeeeeeeeeeeeeeeeee"+u.getUserEmail());
        List<OrderDetails> ordertList = new ArrayList<OrderDetails>();
        begin();
        String select_query= "from OrderDetails where cname=:cname";
        
        try {
        	
            Query q=getSession().createQuery(select_query);
            q.setString("cname", u.getUserEmail());
          
            ordertList = q.list();
            commit(); 
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return ordertList;
    }
        
    public List<Products> displayOrderProducts(int id) throws Exception{
        List<Products> productList = new ArrayList<Products>();
        begin();
        String select_query= "SELECT o.productList from OrderDetails o where o.ID=:ID";
        try {
        	
        	
            Query q=getSession().createQuery(select_query);
            q.setParameter("ID", id);
            productList = q.list();
            commit(); 
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
    
}
