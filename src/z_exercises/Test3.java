package z_exercises;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(countNum(2,22,2));
        System.out.println(countNum(1,11,1));
        System.out.println(countNum(1,5,3));
    }

    public static int countNum (int L, int R, int x) {
        // write code here
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = L; i <= R; i++) {
            stringBuilder.append(i);
        }
        String sequence = stringBuilder.toString();
        for (int i = 0; i < sequence.length(); i++) {
            if (x == sequence.charAt(i)-48){
                count++;
            }
        }
        return count;
    }
}
