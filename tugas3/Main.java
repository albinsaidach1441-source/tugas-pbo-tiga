/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas3;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        Drawable drawableCircle = (Drawable) circle;
        Drawable drawableRectangle = (Drawable) rectangle;

        System.out.println("Luas Lingkaran: " + circle.getArea());
        drawableCircle.draw();

        System.out.println("Luas Persegi Panjang: " + rectangle.getArea());
        drawableRectangle.draw();
    }
}
