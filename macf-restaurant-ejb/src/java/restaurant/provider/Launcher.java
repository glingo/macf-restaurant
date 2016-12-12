/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.provider;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author caill
 */
public class Launcher {
    
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            Provider provider = (Provider) ctx.lookup("java:global/macf-restaurant/macf-restaurant-ejb/data-provider");
            System.out.println("------------------------------------->>>> "+provider);
            provider.provide();
        } catch (NamingException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
