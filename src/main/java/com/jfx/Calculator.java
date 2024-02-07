package com.jfx;

import java.util.Stack;

public class Calculator {
    public static double calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                double number = c - '0';
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    number = number * 10 + (expression.charAt(i + 1) - '0');
                    i++;
                }
                numbers.push(number);
                if (!operations.isEmpty() && (operations.peek() == '*' || operations.peek() == '/')) {
                    compute(numbers, operations);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operations.push(c);
            }
        }
        while (!operations.isEmpty()) {
            compute(numbers, operations);
        }
        return numbers.pop();
    }

    private static void compute(Stack<Double> numbers, Stack<Character> operations) {
        double b = numbers.pop();
        double a = numbers.pop();
        char operation = operations.pop();
        double result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                }
                break;
        }
        numbers.push(result);
    }
} 
