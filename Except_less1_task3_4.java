/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен частному
 * элементов двух входящих массивов в той же ячейке. Если длины массивов не
 * равны, необходимо как-то оповестить пользователя. Важно: При выполнении
 * метода единственное исключение, которое пользователь может увидеть -
 * RuntimeException, т.е. ваше.
 */
public class Except_less1_task3_4 {

    static float[] div_elem(Integer[] a, Integer[] b) {
        float x[] = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            try {
                x[i] = a[i] / b[i];
            } catch (ArithmeticException e) {
                System.out.println("На ноль делить нельзя! Итоговый массив с ошибкой");
            }
        }
        return x;

    }

    public static void main(String[] args) {

        Integer old_arr[] = new Integer[] { 8, 6, 5, 18 };
        Integer some_arr[] = new Integer[] { 2, 3, 5 };
        try {
            if (old_arr.length != some_arr.length) {
                throw new RuntimeException("Длинна массивов не одинакова!");
            }
            float new_arr[] = div_elem(old_arr, some_arr);

            System.out.println("Итоговый массив: ");
            for (int i = 0; i < new_arr.length; i++) {
                System.out.printf("%f ", new_arr[i]);
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
