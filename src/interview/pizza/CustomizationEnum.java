package interview.pizza;

public enum CustomizationEnum {

    Dough1(1,"dough_A"),
    Dough2(2,"dough_B"),

    Sauce1(3,"sauce_A"),
    Sauce2(4,"sauce_B"),

    Topping1(5, "topping_A"),
    Topping2(6,"topping_B"),

    Size1(7, "size_A"),
    Size2(8, "size_B"),

    Shape1(9,"shape_A"),
    Shape2(10,"shape_B");

    private int id;
    private String data;

    CustomizationEnum(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}
