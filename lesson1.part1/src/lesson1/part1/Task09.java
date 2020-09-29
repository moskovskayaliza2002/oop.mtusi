package lesson1.part1;
// Напиши код метода sumDigitsInNumber(int number).
// Метод на вход принимает целое трехзначное число. Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.
public class Task09 {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }
    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int count = (Integer.toString(number)).length();
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number = (int)(number/10);
        }
        return sum;
    }
}