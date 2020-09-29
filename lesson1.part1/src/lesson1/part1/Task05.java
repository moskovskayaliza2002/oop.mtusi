package lesson1.part1;
// Закомментируй ненужные строки кода, чтобы на экран вывелась надпись:
// 9 умножить на 3 равно 27
public class Task05 {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;

        //System.out.print("девять");
        System.out.print(b);
        System.out.print(" умножить ");
        System.out.print("на ");
        System.out.print(a);
        //System.out.print("три");
        //System.out.print(" не ");
        //System.out.print("будет ");
        System.out.print(" равно ");
        //System.out.print("пятнадцать");
        //System.out.print(21);
        System.out.print((int) Math.pow(3, 3));
    }
}