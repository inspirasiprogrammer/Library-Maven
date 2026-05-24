CREATE DATABASE IF NOT EXISTS perpustakaan_db;
USE perpustakaan_db;

CREATE TABLE IF NOT EXISTS buku (
    id_buku VARCHAR(20) PRIMARY KEY,
    judul_buku VARCHAR(150) NOT NULL,
    penulis VARCHAR(100) NOT NULL,
    stok INT NOT NULL
);

INSERT INTO buku (id_buku, judul_buku, penulis, stok) VALUES
('B001', 'Dasar Dasar Java', 'Andi Setiawan', 10),
('B002', 'Pemrograman Berbasis Objek', 'Budi Santoso', 7),
('B003', 'Belajar JDBC', 'Citra Lestari', 5)
ON DUPLICATE KEY UPDATE
judul_buku = VALUES(judul_buku),
penulis = VALUES(penulis),
stok = VALUES(stok);
