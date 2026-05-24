CREATE DATABASE IF NOT EXISTS perpustakaan_db;
USE perpustakaan_db;

CREATE TABLE IF NOT EXISTS buku (
    id_buku VARCHAR(20) PRIMARY KEY,
    judul_buku VARCHAR(150) NOT NULL,
    penulis VARCHAR(100) NOT NULL,
    stok INT NOT NULL
);

CREATE TABLE IF NOT EXISTS pengguna (
    id_pengguna VARCHAR(20) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    role VARCHAR(30) NOT NULL
);

INSERT INTO buku (id_buku, judul_buku, penulis, stok) VALUES
('B001', 'Dasar Dasar Java', 'Andi Setiawan', 10),
('B002', 'Pemrograman Berbasis Objek', 'Budi Santoso', 7),
('B003', 'Belajar JDBC', 'Citra Lestari', 5)
ON DUPLICATE KEY UPDATE
judul_buku = VALUES(judul_buku),
penulis = VALUES(penulis),
stok = VALUES(stok);

INSERT INTO pengguna (id_pengguna, username, password, nama_lengkap, role) VALUES
('U001', 'admin', 'admin123', 'Administrator Perpustakaan', 'ADMIN')
ON DUPLICATE KEY UPDATE
password = VALUES(password),
nama_lengkap = VALUES(nama_lengkap),
role = VALUES(role);
