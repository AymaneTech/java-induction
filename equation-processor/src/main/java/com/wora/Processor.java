package com.wora;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Processor {
    private static final Map<String, Double> variables = new HashMap<>();
    private final Stack<Double> operands = new Stack<>();
    private final Stack<OperationToken> operations = new Stack<>();
    private final String equation;

    private final Scanner scanner;

    private int current;
    private int start;

    public Processor(String equation, Scanner scanner) {
        this.equation = equation;
        this.scanner = scanner;
    }

    public double evaluate() {
        scanTokens();

        while (!operations.isEmpty())
            evaluateTop();

        if (operands.size() != 1)
            throw new IllegalArgumentException("Invalid equation: incorrect number of operands");

        return operands.pop();
    }

    private void scanTokens() {
        while (!isAtEndOfLine()) {
            start = current;
            scanToken();
        }
    }

    private void scanToken() {
        char c = nexChar();
        switch (c) {
            case '+' -> handleOperation(OperationToken.PLUS);
            case '-' -> handleOperation(OperationToken.MINUS);
            case '*' -> handleOperation(OperationToken.MULTIPLY);
            case '/' -> handleOperation(OperationToken.DIVIDE);
            default -> {
                if (isDigit(c))
                    handleNumber();
                else if (isAlpha(c))
                    handleVariable();
                else if (isWhiteSpace(c))
                    handleWhiteSpace();
                else
                    throw new IllegalArgumentException("Invalid character");
            }
        }
    }


    private void evaluateTop() {
        if (operands.size() < 2)
            throw new IllegalArgumentException("Invalid equation: Not enough operands");

        OperationToken op = operations.pop();
        double b = operands.pop();
        double a = operands.pop();

        double result = switch (op) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                yield a / b;
            }
        };

        operands.push(result);
    }

    private void handleOperation(OperationToken newOp) {
        while (!operations.isEmpty()
                && operations.peek().priority() >= newOp.priority()) {
            evaluateTop();
        }

        operations.push(newOp);
    }

    private void handleNumber() {
        while (isDigit(peek()) && !isAtEndOfLine())
            nexChar();

        String number = equation.substring(start, current);
        operands.push(Double.valueOf(number));
    }

    private void handleVariable() {
        while (isAlpha(peek()) && !isAtEndOfLine())
            nexChar();

        String variableName = equation.substring(start, current);
        if (!variables.containsKey(variableName)) {
            System.out.print("Please enter variableName " + variableName + " value :  ");
            double variableValue = scanner.nextDouble();
            
            variables.put(variableName, variableValue);
        }
        operands.push(variables.get(variableName));
    }

    private void handleWhiteSpace() {
        while (isWhiteSpace(peek()) && !isAtEndOfLine())
            nexChar();
    }

    private char peek() {
        if (isAtEndOfLine()) return '\0';
        return equation.charAt(current);
    }

    private char nexChar() {
        return equation.charAt(current++);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z'
                || c >= 'A' && c <= 'Z';
    }

    private boolean isWhiteSpace(char c) {
        return c == ' ';
    }

    private boolean isAtEndOfLine() {
        return current >= equation.length();
    }

    enum OperationToken {
        PLUS(1),
        MINUS(1),
        MULTIPLY(2),
        DIVIDE(2);

        private final int priority;

        OperationToken(int priority) {
            this.priority = priority;
        }

        public int priority() {
            return priority;
        }
    }
}
