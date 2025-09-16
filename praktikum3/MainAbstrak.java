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

// Kelas abstrak
abstract class Kendaraan {
    protected String merk;

    public Kendaraan(String merk) {
        this.merk = merk;
    }

    // Metode abstrak
    public abstract void nyalakanMesin();

    // Metode non-abstrak
    public void matikanMesin() {
        System.out.println(merk + " mesin dimatikan.");
    }
}

// Subclass Mobil
class Mobil extends Kendaraan {
    public Mobil(String merk) {
        super(merk);
    }

    @Override
    public void nyalakanMesin() {
        System.out.println(merk + " (Mobil): Mesin dinyalakan dengan kunci.");
    }
}

// Subclass Motor
class Motor extends Kendaraan {
    public Motor(String merk) {
        super(merk);
    }

    @Override
    public void nyalakanMesin() {
        System.out.println(merk + " (Motor): Mesin dinyalakan dengan starter.");
    }
}

// Main class
public class MainAbstrak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1 = Mobil");
        System.out.println("2 = Motor");
        int pilihan = scanner.nextInt();

        Kendaraan kendaraan;

        if (pilihan == 1) {
            kendaraan = new Mobil("Toyota");
        } else if (pilihan == 2) {
            kendaraan = new Motor("Honda");
        } else {
            System.out.println("Pilihan tidak valid.");
            scanner.close();
            return;
        }

        // Panggil method
        kendaraan.nyalakanMesin();
        kendaraan.matikanMesin();

        scanner.close();
    }
}

