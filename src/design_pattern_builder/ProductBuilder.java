package design_pattern_builder;

public class ProductBuilder {

    private Product product;

    public ProductBuilder(){
        this.product = new Product();
    }

    public ProductBuilder id(Long id){
        this.product.setId(id);
        return this;
    }

    public Long id(){
        return this.product.getId();
    }

    public ProductBuilder name(String name){
        this.product.setName(name);
        return this;
    }

    public String name(){
        return this.product.getName();
    }

    public ProductBuilder brand(String brand){
        this.product.setBrand(brand);
        return this;
    }

    public String brand(){
        return this.product.getBrand();
    }
    public Product build(){
        return this.product;
    }

}
