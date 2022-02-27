package others;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Siegfried GENG
 * @date 2019/8/26 - 13:38
 */
public class TestReflection {

    public static List<Entity01> removeUnlavidInstances(List<Entity01> fullList){

        List<Entity01> invalidList = new ArrayList<>();

        for (Entity01 entity01 : fullList) {

            Class clazz = entity01.getClass();
//            Field[] fields = clazz.getDeclaredFields();

            Field field = null;

            try {
                field = clazz.getDeclaredField("valid");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

//            for (Field field : fields) {

                field.setAccessible(true);
                Boolean valueStr = null;
                try {
                    Object value = field.get(entity01);
                    valueStr = (Boolean)value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (valueStr.equals(false)){
                    System.out.println("有不合格的！" + entity01.toString());
                    invalidList.add(entity01);

                }
            }

            fullList.removeAll(invalidList);

//        }

        return fullList;
    }

    
    public static void main(String[] args) {


        try {
            Class<?> clazz = Class.forName("others.CommonBean");
            Object o = clazz.newInstance();
            CommonBean bean = (CommonBean) o;
            System.out.println("这是反射创建的对象:" + bean);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


//        others.Entity01 e1 = new others.Entity01(1, "张三",true);
//        others.Entity01 e2 = new others.Entity01(2, "李四no",false);
//        others.Entity01 e3 = new others.Entity01(3, "王五",false);
//        others.Entity01 e4 = new others.Entity01(4, "赵六",false);
//        others.Entity01 e5 = new others.Entity01(5, "钱七",true);
//
//        List<others.Entity01> entity01List = new ArrayList<>();
//        entity01List.add(e1);
//        entity01List.add(e2);
//        entity01List.add(e3);
//        entity01List.add(e4);
//        entity01List.add(e5);
//
//        List<others.Entity01> entity01List1 = removeUnlavidInstances(entity01List);
//        System.out.println(entity01List1);


    }
}
