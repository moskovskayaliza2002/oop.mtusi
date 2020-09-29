package lesson1.part2;
// Реализуй метод print3. Метод должен вывести переданную строку (слово) на экран три раза через пробел.
public class Task14 {
    public static void print3(String s) {
        System.out.println(s + " " + s + " " + s );
    }
    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}
