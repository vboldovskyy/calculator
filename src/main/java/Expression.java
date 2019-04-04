import java.math.BigInteger;
import java.util.regex.Pattern;

public class Expression {
    private BigInteger left;
    private BigInteger right;
    private Operation operation;
    private boolean isRoman;

    public Expression(String exp) {

        if (exp.indexOf(Subtraction.SIGN) != -1) {
            this.operation = Subtraction.getInstance();
        }
        if (exp.indexOf(Addition.SIGN) != -1) {
            this.operation = Addition.getInstance();
        }

        if (exp.indexOf(Multiplication.SIGN) != -1) {
            this.operation = Multiplication.getInstance();
        }

        if (exp.indexOf(Division.SIGN) != -1) {
            this.operation = Division.getInstance();
        }
        if (this.operation == null) {
            throw new IllegalArgumentException("you should provide the operation sign");
        }
        String[] args = exp.split(Pattern.quote(Character.toString(operation.getSign())));
        if (args.length != 2) {
            throw new IllegalArgumentException("you should provide exactly two arguments and one operation sign for the operation");
        }
        try {
            this.left = new BigInteger(args[0].trim());
            this.isRoman = false;
        } catch (NumberFormatException nf) {
            try {
                this.left = new BigInteger(String.valueOf(RomanNumber.romanToArabic(args[0].trim().toUpperCase())));
                this.isRoman = true;
            } catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException("the left side of expression is not a number");
            }

        }
        try {
            if (!this.isRoman) {
                this.right = new BigInteger(args[1].trim());
            }

        } catch (NumberFormatException nf) {
            try {
                this.right = new BigInteger(String.valueOf(RomanNumber.romanToArabic(args[1].toUpperCase().trim())));
            } catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException("the right side of expression is not a number");
            }
            throw new IllegalArgumentException("the numbers should be both roman or both arabic");
        }

        try {
            if (this.isRoman) {
                this.right = new BigInteger(String.valueOf(RomanNumber.romanToArabic(args[1].toUpperCase().trim())));
            }
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("the right side of expression is not a roman number");
        }
    }


    public String evaluate() {
        return this.operation.calculateResult(this.left, this.right, this.isRoman);

        }
    }

