# Library Maven

Aplikasi desktop manajemen data buku perpustakaan berbasis Java, Maven, Swing, JDBC, dan MySQL.

## Project Description

Library Maven adalah aplikasi desktop untuk operasi dasar perpustakaan:
- login pengguna,
- manajemen data buku (CRUD),
- pencarian buku berdasarkan judul,
- dashboard internal.

Project ini menggunakan pola sederhana berbasis DAO dan cocok sebagai baseline internal system untuk skala kecil sampai menengah.

## Tech Stack

| Komponen | Teknologi |
|---|---|
| Language | Java (source/target 17) |
| Build Tool | Maven |
| UI | Java Swing |
| Data Access | JDBC |
| Database | MySQL |
| Driver | mysql-connector-j 8.4.0 |
| IDE | Apache NetBeans |

## Project Structure

```text
Library-Maven/
|-- database/
|   `-- library_maven.sql
|-- src/
|   `-- main/
|       |-- java/com/perpustakaan/
|       |   |-- App.java
|       |   |-- config/
|       |   |-- dao/
|       |   |-- model/
|       |   `-- view/
|       `-- resources/
|           `-- db.properties
|-- pom.xml
|-- README.md
`-- TECHNICAL_DOCUMENTATION.md
```

## Installation

1. Install JDK 17+.
2. Install Apache NetBeans (Maven support).
3. Install MySQL Server.
4. Pastikan user database memiliki hak akses ke schema target.

## Setup

1. Clone repository.
2. Jalankan SQL bootstrap:

```sql
SOURCE database/library_maven.sql;
```

3. Konfigurasi koneksi database pada file `src/main/resources/db.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/perpustakaan_db?useSSL=false&serverTimezone=Asia/Jakarta
db.username=root
db.password=
```

4. Buka project di NetBeans via `File > Open Project`.

## Running

### Menjalankan dari NetBeans
1. Klik kanan project.
2. Pilih `Clean and Build`.
3. Pilih `Run`.

### Menjalankan dari Maven CLI

```bash
mvn clean package
mvn exec:java
```

### Menjalankan dari JAR

```bash
java -jar target/library-maven-1.0-SNAPSHOT.jar
```

## Default Credentials

- Username: `admin`
- Password: `admin123`

Penting: ganti kredensial default sebelum penggunaan production.

## Screenshot Placeholder

- Placeholder Login Screen: `docs/images/login-screen.png`
- Placeholder Dashboard Screen: `docs/images/dashboard-screen.png`
- Placeholder Buku Form Screen: `docs/images/buku-form-screen.png`

Catatan: folder screenshot belum disertakan dalam repository saat ini.

## API Usage

Project ini adalah desktop app dan tidak menyediakan REST API publik.
Kontrak penggunaan internal berbasis method Java:
- `PenggunaDAO.login(username, password)`
- `BukuDAO.insert(buku)`
- `BukuDAO.update(buku)`
- `BukuDAO.delete(idBuku)`
- `BukuDAO.getAll()`
- `BukuDAO.searchByJudul(keyword)`

## Contributor Guide

1. Gunakan branch terpisah per fitur/perbaikan.
2. Pastikan build sukses sebelum merge.
3. Tambahkan test saat menambah business logic.
4. Hindari perubahan pada blok generated code NetBeans tanpa kebutuhan jelas.
5. Dokumentasikan perubahan arsitektur pada `TECHNICAL_DOCUMENTATION.md`.

## Production Notes

- Hardening keamanan yang wajib sebelum production:
  - implementasi password hashing,
  - logging terstruktur,
  - penghapusan akun default,
  - test automation.

Lihat dokumentasi lengkap di `TECHNICAL_DOCUMENTATION.md`.

## License

Belum ditentukan.

Jika project ini akan dipublikasikan eksternal, tambahkan file LICENSE dengan lisensi resmi (misalnya MIT/Apache-2.0/proprietary internal).
