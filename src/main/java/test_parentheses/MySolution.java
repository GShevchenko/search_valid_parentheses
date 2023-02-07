package test_parentheses;

/* Задача: Найти валидные круглые скобки.
        Обязательно счетчик и правильные скобки нужно выводить.
        Пример 1:
        Ввод: "(()"
        Вывод: 2 - ()
        Пример 2:
        Ввод: ")()())"
        Вывод: 4 - ()()
        Пример 3:
        Ввод: ")(()())"
        Вывод: 6 - (()())
        Пример 4:
        Ввод: ")("
        Вывод: 0
        Пример 5:
        Ввод: "())(()())(()"
        Вывод: 10 - ()(()())() */

import java.util.Stack;

public class MySolution {


    public static final String LEFT_PARENTHESES = "(";
    public static final String RIGHT_PARENTHESES = ")";
    public static final String FULL_PARENTHESES = "()";


    public static String searchValidParentheses1(String data) {
        StringBuilder finaleResult = new StringBuilder();
        StringBuilder intermediateResult = new StringBuilder();
        String[] crudeParentheses = data.split("");
        Stack<String> leftParentheses = new Stack<>();
        var isOuterGroup = false; // group contains outer parentheses like (()())
        var isFlushed = false;

        for (String crudeParenthesis : crudeParentheses) {
            // If all parentheses are extracted from stack, it's necessary to reset values
            if (leftParentheses.size() == 0) {
                isOuterGroup = false;
                isFlushed = false;
            }
            if (isLeftParenthesis(crudeParenthesis)) {
                leftParentheses.add(crudeParenthesis);
                isOuterGroup = leftParentheses.size() > 1;
                continue;
            }
            // If current is ) and stack is still empty
            if (leftParentheses.size() == 0) {
                continue;
            }
            if (!isOuterGroup) {
                intermediateResult.append(FULL_PARENTHESES);
                leftParentheses.pop();
            }
            if (isOuterGroup) {
                if (!isFlushed) {
                    finaleResult.append(intermediateResult);
                    intermediateResult = new StringBuilder();
                    isFlushed = true;
                }
                if (leftParentheses.size() > 1) {
                    intermediateResult.append(FULL_PARENTHESES);
                } else {
                    intermediateResult = new StringBuilder()
                            .append(LEFT_PARENTHESES)
                            .append(intermediateResult)
                            .append(RIGHT_PARENTHESES);
                }
                leftParentheses.pop();
            }
        }
        return finaleResult.append(intermediateResult).toString();
    }

    public static boolean isLeftParenthesis(String parenthesis) {
        return LEFT_PARENTHESES.equals(parenthesis);
    }


}
