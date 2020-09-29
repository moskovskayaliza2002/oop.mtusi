package lesson1.part1;
// Метод convertCelsiusToFahrenheit(int celsius) принимает значение в градусах Цельсия.
// Метод должен переводить температуру и возвращать значение в градусах Фаренгейта.
// Температура по Цельсию TC и температура по Фаренгейту TF связаны следующим соотношением:
// TF = (9 / 5) * TC + 32
public class Task07 {
    public static void main(String[] args) {
        System.out.println(convertCelsiusToFahrenheit(41));
    }
    public static double convertCelsiusToFahrenheit(int celsius) {
        return 1.8 * celsius + 32;
    }
}
