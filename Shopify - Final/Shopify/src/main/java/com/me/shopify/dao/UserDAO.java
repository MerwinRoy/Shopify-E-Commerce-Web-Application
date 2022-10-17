package com.me.shopify.dao;

import org.hibernate.HibernateException;
//import org.hibernate.query.Query;

import com.me.shopify.pojo.User;

public class UserDAO extends DAO{
	
	
	public User register(User u) throws Exception {
        try {
            begin();
            System.out.println("inside DAO");
            getSession().save(u);
            commit();
            return u;

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating user: " + e.getMessage());
        }
    }
	
	public boolean updateUser(String email) throws Exception {
        try {
            begin();
            System.out.println("inside DAO");
            org.hibernate.Query q = getSession().createQuery("from User where userEmail = :useremail");
            q.setString("useremail", email);
            User user = (User) q.uniqueResult();
            if(user!=null){
                user.setStatus(1);
                getSession().update(user);
                commit();
                return true;
            }else{
                return false;
            }

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating user: " + e.getMessage());
        }
    
    }
	
	public User get(String userEmail, String password) throws Exception {
        try {
            begin();
            org.hibernate.Query q = getSession().createQuery("from User where userEmail = :useremail and password = :password");
            q.setString("useremail", userEmail);
            q.setString("password", password);            
            User user = (User) q.uniqueResult();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + userEmail, e);
        }
    }
	
	public User get(String userEmail){
        try {
            begin();
            org.hibernate.Query q = getSession().createQuery("from User where userEmail = :useremail");
            q.setString("useremail", userEmail);
            User user = (User) q.uniqueResult();
            return user;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
        
    }

}
