/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenovo
 */
public abstract class Pasien {
    // Encapsulation: atribut bersifat private
    private String nama;
    private String noIdentitas;
    private String JenisKelamin;
    private String Catatan;

    // Constructor
    public Pasien(String nama, String noIdentitas, String JenisKelamin, String Catatan) {
        this.nama = nama;
        this.noIdentitas = noIdentitas;
        this.JenisKelamin = JenisKelamin;
        this.Catatan = Catatan;
    }

    // Abstract method yang harus diimplementasi oleh subclass (Abstraction)
    public abstract String getJenisPerawatan();

    // Getter dan Setter (Encapsulation)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    @Override
    public String toString() {
        return "Pasien{nama='" + nama + "', noIdentitas='" + noIdentitas + "', jenis='" + getJenisPerawatan() + "'}";
    }
}
