package lesson1.part1;
// Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
// Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
// Эти размеры передаются в метод getVolume. Метод должен вернуть количество литров воды, которое нужно для наполнения бассейна.
public class Task11 {
    private static class Pool {
        final public int a = 25;
        final protected int b = 25;
        final private int c = 2;

        public long getVolume(int a, int b, int c) {
            long liters = a * b * c * 1000;
            return liters;
        }
    }
    public static void main(String[] args) {
        Pool pool = new Pool();
        long poolVolume = pool.getVolume(25, 5, 2);
        System.out.println(poolVolume);
    }
}