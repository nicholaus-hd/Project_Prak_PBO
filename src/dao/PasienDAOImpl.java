/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connector;
import model.Pasien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasienDAOImpl implements PasienDAO {

    @Override
    public boolean insert(Pasien pasien) {
        String sql = "INSERT INTO pasien (no_id, nama, jk, penanganan, catatan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pasien.getNoId());
            pstmt.setString(2, pasien.getNama());
            pstmt.setString(3, pasien.getJk());
            pstmt.setString(4, pasien.getPenanganan());
            pstmt.setString(5, pasien.getCatatan());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean update(Pasien pasien) {
        String sql = "UPDATE pasien SET nama=?, jk=?, penanganan=?, catatan=? WHERE no_id=?";
        try (Connection conn = connector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pasien.getNama());
            pstmt.setString(2, pasien.getJk());
            pstmt.setString(3, pasien.getPenanganan());
            pstmt.setString(4, pasien.getCatatan());
            pstmt.setString(5, pasien.getNoId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean delete(String noId) {
        String sql = "DELETE FROM pasien WHERE no_id=?";
        try (Connection conn = connector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, noId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Pasien getById(String noId) {
        String sql = "SELECT * FROM pasien WHERE no_id=?";
        Pasien pasien = null;

        try (Connection conn = connector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, noId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pasien = new Pasien() {
                };
                pasien.setNoId(rs.getString("no_id"));
                pasien.setNama(rs.getString("nama"));
                pasien.setJk(rs.getString("jk"));
                pasien.setPenanganan(rs.getString("penanganan"));
                pasien.setCatatan(rs.getString("catatan"));
            }
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return pasien;
    }

    @Override
    public List<Pasien> getAll() {
        List<Pasien> listPasien = new ArrayList<>();
        String sql = "SELECT * FROM pasien ORDER BY nama ASC";

        try (Connection conn = connector.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pasien pasien = new Pasien() {
                };
                pasien.setNoId(rs.getString("no_id"));
                pasien.setNama(rs.getString("nama"));
                pasien.setJk(rs.getString("jk"));
                pasien.setPenanganan(rs.getString("penanganan"));
                pasien.setCatatan(rs.getString("catatan"));
                listPasien.add(pasien);
            }
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listPasien;
    }

    @Override
    public List<Pasien> search(String keyword) {
        List<Pasien> listPasien = new ArrayList<>();
        String sql = "SELECT * FROM pasien WHERE nama LIKE ? OR no_id LIKE ? ORDER BY nama ASC";

        try (Connection conn = connector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String searchKeyword = "%" + keyword + "%";
            pstmt.setString(1, searchKeyword);
            pstmt.setString(2, searchKeyword);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pasien pasien = new Pasien() {
                };
                pasien.setNoId(rs.getString("no_id"));
                pasien.setNama(rs.getString("nama"));
                pasien.setJk(rs.getString("jk"));
                pasien.setPenanganan(rs.getString("penanganan"));
                pasien.setCatatan(rs.getString("catatan"));
                listPasien.add(pasien);
            }
        } catch (SQLException e) {
            Logger.getLogger(PasienDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listPasien;
    }

    @Override
    public boolean exportToCSV(List<Pasien> listPasien) {
        String fileName = "data_pasien_"
                + java.time.LocalDateTime.now().format(
                        java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                ) + ".csv";

        // Gunakan JFileChooser untuk memilih lokasi save
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan File CSV");
        fileChooser.setSelectedFile(new java.io.File(fileName));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "CSV Files", "csv"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".csv");
            }

            try (java.io.PrintWriter writer = new java.io.PrintWriter(
                    new java.io.OutputStreamWriter(
                            new java.io.FileOutputStream(fileToSave),
                            "UTF-8"))) {

                // Tulis header CSV
                writer.println("No_Identitas,Nama,Jenis_Kelamin,Penanganan,Catatan");

                for (Pasien pasien : listPasien) {
                    String nama = escapeCSV(pasien.getNama());
                    String catatan = escapeCSV(pasien.getCatatan());

                    writer.printf("%s,%s,%s,%s,%s%n",
                            pasien.getNoId(),
                            nama,
                            pasien.getJk(),
                            pasien.getPenanganan(),
                            catatan
                    );
                }

                writer.flush();
                return true;

            } catch (java.io.IOException e) {
                Logger.getLogger(PasienDAOImpl.class.getName())
                        .log(java.util.logging.Level.SEVERE, null, e);
                return false;
            }
        }

        return false; // User cancel
    }

// Helper method untuk escape karakter khusus CSV
    private String escapeCSV(String value) {
        if (value == null) {
            return "";
        }
        
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }

        return value;
    }
}
