package org.example.models;

public class Handphone {
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

    // GETTER & SETTER
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

    // POLYMORPHISM STATIS: OVERLOADING 1
    public void updateHarga(int hargaBaru) {
        setHarga(hargaBaru);
        System.out.println("Harga berhasil diubah menjadi: Rp" + this.harga);
    }

    public void updateHarga(double persenDiskon) {
        int diskon = (int) (this.harga * (persenDiskon / 100));
        setHarga(this.harga - diskon);
        System.out.println("Diskon " + persenDiskon + "% diterapkan. Harga baru: Rp" + this.harga);
    }

    // POLYMORPHISM DINAMIS: OVERRIDE 1
    public void tampilkanData() {
        System.out.println("Merk: " + this.merk + " | Nama: " + this.nama + " | Harga: Rp" + this.harga);
    }

    // POLYMORPHISM STATIS: OVERLOADING KE-2
    public void tampilkanData(boolean showDetail) {
        this.tampilkanData();
        if (showDetail) {
            System.out.println("  -> Distributor: " + this.distributor + " | Status: " + this.status);
        }
    }

    // POLYMORPHISM DINAMIS: OVERRIDE KE-2
    public void booting() {
        System.out.println("[SISTEM] Memulai handphone standar...");
    }
}