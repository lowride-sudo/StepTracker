import java.util.Scanner;

//Содержит отображение меню и вызывает класс трекер шагов

public class Main {
    public static void main(String[] args) {
        boolean continueProgram = true;
        Scanner scan = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (continueProgram) {
            try {
                int menuChoice;
                mainMenu();
                menuChoice = scan.nextInt();
                switch (menuChoice) {
                    case 1:
                        stepTracker.enterStepForDay();
                        break;
                    case 2:
                        stepTracker.printMonthStatistic();
                        break;
                    case 3:
                        System.out.println("Укажите цель в количестве шагов");
                        stepTracker.setStepsCountDayGoal();
                        break;
                    case 4:
                        System.out.println("Установлена цель в: " + stepTracker.getStepsCountDayGoal() + " шагов");
                        break;
                    case 5:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("Укажите повторно верный пункт меню");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void mainMenu() {
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println("Приложение Трекер шагов");
        System.out.println("__________________________________________________");
        System.out.println("1. Ввести количество шагов за нужный день");
        System.out.println("2. Вывести статистику за нужный месяц");
        System.out.println("3. Установить цель по шагам за день");
        System.out.println("4. Вывести текущую цель по шагам за день");
        System.out.println("5. Выйти из приложения");
        System.out.println();
        System.out.println();
        System.out.println("Введите номер пункта меню:");
    }


}
