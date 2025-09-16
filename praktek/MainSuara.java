/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3.praktek;

/**
 *
 * @author user
 */
import java.util.Scanner;

// Kelas induk
class Hewans {
    public void suara() {
        System.out.println("Hewan membuat suara");
    }
}

// Kelas turunan Anjing
class Anjings extends Hewans {
    @Override
    public void suara() {
        System.out.println("Anjing menggonggong");
    }
}

// Kelas turunan Kucing
class Kucings extends Hewans {
    @Override
    public void suara() {
        System.out.println("Kucing mengeong");
    }
}

// Kelas utama
public class MainSuara {
    public static void main(String[] args) {
        // Membuat array Hewan berisi beberapa objek turunan
        try(Scanner scanner = new Scanner(System.in)) {
            // Membuat array Hewan berisi beberapa objek turunan
            Hewan[] hewanArray = new Hewan[3];
            hewanArray[0] = new Anjing();
            hewanArray[1] = new Kucing();
            hewanArray[2] = new Kucing();
            
            // Meminta input dari pengguna
            System.out.println("Pilih hewan dari 0 hingga 2:");
            int pilihan = scanner.nextInt();
            
            // Mengecek apakah pilihan valid
            if (pilihan >= 0 && pilihan < hewanArray.length) {
                hewanArray[pilihan].suara();  // Memanggil suara sesuai objek
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}