package kernel.util;

public abstract class IntegerUtils {
    
    public static Integer add(int a, int b){
        return a + b;
    }
    
    public static Integer max(int a, int b){
        return a > b ? a : b;
    }
    
    public static void main(String[] args) {
        System.out.println(IntegerUtils.add(1, 5));
        System.out.println(IntegerUtils.max(10, 20));
    }
    
}
