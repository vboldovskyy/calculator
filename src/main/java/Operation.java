import java.math.BigInteger;

public interface Operation {


    String calculateResult(BigInteger left, BigInteger right, boolean isRoman);
    char getSign();
}
