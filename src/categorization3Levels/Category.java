package categorization3Levels;

import java.util.List;

public class Category {

    private Integer id;
    private Integer pid;
    private Integer c_level;
    private String c_name;
    private Integer sort;
    private List<Category> children;

    public Category(Integer id, Integer pid, Integer c_level, String c_name, Integer sort) {
        this.id = id;
        this.pid = pid;
        this.c_level = c_level;
        this.c_name = c_name;
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getC_level() {
        return c_level;
    }

    public void setC_level(Integer c_level) {
        this.c_level = c_level;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", pid=" + pid +
                ", c_level=" + c_level +
                ", c_name='" + c_name + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }
}
