package design_pattern_builder;

public class Customer {

    public static void main(String[] args) {

        ProductBuilder builder = new ProductBuilder();
//        Product product = builder.id(3L).name("汽车").brand("宝马").build();
        Product product = builder.id(4L).build();
        System.out.println(product);
        System.out.println(builder.id());

        Product2 product2 = Product2.builder().id(888L).type("火车").build();
        System.out.println(product2);

//        Product3 product3 = Product3.builder().id(333).name("啊啊啊啊").build();
//        System.out.println(product3);
    }
}
