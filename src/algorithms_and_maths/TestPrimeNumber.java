package algorithms_and_maths;

/**
 * 求1-100之间的质数
 * @author Siegfried GENG
 * @date 2019/9/5 - 12:25
 */
public class TestPrimeNumber {

    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {

            boolean flag = true;
            // 注意这里j的取值范围！<=i/2！！！
            for (int j = 2; j <= i/2; j++) {
                if (i%j == 0){
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(i+" ");
            }

        }

    }
    

}
