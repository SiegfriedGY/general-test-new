package number_related;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalTest {

    public static void main(String[] args) {
        String value = "234.009";
        String value1 = "0.00000001";
        System.out.println(new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(value1).setScale(2, BigDecimal.ROUND_HALF_UP));

        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        System.out.println(currency.toString());
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }
}
