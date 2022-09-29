/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
(*) Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
(*) При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
**Eсли данное задание вызывает много трудностей, можно сдать задание 4 из семинара 3 в качестве ДЗ */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Except_less3_task1_v2 {

    static void check(String[] arr) throws Exception {

        if (arr.length != 6) {
            throw new Exception("Не верное кол-во элементов: " + arr.length
                    + ". Должно быть 6.");
        }
    }

    static void checkResult(String elem, int flag) throws Exception {
        if (flag == 0 | flag == 1 | flag == 2) {
            throw new Exception("Фамилия, имя или отчество сожержит не только буквы. Илон негодует...");
        }
        if (flag == 3) {
            throw new Exception("Дата не похожа на дату! Вы из другой системы исчисления?");
        }
        if (flag == 4) {
            throw new Exception("По такому телефону до вас не дозвоняться. Я иногда мечтаю о таком...");
        }
        if (flag == 5) {
            throw new Exception("Ох уж этот пол! С горизонтальным все намного проще...");
        }
    }

    static void newFile(File file) {
        try (FileWriter writer = new FileWriter(file.getName())) {
        } catch (IOException e) {
            System.out.println("Упс! Ошибка записи.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        String[] regexs = new String[] { "[a-zA-Z]{3,}", "([a-zA-Z]{3,})", "([a-zA-Z]{3,})",
                "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.(19|20)[0-9][0-9]", "(\\+?\\d){11}", "(f|m){1}" };
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Жду ввода ваших данных через пробел. Пожалуйста...: ");
        String inputStr = iScanner.nextLine(); // "+79018016004 pavlov Egor vladimirovich m 31.12.1983 ";
        iScanner.close();
        String[] splited = inputStr.split("\\s");

        try {
            check(splited); // проверили кол-во элементов
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Программа завершена с ошибкой!");
            System.exit(1);
        }

        ArrayList<String> result = new ArrayList<String>();
        for (int n = 0; n < regexs.length; n++) {
            result.add(null); // а как по другому изменить потом элементы?
        }
        for (int i = 0; i < splited.length; i++) {
            for (int j = 0; j < regexs.length; j++) { // умнее O(n2) я не придумал
                Pattern pattern = Pattern.compile(regexs[j]);
                Matcher matcher = pattern.matcher(splited[i]);
                if (matcher.matches()) {
                    if (result.get(j) == null) {
                        result.set(j, splited[i]);
                        splited[i] = " "; // кудаж без костылей. убираем чтобы 2й раз не попалось тоже самое. и 3й...
                    }
                }
            }
        }

        File f = new File(result.get(0) + ".txt");
        FileWriter writer = new FileWriter(f.getName(), true);

        if (!f.isFile()) {
            newFile(f);
            System.out.println("Файл создан!");
        }

        for (int k = 0; k < result.size(); k++) {
            String spam = result.get(k);
            if (spam == null) {
                try {
                    checkResult(spam, k);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Вы ввели: " + spam);
                    System.out.println("Программа завершена с ошибкой!");
                    System.exit(1);
                }
            } else {
                writer.append("<" + result.get(k) + ">");
                System.out.println(result.get(k));
            }
        }
        writer.append("\n");
        writer.flush();
        System.out.println("Данные добавлены!");
    }
}