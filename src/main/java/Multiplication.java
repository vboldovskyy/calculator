import java.math.BigInteger;

public class Multiplication implements Operation {
    public static final char SIGN = '*';

    private static Operation multiplication = new Multiplication();

    private Multiplication(){

    }

    public static Operation getInstance()
    {
        return multiplication;
    }

    @Override
    public String calculateResult(BigInteger left, BigInteger right, boolean isRoman) {
        int result = left.multiply(right).intValue();

        if (isRoman && result > 0 && result < 4000){
            return RomanNumber.arabicToRoman(result);
        }

        return left.multiply(right).toString();
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
