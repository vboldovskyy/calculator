import java.math.BigInteger;

public class Addition implements Operation {

    public static final char SIGN = '+';

    @Override
    public BigInteger calculateResult(BigInteger left, BigInteger right) {
        return left.add(right);
    }

    @Override
    public char getSign() {
        return SIGN;
    }
}
