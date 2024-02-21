package com.jfx;

import java.util.Stack;

public class Calculator {
    public static double calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.' || (c == '-' && (i == 0 || !Character.isDigit(expression.charAt(i - 1))))) {
                StringBuilder number = new StringBuilder();
                if (c == '-') {
                    number.append(c);
                    i++;
                }
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                i--; // decrement i because the for loop will increment it
                numbers.push(Double.parseDouble(number.toString()));
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
