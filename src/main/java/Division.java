import java.math.BigInteger;

public class Division implements Operation {
    public static final char SIGN = '/';

    private static Operation division = new Division();

    private Division() {
    }

    public static Operation getInstance() {
        return division;
    }

    @Override
    public String calculateResult(BigInteger left, BigInteger right, boolean isRoman) {
        if (right.intValue() == 0) {
            throw new IllegalArgumentException("you cannot divide by zero");
        }
        int remainder = calculateRemainder(left, right).intValue();
        int result = left.divide(right).intValue();

        if (isRoman && result > 0 && result < 4000 && remainder == 0) {
            return RomanNumber.arabicToRoman(result);
        }
        if (isRoman && result > 0 && result < 4000) {
            return RomanNumber.arabicToRoman(result) + " and the remainder of " + RomanNumber.arabicToRoman(remainder);
        }

        if (remainder == 0) {
            return left.divide(right).toString();
        }

        return left.divide(right).toString() + " and the remainder of " + calculateRemainder(left, right).toString();
    }


    @Override
    public char getSign() {
        return SIGN;
    }

    private BigInteger calculateRemainder(BigInteger left, BigInteger right) {
        if (right.intValue() == 0) {
            throw new IllegalArgumentException("you cannot divide by zero");
        }
        return left.remainder(right);
    }
}
