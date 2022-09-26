/* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
  вместо этого, необходимо повторно запросить у пользователя ввод данных.*/

import java.util.Scanner;

public class Except_less2_task1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите дробное число типа 'float': ");
        while (true) // while (!sc.hasNextFloat()) попроще выглядит без исключений
            try {
                Float some_float = sc.nextFloat();
                sc.close();
                System.out.printf("Это %f мне нравиться!", some_float);
                break;
            } catch (Exception e) {
                System.out.println("Не верный формат! Попробуй еще!");
                sc.next();
            }
    }
}
