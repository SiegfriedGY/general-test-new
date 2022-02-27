package others;

public class StaticBlock {

    private static Entity01 entity;

    static {
        System.out.println("this is static block");
        entity = new Entity01(1, "aaa", true);
    }

    public static void main(String[] args){

        System.out.println("-----------------");
        System.out.println(entity);
                
    }
}
