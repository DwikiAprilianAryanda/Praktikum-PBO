# Sistem Manajemen Toko Handphone 📱

## 1. Deskripsi Singkat Program
Sistem Manajemen Toko Handphone adalah sebuah program aplikasi berbasis konsol (CLI) yang ditulis menggunakan bahasa pemrograman Java. Program ini dibuat untuk menyimulasikan pengelolaan data barang di sebuah toko *handphone*, dengan menerapkan konsep dasar *Object-Oriented Programming* (OOP) seperti pembuatan *Class*, instansiasi *Object*, *Constructor Overloading*, serta penggunaan kata kunci `this`.

Fungsionalitas utama dari program ini adalah operasi **CRUD (Create, Read, Update, Delete)**. Data *handphone* (Merk, Nama, dan Harga) disimpan secara dinamis di dalam memori menggunakan struktur data `ArrayList` dari *library* `java.util.ArrayList`. Program ini juga bersifat interaktif, di mana pengguna dapat memilih aksi melalui menu perulangan `while` dan percabangan `switch-case` yang dikendalikan oleh *input* dari `Scanner`.

## 2. Code Program
Berikut adalah *source code* lengkap dari program Sistem Manajemen Toko Handphone:

```java
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

    Handphone(String merk, String nama, int harga) {
        this.merk = merk;     
        this.nama = nama;
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
```

## 3. Output Program
### 3.1 Menu Utama
<img width="436" height="201" alt="image" src="https://github.com/user-attachments/assets/ea6ff95f-5a9c-4497-8617-7ffbb49f6cdc" />

### 3.2 Create
<img width="435" height="379" alt="image" src="https://github.com/user-attachments/assets/558ac952-978a-45cc-9145-2126197fb93f" />

### 3.3 Read
<img width="629" height="104" alt="image" src="https://github.com/user-attachments/assets/090cdcac-8921-4a58-8e4e-84e02e2ec799" />

### 3.4 Update
<img width="652" height="510" alt="image" src="https://github.com/user-attachments/assets/44d4d473-6164-4b35-a48e-7dcf059132fe" />

### 3.5 Delete
<img width="658" height="396" alt="image" src="https://github.com/user-attachments/assets/14377c6b-40a4-4fe9-b66d-2f53e7532da0" />

