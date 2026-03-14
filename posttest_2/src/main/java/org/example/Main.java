package org.example;
import org.example.models.Handphone;
import com.google.gson.Gson;      // package external (Gson)
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("5. Keluar & Cetak JSON (Poin Plus)");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

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
                                                            // Mengambil data menggunakan Getter
                            System.out.println("Merk: " + daftarHandphone.get(i).getMerk() + " | Nama: " + daftarHandphone.get(i).getNama()+ " | Harga: " + daftarHandphone.get(i).getHarga());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Update Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        System.out.print("Masukkan nomor urut data yang ingin diubah: ");
                        int indexUpdate = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexUpdate >= 0 && indexUpdate < daftarHandphone.size()) {
                            Handphone hpTarget = daftarHandphone.get(indexUpdate);

                            System.out.print("Masukkan Merk Baru: ");
                                                            // Menimpa data menggunakan Setter
                            hpTarget.setMerk(scanner.nextLine());

                            System.out.print("Masukkan Nama Baru: ");
                            hpTarget.setNama(scanner.nextLine());

                            System.out.print("Masukkan Harga Baru: ");
                            hpTarget.setHarga(scanner.nextInt());

                            System.out.println("Data berhasil diperbarui!");
                        } else {
                            System.out.println("Nomor urut tidak valid!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Hapus Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
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
                    System.out.println("\nTerima kasih! Menyimpan data terakhir ke format JSON...");

                                                          // Implementasi package external GSON
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonOutput = gson.toJson(daftarHandphone);
                    System.out.println(jsonOutput);
                    break;

                default:
                    System.out.println("Pilihan tidak ada di menu. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
