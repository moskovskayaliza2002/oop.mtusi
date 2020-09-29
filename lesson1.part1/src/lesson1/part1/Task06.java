package lesson1.part1;
// Выведи на экран длину окружности, рассчитанную по формуле: L = 2 * Pi * radius.
// Результат - дробное число (тип double).
// В качестве значения Pi используй значение 3.14.
public class Task06 {
    public static void main(String[] args) {
        printCircleLength(5);
    }
    public static void printCircleLength(int radius) {
        //напишите тут ваш код
        System.out.println(2 * radius * 3.14);
    }

}
