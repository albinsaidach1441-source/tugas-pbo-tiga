package praktikum3;

import java.util.Scanner;

// Kelas abstrak Rekening
abstract class Rekening {
    protected String noRek;
    protected double saldo;

    public Rekening(String noRek, double saldo) {
        this.noRek = noRek;
        this.saldo = saldo;
    }

    // Method umum
    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor Rp" + jumlah + " berhasil. Saldo = Rp" + saldo);
        } else {
            System.out.println("Jumlah setor harus lebih dari 0.");
        }
    }

    // Method abstrak (aturan berbeda di tiap subclass)
    public abstract void tarik(double jumlah);

    public void info() {
        System.out.println("No Rekening: " + noRek + " | Saldo: Rp" + saldo);
    }
}

// Rekening Tabungan: tidak boleh di bawah saldo minimum
class RekeningTabungan extends Rekening {
    private double saldoMinimum;

    public RekeningTabungan(String noRek, double saldo, double saldoMinimum) {
        super(noRek, saldo);
        this.saldoMinimum = saldoMinimum;
    }

    @Override
    public void tarik(double jumlah) {
        if (saldo - jumlah >= saldoMinimum) {
            saldo -= jumlah;
            System.out.println("Tarik Rp" + jumlah + " berhasil. Saldo = Rp" + saldo);
        } else {
            System.out.println("Gagal tarik. Saldo tidak boleh kurang dari Rp" + saldoMinimum);
        }
    }
}

// Rekening Giro: bisa minus sampai limit tertentu (overdraft)
class RekeningGiro extends Rekening {
    private double overdraftLimit;

    public RekeningGiro(String noRek, double saldo, double overdraftLimit) {
        super(noRek, saldo);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void tarik(double jumlah) {
        if (saldo - jumlah >= -overdraftLimit) {
            saldo -= jumlah;
            System.out.println("Tarik Rp" + jumlah + " berhasil. Saldo = Rp" + saldo);
        } else {
            System.out.println("Gagal tarik. Melebihi overdraft limit Rp" + overdraftLimit);
        }
    }
}

// Rekening Deposito: hanya bisa ditarik saat jatuh tempo
class RekeningDeposito extends Rekening {
    private boolean jatuhTempo;

    public RekeningDeposito(String noRek, double saldo, boolean jatuhTempo) {
        super(noRek, saldo);
        this.jatuhTempo = jatuhTempo;
    }

    @Override
    public void tarik(double jumlah) {
        if (!jatuhTempo) {
            System.out.println("Gagal tarik. Deposito belum jatuh tempo.");
        } else if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Tarik Rp" + jumlah + " berhasil. Saldo = Rp" + saldo);
        } else {
            System.out.println("Gagal tarik. Saldo tidak mencukupi.");
        }
    }
}

// Main class interaktif
public class MainRekening {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistem Perbankan ===");
        System.out.println("Pilih jenis rekening:");
        System.out.println("1. Rekening Tabungan");
        System.out.println("2. Rekening Giro");
        System.out.println("3. Rekening Deposito");
        int pilih = sc.nextInt();

        Rekening rekening = null;

        switch (pilih) {
            case 1:
                rekening = new RekeningTabungan("T-001", 1000000, 50000);
                break;
            case 2:
                rekening = new RekeningGiro("G-001", 500000, 200000);
                break;
            case 3:
                System.out.println("Apakah sudah jatuh tempo? (true/false): ");
                boolean jatuhTempo = sc.nextBoolean();
                rekening = new RekeningDeposito("D-001", 2000000, jatuhTempo);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== Menu Transaksi ===");
            System.out.println("1. Info Saldo");
            System.out.println("2. Setor");
            System.out.println("3. Tarik");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    rekening.info();
                    break;
                case 2:
                    System.out.print("Jumlah setor: ");
                    double setoran = sc.nextDouble();
                    rekening.setor(setoran);
                    break;
                case 3:
                    System.out.print("Jumlah tarik: ");
                    double tarik = sc.nextDouble();
                    rekening.tarik(tarik);
                    break;
                case 0:
                    jalan = false;
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        }

        sc.close();
        System.out.println("Terima kasih telah menggunakan sistem perbankan.");
    }
}
