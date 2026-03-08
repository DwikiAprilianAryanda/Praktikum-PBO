import java.util.ArrayList;
import java.util.Scanner;

class Handphone {
    String merk;
    String nama;
    int harga;

    Handphone() {
        this.merk = "Belum diketahui";
        this.nama = "Belum diketahui";
        this.harga = 0;
    }

    Handphone(String merk, String tipe, int harga) {
        this.merk = merk;     // Penggunaan kata kunci "this"
        this.nama = tipe;
        this.harga = harga;
    }

    void tampilkanData() {
        System.out.println("Merk: " + this.merk + " | Nama: " + this.nama + " | Harga: Rp" + this.harga);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Handphone> daftarHandphone = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== SISTEM MANAJEMEN TOKO HANDPHONE ===");
            System.out.println("1. Tambah Data Handphone (Create)");
            System.out.println("2. Lihat Data Handphone (Read)");
            System.out.println("3. Update Data Handphone (Update)");
            System.out.println("4. Hapus Data Handphone (Delete)");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Merk Handphone: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama Handphone: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Harga Handphone: ");
                    int hargaBaru = scanner.nextInt();
                    Handphone hpBaru = new Handphone(merkBaru, namaBaru, hargaBaru);
                    daftarHandphone.add(hpBaru);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n--- Daftar Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        for (int i = 0; i < daftarHandphone.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarHandphone.get(i).tampilkanData();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Update Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong, tidak ada yang bisa diubah.");
                    } else {
                        System.out.print("Masukkan nomor urut data yang ingin diubah: ");
                        int indexUpdate = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexUpdate >= 0 && indexUpdate < daftarHandphone.size()) {
                            System.out.print("Masukkan Merk Baru: ");
                            String merkUpdate = scanner.nextLine();
                            System.out.print("Masukkan Nama Baru: ");
                            String namaUpdate = scanner.nextLine();
                            System.out.print("Masukkan Harga Baru: ");
                            int hargaUpdate = scanner.nextInt();
                            Handphone hpUpdate = new Handphone(merkUpdate, namaUpdate, hargaUpdate);
                            daftarHandphone.set(indexUpdate, hpUpdate);
                            System.out.println("Data berhasil diperbarui!");
                        } else {
                            System.out.println("Nomor urut tidak valid!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Hapus Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong, tidak ada yang bisa dihapus.");
                    } else {
                        System.out.print("Masukkan nomor urut data yang ingin dihapus: ");
                        int indexDelete = scanner.nextInt() - 1;

                        if (indexDelete >= 0 && indexDelete < daftarHandphone.size()) {
                            daftarHandphone.remove(indexDelete);
                            System.out.println("Data berhasil dihapus!");
                        } else {
                            System.out.println("Nomor urut tidak valid!");
                        }
                    }
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak ada di menu. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}