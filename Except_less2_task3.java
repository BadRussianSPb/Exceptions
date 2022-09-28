/*
Дан следующий код, исправьте его там, где требуется
*public static void main(String[] args) throws Exception {
*  try {
*       int a = 90;
*       int b = 3;
*       System.out.println(a / b);
*       printSum(23, 234);
*       int[] abc = { 1, 2 };
*       abc[3] = 9;
*   } catch (Throwable ex) {
*       System.out.println("Что-то пошло не так...");
*   } catch (NullPointerException ex) {
*       System.out.println("Указатель не может указывать на null!");
*   } catch (IndexOutOfBoundsException ex) {
*       System.out.println("Массив выходит за пределы своего размера!");
*   }
*}
*public static void printSum(Integer a, Integer b) throws FileNotFoundException {
*   System.out.println(a + b);
*}
 */

public class Except_less2_task3 {

    public static void main(String[] args) throws Exception {
        try {
            Integer a = 93; // примитивные не могут принимать null
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { // все остальные исключения обработаны в конце, иначе срабатывать будет только
                                 // это.
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException { // метод пробрасывает "правильное"
                                                                                    // иключение
        System.out.println(a + b);
    }
}
