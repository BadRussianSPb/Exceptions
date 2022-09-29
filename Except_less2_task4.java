import java.util.Scanner;

/*
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

public class Except_less2_task4 {

    static void input() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Только не пустая строка!");
        String new_line = sc.nextLine();
        sc.close();
        if ((new_line).trim().equals("")) { // колдунство с пустой строкой :)
            throw new Exception("Ввод пустой строки не предусмотрен!");
        }
    }

    public static void main(String[] args) {
        try {
            input();
            System.out.println("Отработали без ошибок!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
