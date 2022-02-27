package others;

public class ClassCast {
    
    public static void main(String[] args){
        
        Object o = 111;
        Long dest = Long.valueOf((Integer)o);
        System.out.println(dest);
        System.out.println(dest.getClass());

        Object o1 = 123;
        String str = String.valueOf(o1);
        System.out.println(str);


    }
}
