/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Pasien;
import java.util.List;

public interface PasienDAO {
    boolean insert(Pasien pasien);
    boolean update(Pasien pasien);
    boolean delete(String noId);
    Pasien getById(String noId);
    List<Pasien> getAll();
    boolean exportToCSV(List<Pasien> listPasien);
}
