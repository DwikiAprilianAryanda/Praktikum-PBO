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