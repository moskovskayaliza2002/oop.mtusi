package lesson1.part2;
// Написать функцию, которая возвращает минимум из двух чисел.
// Нужно написать тело существующей функции min.
public class Task10 {
    public static int min(int a, int b) {
        if (a > b){
            return b;
        }
        else {
            return a;
        }
    }
    public static void main(String[] args) {
        System.out.println(min(12, 33));
        System.out.println(min(-20, 0));
        System.out.println(min(-10, -20));
    }
}
