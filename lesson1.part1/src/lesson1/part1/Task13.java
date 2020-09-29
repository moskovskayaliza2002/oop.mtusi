package lesson1.part1;
// сила тяжести на Луне составляет примерно 17% от силы тяжести на Земле.
// чтобы не считать каждый раз, реализуй метод getWeight(int),
// который принимает вес тела (в Ньютонах) на Земле, и возвращает,
// сколько это тело будет весить на Луне (в Ньютонах).
// Тип возвращаемого значения - double.
public class Task13 {
    public static void main(String[] args) {
        System.out.println(getWeight(888));
    }
    public static double getWeight(int earthWeight) {
        double weight = 0.17 * earthWeight;
        return weight;
    }
}
