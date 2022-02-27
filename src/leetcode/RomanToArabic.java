package leetcode;

import java.util.Scanner;

public class RomanToArabic {

    static Scanner scanner = new Scanner(System.in);

    // 输入合法性验证
    private static boolean checkValidity(String src) {
        String regExp = "^[IVXLCDM]+$";
        boolean result = src.matches(regExp);
        return result;
    }

    public static int translate(String src){

        String upper = src.toUpperCase();

        while (!checkValidity(upper)){
            System.out.print("输入不合法，请重新输入：");
            upper = scanner.nextLine().toUpperCase();
        }

//        while (checkValidity(upper)){
//            System.out.print("输入合法，请重新输入：");
//            upper = scanner.nextLine().toUpperCase();
//        }

        char[] chars = upper.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {

            char node = chars[i];
            if (node == 'I') {
                result += 1;
            } else if (node == 'V'){
                result += 5;
            } else if (node == 'X'){
                result += 10;
            } else if (node == 'L'){
                result += 50;
            } else if (node == 'C'){
                result += 100;
            } else if (node == 'D'){
                result += 500;
            } else if (node == 'M'){
                result += 1000;
            }

        }

        if (upper.contains("IV")){
            result = result - 6 + 4;
        }
        if (upper.contains("IX")){
            result = result - 11 + 9;
        }
        if (upper.contains("XL")){
            result = result - 60 + 40;
        }
        if (upper.contains("XC")){
            result = result - 110 + 90;
        }
        if (upper.contains("CD")){
            result = result - 600 + 400;
        }
        if (upper.contains("CM")){
            result = result - 1100 + 900;
        }

        return result;
    }



    public static void main(String[] args){

        while (true) {
            System.out.print("请输入罗马数字：");
            String src = scanner.nextLine();
            int dest = translate(src);
            System.out.println("结果为："+dest);
        }
    }
}
