package ru.yura.test1;

public class MainClass {
    public static void main(String[] args) {
        var c1 = new Circle(10);
        System.out.println(c1.getS());
        var s1 = new Square(10);
        System.out.println(s1.getS());
        /*
        Animal[] animals = {
                new Cat("Яндекс",3.5f),
                new Cat("Мурзик",4),
                new Tigre("Тигрёнок",150,100),
                new Jiraf("Жора",5),
                new Cat("Гугл",50),
                new Cat("Луопард")};
        for (var animal :animals) {
            System.out.println(animal.getName()+" "+animal.getColor());
        }

        try {
            System.out.println("Если корни уравнения = -9999999, то это значит, что корней нет.");
            var kvur1 = new KvUr();
            kvur1.getDt(1, 2, 1);
            System.out.println("Корни уравнения 1: " + kvur1.getX1(2, 1) + " " + kvur1.getX2(2, 1));
            var kvur2 = new KvUr();
            kvur1.getDt(10, 27, 3);
            System.out.println("Корни уравнения 2: " + kvur1.getX1(27, 10) + " " + kvur1.getX2(2, 1));
            var kvur3 = new KvUr();
            kvur1.getDt(30, 2, 12);
            System.out.println("Корни уравнения 3: " + kvur1.getX1(2, 1) + " " + kvur1.getX2(2, 1));
        }
        catch (Exception e) {

        }
         */
    }
}
