package nextstep.optional;

import java.util.Arrays;

public enum Expression {

    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String express;

    Expression(String expression) {
        this.express = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.express);
    }

    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(value -> matchExpression(value, expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));
    }

}
