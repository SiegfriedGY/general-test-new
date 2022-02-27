package leetcode;

public class InvalidateIPAddress {
    public static void main(String[] args){

        String src = "255.255.50.0";
        String result = src.replaceAll("\\.", "[.]");
        System.out.println(result);

    }
}
