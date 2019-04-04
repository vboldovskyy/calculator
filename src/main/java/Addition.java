import java.math.BigInteger;

public class Addition implements Operation {

    public static final char SIGN = '+';

    private static Operation addition = new Addition();

    private Addition() {
    }

    public static Operation getInstance() {
        return addition;
    }

    @Override
    public String calculateResult(BigInteger left, BigInteger right, boolean isRoman) {
        int result = left.add(right).intValue();

        if (isRoman && result > 0 && result < 4000) {
            return RomanNumber.arabicToRoman(result);
        }

        return left.add(right).toString();
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
