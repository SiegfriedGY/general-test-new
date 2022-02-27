package others;

/**
 * @author Siegfried GENG
 * @date 2019/8/26 - 13:43
 */
public class Entity01 {

    private Integer id;

    private String name;

    private boolean valid;

    public Entity01(Integer id, String name, boolean valid) {
        this.id = id;
        this.name = name;
        this.valid = valid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "others.Entity01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", valid=" + valid +
                '}';
    }
}
