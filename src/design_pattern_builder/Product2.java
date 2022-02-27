package design_pattern_builder;

import lombok.Data;

@Data
public class Product2 {

    private Long id;
    private String type;
    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static ProductBuilder builder(){
        return new ProductBuilder();
    }

    @Override
    public String toString() {
        return "Product2{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    /**
     * 以静态内部类的方式，直接在产品类中提供一个产品的builder，并通过产品类提供的静态方法获取builder，进行相关的各种build，更简洁一些，也具有良好的封装性。
     */
    static class ProductBuilder{

        private Product2 product2;

        private ProductBuilder(){
            this.product2 = new Product2();
        }

        public ProductBuilder id(Long id){
            this.product2.setId(id);
            return this;
        }

        public Long id(){
            return this.product2.getId();
        }

        public ProductBuilder type(String type){
            this.product2.setType(type);
            return this;
        }

        public String type(){
            return this.product2.getType();
        }

        public ProductBuilder brand(String brand){
            this.product2.setBrand(brand);
            return this;
        }

        public String brand(){
            return this.product2.getBrand();
        }

        public Product2 build(){
            return this.product2;
        }
    }
}
