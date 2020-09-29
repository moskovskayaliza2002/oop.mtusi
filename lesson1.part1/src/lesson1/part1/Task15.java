package lesson1.part1;
//Напиши программу, которая выводит на экран квадрат этой переменной (number * number)
public class Task15 {
    public static int number = 25;

    public static void main(String[] args) {
        number = (int) Math.pow(number,2);
        System.out.println(number);
        System.out.println(Math.cos(number));
    }
}
