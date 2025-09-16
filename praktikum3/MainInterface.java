/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3;

/**
 *
 * @author user
 */

import java.util.Scanner;

// Interface
interface AlatElektronik {
    void hidupkan();
    void matikan();
}

// Kelas Televisi
class Televisi implements AlatElektronik {
    @Override
    public void hidupkan() {
        System.out.println("Televisi dihidupkan. Menampilkan siaran TV.");
    }

    @Override
    public void matikan() {
        System.out.println("Televisi dimatikan.");
    }
}

// Kelas Radio
class Radio implements AlatElektronik {
    @Override
    public void hidupkan() {
        System.out.println("Radio dihidupkan. Memutar siaran radio.");
    }

    @Override
    public void matikan() {
        System.out.println("Radio dimatikan.");
    }
}

// Main class
public class MainInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih alat elektronik:");
        System.out.println("1 = Televisi");
        System.out.println("2 = Radio");
        int pilihan = scanner.nextInt();

        AlatElektronik alat;

        if (pilihan == 1) {
            alat = new Televisi();
        } else if (pilihan == 2) {
            alat = new Radio();
        } else {
            System.out.println("Pilihan tidak valid.");
            scanner.close();
            return;
        }

        // Pilih aksi
        System.out.println("Pilih aksi:");
        System.out.println("1 = Hidupkan");
        System.out.println("2 = Matikan");
        int aksi = scanner.nextInt();

        if (aksi == 1) {
            alat.hidupkan();
        } else if (aksi == 2) {
            alat.matikan();
        } else {
            System.out.println("Aksi tidak valid.");
        }

        scanner.close();
    }
}

