package lesson1.part2;
// Создай объект типа Cat (кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
// Присвой каждому животному владельца (owner).
public class Task09 {
    public static void main(String[] args) {
        Woman woman = new Woman();
        Cat cat = new Cat();
        cat.owner = woman;
        Dog dog = new Dog();
        dog.owner = woman;
        Fish fish = new Fish();
        fish.owner = woman;
    }
    public static class Cat {
        public Woman owner;
    }
    public static class Dog {
        public Woman owner;
    }
    public static class Fish {
        public Woman owner;
    }
    public static class Woman {
    }
}
