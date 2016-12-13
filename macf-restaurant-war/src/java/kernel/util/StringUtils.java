/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel.util;

/**
 *
 * @author cdi305
 */
public abstract class StringUtils {
    
    public static String concat(String a, String b) {
        return a + b;
    }
    
    
    public static String fill(String a, String b, int l) {
        
        while (a.length() < l) {
            a = concat(a, b);
        }
        
        return a;
    }
    
    public static String fillLeft(String a, String b, int l) {
        
        while (a.length() < l) {
            a = concat(b, a);
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        System.out.println(StringUtils.concat("ab", " v"));
        System.out.println(StringUtils.fill("a", "b", 20));
        System.out.println(StringUtils.fill("", "=", 20));
        System.out.println(StringUtils.fillLeft(">", "=", 120));
    }
}
