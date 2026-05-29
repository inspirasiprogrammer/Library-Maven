package com.perpustakaan.dao;

import com.perpustakaan.config.DatabaseConnection;
import com.perpustakaan.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public boolean insert(Member member) {
        String sql = "INSERT INTO member (id_member, nama_member, alamat, postal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member.getIdMember());
            stmt.setString(2, member.getNamaMember());
            stmt.setString(3, member.getAlamat());
            stmt.setInt(4, member.getPostal());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Member member) {
        String sql = "UPDATE member SET nama_member = ?, alamat = ?, postal = ? WHERE id_member = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member.getNamaMember());
            stmt.setString(2, member.getAlamat());
            stmt.setInt(3, member.getPostal());
            stmt.setString(4, member.getIdMember());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(String idMember) {
        String sql = "DELETE FROM member WHERE id_member = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idMember);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Member> getAll() {
        String sql = "SELECT id_member, nama_member, alamat, postal FROM member ORDER BY id_member";
        List<Member> list = new ArrayList<>();

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

    public List<Member> searchByJudul(String keyword) {
        String sql = "SELECT id_member, nama_member, alamat, postal FROM member WHERE nama_member LIKE ? ORDER BY id_member";
        List<Member> list = new ArrayList<>();

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
        String sql = "SELECT id_member FROM member ORDER BY id_member DESC LIMIT 1";
        String defaultId = "B001";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (!rs.next()) {
                return defaultId;
            }

            String lastId = rs.getString("id_member");
            int number = Integer.parseInt(lastId.substring(1)) + 1;
            return "B" + new DecimalFormat("000").format(number);
        } catch (Exception e) {
            return defaultId;
        }
    }

    private Member mapResultSet(ResultSet rs) throws SQLException {
        return new Member(
                rs.getString("id_member"),
                rs.getString("nama_member"),
                rs.getString("alamat"),
                rs.getInt("postal")
        );
    }
}
