package z_exercises;

public class FinancialAmountConverter {

    private final static String HUNDRED = "百";
    private final static String DECIMAL = "十";
    private final static String REMNANT = "元";
    private final static String FIRST = "角";
    private final static String SECOND = "分";

    private static String convert(double amount) {

        int hundred = (int) (amount/100);
        int decimal = (int) (amount / 10) % 10;
        int remnant = (int) (amount % 10);
        int firstAfterDot = (int) (amount * 10) % 10;
        int secondAfterDot = (int) (amount * 100) % 10;

        StringBuilder sb = new StringBuilder();
        return sb.append(hundred == 0 ? "" : NumEnum.getCharacterByNum(hundred)+HUNDRED)
                .append(decimal == 0 ? "" : NumEnum.getCharacterByNum(decimal)+DECIMAL)
                .append(remnant == 0 ? "" : NumEnum.getCharacterByNum(remnant)+REMNANT)
                .append(firstAfterDot == 0 ? "" : NumEnum.getCharacterByNum(firstAfterDot)+FIRST)
                .append(secondAfterDot == 0 ? "" : NumEnum.getCharacterByNum(secondAfterDot)+SECOND)
                .toString();
    }

//    private static String convertNum(int num) {
//        String result = "";
//        switch (num) {
//            case 0:
//                result = "零";
//                break;
//            case 1:
//                result = "一";
//                break;
//            case 2:
//                result = "二";
//                break;
//            case 3:
//                result = "三";
//                break;
//            case 4:
//                result = "四";
//                break;
//            case 5:
//                result = "五";
//                break;
//            case 6:
//                result = "六";
//                break;
//            case 7:
//                result = "七";
//                break;
//            case 8:
//                result = "八";
//                break;
//            case 9:
//                result = "九";
//                break;
//
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(convert(123.45));
        System.out.println(convert(634.09));
    }

    enum NumEnum {
        ZERO(0,"零"), ONE(1,"一"), TWO(2,"二"), THREE(3,"三"), FOUR(4,"四"),
        FIVE(5,"五"), SIX(6,"六"), SEVEN(7,"七"), EIGHT(8,"八"), NINE(9,"九");

        private int num;
        private String character;

        NumEnum(int num, String character) {
            this.num = num;
            this.character = character;
        }

        public static String getCharacterByNum(int num) {
            for (NumEnum numEnum : NumEnum.values()) {
                if (numEnum.num == num)
                    return numEnum.character;
            }
            return "";
        }
    }
}
