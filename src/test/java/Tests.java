import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void additionTest() {
        Expression exp = new Expression("45+45");
        Assert.assertEquals("90", exp.evaluate());
    }

    @Test
    public void subtractionTest() {
        Expression exp = new Expression("45-10");
        Assert.assertEquals("35", exp.evaluate());
    }

    @Test
    public void multiplicationTest() {
        Expression exp = new Expression("45*10");
        Assert.assertEquals("450", exp.evaluate());
    }

    @Test
    public void divisionTest() {
        Expression exp = new Expression("25/5");
        Assert.assertEquals("5", exp.evaluate());
    }

    @Test
    public void romanTest() {
        Expression exp = new Expression("XV*LL");
        Assert.assertEquals("MD", exp.evaluate());

    }

    @Test
    public void romanLowerCaseTest() {
        Expression exp = new Expression("xv*ll");
        Assert.assertEquals("MD", exp.evaluate());

    }

    @Test
    public void whitespaceTest() {
        Expression exp = new Expression(" 5 + 2   ");
        Assert.assertEquals("7", exp.evaluate());
    }

    @Test
    public void fallbackToArabicTest()
    {
        Expression exp = new Expression ("MMM*XX");
        Assert.assertEquals("60000", exp.evaluate());
    }

    @Test
    public void divisionWithRemainderTest()
    {
        Expression exp = new Expression ("7/3");
        Assert.assertEquals("2 and the remainder of 1", exp.evaluate());
    }

    @Test
    public void bigIntegerTest()
    {
        Expression exp = new Expression("9999999999999999999999*1234567890123456789012");
        Assert.assertEquals("12345678901234567890118765432109876543210988", exp.evaluate());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalInputTest()
    {
        Expression exp = new Expression("rubbish+garbage");
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionByZeroTest()
    {
        Expression exp = new Expression("5/0");
        exp.evaluate();
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalRightSideTest()
    {
        Expression exp = new Expression("5+garbage");
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalLeftSideTest()
    {
        Expression exp = new Expression("garbage+5");
    }

    @Test (expected = IllegalArgumentException.class)
    public void romanArabicMismatchTest()
    {
        Expression exp = new Expression("5+V");
    }

    @Test (expected = IllegalArgumentException.class)
    public void manyOperationsTest()
    {
        Expression exp = new Expression("5+/*-7");
    }

    @Test (expected = IllegalArgumentException.class)
    public void noOperationTest()
    {
        Expression exp = new Expression("5 10");
    }
}
