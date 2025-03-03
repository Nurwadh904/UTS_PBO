import java.util.ArrayList;
import java.util.Scanner;

class Buah {
    private String nama;
    private double harga;

    public Buah(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

public class TokoBuah {
    private static ArrayList<Buah> daftarBuah = new ArrayList<>();
    private static ArrayList<Buah> keranjang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuah.add(new Buah("Apel", 10000));
        daftarBuah.add(new Buah("Jeruk", 8000));
        daftarBuah.add(new Buah("Mangga", 12000));
        daftarBuah.add(new Buah("Pisang", 7000));

        boolean running = true;
        while (running) {
            System.out.println("\n=== TOKO BUAH ===");
            System.out.println("1. Lihat Daftar Buah");
            System.out.println("2. Tambah Buah Baru");
            System.out.println("3. Ubah Data Buah");
            System.out.println("4. Hapus Buah");
            System.out.println("5. Tambah Buah ke Keranjang");
            System.out.println("6. Lihat Keranjang");
            System.out.println("7. Hitung Total Harga");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanDaftarBuah();
                    break;
                case 2:
                    tambahBuah();
                    break;
                case 3:
                    ubahBuah();
                    break;
                case 4:
                    hapusBuah();
                    break;
                case 5:
                    tambahKeKeranjang();
                    break;
                case 6:
                    tampilkanKeranjang();
                    break;
                case 7:
                    hitungTotal();
                    break;
                case 8:
                    running = false;
                    System.out.println("Terima kasih telah berbelanja di Toko Buah!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private static void tampilkanDaftarBuah() {
        System.out.println("\nDaftar Buah yang Tersedia:");
        for (int i = 0; i < daftarBuah.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBuah.get(i).getNama() + " - Rp " + daftarBuah.get(i).getHarga());
        }
    }

    private static void tambahBuah() {
        System.out.print("Masukkan nama buah baru: ");
        scanner.nextLine();
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga buah: ");
        double harga = scanner.nextDouble();
        daftarBuah.add(new Buah(nama, harga));
        System.out.println("Buah " + nama + " berhasil ditambahkan.");
    }

    private static void ubahBuah() {
        tampilkanDaftarBuah();
        System.out.print("Masukkan nomor buah yang ingin diubah: ");
        int index = scanner.nextInt();
        if (index > 0 && index <= daftarBuah.size()) {
            scanner.nextLine(); 
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan harga baru: ");
            double hargaBaru = scanner.nextDouble();
            daftarBuah.get(index - 1).setNama(namaBaru);
            daftarBuah.get(index - 1).setHarga(hargaBaru);
            System.out.println("Data buah berhasil diperbarui.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void hapusBuah() {
        tampilkanDaftarBuah();
        System.out.print("Masukkan nomor buah yang ingin dihapus: ");
        int index = scanner.nextInt();
        if (index > 0 && index <= daftarBuah.size()) {
            System.out.println("Buah " + daftarBuah.get(index - 1).getNama() + " telah dihapus.");
            daftarBuah.remove(index - 1);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tambahKeKeranjang() {
        tampilkanDaftarBuah();
        System.out.print("Masukkan nomor buah yang ingin dibeli: ");
        int pilihan = scanner.nextInt();
        if (pilihan > 0 && pilihan <= daftarBuah.size()) {
            keranjang.add(daftarBuah.get(pilihan - 1));
            System.out.println(daftarBuah.get(pilihan - 1).getNama() + " telah ditambahkan ke keranjang.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tampilkanKeranjang() {
        if (keranjang.isEmpty()) {
            System.out.println("\nKeranjang belanja Anda kosong.");
        } else {
            System.out.println("\nIsi Keranjang Belanja Anda:");
            for (int i = 0; i < keranjang.size(); i++) {
                System.out.println((i + 1) + ". " + keranjang.get(i).getNama() + " - Rp " + keranjang.get(i).getHarga());
            }
        }
    }

    private static void hitungTotal() {
        double total = 0;
        for (Buah buah : keranjang) {
            total += buah.getHarga();
        }
        System.out.println("\nTotal harga belanjaan Anda: Rp " + total);
    }
}