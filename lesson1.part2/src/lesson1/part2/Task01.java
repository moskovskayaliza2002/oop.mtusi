package lesson1.part2;
// В классе Person объяви следующие переменные: name типа String, age типа int, weight типа int, money типа int.
// В методе main создай объект Person, занеси его ссылку в переменную person.
//
public class Task01 {
    public static void main(String[] args) {
        Person person = new Person();
    }
    public static class Person {
        String name;
        int age, weight, money;
    }
}
