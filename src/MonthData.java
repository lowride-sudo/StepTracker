

public class MonthData {
    // Экземпляр класса - месяц.

    /*
    Хранит в себе информацию о количестве дней (их 30 по умолчанию, храним в массиве) OK,
    хранит количество шагов в каждом дне - OK,
    содержит методы для вывода шагов по дням в месяц - OK,
    сумме шагов за месяц - OK,
    день в который рекордное количество шагов - ok,
    и лучшая серия дней, где наибольшее количество шагов сделано подряд
     */

    public MonthData() throws Exception {
        maxStepsAmount = 0;
        stepsMonthSum = 0;
//        this.inputDaySteps(day, daySteps);
    }

    private int[] daysStepsEachDay = new int[30];// Здесь храним все записи по дням
    private int maxStepsAmount; // рекордное количество шагов
    private int maxStepsAmountDay; // день в который совершено рекордное количество шагов
    private int stepsMonthSum; // счетчик шагов


    // ввод количества шагов на конкретный день месяца
    public void inputDaySteps(int day, int daySteps) throws Exception {

        if (daysStepsEachDay[day - 1] == 0) { // здесь проверяем что на данный день не внесли шаги
            daysStepsEachDay[day - 1] = daySteps;// вносим количество шагов на день
            stepsMonthSum += daySteps; //
            if (maxStepsAmount < daySteps) {
                maxStepsAmount = daySteps;
                maxStepsAmountDay = day;
            }

        } else {
            stepsMonthSum -= daysStepsEachDay[day - 1]; // убираем из счетчика шаги на эту дату и обновляем новыми
            daysStepsEachDay[day - 1] = daySteps;
            stepsMonthSum += daySteps;
            if (maxStepsAmount < daySteps) {
                maxStepsAmount = daySteps;
                maxStepsAmountDay = day;
            }
        }
    }

    // вывод количества шагов на конкретный день месяца
    public int returnDaySteps(int day) throws Exception {
        if (day < 1 || day > 30) throw new Exception("Неверно указан день месяца, укажите в диапазоне от 1 до 30");
        return daysStepsEachDay[day - 1];
    }

    //метод вывода суммы шагов в месяц
    public int getStepsMonthSum() {
        return stepsMonthSum;
    }

    //метод вывода максимального количества шагов
    public int getMaxStepsAmount() {
        return maxStepsAmount;
    }

    //метод вывода дня с максимальным количеством шагов
    public int getMaxStepsAmountDay() {
        return maxStepsAmountDay;
    }

    //метод вывода среднего значения шагов в день за месяц
    public int getAverageDaySteps() {
        return stepsMonthSum / 30;
    }

    //лучшая серия дней, где наибольшее количество шагов сделано подряд

    public int getBestStreakSteps(StepTracker stepTracker) {
        int streakSeries = 0;
        int streakMax = 0;
        for (int i : daysStepsEachDay) {
            if (i > stepTracker.getStepsCountDayGoal()) {
                streakSeries += 1;
                if (streakSeries > streakMax) {
                    streakMax = streakSeries;
                }
            } else {
                streakSeries = 0;
            }
        }

        return streakMax;
    }

}

