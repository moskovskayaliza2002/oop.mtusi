package lesson1.part2;
// Реализуй метод public static void div(int a, int b).
// Метод должен делить первое число на второе, и выводить на экран результат деления а на b.
// На экран должно быть выведено целое число.
public class Task02 {
    public static void main(String[] args) {
        div(6, 3);
        div(10, 6);
        div(2, 4);
    }
    public static void div(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }
}
