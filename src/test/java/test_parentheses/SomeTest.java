package test_parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test_parentheses.MySolution.searchValidParentheses1;

public class SomeTest {


//    Пример 1:
//    Ввод: "(()"
//    Вывод: 2 - ()
    @Test
    public void firstCase() {
        assertEquals( "2 - ()", searchValidParentheses1("(()"));
    }

//    Пример 2:
//    Ввод: ")()())"
//    Вывод: 4 - ()()
    @Test
    public void secondCase() {
        assertEquals("4 - ()()", searchValidParentheses1(")()())"));
    }

//    Пример 3:
//    Ввод: ")(()())"
//    Вывод: 6 - (()())
    @Test
    public void thirdCase() {
        assertEquals("6 - (()())", searchValidParentheses1(")(()())"));
    }

//    Пример 4:
//    Ввод: ")("
//    Вывод: 0
    @Test
    public void fourthCase() {
        assertEquals("0", searchValidParentheses1(")("));
    }

//    Пример 5:
//    Ввод: "())(()())(()"
//    Вывод: 10 - ()(()())() */
    @Test
    public void fifthCase() {
        assertEquals("10 - ()(()())()", searchValidParentheses1(" ())(()())(()"));
    }


}
