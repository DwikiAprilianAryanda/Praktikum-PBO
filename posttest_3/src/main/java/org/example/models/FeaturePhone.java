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