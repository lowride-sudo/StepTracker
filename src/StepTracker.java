import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Содержит методы для работы трекера
public class StepTracker {
    Scanner scan = new Scanner(System.in);


    public StepTracker() {

    }

    //Ввести количество шагов за определенный день

    //Вводим количество шагов пройденное за конкретный день.
    //      (Просим клиента ввести номер месяца (1-12), день (1-30), количество шагов).
    //Добавить проверки, что клиент ввел не отрицательное число, что число не выходит за диапазон,
    //    что введен именно ожидаемый результат (если принимает только цифры, то цифры).
    //   Если клиент ошибся, то информируем его, и завершаем выполнение метода, возвращая клиента назад в меню.
    private Map<Integer, MonthData> year = new HashMap<>(); // Создаем мапу и заполняем ее месяцами

    public void enterStepForDay() {

        System.out.println("Введите номер месяца:");

        int month = readInt(scan);
        while (month < 1 || month > 12) {
            System.out.println("Введен неверный месяц, повторите ввод");
            month = readInt(scan);
        }

        System.out.println("Введите число месяца от 1 до 30:"); // Проверка на диапазон дней находится в методе inputDaySteps

        int date = readInt(scan);
        while (date < 1 || date > 30) {
            System.out.println("Введите число от 1 до 30");
            date = readInt(scan);}

        System.out.println("Введите число шагов:");
        int stepsCount = readInt(scan);
        while (stepsCount < 1) {
            stepsCount = readInt(scan);
        }

        try {
            if (year.get(month) == null) {
                year.put(month, new MonthData());
            }
            MonthData monthToChange = year.get(month);
            monthToChange.inputDaySteps(date, stepsCount);
            year.put(month, monthToChange);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //Изменить цель по количеству шагов за день //Можно задавать ее при первичном запуске программы

    //Клиент задает планируемое количество шагов на день. Также добавить проверки,
    // что число положительное, и является именно числом, если клиент ошибся, то завершаем метод,
    // и возвращаем клиента также в меню.

    private int stepsCountDayGoal = 0;

    public void setStepsCountDayGoal() {
        try {
            int newGoal = readInt(scan);
            while (newGoal < 0) {
                newGoal = readInt(scan);
            }
            stepsCountDayGoal = newGoal;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int getStepsCountDayGoal() {
        return stepsCountDayGoal;
    }

    //Напечатать статистику за определенный месяц


    //Просим клиента ввести требуемый месяц, по которому хотим получить статистику,
    //  также добавляем проверки на положительное число, и на то, что ввел клиент,
    //  если не удовлетворяет условия, завершаем метод и возвращаем клиента в меню.
    //Какие данные требуется вывести:
    //    Сумма шагов за месяц: ; ok
    //    Максимальное пройденное количество шагов за месяц: ; ok
    //    Среднее пройденное количество шагов за месяц: ; ok
    //    Пройденная за месяц дистанция в км: ;
    //    Количество сожженных килокалорий за месяц: ;
    //    Лучшая серия: ;

    public void printMonthStatistic() {
        try {
            System.out.println("Укажите номер месяца для вывода статистики по нему");

            int month = readInt(scan);
            while (month < 1 || month > 12) {
                System.out.println("Вы ввели неверный месяц, повторите ввод");
                month = readInt(scan);
            }

            System.out.println();
            System.out.println("По " + month + " месяцу имеется следующая статистика: ");
            System.out.println();
            System.out.println("Суммарно шагов за месяц: " + year.get(month).getStepsMonthSum());
            int sumMonthSteps = year.get(month).getStepsMonthSum();
            System.out.println("День с максимальным количеством пройденных шагов: " + year.get(month).getMaxStepsAmount());
            System.out.println("Среднее пройденное количество шагов за день: " + year.get(month).getAverageDaySteps());
            System.out.println("Пройденная дистанция в км: " + Converter.stepsToKm(sumMonthSteps));
            System.out.println("Количество сожженных килокалорий: " + Converter.stepsToKkal(sumMonthSteps));
            System.out.println("Лучшая серия: " + year.get(month).getBestStreakSteps(this));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private int readInt(Scanner s) {
        while (true) {
            String line = s.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Повторите ввод числа");
            }
        }
    }
}
