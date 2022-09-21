
/* Реализуйте 3 метода, чтобы в каждом из них получить разные исключения */
import java.util.Stack;;

public class Except_less1_task1 {

    static void div_by_0(int a) {
        int x = a / 0;
    }

    static void invalid_index(int a) {
        int[] arr = new int[] { 1, 2, 3, 4 };
        System.out.println(arr[a]);
    }

    static void null_stack() {
        Stack<Integer> some_stack = new Stack<Integer>();
        System.out.println(some_stack.peek());
    }

    public static void main(String[] args) {
        int a = 7;
        // 1) ArithmeticException
        div_by_0(a);
        // 2) ArrayIndexOutOfBoundsException
        invalid_index(a);
        // 3) EmptyStackException
        null_stack();
    }
}
