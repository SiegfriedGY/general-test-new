package others;

public abstract class EnumTest {
    private float aFloat = 1.03424321F;
    public EnumTest(){

    }
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
//        EnumTest test = new EnumTest();
//        test.aFloat = 4;
//        System.out.println(test.aFloat);

    }
}
enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
