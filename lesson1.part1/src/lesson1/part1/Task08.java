package lesson1.part1;
// Метод на вход принимает количество сантиметров.
// Нужно сделать так, чтобы метод возвращал число полных метров в centimetre. (1 метр = 100 см).
public class Task08 {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(243));
    }
    public static int getMetreFromCentimetre(int centimetre) {
        return (int)(centimetre/100);
    }
}