# Technical Documentation - Library Maven

Dokumen ini adalah dokumentasi teknis lengkap untuk aplikasi desktop manajemen buku perpustakaan berbasis Java + Maven yang dikembangkan menggunakan Apache NetBeans.

Status dokumen: generated from source code analysis
Tanggal analisis: 2026-05-29
Tipe dokumen: Internal engineering, onboarding, audit, maintenance, handover, production readiness

---

## 1. Project Overview

### 1.1 Nama Aplikasi
- Library Maven
- Artifact: `com.perpustakaan:library-maven:1.0-SNAPSHOT`

### 1.2 Tujuan Aplikasi
Aplikasi ini menyediakan sistem desktop sederhana untuk mengelola data buku perpustakaan dan autentikasi pengguna admin.

### 1.3 Fungsi Utama
- Login pengguna berbasis tabel `pengguna`
- CRUD data buku pada tabel `buku`
- Pencarian buku berdasarkan judul
- Dashboard desktop dengan menu modul

### 1.4 Target Pengguna
- Admin perpustakaan skala kecil/menengah
- Operator data buku internal
- Tim pembelajaran Java desktop + JDBC

### 1.5 Studi Kasus Bisnis
Kasus bisnis utama adalah digitalisasi operasional pencatatan koleksi buku yang sebelumnya manual. Sistem ini menurunkan risiko data hilang, mempercepat pencarian, dan mempermudah maintenance data.

### 1.6 Fitur Utama Sistem
- Modul login
- Modul dashboard
- Modul manajemen buku (tambah, ubah, hapus, cari, refresh)
- Auto-generate ID buku (`B001`, `B002`, dst)
- Validasi input dasar

### 1.7 Cakupan Fungsional Saat Ini
In scope:
- Otentikasi username/password sederhana
- Satu domain data utama: buku

Out of scope:
- Multi-role authorization berbasis menu
- Audit trail
- REST API
- Integrasi monitoring production
- Automated testing

---

## 2. Teknologi yang Digunakan

### 2.1 Tabel Stack Teknologi

| Komponen | Teknologi | Versi | Fungsi |
|---|---|---|---|
| Language | Java | Source/Target 17 (pom), runtime lokal terdeteksi Java 21 | Implementasi aplikasi |
| Build Tool | Apache Maven | Tidak terdeteksi di environment saat analisis (`mvn` belum tersedia di PATH) | Build lifecycle dan dependency management |
| IDE | Apache NetBeans | Tidak dapat dipastikan dari source (tidak ada metadata versi IDE) | GUI Builder `.form` + development environment |
| UI Framework | Java Swing | Bagian dari JDK | User interface desktop |
| Data Access | JDBC | Bagian dari JDK + MySQL driver | Akses database SQL |
| Database | MySQL | Menggunakan syntax MySQL 8+ (`ON DUPLICATE KEY UPDATE`) | Penyimpanan data |
| Maven Dependency | `mysql-connector-j` | 8.4.0 | JDBC driver MySQL |
| Maven Plugin | `maven-compiler-plugin` | 3.13.0 | Kompilasi Java |
| Maven Plugin | `exec-maven-plugin` | 3.5.0 | Menjalankan main class |

### 2.2 Framework yang Teridentifikasi
- Tidak menggunakan framework enterprise seperti Spring/Spring Boot/Jakarta EE.
- Arsitektur dibangun manual menggunakan kombinasi Swing + DAO + Model.

---

## 3. Struktur Project Apache NetBeans

### 3.1 Struktur Folder Aktual

```text
Library-Maven/
|-- database/
|   `-- library_maven.sql
|-- src/
|   `-- main/
|       |-- java/com/perpustakaan/
|       |   |-- App.java
|       |   |-- config/DatabaseConnection.java
|       |   |-- dao/BukuDAO.java
|       |   |-- dao/PenggunaDAO.java
|       |   |-- model/Buku.java
|       |   |-- model/Pengguna.java
|       |   `-- view/
|       |       |-- LoginForm.java(.form)
|       |       |-- DashboardForm.java(.form)
|       |       `-- BukuForm.java(.form)
|       `-- resources/
|           `-- db.properties
|-- target/
|   `-- classes/ ... (build output)
|-- pom.xml
|-- README.md
`-- TECHNICAL_DOCUMENTATION.md
```

### 3.2 Penjelasan Folder yang Diminta

- `nbproject`
  - Pada kondisi analisis saat ini folder ini **tidak ada** di repository.
  - Pada project NetBeans klasik, folder ini berisi metadata IDE. Pada Maven project modern, metadata ini bisa minimal atau tidak di-commit.

- `pom.xml`
  - File konfigurasi utama Maven: dependency, plugin, packaging, properti Java.

- `target`
  - Output hasil build (`.class`, resource hasil copy, metadata maven compiler).

- `src/main/java`
  - Source code produksi aplikasi.

- `src/main/resources`
  - Resource runtime (`db.properties`).

- `src/test/java`
  - Folder standar untuk test unit/integrasi. Pada project ini belum tersedia.

---

## 4. Konfigurasi Maven

### 4.1 Identitas Project
- GroupId: `com.perpustakaan`
- ArtifactId: `library-maven`
- Version: `1.0-SNAPSHOT`
- Packaging: `jar`

### 4.2 Properti Build
- `maven.compiler.source=17`
- `maven.compiler.target=17`
- `project.build.sourceEncoding=UTF-8`
- `exec.mainClass=com.perpustakaan.App`

### 4.3 Dependency

| Dependency | Versi | Scope | Fungsi |
|---|---|---|---|
| `com.mysql:mysql-connector-j` | 8.4.0 | compile (default) | Driver JDBC untuk koneksi ke MySQL |

### 4.4 Plugin Build

| Plugin | Versi | Fungsi |
|---|---|---|
| `maven-compiler-plugin` | 3.13.0 | Kompilasi source Java sesuai source/target |
| `exec-maven-plugin` | 3.5.0 | Menjalankan aplikasi via `exec:java` |

### 4.5 Build Lifecycle
Lifecycle Maven standar yang relevan:
- `validate` -> validasi struktur project
- `compile` -> kompilasi source utama
- `test` -> menjalankan test (saat ini tidak ada test)
- `package` -> menghasilkan artifact `.jar`
- `verify` -> quality gate tambahan (belum dikonfigurasi)
- `install` -> install artifact ke local repository

### 4.6 Profile, Repository, Dependency Management
- `profiles`: tidak didefinisikan
- `repositories`: menggunakan default Maven Central
- `dependencyManagement`: tidak didefinisikan

### 4.7 Kesimpulan Maven Audit
Konfigurasi Maven sederhana dan bersih, namun belum memiliki:
- profile environment (dev/staging/prod)
- plugin quality gate (surefire/failsafe, jacoco, checkstyle/spotbugs)
- maven wrapper (`mvnw`) untuk reproduktibilitas CI/CD

---

## 5. Cara Menjalankan Project di Apache NetBeans

### 5.1 Prasyarat
1. Install JDK (disarankan 17 atau 21 LTS).
2. Install Apache NetBeans (Maven support aktif).
3. Install MySQL server.
4. Buat schema dari file SQL.

### 5.2 Step-by-step di NetBeans
1. Buka NetBeans.
2. Pilih `File > Open Project`.
3. Pilih folder project `Library-Maven`.
4. Tunggu NetBeans melakukan indexing.
5. Pastikan JDK project sesuai (`Project Properties > Libraries > Java Platform`).
6. Jalankan script `database/library_maven.sql` di MySQL.
7. Sesuaikan `src/main/resources/db.properties`.
8. Klik kanan project -> `Build with Dependencies`.
9. Klik kanan project -> `Run`.
10. Login dengan kredensial seed data (`admin` / `admin123`).

### 5.3 Resolve Dependency
- Pada panel output, NetBeans akan menjalankan fase Maven dan mengunduh dependency otomatis.
- Jika gagal download dependency:
  - cek koneksi internet
  - cek konfigurasi proxy Maven/NetBeans
  - jalankan build ulang setelah clear cache

### 5.4 Clean Project
- Klik kanan project -> `Clean and Build`.
- Ini akan menghapus folder `target` lalu membangun ulang artifact.

### 5.5 Debug Project
1. Buka class target (contoh `LoginForm.java`).
2. Set breakpoint pada method event (`onLogin`, `onSimpan`, dll).
3. Klik `Debug Project`.
4. Lakukan interaksi UI sampai breakpoint tercapai.
5. Inspect variable di debugger NetBeans.

### 5.6 Troubleshooting Dependency di NetBeans
- Error unresolved symbol dari dependency:
  - `Reload Project` pada panel Maven
  - `Clean and Build`
- Konflik JDK:
  - samakan `maven.compiler.source/target` dengan JDK aktif

---

## 6. Build & Run Command

Project ini bukan Spring Boot; command disesuaikan untuk aplikasi Java desktop Maven.

### 6.1 Command Inti

```bash
# Kompilasi source utama
mvn clean compile

# Menjalankan test (saat ini no tests)
mvn test

# Packaging artifact JAR
mvn clean package

# Menjalankan aplikasi dari main class via plugin
mvn exec:java

# Menjalankan JAR hasil package (jika manifest main class disiapkan)
java -jar target/library-maven-1.0-SNAPSHOT.jar
```

### 6.2 Penjelasan Fungsi Command
- `mvn clean compile`: memastikan source Java valid dan dependency lengkap.
- `mvn test`: menjalankan test suite untuk quality gate.
- `mvn clean package`: build artifact siap distribusi.
- `mvn exec:java`: mode dev cepat untuk menjalankan kelas utama.
- `java -jar ...`: mode distribusi binary.

Catatan:
- Pada environment analisis ini, command `mvn` belum tersedia di PATH.

---

## 7. Architecture Documentation

### 7.1 Pola Arsitektur
Project menerapkan variasi sederhana dari layered architecture:
- Presentation Layer: Swing forms (`view`)
- Data Access Layer: DAO (`dao`)
- Domain Layer: model POJO (`model`)
- Infrastructure Layer: JDBC connection config (`config`)

Tidak ada service layer eksplisit, sehingga sebagian business rule berada di `view`.

### 7.2 Evaluasi terhadap MVC
- Model: `Buku`, `Pengguna`
- View: `LoginForm`, `DashboardForm`, `BukuForm`
- Controller: event handler di dalam class view

Kesimpulan: MVC parsial, karena controller belum dipisah dari UI class.

### 7.3 Controller / Service / Repository
- Controller: event method seperti `onLogin`, `onSimpan`, `onEdit`
- Service: belum ada layer service
- Repository: direpresentasikan oleh DAO (`BukuDAO`, `PenggunaDAO`)

### 7.4 Dependency Injection
- Tidak menggunakan DI container.
- Dependency dibuat langsung (`new BukuDAO()`, `new PenggunaDAO()`).

### 7.5 Diagram Arsitektur (ASCII)

```text
+-----------------------------+
|          App (main)         |
+--------------+--------------+
               |
               v
+-----------------------------+
|         LoginForm           |
|  - validasi input login     |
|  - panggil PenggunaDAO      |
+--------------+--------------+
               |
               v
+-----------------------------+
|       DashboardForm         |
|  - buka BukuForm            |
+--------------+--------------+
               |
               v
+-----------------------------+
|          BukuForm           |
| - CRUD event handling       |
| - validasi form             |
| - panggil BukuDAO           |
+--------------+--------------+
               |
               v
+-----------------------------+
|           BukuDAO           |
|        PenggunaDAO          |
+--------------+--------------+
               |
               v
+-----------------------------+
|     DatabaseConnection      |
|      JDBC DriverManager     |
+--------------+--------------+
               |
               v
+-----------------------------+
|           MySQL DB          |
+-----------------------------+
```

### 7.6 Flow Request-Response (Desktop Interaction)

```text
User klik tombol -> Event handler Swing -> Validasi input -> DAO query SQL
-> ResultSet / status boolean -> UI menampilkan pesan -> JTable diperbarui
```

---

## 8. Database Documentation

### 8.1 Jenis Database
- Relational DBMS: MySQL
- Database name: `perpustakaan_db`

### 8.2 Konfigurasi Koneksi
Sumber koneksi: `src/main/resources/db.properties`

Contoh:

```properties
db.url=jdbc:mysql://localhost:3306/perpustakaan_db?useSSL=false&serverTimezone=Asia/Jakarta
db.username=root
db.password=
```

### 8.3 Entitas dan Relasi

#### Tabel `buku`
- `id_buku` VARCHAR(20) PK
- `judul_buku` VARCHAR(150) NOT NULL
- `penulis` VARCHAR(100) NOT NULL
- `stok` INT NOT NULL

#### Tabel `pengguna`
- `id_pengguna` VARCHAR(20) PK
- `username` VARCHAR(50) UNIQUE NOT NULL
- `password` VARCHAR(100) NOT NULL
- `nama_lengkap` VARCHAR(100) NOT NULL
- `role` VARCHAR(30) NOT NULL

Relasi:
- Saat ini tidak ada foreign key antar tabel.

### 8.4 Query Flow
- Login: `SELECT ... FROM pengguna WHERE username = ? AND password = ? LIMIT 1`
- Ambil buku: `SELECT ... FROM buku ORDER BY id_buku`
- Cari buku: `SELECT ... FROM buku WHERE judul_buku LIKE ? ORDER BY id_buku`
- Tambah/Ubah/Hapus: query DML standar via PreparedStatement

### 8.5 Migration Strategy
Saat ini migration masih manual via SQL script:
- `database/library_maven.sql`

Rekomendasi enterprise:
- gunakan Flyway/Liquibase untuk versioned schema migration.

### 8.6 ORM/JPA/Hibernate
- Tidak digunakan.
- Data access murni JDBC + DAO.

---

## 9. Interface and Module Contract

### 9.1 Kontrak Modul Data Buku
- Input UI -> object `Buku`
- DAO return:
  - `boolean` untuk operasi DML
  - `List<Buku>` untuk query list
- UI bertanggung jawab atas notifikasi sukses/gagal

### 9.2 Kontrak Modul Login
- Input: username/password dari UI
- DAO return:
  - `Pengguna` jika sukses
  - `null` jika gagal/error

Risiko kontrak saat ini:
- Tidak ada error code spesifik (semua gagal dianggap sama)
- Sulit membedakan gagal autentikasi vs error koneksi DB

---

## 10. Business Logic

### 10.1 Workflow Sistem End-to-End
1. Aplikasi start dari `App.main`.
2. `LoginForm` tampil.
3. User isi username/password.
4. Validasi field kosong.
5. `PenggunaDAO.login` mengeksekusi query.
6. Jika valid: buka `DashboardForm`.
7. User membuka menu `Data Buku`.
8. `BukuForm` load semua data buku.
9. User melakukan CRUD/cari/refresh.

### 10.2 Validasi Bisnis yang Ada
- Login: username/password wajib isi.
- Buku:
  - semua field wajib isi
  - stok harus angka
  - stok tidak boleh negatif

### 10.3 Service Layer
- Belum ada service layer dedicated.
- Rule bisnis tersebar di event handler UI.

### 10.4 Scheduler / Batch
- Tidak ada scheduler (Quartz/ScheduledExecutor) pada project ini.

### 10.5 Transaction Flow
- Tidak ada transaction management eksplisit.
- Setiap operasi DAO menggunakan koneksi baru autocommit default.

Dampak:
- aman untuk operasi single statement sederhana
- belum ideal untuk multi-step transaction atomik

---

## 11. Security Documentation

### 11.1 Authentication
- Mekanisme: username/password di tabel `pengguna`
- Validasi dilakukan dengan query langsung.

### 11.2 Authorization
- Data `role` tersedia pada model `Pengguna`.
- Namun belum ada enforcement role-based access control pada menu/fitur.

### 11.3 Session, JWT, CSRF, CORS, XSS
- JWT: tidak ada (desktop app)
- HTTP session: tidak ada (desktop app)
- CORS/CSRF: tidak relevan karena bukan web app
- XSS: tidak relevan langsung pada UI Swing, tetapi sanitasi input tetap diperlukan untuk output lintas kanal

### 11.4 Password Handling
Temuan kritikal:
- Password disimpan plaintext di database.
- Login membandingkan plaintext.

Rekomendasi wajib:
- gunakan hashing adaptif (BCrypt/Argon2/PBKDF2)
- jangan simpan password plaintext

### 11.5 SQL Injection Prevention
Kondisi saat ini:
- Query memakai `PreparedStatement` parameterized query.
- Ini sudah baik untuk mitigasi SQL injection.

### 11.6 Security Risk Assessment

| Area | Status | Risiko |
|---|---|---|
| Password storage | Poor | Critical |
| Auth failure observability | Limited | Medium |
| SQL injection defense | Good | Low |
| Authorization enforcement | Partial | Medium |
| Secret management | Basic (`db.properties`) | Medium |

Skor keamanan keseluruhan (current): **58/100**

---

## 12. Logging & Monitoring

### 12.1 Logging Framework
- Tidak ada logging framework terintegrasi (SLF4J/Logback/Log4j2).
- Error DB di DAO banyak yang di-swallow (catch lalu return false/null).

### 12.2 Konfigurasi Log
- Belum ada file konfigurasi logging.

### 12.3 Monitoring dan Error Tracking
- Belum ada metrics, tracing, error aggregation.
- Belum ada health check endpoint (wajar untuk desktop app), namun dapat ditambahkan self-check menu.

### 12.4 Rekomendasi
- Integrasikan `slf4j-api` + `logback-classic`.
- Catat exception dengan context (query intent, operation id, timestamp).
- Tambahkan audit log event penting: login sukses/gagal, CRUD action.

---

## 13. Testing Documentation

### 13.1 Kondisi Saat Ini
- `src/test/java` belum ada.
- Belum ada JUnit, Mockito, integration test.

### 13.2 Strategi Testing yang Direkomendasikan

#### Unit Test
- Test model validator dan helper (misal generator ID buku).
- Gunakan JUnit 5.

#### Integration Test
- Uji DAO terhadap test database (Testcontainers MySQL atau DB lokal khusus test).

#### Mock Testing
- Untuk logic UI-controller (setelah refactor ke service/controller class), gunakan Mockito.

### 13.3 Contoh Skeleton Test (Rekomendasi)

```java
@DisplayName("BukuDAO getNextId")
class BukuDAOTest {

    @Test
    void shouldReturnDefaultIdWhenTableEmpty() {
        // arrange test DB state
        // act
        // assert
    }
}
```

### 13.4 Target Coverage
- Minimal 80% untuk layer service/utility.
- DAO minimal memiliki integration test untuk operasi penting.

Skor testing readiness (current): **20/100**

---

## 14. Deployment Guide

Aplikasi ini adalah desktop app (packaging JAR), bukan web app server-side.

### 14.1 Build Production

```bash
mvn -DskipTests clean package
```

Output utama:
- `target/library-maven-1.0-SNAPSHOT.jar`

### 14.2 Deploy ke VPS/Linux (Desktop/Headed Environment)
Skenario ini cocok jika aplikasi dijalankan pada host Linux dengan GUI/X11.

```bash
# 1) install JRE
sudo apt-get update
sudo apt-get install -y openjdk-21-jre

# 2) copy artifact dan config
scp target/library-maven-1.0-SNAPSHOT.jar user@host:/opt/library-app/
scp src/main/resources/db.properties user@host:/opt/library-app/config/

# 3) run
java -jar /opt/library-app/library-maven-1.0-SNAPSHOT.jar
```

### 14.3 Deploy WAR/JAR
- JAR: supported (saat ini)
- WAR: tidak supported karena project bukan aplikasi web servlet

### 14.4 Tomcat Deployment
- Kondisi saat ini: **tidak applicable**.
- Agar dapat deploy ke Tomcat, aplikasi harus diubah ke web architecture (Servlet/JSP/Spring MVC), packaging WAR.

### 14.5 Docker Deployment
Karena aplikasi Swing butuh GUI, Docker cocok untuk build pipeline atau runtime khusus VNC/X11.

Contoh Dockerfile build-only:

```dockerfile
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/library-maven-1.0-SNAPSHOT.jar app.jar
COPY src/main/resources/db.properties ./config/db.properties
CMD ["java", "-jar", "app.jar"]
```

### 14.6 CI/CD (Contoh GitHub Actions)

```yaml
name: build-library-maven
on:
  push:
    branches: [ main ]
  pull_request:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '21'
      - uses: actions/cache@v4
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
      - run: mvn -B -DskipTests clean package
      - uses: actions/upload-artifact@v4
        with:
          name: library-maven-jar
          path: target/*.jar
```

---

## 15. Performance Analysis

### 15.1 Temuan Potensi Bottleneck
- Koneksi database dibuat per operasi DAO (tanpa pooling).
- UI thread (EDT) melakukan operasi DB sinkron, bisa menyebabkan UI freeze saat query lambat.
- Query pencarian `LIKE '%keyword%'` tanpa index fulltext berpotensi lambat untuk data besar.

### 15.2 Query Optimization
Rekomendasi:
- Tambahkan index pada `buku(judul_buku)`.
- Untuk skala besar, pertimbangkan full-text search.

### 15.3 Caching
- Belum ada caching.
- Untuk desktop app sederhana, cache in-memory terbatas bisa dipakai untuk lookup statis.

### 15.4 Memory Usage
- Rendah untuk dataset kecil.
- Risiko meningkat jika tabel besar dimuat full ke JTable.

### 15.5 Thread Management
- Saat ini single-EDT driven untuk UI event.
- Rekomendasi: gunakan `SwingWorker` untuk operasi DB agar UI tetap responsif.

### 15.6 JVM Optimization (Opsional Production)

```bash
java -Xms256m -Xmx512m -XX:+UseG1GC -jar target/library-maven-1.0-SNAPSHOT.jar
```

Skor performa keseluruhan (current): **68/100**

---

## 16. Code Quality Analysis

### 16.1 Penilaian Clean Code
Kekuatan:
- Naming class/package jelas
- Pemisahan model dan DAO sudah ada
- PreparedStatement digunakan konsisten

Kelemahan:
- Error handling tidak informatif (exception disembunyikan)
- UI class cukup gemuk (logic + view bercampur)
- Belum ada service layer

### 16.2 SOLID Principle
- S: parsial, namun UI class melanggar SRP
- O: rendah, ekspansi fitur butuh modifikasi langsung class UI
- L: netral
- I: netral
- D: rendah, dependency concrete class langsung

### 16.3 Duplicate Code & Technical Debt
- Pola notifikasi error/sukses berulang di event handler.
- Debt utama: security plaintext password, tanpa test, tanpa logging.

### 16.4 Maintainability
- Maintainability level: medium.
- Cukup mudah dipahami pemula, tetapi scale-up akan sulit tanpa refactor layer.

### 16.5 Scalability
- Cocok untuk skala kecil.
- Perlu refactor signifikan untuk beban user/data besar.

### 16.6 Code Quality Score
- Readability: 78/100
- Architecture: 64/100
- Testability: 25/100
- Security hygiene: 58/100
- Overall: **63/100**

### 16.7 Rekomendasi Prioritas
1. Implement password hashing + migrasi data user.
2. Tambahkan logging framework dan error observability.
3. Refactor service layer untuk memisahkan business logic dari UI.
4. Tambahkan unit/integration test + CI gate.
5. Tambahkan connection pooling (HikariCP) jika beban meningkat.

---

## 17. Troubleshooting

### 17.1 Error Maven Umum

#### Gejala
`mvn` command not found

#### Solusi
- Install Maven
- Tambahkan `MAVEN_HOME` dan `%MAVEN_HOME%\bin` ke PATH
- Buka terminal baru dan verifikasi `mvn -v`

### 17.2 Dependency Conflict

#### Gejala
ClassNotFound atau NoSuchMethodError untuk MySQL driver

#### Solusi
- Jalankan `mvn dependency:tree`
- Samakan versi connector
- Hapus cache artifact bermasalah dari `.m2/repository`

### 17.3 NetBeans Cache Issue

#### Gejala
Editor/form desync, project tidak sinkron

#### Solusi
- `Clean and Build`
- `Reload Project`
- Restart NetBeans

### 17.4 Java Version Mismatch

#### Gejala
`invalid target release: 17` atau class version mismatch

#### Solusi
- Gunakan JDK minimal 17
- Sesuaikan project JDK di NetBeans
- Samakan `maven.compiler.source/target` dengan JDK build

### 17.5 Build Failed

#### Gejala
Compile error di class GUI atau DAO

#### Solusi
- Cek output panel detail
- Verifikasi import dan method signature
- Pastikan file `.form` dan `.java` tidak konflik

### 17.6 Classpath Issue

#### Gejala
MySQL driver tidak ditemukan saat runtime

#### Solusi
- Pastikan dependency `mysql-connector-j` ada di pom
- Jalankan dari Maven lifecycle (bukan hanya run class manual tanpa classpath)

### 17.7 Koneksi Database Gagal

#### Gejala
Login selalu gagal / CRUD gagal

#### Solusi
- Cek `db.properties`
- Cek service MySQL aktif
- Cek database `perpustakaan_db` dan tabel ada
- Uji kredensial via MySQL client

---

## 18. README.md Professional

README professional telah diperbarui secara terpisah pada file `README.md` agar:
- lebih ringkas untuk developer entry point
- tetap sinkron dengan dokumentasi teknis lengkap ini
- siap dipakai onboarding cepat

---

## Lampiran A - Daftar Class Utama

| Package | Class | Tanggung Jawab |
|---|---|---|
| `com.perpustakaan` | `App` | Entry point aplikasi |
| `com.perpustakaan.config` | `DatabaseConnection` | Provider koneksi JDBC |
| `com.perpustakaan.model` | `Buku` | Entity model buku |
| `com.perpustakaan.model` | `Pengguna` | Entity model pengguna |
| `com.perpustakaan.dao` | `BukuDAO` | Operasi CRUD buku |
| `com.perpustakaan.dao` | `PenggunaDAO` | Otentikasi login |
| `com.perpustakaan.view` | `LoginForm` | UI login |
| `com.perpustakaan.view` | `DashboardForm` | UI dashboard/menu |
| `com.perpustakaan.view` | `BukuForm` | UI CRUD data buku |

---

## Lampiran B - Risk Register (Ringkas)

| ID | Risiko | Dampak | Probabilitas | Mitigasi |
|---|---|---|---|---|
| R-01 | Password plaintext | Tinggi | Tinggi | Hashing + migrasi user password |
| R-02 | Tidak ada automated test | Tinggi | Tinggi | Tambah JUnit + integration test |
| R-03 | Exception tidak terlog | Medium | Tinggi | Integrasi logging framework |
| R-04 | UI freeze saat query lambat | Medium | Medium | Gunakan SwingWorker |
| R-05 | Build environment tidak konsisten | Medium | Medium | Tambah Maven Wrapper + CI gate |

---

## Lampiran C - Roadmap Refactor 90 Hari

### Fase 1 (Minggu 1-2)
- Setup Maven Wrapper
- Tambah JUnit 5 + Mockito + test skeleton
- Tambah logging dasar

### Fase 2 (Minggu 3-6)
- Refactor service layer
- Implement password hashing
- Perbaiki error handling berbasis exception domain

### Fase 3 (Minggu 7-12)
- Tambah integration test DB
- Tambah pipeline CI/CD quality gate
- Optimasi UX performa (async DB calls)

---

## Kesimpulan Eksekutif

Aplikasi ini layak untuk operasi internal skala kecil dan sangat baik sebagai baseline pembelajaran Java desktop + JDBC. Untuk kebutuhan enterprise production, diperlukan peningkatan pada aspek security, observability, test automation, dan pemisahan arsitektur agar maintainability serta scalability meningkat signifikan.
# Dokumentasi Teknis Enterprise

Dokumen ini disusun dari analisis langsung terhadap source code, konfigurasi Maven, SQL schema, dan struktur proyek.

## 1. Project Overview

### 1.1 Nama Aplikasi
Library Maven - Aplikasi CRUD Data Buku Perpustakaan.

### 1.2 Tujuan Aplikasi
Aplikasi desktop untuk mendigitalisasi proses pengelolaan data buku dan login pengguna pada operasional perpustakaan skala kecil-menengah.

### 1.3 Fungsi Utama
- Autentikasi pengguna (login berbasis database).
- Manajemen data buku (Create, Read, Update, Delete).
- Pencarian data buku berdasarkan judul.
- Dashboard aplikasi dengan menu internal.

### 1.4 Target Pengguna
- Admin perpustakaan.
- Staf operasional perpustakaan.
- Tim IT internal untuk maintenance aplikasi desktop Java.

### 1.5 Studi Kasus Bisnis
Masalah bisnis yang ditangani:
- Pencatatan buku manual rentan salah input.
- Sulit menelusuri data buku dengan cepat.
- Tidak ada kontrol akses dasar sebelum mengelola data.

Nilai bisnis:
- Input dan update data lebih cepat.
- Konsistensi data meningkat.
- Jejak proses operasional lebih terstruktur.

### 1.6 Fitur Utama Sistem
- Login dengan validasi kredensial.
- Dashboard dengan status user aktif.
- Form data buku berbasis tabel dan form input.
- ID buku otomatis (B001, B002, dst).
- Validasi input kosong dan nilai stok.

## 2. Teknologi yang Digunakan

### 2.1 Tabel Teknologi

| Kategori | Teknologi | Versi | Status pada Proyek |
|---|---|---:|---|
| Bahasa | Java | Source/Target 17 (POM) | Terkonfigurasi |
| Runtime lokal (terdeteksi) | Java Runtime | 21.0.10 LTS | Terdeteksi di mesin kerja |
| Build Tool | Apache Maven | Tidak terdeteksi di PATH | Perlu instalasi/konfigurasi |
| IDE | Apache NetBeans | Tidak terdeteksi otomatis dari repo | Digunakan (berdasarkan struktur/.form) |
| UI | Java Swing | Built-in JDK | Digunakan |
| Data Access | JDBC | Built-in JDK | Digunakan |
| Database Driver | MySQL Connector/J | 8.4.0 | Dependency aktif |
| Database | MySQL | 8.x direkomendasikan | Digunakan lewat JDBC URL |
| Test Framework | JUnit/Mockito | - | Belum ada |
| Logging Framework | SLF4J/Logback/Log4j | - | Belum ada |

### 2.2 Framework dan Library
- Tidak menggunakan framework enterprise seperti Spring Boot.
- Arsitektur bersifat plain Java desktop dengan pola DAO.
- Library eksternal utama hanya MySQL Connector/J.

### 2.3 Plugin Maven
- maven-compiler-plugin 3.13.0.
- exec-maven-plugin 3.5.0.

## 3. Struktur Project Apache NetBeans

### 3.1 Struktur Saat Ini (Hasil Analisis)
- Root project berisi POM, README, folder source, SQL, dan target build.
- Ada file .form (NetBeans GUI Builder), menandakan project di-maintain melalui GUI editor NetBeans.
- Folder nbproject tidak ditemukan pada repository saat analisis.

### 3.2 Fungsi Komponen Struktur

| Path/Folder | Fungsi |
|---|---|
| pom.xml | Konfigurasi build Maven: metadata, dependency, plugin, Java version |
| src/main/java | Source code aplikasi utama (App, config, dao, model, view) |
| src/main/resources | Resource runtime (db.properties) |
| src/test/java | Lokasi test Maven standar (belum tersedia) |
| database | SQL bootstrap database dan seed data |
| target | Output hasil kompilasi dan artifact build |
| nbproject | Metadata NetBeans Ant/legacy project (tidak ada di repo ini) |

### 3.3 Implikasi Tidak Adanya nbproject
- Untuk Maven project modern, ketiadaan nbproject tidak menghalangi build.
- Konfigurasi project tetap bisa di-resolve dari pom.xml.
- File .form tetap dapat diproses NetBeans saat membuka project Maven.

## 4. Konfigurasi Maven

### 4.1 Ringkasan POM
- groupId: com.perpustakaan
- artifactId: library-maven
- version: 1.0-SNAPSHOT
- packaging: jar
- main class: com.perpustakaan.App

### 4.2 Dependency

| Dependency | Versi | Fungsi | Catatan |
|---|---:|---|---|
| com.mysql:mysql-connector-j | 8.4.0 | Driver JDBC untuk koneksi Java ke MySQL | Wajib agar DriverManager dapat membuka koneksi |

### 4.3 Plugin Build

| Plugin | Versi | Fungsi |
|---|---:|---|
| maven-compiler-plugin | 3.13.0 | Kompilasi source Java ke bytecode |
| exec-maven-plugin | 3.5.0 | Menjalankan main class langsung via Maven |

### 4.4 Packaging
- Packaging JAR cocok untuk aplikasi desktop Java.
- Bukan packaging WAR, sehingga tidak dirancang untuk deployment web container.

### 4.5 Build Lifecycle
- validate: validasi POM.
- compile: kompilasi source.
- test: menjalankan test (saat ini tidak ada test).
- package: menghasilkan JAR.
- verify/install/deploy: tahap lanjutan artifact.

### 4.6 Profile, Repository, Dependency Management
- Profile khusus: tidak ada.
- Repository kustom: tidak ada (mengandalkan Maven Central).
- dependencyManagement: tidak ada (sederhana, single module).

## 5. Cara Menjalankan Project di Apache NetBeans

### 5.1 Prasyarat
1. Install JDK minimal 17 (disarankan 17 atau 21 LTS).
2. Install Apache NetBeans yang mendukung Maven.
3. Install MySQL dan pastikan service aktif.
4. Buat schema dan data awal dari SQL project.

### 5.2 Step-by-Step Import dan Run
1. Buka Apache NetBeans.
2. Pilih File -> Open Project.
3. Arahkan ke folder root project.
4. NetBeans akan mendeteksi sebagai Maven Project.
5. Tunggu proses indexing dan dependency resolve.
6. Sesuaikan file db.properties sesuai host/credential MySQL.
7. Jalankan script SQL bootstrap ke MySQL.
8. Klik kanan project -> Clean and Build.
9. Klik kanan project -> Run.
10. Form login aplikasi akan muncul.

### 5.3 Build, Clean, Run, Debug
- Build: menu Build Project.
- Clean: menu Clean Project.
- Run: menu Run Project.
- Debug: menu Debug Project, pasang breakpoint di event handler atau DAO.

### 5.4 Troubleshooting Dependency di NetBeans
- Jika dependency tidak terunduh: cek koneksi internet/proxy dan Maven settings.xml.
- Jika Maven tidak dikenali: set Maven home di NetBeans.
- Jika JDK mismatch: set Java Platform pada Project Properties.

## 6. Build & Run Command

### 6.1 Command Maven (Jika Maven Terpasang)

~~~bash
mvn clean
mvn compile
mvn test
mvn package
mvn exec:java
~~~

### 6.2 Fungsi Tiap Command
- mvn clean: hapus artifact build lama di target.
- mvn compile: kompilasi source utama.
- mvn test: jalankan test unit/integrasi (saat tersedia).
- mvn package: buat artifact JAR.
- mvn exec:java: jalankan aplikasi via main class.

### 6.3 Menjalankan JAR Langsung

~~~bash
java -jar target/library-maven-1.0-SNAPSHOT.jar
~~~

Catatan: command di atas berhasil jika JAR dapat mengeksekusi class utama dan dependency tersedia sesuai packaging/runtime.

## 7. Architecture Documentation

### 7.1 Pola Arsitektur yang Teridentifikasi
- MVP sederhana berbasis Swing event handler.
- DAO layer untuk akses data.
- Model layer untuk representasi entitas.
- Tidak ada service layer terpisah.

### 7.2 Struktur Package
- com.perpustakaan
- com.perpustakaan.config
- com.perpustakaan.dao
- com.perpustakaan.model
- com.perpustakaan.view

### 7.3 Mapping Layer

| Konsep Layer | Implementasi Aktual |
|---|---|
| Presentation | LoginForm, DashboardForm, BukuForm |
| Business Logic | Tersebar di event handler form + sebagian di DAO |
| Data Access | BukuDAO, PenggunaDAO |
| Configuration | DatabaseConnection + db.properties |
| Domain Model | Buku, Pengguna |

### 7.4 Status Controller/Service/Repository
- Controller formal: tidak ada.
- Service layer formal: tidak ada.
- Repository pattern: setara DAO pattern.

### 7.5 Dependency Injection
- DI framework: tidak ada.
- Instansiasi objek dilakukan manual (new) di class UI.

### 7.6 Diagram Arsitektur ASCII

~~~text
+---------------------+
|      Swing UI       |
| Login/Dashboard/Buku|
+----------+----------+
           |
           v
+---------------------+
|   DAO Layer         |
| PenggunaDAO/BukuDAO |
+----------+----------+
           |
           v
+---------------------+
| DatabaseConnection  |
| (db.properties)     |
+----------+----------+
           |
           v
+---------------------+
|      MySQL DB       |
| pengguna, buku      |
+---------------------+
~~~

### 7.7 Flow Request-Response (Login)

~~~text
User Input -> LoginForm -> PenggunaDAO.login()
-> SQL SELECT pengguna -> hasil cocok?
-> Ya: DashboardForm dibuka
-> Tidak: pesan error
~~~

### 7.8 Flow Request-Response (CRUD Buku)

~~~text
User Action (Simpan/Edit/Hapus/Cari)
-> BukuForm handler
-> validasi form
-> BukuDAO query
-> hasil boolean/list
-> update JTable + notifikasi
~~~

## 8. Database Documentation

### 8.1 Jenis Database
MySQL relational database.

### 8.2 Konfigurasi Koneksi
Konfigurasi dibaca dari resource db.properties:

~~~properties
db.url=jdbc:mysql://localhost:3306/perpustakaan_db?useSSL=false&serverTimezone=Asia/Jakarta
db.username=root
db.password=
~~~

### 8.3 Entitas dan Tabel

| Tabel | Kolom Utama | Keterangan |
|---|---|---|
| buku | id_buku (PK), judul_buku, penulis, stok | Menyimpan katalog buku |
| pengguna | id_pengguna (PK), username (UNIQUE), password, nama_lengkap, role | Menyimpan akun login |

### 8.4 Relasi Tabel
- Tidak ada foreign key antar tabel pada skema saat ini.
- Modul buku dan login berdiri sendiri.

### 8.5 Query Flow
- Login: SELECT berdasarkan username + password.
- List buku: SELECT ORDER BY id_buku.
- Cari buku: SELECT LIKE judul_buku.
- Simpan/Edit/Hapus: INSERT/UPDATE/DELETE buku.

### 8.6 Migration
- Belum ada migration tool (Flyway/Liquibase).
- Inisialisasi dilakukan manual via file SQL bootstrap.

### 8.7 ORM/JPA/Hibernate
- Tidak digunakan.
- Data access murni JDBC PreparedStatement.

## 9. Integrasi/API Boundary

Aplikasi adalah desktop app, sehingga tidak menyediakan REST API publik.
Boundary integrasi utama:
- UI ke DAO melalui method Java.
- DAO ke DB melalui JDBC.

Jika nanti dibutuhkan API eksternal, disarankan split backend service terpisah.

## 10. Business Logic

### 10.1 Workflow Sistem Utama
1. Pengguna membuka aplikasi.
2. Form login tampil.
3. Sistem validasi input username/password non-kosong.
4. Sistem cek kredensial ke tabel pengguna.
5. Jika valid, dashboard dibuka.
6. Pengguna membuka modul data buku.
7. Pengguna melakukan CRUD/cari.
8. Data tersimpan/terupdate di database.

### 10.2 Service Layer
- Belum ada service layer eksplisit.
- Logika bisnis ringan masih melekat di UI event handlers.

### 10.3 Validasi
Validasi yang sudah ada:
- Login: field wajib isi.
- Buku: field wajib isi.
- Stok harus integer dan tidak negatif.

Gap validasi:
- Panjang string dan karakter khusus belum dibatasi.
- Tidak ada validasi duplikasi judul/aturan domain lanjut.

### 10.4 Scheduler
- Tidak ada scheduler/background job.

### 10.5 Transaction Flow
- Operasi JDBC menggunakan auto-commit default.
- Tidak ada transaksi multi-step eksplisit.

## 11. Security Documentation

### 11.1 Status Keamanan Saat Ini

| Area | Status | Catatan |
|---|---|---|
| Authentication | Ada (basic login) | Query username+password langsung |
| Authorization | Minimal | Role hanya ditampilkan, belum membatasi fitur |
| Session/JWT | Tidak ada | Desktop state in-memory |
| Password Hashing | Tidak ada | Password plaintext di DB |
| SQL Injection | Cukup baik | Menggunakan PreparedStatement |
| CORS/CSRF/XSS | Tidak relevan langsung | Karena bukan aplikasi web |
| Error Handling Security | Lemah | Exception banyak disembunyikan |

### 11.2 Risiko Utama
- Password plaintext berisiko tinggi bila database bocor.
- Akun default admin/admin123 pada seed data berisiko jika tidak diganti.
- Koneksi DB tanpa pengamanan tambahan (contoh SSL disable di URL).
- Tidak ada audit log login dan aksi CRUD.

### 11.3 Rekomendasi Prioritas
1. Implementasikan hash password (bcrypt/argon2).
2. Terapkan kebijakan password dan ganti akun default.
3. Tambahkan role-based authorization nyata di UI/aksi.
4. Tambahkan logging keamanan (login gagal/berhasil, aksi hapus/edit).
5. Perbaiki strategi penanganan error (jangan silent failure).

## 12. Logging & Monitoring

### 12.1 Kondisi Saat Ini
- Logging framework khusus belum digunakan.
- Monitoring aplikasi belum tersedia.
- Health check endpoint tidak ada (desktop app).

### 12.2 Dampak
- Sulit audit ketika insiden terjadi.
- Sulit troubleshooting di produksi.

### 12.3 Rekomendasi
- Tambahkan SLF4J + Logback.
- Buat level log: INFO/WARN/ERROR.
- Simpan log rolling file harian.
- Tambahkan event log bisnis: login, CRUD buku, kegagalan DB.

## 13. Testing Documentation

### 13.1 Kondisi Saat Ini
- src/test/java belum ada.
- Unit test, integration test, mock test belum ada.
- Coverage belum terukur.

### 13.2 Rekomendasi Stack Testing
- JUnit 5 untuk unit test.
- Mockito untuk mocking dependency.
- Testcontainers atau H2 mode kompatibel untuk integration test DAO.

### 13.3 Contoh Unit Test (Template)

~~~java
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BukuValidationTest {

    @Test
    void stokHarusPositif() {
        int stok = 5;
        assertTrue(stok >= 0);
    }
}
~~~

### 13.4 Target Coverage
- Minimal 80% untuk modul domain dan data-access.
- Prioritas test: login flow, CRUD flow, validasi input, error handling DB.

## 14. Deployment Guide

### 14.1 Build Production

~~~bash
mvn clean package -DskipTests
~~~

Artifact utama: JAR di folder target.

### 14.2 Deploy ke VPS/Linux
1. Install JDK 17/21 dan Maven (opsional jika build di server).
2. Setup MySQL dan import SQL schema.
3. Salin JAR ke server.
4. Siapkan file konfigurasi database sesuai environment.
5. Jalankan via java -jar.

Contoh systemd service:

~~~ini
[Unit]
Description=Library Maven Desktop App
After=network.target

[Service]
User=appuser
WorkingDirectory=/opt/library-maven
ExecStart=/usr/bin/java -jar /opt/library-maven/library-maven-1.0-SNAPSHOT.jar
Restart=always

[Install]
WantedBy=multi-user.target
~~~

Catatan: karena aplikasi Swing, server headless tidak ideal tanpa X server.

### 14.3 WAR/JAR dan Tomcat
- Saat ini packaging adalah JAR desktop, bukan WAR webapp.
- Deployment ke Tomcat tidak berlaku langsung.
- Jika target Tomcat, arsitektur harus diubah menjadi web application.

### 14.4 Docker Deployment
Untuk backend DB:

~~~bash
docker run -d --name mysql-perpustakaan \
  -e MYSQL_ROOT_PASSWORD=secret \
  -e MYSQL_DATABASE=perpustakaan_db \
  -p 3306:3306 mysql:8.4
~~~

Untuk aplikasi Swing, Docker umumnya tidak direkomendasikan di production headless kecuali ada kebutuhan khusus GUI forwarding.

### 14.5 CI/CD (Contoh GitHub Actions)

~~~yaml
name: Java Maven CI
on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
      - name: Build
        run: mvn -B clean package
~~~

## 15. Performance Analysis

### 15.1 Potensi Bottleneck
- Koneksi DB dibuat per operasi DAO (tanpa pooling).
- Query pencarian memakai LIKE tanpa indeks khusus selain struktur default.
- Operasi DB sinkron di event UI dapat membuat UI freeze saat DB lambat.

### 15.2 Query Optimization
- Tambahkan index untuk kolom pencarian (judul_buku) bila dataset besar.
- Pertimbangkan pagination jika data buku bertambah signifikan.

### 15.3 Caching
- Belum ada caching.
- Untuk desktop kecil, cache ringan in-memory bisa membantu list statis.

### 15.4 Memory dan Thread
- EDT Swing digunakan benar saat startup.
- Namun operasi DB sebaiknya dipindah ke SwingWorker agar UI responsif.

### 15.5 JVM Optimization
Saran runtime awal:

~~~bash
java -Xms256m -Xmx512m -XX:+UseG1GC -jar target/library-maven-1.0-SNAPSHOT.jar
~~~

### 15.6 Rekomendasi Performa Prioritas
1. Implement koneksi pool (HikariCP).
2. Jalankan query DB via background worker.
3. Tambahkan indeks pada kolom yang sering dicari.
4. Kurangi popup blocking berlebihan untuk alur cepat.

## 16. Code Quality Analysis

### 16.1 Penilaian Umum

| Aspek | Nilai (0-10) | Catatan |
|---|---:|---|
| Keterbacaan | 7.5 | Struktur package jelas, naming cukup baik |
| Clean Code | 6.5 | Banyak logic di UI, error handling minim |
| SOLID | 5.5 | SRP belum optimal pada layer view |
| Maintainability | 6.5 | Cocok skala kecil, menengah butuh refactor |
| Scalability | 5.0 | Tanpa service layer/pooling/testing |
| Security Hygiene | 4.0 | Password plaintext, audit minim |
| Testability | 4.0 | Tidak ada test, UI logic kuat terikat |

Skor total estimasi: 5.7/10.

### 16.2 Technical Debt yang Teridentifikasi
- Exception handling silent (return false/null tanpa log detail).
- Belum ada test otomatis.
- Belum ada service abstraction.
- Konfigurasi sensitif masih sederhana.

### 16.3 Rekomendasi Refactor
1. Tambah service layer antara UI dan DAO.
2. Standarisasi Result object untuk error message teknis.
3. Tambah logging terstruktur.
4. Pisahkan validasi domain dari UI form.
5. Bangun baseline test coverage.

## 17. Troubleshooting

### 17.1 Error Maven Umum
- Gejala: mvn command not found.
- Solusi:
  1. Install Maven.
  2. Tambahkan MAVEN_HOME dan PATH.
  3. Verifikasi dengan mvn -v.

### 17.2 Dependency Conflict
- Gejala: class not found / version bentrok.
- Solusi:
  1. Jalankan mvn dependency:tree.
  2. Gunakan exclusion bila perlu.
  3. Pin versi dependency di POM.

### 17.3 NetBeans Cache Issue
- Gejala: perubahan .form/.java tidak sinkron.
- Solusi:
  1. Clean and Build.
  2. Invalidate cache/indexing NetBeans.
  3. Reopen project.

### 17.4 Java Version Mismatch
- Gejala: invalid target release / unsupported class version.
- Solusi:
  1. Samakan JDK project dengan maven.compiler.source/target.
  2. Pastikan JAVA_HOME mengarah ke JDK yang benar.

### 17.5 Build Failed
- Gejala: kompilasi gagal di plugin compiler.
- Solusi:
  1. Baca error pertama (root cause).
  2. Perbaiki syntax/import.
  3. Ulangi mvn clean compile.

### 17.6 Classpath Issue
- Gejala: mysql driver tidak ditemukan.
- Solusi:
  1. Pastikan dependency mysql-connector-j ada.
  2. Jalankan clean build.
  3. Pastikan IDE tidak offline mode.

## 18. README.md Professional

README profesional telah disiapkan ulang untuk kebutuhan:
- deskripsi proyek,
- instalasi,
- setup,
- running,
- screenshot placeholder,
- API usage (desktop interaction contract),
- contributor guide,
- license.

Lihat file README.md terbaru di root project.

---

## Lampiran A - Ringkasan Hasil Analisa Otomatis

### A.1 Komponen Utama yang Terdeteksi
- Main class desktop Swing.
- DAO untuk operasi tabel buku dan pengguna.
- Konfigurasi database berbasis properties.
- SQL bootstrap untuk schema dan seed.

### A.2 Pattern yang Terdeteksi
- DAO pattern.
- Model POJO.
- Event-driven UI (Swing).

### A.3 Risiko Keamanan Terdeteksi
- Password plaintext.
- Kredensial default.
- Minim audit/logging.

### A.4 Risiko Performa Terdeteksi
- Tanpa connection pooling.
- Query sinkron di thread UI.
- Belum ada test performa dan monitoring.

### A.5 Kesiapan Production (Estimasi)
- Functional readiness: menengah.
- Operational readiness: rendah-menengah.
- Security readiness: rendah.
- Test readiness: rendah.

Rekomendasi: lakukan hardening keamanan, testing, dan observability sebelum go-live enterprise.
