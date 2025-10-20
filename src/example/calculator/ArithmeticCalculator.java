package example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T> {

    private List<Integer> results = new ArrayList<>();

    private T num1, num2;
    private OperatorType operator;

    public ArithmeticCalculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

}
