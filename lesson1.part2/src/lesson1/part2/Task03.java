package lesson1.part2;
// В методе public static void hackSalary(int a) увеличь зарплату на 100 и выведи на экран надпись:
// "Твоя зарплата составляет: <a+100> долларов в месяц."
// Где <a+100> - это зарплата увеличенная на 100.
public class Task03 {
    public static void main(String[] args) {
        hackSalary(700);
    }
    public static void hackSalary(int a) {
        System.out.println("Твоя зарплата составляет: " + (a + 100) + " долларов в месяц.");
    }
}
