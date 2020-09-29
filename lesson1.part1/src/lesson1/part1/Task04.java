package lesson1.part1;
// Раскомментируй одну строчку, чтобы программа вывела на экран числа 26 и 25.
public class Task04 {
    public static void main(String[] args) {
        int x = 27;
        int y = 15;
        // y = x - y;
        // y = y - x;
        // y = y + x;
        // y = y + x;
        y = x / y;
        // y = y / x;
        // y = y * x;
        x = x - y;
        y = y - x;

        System.out.println(Math.abs(x));
        System.out.println(Math.abs(y));
    }
}