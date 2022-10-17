package com.me.shopify.session;
import javax.servlet.http.HttpServletRequest;

import com.me.shopify.model.AddToCart;
public class UserSession {
	public static AddToCart getCartInSession(HttpServletRequest request) {
		 
        // Get Cart from Session.
		AddToCart cartInfo = (AddToCart) request.getSession().getAttribute("myCart");
        
        // If null, create it.
        if (cartInfo == null) {
            cartInfo = new AddToCart();
            
            // And store to Session.
            request.getSession().setAttribute("myCart", cartInfo);
        }
 
        return cartInfo;
    }
 
    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }
 
    public static void storeLastOrderedCartInSession(HttpServletRequest request, AddToCart cartInfo) {
        request.getSession().setAttribute("lastOrderedCart", cartInfo);
    }
    
    public static AddToCart getLastOrderedCartInSession(HttpServletRequest request) {
        return (AddToCart) request.getSession().getAttribute("lastOrderedCart");
    }
}
