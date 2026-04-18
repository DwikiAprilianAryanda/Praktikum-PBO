# Sistem Manajemen Toko Handphone 📱

## 1. Deskripsi Singkat Program

Sistem Manajemen Toko Handphone adalah program CLI berbasis Java yang mensimulasikan manajemen data (CRUD) dengan menerapkan berbagai pilar Object-Oriented Programming (OOP) secara lengkap.

Pada **Posttest 5** ini, struktur program ditingkatkan dengan pengamanan desain menggunakan konsep **Abstraction** dan **Interface**:
1. **Abstract Class & Method :** Superclass `Handphone` diubah menjadi `abstract class`. Hal ini secara logis mencegah program menginstansiasi HP "mentah" yang tidak jelas jenisnya. Selain itu, method `booting()` diubah menjadi `abstract void booting();` tanpa *body*, yang memaksa seluruh subclass (FeaturePhone, Smartphone, dll) untuk wajib memiliki logika booting-nya masing-masing.
2. **Interface Implementation :** Dibuat sebuah interface bernama `OperasiPerangkat` yang memuat 2 kontrak method: `cekBaterai()` dan `matikanPerangkat()`. Interface ini kemudian diimplementasikan (`implements`) secara bersamaan dengan class abstrak `Handphone`, menunjukkan bahwa dalam Java sebuah abstract class dapat menggabungkan inheritance dan interface secara simultan . Method dari interface ini didemonstrasikan pada Menu (Read) program.


## 2. Code Program
### 2.1 FeaturePhone.java
```
package org.example.models;

public class FeaturePhone extends Handphone {
    private String tipeJaringan;

    public FeaturePhone(String merk, String nama, int harga, String tipeJaringan) {
        super(merk, nama, harga);
        this.tipeJaringan = tipeJaringan;
    }

    public String getTipeJaringan() { return tipeJaringan; }
    public void setTipeJaringan(String tipeJaringan) { this.tipeJaringan = tipeJaringan; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Tipe Jaringan: " + this.tipeJaringan);
    }

    @Override
    public void booting() {
        System.out.println("[SISTEM] Menyalakan layar monokrom... Feature Phone siap.");
    }
}
```

### 2.2 Handphone.java
```
package org.example.models;

// 1. Mengubah menjadi Abstract Class & Mengimplementasikan Interface
public abstract class Handphone implements OperasiPerangkat {
    private String merk;
    private String nama;
    private int harga;

    protected String distributor = "PT. ASCII Asik";
    String status = "Tersedia";

    public Handphone(String merk, String nama, int harga) {
        this.merk = merk;
        this.nama = nama;
        setHarga(harga);
    }

    // --- GETTER & SETTER (Tetap sama) ---
    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getHarga() { return harga; }

    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Peringatan: Harga tidak boleh negatif. Nilai di-set ke 0.");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public void updateHarga(int hargaBaru) {
        setHarga(hargaBaru);
        System.out.println("Harga berhasil diubah menjadi: Rp" + this.harga);
    }

    public void updateHarga(double persenDiskon) {
        int diskon = (int) (this.harga * (persenDiskon / 100));
        setHarga(this.harga - diskon);
        System.out.println("Diskon " + persenDiskon + "% diterapkan. Harga baru: Rp" + this.harga);
    }

    public void tampilkanData() {
        System.out.println("Merk: " + this.merk + " | Nama: " + this.nama + " | Harga: Rp" + this.harga);
    }

    public void tampilkanData(boolean showDetail) {
        this.tampilkanData();
        if (showDetail) {
            System.out.println("  -> Distributor: " + this.distributor + " | Status: " + this.status);
        }
    }

    // 2. ABSTRACT METHOD
    public abstract void booting();

    // 3. IMPLEMENTASI METHOD DARI INTERFACE
    @Override
    public void cekBaterai() {
        System.out.println("[SISTEM] Kapasitas baterai saat ini: 100% (Penuh)");
    }

    @Override
    public void matikanPerangkat() {
        System.out.println("[SISTEM] Mematikan perangkat " + this.merk + " " + this.nama + "...");
    }
}
```

### 2.3 Smartphone.java
```
package org.example.models;

public class Smartphone extends Handphone {
    private String sistemOperasi;

    public Smartphone(String merk, String nama, int harga, String sistemOperasi) {
        super(merk, nama, harga);
        this.sistemOperasi = sistemOperasi;
    }

    public String getSistemOperasi() { return sistemOperasi; }
    public void setSistemOperasi(String sistemOperasi) { this.sistemOperasi = sistemOperasi; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Sistem Operasi: " + this.sistemOperasi);
    }

    @Override
    public void booting() {
        System.out.println("[SISTEM] Memuat " + this.sistemOperasi + " OS... Smartphone siap digunakan.");
    }
}
```

### 2.4 SmartphoneGaming.java
```
package org.example.models;

public class SmartphoneGaming extends Smartphone {
    private int kapasitasRAM;

    public SmartphoneGaming(String merk, String nama, int harga, String sistemOperasi, int kapasitasRAM) {
        super(merk, nama, harga, sistemOperasi);
        this.kapasitasRAM = kapasitasRAM;
    }

    public int getKapasitasRAM() { return kapasitasRAM; }
    public void setKapasitasRAM(int kapasitasRAM) { this.kapasitasRAM = kapasitasRAM; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Kapasitas RAM: " + this.kapasitasRAM + " GB");
    }

    @Override
    public void booting() {
        super.booting();
        System.out.println("[SISTEM] Mengaktifkan mode performa tinggi dan RGB lighting...");
    }
}
```

### 2.5 OperasiPerangkat.java
```
package org.example.models;

public interface OperasiPerangkat {
    void cekBaterai();
    void matikanPerangkat();
}
```

### 2.6 Main.java
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
                            System.out.print("\n[" + (i + 1) + "] ");

                            // Menampilkan data dan informasi
                            daftarHandphone.get(i).tampilkanData(true);

                            // Memanggil Abstract Method yang di override subclass
                            daftarHandphone.get(i).booting();

                            // Memanggil method hasil implementasi Interface
                            daftarHandphone.get(i).cekBaterai();
                            daftarHandphone.get(i).matikanPerangkat();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Update Data Handphone ---");
                    if (daftarHandphone.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        for (int i = 0; i < daftarHandphone.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarHandphone.get(i).tampilkanData();
                        }
                        System.out.print("Masukkan nomor urut data yang ingin diubah: ");
                        int indexUpdate = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexUpdate >= 0 && indexUpdate < daftarHandphone.size()) {
                            Handphone hpTarget = daftarHandphone.get(indexUpdate);

                            System.out.println("\nPilih Opsi Update Harga (Mendemonstrasikan Overloading):");
                            System.out.println("1. Ubah Harga Langsung (Input Nominal Bebas)");
                            System.out.println("2. Terapkan Diskon (Input Persentase)");
                            System.out.print("Pilihan (1/2): ");
                            int opsiHarga = scanner.nextInt();
                            scanner.nextLine();

                            if (opsiHarga == 1) {
                                System.out.print("Masukkan Harga Baru (Angka): ");
                                int nominalBaru = scanner.nextInt();
                                hpTarget.updateHarga(nominalBaru);
                                scanner.nextLine();
                            } else if (opsiHarga == 2) {
                                System.out.print("Masukkan Persentase Diskon (Contoh: 15.5): ");
                                double diskon = scanner.nextDouble();
                                hpTarget.updateHarga(diskon);
                                scanner.nextLine();
                            }

                            // Update tipe spesifik
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



## 3. Output Program
### 3.1 Menu Utama
<img width="420" height="216" alt="image" src="https://github.com/user-attachments/assets/51e62b8e-6730-4bc1-b610-3ae5f1286bbb" />

### 3.2 Create
<img width="419" height="388" alt="image" src="https://github.com/user-attachments/assets/8fc65ced-953d-4bca-a09b-917b28106259" />

#### 3.2.1 Feature Phone
<img width="493" height="289" alt="image" src="https://github.com/user-attachments/assets/d46ba3b8-b6bd-4780-a466-d9d20b13f211" />

#### 3.2.2 Smartphone
<img width="389" height="288" alt="image" src="https://github.com/user-attachments/assets/2bf5d93b-44de-48a4-80fc-bf31ad5da177" />

#### 3.2.3 Smartphone Gaming
<img width="436" height="314" alt="image" src="https://github.com/user-attachments/assets/a0a06e2f-1489-4f39-a8fd-da48f69e11e0" />

### 3.3 Read
<img width="737" height="672" alt="image" src="https://github.com/user-attachments/assets/9195295d-2a7a-462b-b7cf-a9b0cdfa2314" />

### 3.4 Update
<img width="655" height="561" alt="image" src="https://github.com/user-attachments/assets/ffc42deb-f4f8-44c7-b9b5-6bb908cf9e4e" />

#### Setelah diupdate
<img width="730" height="563" alt="image" src="https://github.com/user-attachments/assets/43d08994-8e37-45a1-8290-0f6e409e7774" />

### 3.5 Delete
<img width="1521" height="642" alt="image" src="https://github.com/user-attachments/assets/eca19493-7895-45ea-b9a5-640915c223b9" />

#### Setelah dihapus
<img width="1527" height="449" alt="image" src="https://github.com/user-attachments/assets/fb3df8ab-5834-4b08-b9b2-e17216e796da" />

### 3.6 Cetak
<img width="843" height="620" alt="image" src="https://github.com/user-attachments/assets/e4f2717b-8b62-441e-ac53-3f04157ad1ac" />
