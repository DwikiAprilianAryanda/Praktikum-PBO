package org.example;

import org.example.models.Handphone;
import org.example.models.FeaturePhone;
import org.example.models.Smartphone;
import org.example.models.SmartphoneGaming;
import com.google.gson.Gson;
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
            System.out.println("5. Keluar & Cetak JSON");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Pilih Jenis Handphone ---");
                    System.out.println("1. Feature Phone");
                    System.out.println("2. Smartphone");
                    System.out.println("3. Smartphone Gaming");
                    System.out.print("Pilih (1-3): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan Merk: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Harga: ");
                    int hargaBaru = scanner.nextInt();
                    scanner.nextLine();

                    if (jenis == 1) {
                        System.out.print("Masukkan Tipe Jaringan (contoh: 2G/3G): ");
                        String jaringan = scanner.nextLine();
                        FeaturePhone fp = new FeaturePhone(merkBaru, namaBaru, hargaBaru, jaringan);
                        daftarHandphone.add(fp);
                        System.out.println("Feature Phone berhasil ditambahkan!");
                    } else if (jenis == 2) {
                        System.out.print("Masukkan Sistem Operasi: ");
                        String os = scanner.nextLine();
                        Smartphone sp = new Smartphone(merkBaru, namaBaru, hargaBaru, os);
                        daftarHandphone.add(sp);
                        System.out.println("Smartphone berhasil ditambahkan!");
                    } else if (jenis == 3) {
                        System.out.print("Masukkan Sistem Operasi: ");
                        String os = scanner.nextLine();
                        System.out.print("Masukkan Kapasitas RAM (GB): ");
                        int ram = scanner.nextInt();
                        scanner.nextLine();
                        SmartphoneGaming sg = new SmartphoneGaming(merkBaru, namaBaru, hargaBaru, os, ram);
                        daftarHandphone.add(sg);
                        System.out.println("Smartphone Gaming berhasil ditambahkan!");
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        for (int i = 0; i < daftarHandphone.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarHandphone.get(i).tampilkanData();
                            System.out.println("");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Update Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        System.out.println("Daftar Data Saat Ini:");
                        for (int i = 0; i < daftarHandphone.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarHandphone.get(i).tampilkanData();
                            System.out.println("");
                        }
                        System.out.println("-----------------------------------");

                        System.out.print("Masukkan nomor urut data yang ingin diubah: ");
                        int indexUpdate = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexUpdate >= 0 && indexUpdate < daftarHandphone.size()) {
                            Handphone hpTarget = daftarHandphone.get(indexUpdate);

                            System.out.print("Masukkan Merk Baru: ");
                            hpTarget.setMerk(scanner.nextLine());

                            System.out.print("Masukkan Nama Baru: ");
                            hpTarget.setNama(scanner.nextLine());

                            System.out.print("Masukkan Harga Baru: ");
                            hpTarget.setHarga(scanner.nextInt());
                            scanner.nextLine();

                            if (hpTarget instanceof SmartphoneGaming) {
                                SmartphoneGaming sgTarget = (SmartphoneGaming) hpTarget;
                                System.out.print("Masukkan Sistem Operasi Baru: ");
                                sgTarget.setSistemOperasi(scanner.nextLine());
                                System.out.print("Masukkan Kapasitas RAM Baru (GB): ");
                                sgTarget.setKapasitasRAM(scanner.nextInt());
                                scanner.nextLine();
                            } else if (hpTarget instanceof Smartphone) {
                                Smartphone spTarget = (Smartphone) hpTarget;
                                System.out.print("Masukkan Sistem Operasi Baru: ");
                                spTarget.setSistemOperasi(scanner.nextLine());
                            } else if (hpTarget instanceof FeaturePhone) {
                                FeaturePhone fpTarget = (FeaturePhone) hpTarget;
                                System.out.print("Masukkan Tipe Jaringan Baru: ");
                                fpTarget.setTipeJaringan(scanner.nextLine());
                            }

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
                        System.out.println("Daftar Data Saat Ini:");
                        for (int i = 0; i < daftarHandphone.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarHandphone.get(i).tampilkanData();
                            System.out.println("");
                        }
                        System.out.println("-----------------------------------");

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
