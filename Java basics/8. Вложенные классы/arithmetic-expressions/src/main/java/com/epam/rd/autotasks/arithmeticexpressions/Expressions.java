package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    private static String valueToString(int value) {
        if (value < 0) {
            return "(" + value + ")";
        }
        return String.valueOf(value);
    }

    public static Expression val(int value) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return valueToString(value);
            }
        };
        return expression;
    }

    public static Expression sum(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression exp : members) {
                    sum += exp.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String str = "(";
                for (Expression exp : members) {
                    str += exp.toExpressionString();
                    str += " + ";
                }
                str = str.substring(0, str.length() - 3);
                str += ")";
                return str;
            }
        };
        return expression;
    }

    public static Expression product(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int product = 1;
                for (Expression exp : members) {
                    product *= exp.evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                String str = "(";
                for (Expression exp : members) {
                    str += exp.toExpressionString();
                    str += " * ";
                }
                str = str.substring(0, str.length() - 3);
                str += ")";
                return str;
            }
        };
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
        return expression;
    }

}
