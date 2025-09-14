/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas3;

/**
 *
 * @author user
 */
class Rectangle extends Shape implements Drawable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height; // rumus luas persegi panjang
    }

    @Override
    public void draw() {
        System.out.println("Menggambar sebuah Persegi Panjang dengan lebar " + width + " dan tinggi " + height);
    }
}
