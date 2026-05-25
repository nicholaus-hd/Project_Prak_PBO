/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pasien;
import dao.PasienDAO;
import dao.PasienDAOImpl;
import java.util.List;

public class PasienController {
    private final PasienDAO dao;

    public PasienController() {
        this.dao = new PasienDAOImpl();
    }

    // Handle Tambah Event
    public boolean handleTambah(Pasien pasien) {
        if (pasien == null || pasien.getNoId().trim().isEmpty() || pasien.getNama().trim().isEmpty()) {
            return false; // Validasi gagal
        }
        return dao.insert(pasien);
    }

    // Handle Update Event
    public boolean handleUpdate(Pasien pasien) {
        if (pasien == null || pasien.getNoId().trim().isEmpty() || pasien.getNama().trim().isEmpty()) {
            return false;
        }
        return dao.update(pasien);
    }

    // Handle Delete Event
    public boolean handleDelete(String noId) {
        if (noId == null || noId.trim().isEmpty()) return false;
        return dao.delete(noId);
    }

    // Handle Refresh Table Event
    public List<Pasien> handleGetAllPasien() {
        return dao.getAll();
    }
}