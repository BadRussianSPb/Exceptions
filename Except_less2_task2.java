/*Если необходимо, исправьте данный код 
try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}
 */
public class Except_less2_task2 {

    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[10]; // массив не был инициализирован. Ошибка при компиляции.
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
