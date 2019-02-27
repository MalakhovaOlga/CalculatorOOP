import static java.lang.String.valueOf;

public class Calculator {
    float value;

    Calculator(float value) {
        this.value = value;
    }

    float executeAdditon(Calculator b) {
        return this.value + b.value;
    }

    float executeSubtraction (Calculator b) {
        return this.value + b.value;
    }

    float executeMultiplication (Calculator b) {
        return this.value * b.value;
    }

    float executeDivision (Calculator b) {
        return this.value / b.value;
    }

    void set (float newValue) {
        this.value = newValue;
    }

    public String toString () {
        return valueOf (this.value);
    }
}
