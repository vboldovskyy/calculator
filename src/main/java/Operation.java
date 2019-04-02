import java.math.BigInteger;

public interface Operation {

    BigInteger calculateResult(BigInteger left, BigInteger right);
    char getSign();
}
