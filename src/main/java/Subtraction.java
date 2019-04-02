import java.math.BigInteger;

public class Subtraction implements Operation {
    public static final char SIGN = '-';

    @Override
    public BigInteger calculateResult(BigInteger left, BigInteger right) {
        return left.subtract(right);
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
