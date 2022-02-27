package collections_related;

import java.util.Objects;

/**
 * @author Siegfried GENG
 * @date 2019/9/4 - 21:45
 */
public class CommonBean {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonBean)) return false;
        CommonBean that = (CommonBean) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonBean(int id, String name) {

        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "others.CommonBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public CommonBean() {
    }
}
