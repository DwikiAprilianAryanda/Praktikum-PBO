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
