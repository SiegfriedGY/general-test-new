package basics;

public class LoopTest {

    public static void main(String[] args) {

        outer: for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("去你妹:["+i+"]["+j+"]");
                if (j==2)
                    break outer; // 不写outer只能跳出本层循环
            }
        }
    }
}
