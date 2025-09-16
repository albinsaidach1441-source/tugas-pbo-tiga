/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3.praktek;
import java.util.Scanner;

/**
 *
 * @author user
 */
class Hewani {
    public void suara() {
        System.out.println("Hewan membuat suara");
    }
}

// Kelas turunan Anjing
class Anjingg extends Hewani {
    @Override
    public void suara() {
        System.out.println("Anjing menggonggong");
    }
}

// Kelas turunan Kucing
class Kucingg extends Hewani {
    @Override
    public void suara() {
        System.out.println("Kucing mengeong");
    }
}

// Kelas utama
public class MainHewani {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih hewan:");
        System.out.println("1. Anjing");
        System.out.println("2. Kucing");
        System.out.print("Masukkan pilihan Anda (1 atau 2): ");
        int pilihan = scanner.nextInt();

        Hewani hewannn = null; // Referensi polimorfisme

        if (pilihan == 1) {
            Anjingg hewani = new Anjingg(); // Polimorfisme: objek Anjing
        } else if (pilihan == 2) {
            Kucingg hewani = new Kucingg(); // Polimorfisme: objek Kucing
        } else {
            System.out.println("Pilihan tidak valid.");
            scanner.close();
            return;
        }

        // Memanggil metode suara secara polimorfik
        hewannn.suara();

        scanner.close();
    }
}
