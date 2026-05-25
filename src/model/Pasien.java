package model;

public class Pasien {
    private String noId;
    private String nama;
    private String jk;
    private String penanganan;
    private String catatan;

    public Pasien() {}

    public Pasien(String noId, String nama, String jk, String penanganan, String catatan) {
        this.noId = noId;
        this.nama = nama;
        this.jk = jk;
        this.penanganan = penanganan;
        this.catatan = catatan;
    }

    // Getters dan Setters
    public String getNoId() { return noId; }
    public void setNoId(String noId) { this.noId = noId; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getJk() { return jk; }
    public void setJk(String jk) { this.jk = jk; }
    
    public String getPenanganan() { return penanganan; }
    public void setPenanganan(String penanganan) { this.penanganan = penanganan; }
    
    public String getCatatan() { return catatan; }
    public void setCatatan(String catatan) { this.catatan = catatan; }
    
    @Override
    public String toString() {
        return "Pasien{" + "noId=" + noId + ", nama=" + nama + '}';
    }
}