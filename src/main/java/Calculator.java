import static java.lang.String.valueOf;

public class Calculator {
    float value1;
    float value2;
    char sign;

    Calculator(float value1, float value2, char sign) {
        this.value1 = value1;
        this.value2 = value2;
        this.sign = sign;
    }

    float getResult () {
        float result = 0;
        switch (this.sign) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 + value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                result = value1 / value2;
                break;
        }
        return result;
    }
}
