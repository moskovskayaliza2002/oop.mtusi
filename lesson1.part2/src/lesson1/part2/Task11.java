package lesson1.part2;
// Написать функцию, которая вычисляет минимум из трёх чисел.
// Нужно написать тело существующей функции min.
public class Task11 {
    public static int min(int a, int b, int c) {
        int min = a;
        if (b < min){
            min = b;
        }
        if (c < min){
            min = c;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
