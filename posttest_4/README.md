# Sistem Manajemen Toko Handphone 📱

## 1. Deskripsi Singkat Program
Sistem Manajemen Toko Handphone adalah program CLI berbasis Java yang mensimulasikan manajemen data (CRUD) dengan menerapkan berbagai pilar Object-Oriented Programming (OOP) dari modul sebelumnya (Encapsulation dan Inheritance).

Pada **Posttest 4** ini, program mengimplementasikan konsep **Polymorphism (Polimorfisme)** untuk membuat struktur *method* yang lebih general dan *reusable*. Program ini berhasil memenuhi **Poin Plus (Lebih dari 1 Fungsi Overriding & Overloading)** yang diterapkan secara logis:

1. Static Polymorphism (Overloading) :
   - `tampilkanData()` dan `tampilkanData(boolean showDetail)`: Berfungsi ganda untuk melihat data normal atau melihat data spesifik dengan status dan distributor.
   - `updateHarga(int hargaBaru)` dan `updateHarga(double persenDiskon)`: Berfungsi ganda pada menu Update agar *user* bisa memberikan harga absolute atau menghitung secara otomatis potongan diskon (Diterapkan di Menu 3 Update).
2. Dynamic Polymorphism (Overriding) :
   - Memodifikasi ulang (menggunakan `@Override`) *method* bawaan `tampilkanData()` pada masing-masing Subclass untuk menayangkan tambahan spesifikasi OS/Jaringan/RAM.
   - Memodifikasi ulang *method* `booting()`. [cite_start]Saat program me-*looping* ArrayList Superclass `Handphone` di Menu Read, setiap Subclass akan mencetak status *booting* yang berbeda sesuai jenis instansiasinya (membuktikan eksekusi saat *runtime*) .
