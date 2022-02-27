package others;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Siegfried GENG
 * @date 2019/8/23 - 12:59
 */
public class TestDeprecated implements Serializable{

    @Deprecated
    public String test(){
        return "";
    }

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("999");
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(9);
    }

}
