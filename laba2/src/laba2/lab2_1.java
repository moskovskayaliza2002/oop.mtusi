package laba2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class lab2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // Вызываем конструкторы
        Point3d point1 = new Point3d();
        Point3d point2 = new Point3d();
        Point3d point3 = new Point3d();
        // Присваиваем введеные значения каждой координате точки 1
        System.out.println("Введите координаты первой точки: ");
        String str1 = read.readLine();
        String[] arr1 = str1.split(" ");
        point1.setX(Double.parseDouble(arr1[0]));
        point1.setY(Double.parseDouble(arr1[1]));
        point1.setZ(Double.parseDouble(arr1[2]));
        // Присваиваем введеные значения каждой координате точки 2
        System.out.println("Введите координаты второй точки через пробел: ");
        String str2 = read.readLine();
        String[] arr2 = str2.split(" ");
        point2.setX(Double.parseDouble(arr2[0]));
        point2.setY(Double.parseDouble(arr2[1]));
        point2.setZ(Double.parseDouble(arr2[2]));
        // Присваиваем введеные значения каждой координате точки 3
        System.out.println("Введите координаты третьей точки через пробел: ");
        String str3 = read.readLine();
        String[] arr3 = str3.split(" ");
        point3.setX(Double.parseDouble(arr3[0]));
        point3.setY(Double.parseDouble(arr3[1]));
        point3.setZ(Double.parseDouble(arr3[2]));
        // Сравниваем точки и высчитываем площадь
        if ((point1.compare(point2)) || (point2.compare(point3)) || (point1.compare(point3))){
            System.out.println("Введеные точки не составляют треугольник!");
        }
        else{
            System.out.println("Площадь треугольника равна: " + computeArea(point1, point2, point3));
        }
    }
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        // Вызываем методы для подсчета длин сторон и высчитываем площадь по формуле Герона
        double side1, side2, side3, area, semiPerimeter;
        side1 = point1.distanceTo(point2);
        side2 = point2.distanceTo(point3);
        side3 = point1.distanceTo(point3);
        semiPerimeter = 0.5 * (side1 + side2 + side3);
        area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        return area;
    }
}
