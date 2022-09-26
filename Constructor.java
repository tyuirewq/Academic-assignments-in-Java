package code.Java;

import java.util.*;

class Constructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle   :     ");
        double radius = sc.nextDouble();
        Circle a = new Circle(radius);
        System.out.println("Area of the cicle is :    " + a.area);
        sc.close();
    }
}

// This is Our Constructor Class
class Circle {
    double area;

    Circle(double radius) {
        area = (22 * radius * radius) / 7;
    }
}

// Hariom Kaushal
// 202051080