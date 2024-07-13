

/*
(Содержит методы для конвертации шагов в КМ и конвертации шагов в Килокалории)
(1 шаг примем равным 75см, 1 шаг тратит 50ккал)
 */

public class Converter {
    private static double kkalInStep = 0.05;
    private static double meterInStep = 0.75;

    public static double stepsToKm (int steps) {
        return (steps * meterInStep) / 1000;
    }

    public static double stepsToKkal (int steps) {
        return steps * kkalInStep;
    }
}
