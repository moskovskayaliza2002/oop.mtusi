package lesson1.part2;
// Реализуй метод print3. Метод должен вывести на экран переданную строку 3 раза.
// Каждый раз с новой строки.
public class Task13 {
    public static void print3(String s) {
        for (int i = 0; i < 3; i++) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        print3("I love you!");
    }
}
