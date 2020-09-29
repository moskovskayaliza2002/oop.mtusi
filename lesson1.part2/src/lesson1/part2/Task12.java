package lesson1.part2;
// Написать функцию, которая вычисляет минимум из четырёх чисел.
// Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
public class Task12 {
    public static int min(int a, int b, int c, int d) {
        int min = min(a,b);
        min = min(min,c);
        min = min(min,d);
        return min;
    }
    public static int min(int a, int b) {
        if (a > b){
            return b;
        }
        else {
            return a;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
