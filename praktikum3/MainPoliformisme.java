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

class Hewan {
    public void suara() {
        System.out.println("Hewan membuat suara");
    }
}

class Anjing extends Hewan {
    @Override
    public void suara() {
        System.out.println("Anjing menggonggong");
    }
}

class Kucing extends Hewan {
    @Override
    public void suara() {
        System.out.println("Kucing mengeong");
    }
}

// Tambahan kelas Burung
class Burung extends Hewan {
    @Override
    public void suara() {
        System.out.println("Burung berkicau");
    }
}

public class MainPoliformisme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sekarang array punya 3 jenis hewan (Anjing, Kucing, Burung)
       Hewan[] hewanArray = new Hewan[3];
        hewanArray[0] = new Anjing();
        hewanArray[1] = new Kucing();
        hewanArray[2] = new Burung();

        System.out.println("Pilih hewan dari 0 hingga 2:");
        System.out.println("0 = Anjing, 1 = Kucing, 2 = Burung");
        int pilihan = scanner.nextInt();

        if (pilihan >= 0 && pilihan < hewanArray.length) {
            hewanArray[pilihan].suara(); // Polimorfisme: suara() tergantung objek
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
