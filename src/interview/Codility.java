package interview;

public class Codility {

    public static void main(String[] args){
        System.out.println(solution(-333));
    }

    public static int solution(int N) {
        if (N==0){
            return 50;
        }

        String temp = "";
        int result = 0;
        if (N > 0){
            String nToStr = String.valueOf(N);
            for (int i = 0; i < nToStr.length(); i++) {
                int current = nToStr.charAt(i) - '0';
                if (current < 5) {
                    temp = nToStr.substring(0, i) + "5" + nToStr.substring(i);
                    break;
                }
            }
            result = "".equals(temp)?Integer.valueOf(nToStr+"5"):Integer.valueOf(temp);
        } else {
            String nToStr = String.valueOf(N).substring(1);
            for (int i = 0; i < nToStr.length(); i++) {
                int current = nToStr.charAt(i) - '0';
                if (current > 5) {
                    temp = nToStr.substring(0, i) + "5" + nToStr.substring(i);
                    break;
                }
            }
            result = "".equals(temp)?Integer.valueOf("-"+nToStr+"5"):Integer.valueOf("-"+temp);
        }
        return result;
    }

}
