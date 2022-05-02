package org.example.HWLesson4;



public class Triangle {
    public int a;
    public int b;
    public int c;


    public static Double triangleArea(int a, int b, int c)throws MyException{
        double p = (a + b + c) / 2.0;
        if (a + b < c || a + c < b || b + c < a) {
            throw new MyException("Такого треугольника не существует");
        }else if (p==0||p-a==0||p-b==0||p-c==0) {
            throw new MyException("Площадь треугольника равна нулю");}
        else {

            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Площадь треугольника: "+ square);
        return square;
        }


    }


}



