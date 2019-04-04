import java.math.BigInteger;

public class Subtraction implements Operation {
    public static final char SIGN = '-';

    private static final Operation subtraction = new Subtraction();

    private Subtraction(){

    }

    public static Operation getInstance(){
        return subtraction;
    }

    @Override
    public String calculateResult(BigInteger left, BigInteger right, boolean isRoman) {

        int result = left.subtract(right).intValue();

        if (isRoman && result > 0 && result < 4000){
            return RomanNumber.arabicToRoman(result);
        }

        return left.subtract(right).toString();
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
