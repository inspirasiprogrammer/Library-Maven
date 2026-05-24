package com.perpustakaan.dao;

import com.perpustakaan.config.DatabaseConnection;
import com.perpustakaan.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {

    public boolean insert(Buku buku) {
        String sql = "INSERT INTO buku (id_buku, judul_buku, penulis, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, buku.getIdBuku());
            stmt.setString(2, buku.getJudulBuku());
            stmt.setString(3, buku.getPenulis());
            stmt.setInt(4, buku.getStok());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Buku buku) {
        String sql = "UPDATE buku SET judul_buku = ?, penulis = ?, stok = ? WHERE id_buku = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, buku.getJudulBuku());
            stmt.setString(2, buku.getPenulis());
            stmt.setInt(3, buku.getStok());
            stmt.setString(4, buku.getIdBuku());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(String idBuku) {
        String sql = "DELETE FROM buku WHERE id_buku = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idBuku);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Buku> getAll() {
        String sql = "SELECT id_buku, judul_buku, penulis, stok FROM buku ORDER BY id_buku";
        List<Buku> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            return list;
        }

        return list;
    }

    public List<Buku> searchByJudul(String keyword) {
        String sql = "SELECT id_buku, judul_buku, penulis, stok FROM buku WHERE judul_buku LIKE ? ORDER BY id_buku";
        List<Buku> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSet(rs));
                }
            }
        } catch (SQLException e) {
            return list;
        }

        return list;
    }

    public String getNextId() {
        String sql = "SELECT id_buku FROM buku ORDER BY id_buku DESC LIMIT 1";
        String defaultId = "B001";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (!rs.next()) {
                return defaultId;
            }

            String lastId = rs.getString("id_buku");
            int number = Integer.parseInt(lastId.substring(1)) + 1;
            return "B" + new DecimalFormat("000").format(number);
        } catch (Exception e) {
            return defaultId;
        }
    }

    private Buku mapResultSet(ResultSet rs) throws SQLException {
        return new Buku(
                rs.getString("id_buku"),
                rs.getString("judul_buku"),
                rs.getString("penulis"),
                rs.getInt("stok")
        );
    }
}
