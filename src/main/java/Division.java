import java.math.BigInteger;

public class Division implements Operation {
    public static final char SIGN = '/';

    @Override
    public BigInteger calculateResult(BigInteger left, BigInteger right) {
        if (right.intValue() == 0) {
            throw new IllegalArgumentException("you cannot divide by zero");
        }
        return left.divide(right);
    }

    @Override
    public char getSign() {
        return SIGN;
    }

    public BigInteger calculateRemainder(BigInteger left, BigInteger right) {
        if (right.intValue() == 0) {
            throw new IllegalArgumentException("you cannot divide by zero");
        }
        return left.remainder(right);
    }
}
