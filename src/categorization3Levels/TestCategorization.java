package categorization3Levels;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class TestCategorization {

    public static void main(String[] args) throws Exception {

        Category c1 = new Category(1,0,1,"一级分类1",0);
        Category c2 = new Category(2,0,1,"一级分类2",0);

        Category c3 = new Category(3,1,2,"二级分类1",0);
        Category c4 = new Category(4,1,2,"二级分类2",0);
        Category c5 = new Category(5,1,2,"二级分类3",0);
        c3.setSort(0);
        c4.setSort(5);
        c5.setSort(2);

        Category c6 = new Category(6,2,2,"二级分类4",0);
        Category c7 = new Category(7,2,2,"二级分类5",0);

        Category c8 = new Category(8,3,3,"三级分类1",0);
        Category c9 = new Category(9,3,3,"三级分类2",0);
        Category c10 = new Category(10,4,3,"三级分类3",0);
        Category c11 = new Category(11,4,3,"三级分类4",0);
        Category c12 = new Category(12,5,3,"三级分类5",0);
        Category c13 = new Category(13,5,3,"三级分类6",0);
        Category c14 = new Category(14,5,3,"三级分类7",0);
        Category c15 = new Category(15,6,3,"三级分类8",0);
        Category c16 = new Category(16,6,3,"三级分类9",0);
        Category c17 = new Category(17,7,3,"三级分类10",0);
        Category c18 = new Category(18,7,3,"三级分类11",0);

        List<Category> list = new LinkedList<>();

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c9);
        list.add(c10);
        list.add(c11);
        list.add(c12);
        list.add(c13);
        list.add(c14);
        list.add(c15);
        list.add(c16);
        list.add(c17);
        list.add(c18);

        List<Category> result = listInTree(list);
        System.out.println(JSON.toJSON(result));

    }

    private static List<Category> listInTree(List<Category> list) {
        return list.stream().filter(e->e.getC_level()==1)
                .peek(e-> e.setChildren(getChildren(e, list)))
                .sorted(Comparator.comparingInt(Category::getSort))
                .collect(Collectors.toList());
    }

    private static List<Category> getChildren(Category parent, List<Category> list) {
        return list.stream().filter(e -> e.getPid().equals(parent.getId()))
                .peek(e->e.setChildren(getChildren(e, list)))
                .sorted(Comparator.comparingInt(Category::getSort))
                .collect(Collectors.toList());

    }
}
