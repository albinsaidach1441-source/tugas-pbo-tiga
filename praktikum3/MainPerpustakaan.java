/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.Scanner;

// Superclass
abstract class Item {
    protected String judul;
    protected int tahunTerbit;

    public Item(String judul, int tahunTerbit) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public abstract void tampilkanInfo();
}

// Subclass Buku
class Buku extends Item {
    private String pengarang;
    private int jumlahHalaman;

    public Buku(String judul, int tahunTerbit, String pengarang, int jumlahHalaman) {
        super(judul, tahunTerbit);
        this.pengarang = pengarang;
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Buku: " + judul + " (" + tahunTerbit + "), Pengarang: " + pengarang + ", Halaman: " + jumlahHalaman);
    }
}

// Subclass Majalah
class Majalah extends Item {
    private int edisi;
    private int volume;

    public Majalah(String judul, int tahunTerbit, int edisi, int volume) {
        super(judul, tahunTerbit);
        this.edisi = edisi;
        this.volume = volume;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Majalah: " + judul + " (" + tahunTerbit + "), Edisi: " + edisi + ", Volume: " + volume);
    }
}

// Subclass DVD
class DVD extends Item {
    private int durasi; // menit
    private String genre;

    public DVD(String judul, int tahunTerbit, int durasi, String genre) {
        super(judul, tahunTerbit);
        this.durasi = durasi;
        this.genre = genre;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("DVD: " + judul + " (" + tahunTerbit + "), Durasi: " + durasi + " menit, Genre: " + genre);
    }
}

// Contoh tambahan: Ebook
class Ebook extends Item {
    private double ukuranFile; // MB
    private String format;

    public Ebook(String judul, int tahunTerbit, double ukuranFile, String format) {
        super(judul, tahunTerbit);
        this.ukuranFile = ukuranFile;
        this.format = format;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Ebook: " + judul + " (" + tahunTerbit + "), Ukuran: " + ukuranFile + "MB, Format: " + format);
    }
}

// Main class
public class MainPerpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> koleksi = new ArrayList<>();

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== Menu Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Majalah");
            System.out.println("3. Tambah DVD");
            System.out.println("4. Tambah Ebook");
            System.out.println("5. Tampilkan Semua Item");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (pilih) {
                case 1:
                    System.out.print("Judul: ");
                    String judulBuku = scanner.nextLine();
                    System.out.print("Tahun terbit: ");
                    int tahunBuku = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Pengarang: ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Jumlah halaman: ");
                    int halaman = scanner.nextInt();
                    koleksi.add(new Buku(judulBuku, tahunBuku, pengarang, halaman));
                    break;
                case 2:
                    System.out.print("Judul: ");
                    String judulMaj = scanner.nextLine();
                    System.out.print("Tahun terbit: ");
                    int tahunMaj = scanner.nextInt();
                    System.out.print("Edisi: ");
                    int edisi = scanner.nextInt();
                    System.out.print("Volume: ");
                    int volume = scanner.nextInt();
                    koleksi.add(new Majalah(judulMaj, tahunMaj, edisi, volume));
                    break;
                case 3:
                    System.out.print("Judul: ");
                    String judulDVD = scanner.nextLine();
                    System.out.print("Tahun terbit: ");
                    int tahunDVD = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Durasi (menit): ");
                    int durasi = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    koleksi.add(new DVD(judulDVD, tahunDVD, durasi, genre));
                    break;
                case 4:
                    System.out.print("Judul: ");
                    String judulE = scanner.nextLine();
                    System.out.print("Tahun terbit: ");
                    int tahunE = scanner.nextInt();
                    System.out.print("Ukuran file (MB): ");
                    double ukuran = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Format: ");
                    String format = scanner.nextLine();
                    koleksi.add(new Ebook(judulE, tahunE, ukuran, format));
                    break;
                case 5:
                    System.out.println("\n=== Daftar Item ===");
                    for (Item i : koleksi) {
                        i.tampilkanInfo();
                    }
                    break;
                case 0:
                    jalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}

