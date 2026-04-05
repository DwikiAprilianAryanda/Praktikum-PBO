# Sistem Manajemen Toko Handphone 📱 (Posttest 3: Inheritance)

## 1. Deskripsi Singkat Program
Sistem Manajemen Toko Handphone adalah program aplikasi CLI (Command Line Interface) berbasis Java untuk mensimulasikan manajemen data (CRUD) di toko handphone.

Pada Posttest 3 ini, program mengimplementasikan konsep Inheritance (Pewarisan untuk memisahkan spesifikasi tipe handphone menjadi lebih rinci:
1. **Lebih dari 2 Subclass:** Program memiliki 3 subclass, yaitu `FeaturePhone`, `Smartphone`, dan `SmartphoneGaming`.
2. **Minimal 1 Tipe Inheritance:** Program menerapkan dua tipe inheritance sekaligus, yaitu:
   - **Hierarchical Inheritance:** Superclass `Handphone` diwariskan ke `FeaturePhone` dan `Smartphone` secara sejajar .
   - **Multilevel Inheritance:** Superclass `Handphone` diwariskan ke `Smartphone`, yang kemudian diturunkan lagi ke `SmartphoneGaming` .
3. Penggunaan *keyword* `extends` pada deklarasi class, serta `super()` untuk memanggil konstruktor parent dan `super.tampilkanData()` untuk memanggil method parent .

## 2. Code Program
### 2.1 Main.java
```
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
                    System.out.println("\n--- Update Data Dasar Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
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
```

### 2.2 FeaturePhone.java
```
package org.example.models;

public class FeaturePhone extends Handphone {
    private String tipeJaringan;

    public FeaturePhone(String merk, String nama, int harga, String tipeJaringan) {
        super(merk, nama, harga);
        this.tipeJaringan = tipeJaringan;
    }

    public String getTipeJaringan() {
        return tipeJaringan;
    }

    public void setTipeJaringan(String tipeJaringan) {
        this.tipeJaringan = tipeJaringan;
    }

    // Memodifikasi method tampilkanData bawaan parent
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Tipe Jaringan: " + this.tipeJaringan);
    }
}
```

### 2.3 Handphone.java
```
package org.example.models;

public class Handphone {

    // PRIVATE
    private String merk;
    private String nama;
    private int harga;

    // PROTECTED
    protected String distributor = "PT. Ingin Menjadi Programer Handal Tapi Malas Ngoding";

    // DEFAULT
    String status = "Tersedia";

    // PUBLIC
    public Handphone(String merk, String nama, int harga) {
        this.merk = merk;
        this.nama = nama;
        setHarga(harga);
    }

    // GETTER & SETTER

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    // Encapsulation
    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Peringatan: Harga tidak boleh negatif. Nilai di-set ke 0.");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    // Method Public
    public void tampilkanData() {
        System.out.println("Merk: " + this.merk + " | Nama: " + this.nama +
                " | Harga: Rp" + this.harga +
                " | Distributor: " + this.distributor +
                " | Status: " + this.status);
    }
}
```

### 2.4 Smartphone.java
```
package org.example.models;

public class Smartphone extends Handphone {
    private String sistemOperasi;

    public Smartphone(String merk, String nama, int harga, String sistemOperasi) {
        super(merk, nama, harga);
        this.sistemOperasi = sistemOperasi;
    }

    public String getSistemOperasi() {
        return sistemOperasi;
    }

    public void setSistemOperasi(String sistemOperasi) {
        this.sistemOperasi = sistemOperasi;
    }

    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Sistem Operasi: " + this.sistemOperasi);
    }
}
```


### 2.5 SmartphoneGaming.java
```
package org.example.models;

public class SmartphoneGaming extends Smartphone {
    private int kapasitasRAM;

    public SmartphoneGaming(String merk, String nama, int harga, String sistemOperasi, int kapasitasRAM) {
        super(merk, nama, harga, sistemOperasi);
        this.kapasitasRAM = kapasitasRAM;
    }

    public int getKapasitasRAM() {
        return kapasitasRAM;
    }

    public void setKapasitasRAM(int kapasitasRAM) {
        this.kapasitasRAM = kapasitasRAM;
    }

    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Kapasitas RAM: " + this.kapasitasRAM + " GB");
    }
}
```


## 3. Output Program
