import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {

    @Test
    public void howDoesGetResultWork_AdditionNumbers() {
        Calculator calc1 = new Calculator(5, 5, '+');
        Assert.assertEquals("Incorrect result if addition numbers", 10.0, calc1.getResult(), 0);
    }

    @Test
    public void howDoesGetResultWork_SubtractionNumbers1() {
        Calculator calc2 = new Calculator(5, -5, '+');
        Assert.assertEquals("Incorrect result if subtraction numbers", 0, calc2.getResult(), 0);
    }

    @Test
    public void howDoesGetResultWork_SubtractionNumbers2() {
        Calculator calc3 = new Calculator(-5, 5, '+');
        Assert.assertEquals("Incorrect result if subtraction numbers", 0, calc3.getResult(), 0);
    }

    @Test
    public void howDoesGetResultWork_MultiplicationNumbers() {
        Calculator calc4 = new Calculator(5, 5, '*');
        Assert.assertEquals("Incorrect result if multiplication numbers", 25, calc4.getResult(), 0);
    }

    @Test
    public void howDoesGetResultWork_DivisionNumbers () {
        Calculator calc5 = new Calculator (5,5,'/');
        Assert.assertEquals("Incorrect result if division numbers",1,calc5.getResult(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void howDoesAnalyseInputStringWork_NumberAndLetter() {
        String s1 = new String("4+a");
        String result1[] = CalculatorOOP.analyseInputString(s1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void howDoesAnalyseInputStringWork_JustNumber() {
        String s2 = new String("5 ");
        String result3[] = CalculatorOOP.analyseInputString(s2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void howDoesAnalyseInputStringWork_ThreeNumbers() {
        String s3 = new String("4+2*3");
        String result4[] = CalculatorOOP.analyseInputString(s3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void howDoesAnalyseInputStringWork_SignAtTheEnd() {
        String s4 = new String("5-2/");
        String result5[] = CalculatorOOP.analyseInputString(s4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void howDoesAnalyseInputStringWork_Comma() {
        String s5 = new String("5,8/2");
        String result6[] = CalculatorOOP.analyseInputString(s5);
    }



}
