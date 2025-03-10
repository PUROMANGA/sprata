package subject;

import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

public enum Operator {
    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String symbol;
    public BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator isOperator(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(symbol)) {  // ✅ equals() 사용
                return operator;
            }
        }
        return null;
    }

    public int apply(int x, int y) {
        return expression.apply(x, y);
    }
}
