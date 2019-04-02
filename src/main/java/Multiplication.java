import java.math.BigInteger;

public class Multiplication implements Operation {
    public static final char SIGN = '*';

    @Override
    public BigInteger calculateResult(BigInteger left, BigInteger right) {
        return left.multiply(right);
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
