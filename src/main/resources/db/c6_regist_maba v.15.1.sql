-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2017 at 07:10 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `c6_regist_maba`
--

-- --------------------------------------------------------

--
-- Table structure for table `agama`
--

CREATE TABLE `agama` (
  `agama_id` int(11) NOT NULL,
  `nama_agama` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agama`
--

INSERT INTO `agama` (`agama_id`, `nama_agama`) VALUES
(1, 'Islam'),
(2, 'Kristen'),
(3, 'Katholik');

-- --------------------------------------------------------

--
-- Table structure for table `alamat`
--

CREATE TABLE `alamat` (
  `jalan_id` int(11) NOT NULL,
  `kota_kabupaten_id` int(11) NOT NULL,
  `jalan` varchar(30) NOT NULL,
  `kecamatan` varchar(12) NOT NULL,
  `kelurahan` varchar(12) NOT NULL,
  `kode_pos` varchar(5) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alamat`
--

INSERT INTO `alamat` (`jalan_id`, `kota_kabupaten_id`, `jalan`, `kecamatan`, `kelurahan`, `kode_pos`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 1102, 'Jalan Harum', 'Bunga', 'Semerbak', '11120', 'benathavia.saladdin', '2017-08-20 08:00:00', 'benathavia.saladdin', '2017-08-20 08:00:00'),
(2, 1107, 'Jalan Wangi', 'Kembang', 'Mekar', '11121', 'hardyn.adiyoso', '2017-08-22 09:00:00', 'hardyn.adiyoso', '2017-08-20 08:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `asuransi_kesehatan`
--

CREATE TABLE `asuransi_kesehatan` (
  `nomor_asuransi` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `nomor_penerbit_asuransi` varchar(30) NOT NULL,
  `expired_date` date NOT NULL,
  `scan_kartu` varchar(255) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asuransi_kesehatan`
--

INSERT INTO `asuransi_kesehatan` (`nomor_asuransi`, `username`, `nomor_penerbit_asuransi`, `expired_date`, `scan_kartu`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
('12345678', 'benathavia.saladdin', '10001010', '2020-12-31', 'sk1.jpg', 'benathavia.saladdin', '2017-08-20 08:30:00', 'benathavia.saladdin', '2017-08-20 08:30:00'),
('24688642', 'hardyn.adiyoso', '20002020', '2021-01-01', 'sk2.jpg', 'hardyn.adiyoso', '2017-08-22 09:30:00', 'hardyn.adiyoso', '2017-08-20 09:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `biodata_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `jalan_id` int(11) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` varchar(1) NOT NULL,
  `nomor_telepon` varchar(12) NOT NULL,
  `kewarganegaraan` varchar(12) NOT NULL,
  `nomor_ktp` varchar(16) NOT NULL,
  `sidik_jari` varchar(255) NOT NULL,
  `scan_ktp` varchar(255) NOT NULL,
  `scan_kk` varchar(255) NOT NULL,
  `scan_surat_pernyataan_mahasiswa` varchar(255) NOT NULL,
  `status_verifikasi` varchar(255) NOT NULL,
  `flag_aktif` varchar(255) NOT NULL,
  `ukuran_jaket` varchar(4) DEFAULT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `agama_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`biodata_id`, `username`, `jalan_id`, `tanggal_lahir`, `jenis_kelamin`, `nomor_telepon`, `kewarganegaraan`, `nomor_ktp`, `sidik_jari`, `scan_ktp`, `scan_kk`, `scan_surat_pernyataan_mahasiswa`, `status_verifikasi`, `flag_aktif`, `ukuran_jaket`, `komentar`, `created_by`, `created_at`, `updated_by`, `updated_at`, `agama_id`) VALUES
(5, 'benathavia.saladdin', 1, '1997-03-10', 'L', '085700000001', 'WNI', '1234567890123456', 'sj1.jpg', 'sktp1.jpg', 'skk1.jpg', 'sspm1.jpg', 'Verified', '1', 'M', NULL, 'benathavia.saladdin', '2017-04-19 17:03:22', 'benathavia.saladdin', '2017-08-20 08:00:00', 1),
(6, 'hardyn.adiyoso', 2, '1998-02-05', 'P', '085700000002', 'WNI', '1234567890123457', 'sj2.jpg', 'sktp2.jpg', 'skk2.jpg', 'sspm2.jpg', 'Verified', '1', 'L', NULL, 'hardyn.adiyoso', '2017-08-20 10:00:00', 'hardyn.adiyoso', '2017-08-20 10:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `data_kesehatan`
--

CREATE TABLE `data_kesehatan` (
  `data_kesehatan_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `form_survey_kesehatan` varchar(255) NOT NULL,
  `hasil_tes_kesehatan` varchar(255) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_kesehatan`
--

INSERT INTO `data_kesehatan` (`data_kesehatan_id`, `username`, `form_survey_kesehatan`, `hasil_tes_kesehatan`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 'benathavia.saladdin', 'survey1.pdf', 'test1.pdf', 'benathavia.saladdin', '2017-08-20 09:00:00', 'benathavia.saladdin', '2017-08-20 09:00:00'),
(2, 'hardyn.adiyoso', 'survey2.pdf', 'test2.pdf', 'hardyn.adiyoso', '2017-08-20 10:30:00', 'hardyn.adiyoso', '2017-08-20 10:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE `fakultas` (
  `fakultas_id` int(11) NOT NULL,
  `nama_fakultas` varchar(255) NOT NULL,
  `rumpun_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`fakultas_id`, `nama_fakultas`, `rumpun_id`) VALUES
(1, 'Kedokteran', 3),
(2, 'Kedokteran Gigi', 3),
(3, 'Matematika dan Ilmu Pengetahuan Alam', 1),
(4, 'Teknik', 1),
(5, 'Hukum', 2),
(6, 'Ekonomi dan Bisnis', 2),
(7, 'Psikologi', 3),
(8, 'Ilmu Pengetahuan Budaya', 2),
(9, 'Ilmu Pengetahuan Sosial dan Ilmu Politik', 2),
(10, 'Kesehatan Masyarakat', 3),
(11, 'Ilmu Komputer', 1),
(12, 'Ilmu Keperawatan', 3),
(13, 'Farmasi', 3),
(14, 'Ilmu Administrasi', 2),
(15, 'Vokasi', 1),
(16, 'Sekolah Ilmu Lingkungan', 1),
(17, 'Sekolah Kajian Strategik dan Global', 2);

-- --------------------------------------------------------

--
-- Table structure for table `ijazah`
--

CREATE TABLE `ijazah` (
  `nomor_ijazah` varchar(30) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `institusi_id` int(11) NOT NULL,
  `jenjang` varchar(10) NOT NULL,
  `scan_ijazah` varchar(255) NOT NULL,
  `scan_pernyataan_ijazah` varchar(255) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ijazah`
--

INSERT INTO `ijazah` (`nomor_ijazah`, `username`, `institusi_id`, `jenjang`, `scan_ijazah`, `scan_pernyataan_ijazah`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
('14000001', 'benathavia.saladdin', 1, 'SMA', 'ijazah1.jpg', 'spi1.jpg', 'benathavia.saladdin', '2017-08-15 10:05:00', 'benathavia.saladdin', '2017-08-15 10:05:00'),
('1406123456', 'hardyn.adiyoso', 2, 'Sarjana', 'ijazah2.jpg', 'spi2.jpg', 'hardyn.adiyoso', '2017-08-15 11:00:00', 'hardyn.adiyoso', '2017-08-15 11:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `institusi`
--

CREATE TABLE `institusi` (
  `institusi_id` int(11) NOT NULL,
  `nama_institusi` varchar(255) NOT NULL,
  `tingkat_pendidikan_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `institusi`
--

INSERT INTO `institusi` (`institusi_id`, `nama_institusi`, `tingkat_pendidikan_id`) VALUES
(1, 'SMAN 1 Jakarta', 1),
(2, 'Universitas Indonesia', 2);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_ept`
--

CREATE TABLE `jadwal_ept` (
  `jadwal_ept_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `timestamp_akhir` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_ept`
--

INSERT INTO `jadwal_ept` (`jadwal_ept_id`, `timestamp_awal`, `timestamp_akhir`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, '2017-08-28 01:00:00', '2017-08-28 05:00:00', 'redita.arifin', '2017-08-15 10:05:00', 'redita.arifin', '2017-08-15 10:05:00'),
(2, '2017-08-28 06:00:00', '2017-08-28 10:00:00', 'redita.arifin', '2017-08-15 10:10:00', 'redita.arifin', '2017-08-15 10:05:00'),
(3, '2017-08-29 01:00:00', '2017-08-29 05:00:00', 'redita.arifin', '2017-08-15 10:15:00', 'redita.arifin', '2017-08-15 10:05:00'),
(4, '2017-08-29 06:00:00', '2017-08-29 10:00:00', 'redita.arifin', '2017-08-15 10:20:00', 'redita.arifin', '2017-08-15 10:05:00');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_registrasi`
--

CREATE TABLE `jadwal_registrasi` (
  `jadwal_registrasi_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `timestamp_akhir` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `kapasitas` int(11) NOT NULL,
  `fakultas_id` int(11),
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_registrasi`
--

INSERT INTO `jadwal_registrasi` (`jadwal_registrasi_id`, `timestamp_awal`, `timestamp_akhir`, `kapasitas`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, '2017-08-21 01:00:00', '2017-08-21 03:00:00', 200, 'redita.arifin', '2017-08-15 10:00:00', 'redita.arifin', '2017-08-15 10:00:00'),
(2, '2017-08-21 03:00:00', '2017-08-21 05:00:00', 200, 'redita.arifin', '2017-08-15 10:05:00', 'redita.arifin', '2017-08-15 10:00:00'),
(3, '2017-08-21 06:00:00', '2017-08-22 08:00:00', 200, 'redita.arifin', '2017-08-15 10:10:00', 'redita.arifin', '2017-08-15 10:00:00'),
(4, '2017-08-22 01:00:00', '2017-08-22 03:00:00', 200, 'redita.arifin', '2017-08-15 10:15:00', 'redita.arifin', '2017-08-15 10:00:00'),
(5, '2017-08-22 03:00:00', '2017-08-22 05:00:00', 200, 'redita.arifin', '2017-08-15 10:20:00', 'redita.arifin', '2017-08-15 10:00:00'),
(6, '2017-08-22 06:00:00', '2017-08-22 08:00:00', 200, 'redita.arifin', '2017-08-15 10:25:00', 'redita.arifin', '2017-08-15 10:00:00'),
(7, '2017-08-23 01:00:00', '2017-08-23 03:00:00', 200, 'redita.arifin', '2017-08-15 10:30:00', 'redita.arifin', '2017-08-15 10:00:00'),
(8, '2017-08-23 03:00:00', '2017-08-23 05:00:00', 200, 'redita.arifin', '2017-08-15 10:35:00', 'redita.arifin', '2017-08-15 10:00:00'),
(9, '2017-08-23 06:00:00', '2017-08-23 08:00:00', 200, 'redita.arifin', '2017-08-15 10:40:00', 'redita.arifin', '2017-08-15 10:00:00'),
(10, '2017-08-24 01:00:00', '2017-08-24 03:00:00', 200, 'redita.arifin', '2017-08-15 10:45:00', 'redita.arifin', '2017-08-15 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_tes_kesehatan`
--

CREATE TABLE `jadwal_tes_kesehatan` (
  `jadwal_tes_kesehatan_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `timestamp_akhir` timestamp NOT NULL DEFAULT '2017-04-18 00:00:00',
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_tes_kesehatan`
--

INSERT INTO `jadwal_tes_kesehatan` (`jadwal_tes_kesehatan_id`, `timestamp_awal`, `timestamp_akhir`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, '2017-08-21 01:00:00', '2017-08-21 03:00:00', 'wilson.mokoginta', '2017-08-15 10:00:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(2, '2017-08-21 03:00:00', '2017-08-21 05:00:00', 'wilson.mokoginta', '2017-08-15 10:05:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(3, '2017-08-21 06:00:00', '2017-08-22 08:00:00', 'wilson.mokoginta', '2017-08-15 10:10:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(4, '2017-08-22 01:00:00', '2017-08-22 03:00:00', 'wilson.mokoginta', '2017-08-15 10:15:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(5, '2017-08-22 03:00:00', '2017-08-22 05:00:00', 'wilson.mokoginta', '2017-08-15 10:20:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(6, '2017-08-22 06:00:00', '2017-08-22 08:00:00', 'wilson.mokoginta', '2017-08-15 10:25:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(7, '2017-08-23 01:00:00', '2017-08-23 03:00:00', 'wilson.mokoginta', '2017-08-15 10:30:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(8, '2017-08-23 03:00:00', '2017-08-23 05:00:00', 'wilson.mokoginta', '2017-08-15 10:35:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(9, '2017-08-23 06:00:00', '2017-08-23 08:00:00', 'wilson.mokoginta', '2017-08-15 10:40:00', 'wilson.mokoginta', '2017-08-15 10:00:00'),
(10, '2017-08-24 01:00:00', '2017-08-24 03:00:00', 'wilson.mokoginta', '2017-08-15 10:45:00', 'wilson.mokoginta', '2017-08-15 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `jenjang`
--

CREATE TABLE `jenjang` (
  `jenjang_id` int(11) NOT NULL,
  `nama_jenjang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenjang`
--

INSERT INTO `jenjang` (`jenjang_id`, `nama_jenjang`) VALUES
(1, 'Sarjana'),
(2, 'Magister'),
(3, 'Doktor'),
(4, 'Profesi'),
(5, 'Spesialis'),
(6, 'Vokasi');

-- --------------------------------------------------------

--
-- Table structure for table `kota_kabupaten`
--

CREATE TABLE `kota_kabupaten` (
  `kota_kabupaten_id` int(11) NOT NULL,
  `provinsi_id` int(11) NOT NULL,
  `nama_kota_kabupaten` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota_kabupaten`
--

INSERT INTO `kota_kabupaten` (`kota_kabupaten_id`, `nama_kota_kabupaten`, `provinsi_id`) VALUES

(1101, 'Kab. Simeulue', 11),
(1102, 'Kab. Aceh Singkil', 11),
(1103, 'Kab. Aceh Selatan', 11),
(1104, 'Kab. Aceh Tenggara', 11),
(1105, 'Kab. Aceh Timur', 11),
(1106, 'Kab. Aceh Tengah', 11),
(1107, 'Kab. Aceh Barat', 11),
(1108, 'Kab. Aceh Besar', 11),
(1109, 'Kab. Pidie', 11),
(1110, 'Kab. Bireuen', 11),
(1111, 'Kab. Aceh Utara', 11),
(1112, 'Kab. Aceh Barat Daya', 11),
(1113, 'Kab. Gayo Lues', 11),
(1114, 'Kab. Aceh Tamiang', 11),
(1115, 'Kab. Nagan Raya', 11),
(1116, 'Kab. Aceh Jaya', 11),
(1117, 'Kab. Bener Meriah', 11),
(1118, 'Kab. Pidie Jaya', 11),
(1171, 'Kota Banda Aceh', 11),
(1172, 'Kota Sabang', 11),
(1173, 'Kota Langsa', 11),
(1174, 'Kota Lhokseumawe', 11),
(1175, 'Kota Subulussalam', 11),
(1201, 'Kab. Nias', 12),
(1202, 'Kab. Mandailing Natal', 12),
(1203, 'Kab. Tapanuli Selatan', 12),
(1204, 'Kab. Tapanuli Tengah', 12),
(1205, 'Kab. Tapanuli Utara', 12),
(1206, 'Kab. Toba Samosir', 12),
(1207, 'Kab. Labuhan Batu', 12),
(1208, 'Kab. Asahan', 12),
(1209, 'Kab. Simalungun', 12),
(1210, 'Kab. Dairi', 12),
(1211, 'Kab. Karo', 12),
(1212, 'Kab. Deli Serdang', 12),
(1213, 'Kab. Langkat', 12),
(1214, 'Kab. Nias Selatan', 12),
(1215, 'Kab. Humbang Hasundutan', 12),
(1216, 'Kab. Pakpak Bharat', 12),
(1217, 'Kab. Samosir', 12),
(1218, 'Kab. Serdang Bedagai', 12),
(1219, 'Kab. Batu Bara', 12),
(1220, 'Kab. Padang Lawas Utara', 12),
(1221, 'Kab. Padang Lawas', 12),
(1222, 'Kab. Labuhan Batu Selatan', 12),
(1223, 'Kab. Labuhan Batu Utara', 12),
(1224, 'Kab. Nias Utara', 12),
(1225, 'Kab. Nias Barat', 12),
(1271, 'Kota Sibolga', 12),
(1272, 'Kota Tanjung Balai', 12),
(1273, 'Kota Pematang Siantar', 12),
(1274, 'Kota Tebing Tinggi', 12),
(1275, 'Kota Medan', 12),
(1276, 'Kota Binjai', 12),
(1277, 'Kota Padangsidimpuan', 12),
(1278, 'Kota Gunungsitoli', 12),
(1301, 'Kab. Kepulauan Mentawai', 13),
(1302, 'Kab. Pesisir Selatan', 13),
(1303, 'Kab. Solok', 13),
(1304, 'Kab. Sijunjung', 13),
(1305, 'Kab. Tanah Datar', 13),
(1306, 'Kab. Padang Pariaman', 13),
(1307, 'Kab. Agam', 13),
(1308, 'Kab. Lima Puluh Kota', 13),
(1309, 'Kab. Pasaman', 13),
(1310, 'Kab. Solok Selatan', 13),
(1311, 'Kab. Dharmasraya', 13),
(1312, 'Kab. Pasaman Barat', 13),
(1371, 'Kota Padang', 13),
(1372, 'Kota Solok', 13),
(1373, 'Kota Sawah Lunto', 13),
(1374, 'Kota Padang Panjang', 13),
(1375, 'Kota Bukittinggi', 13),
(1376, 'Kota Payakumbuh', 13),
(1377, 'Kota Pariaman', 13),
(1401, 'Kab. Kuantan Singingi', 14),
(1402, 'Kab. Indragiri Hulu', 14),
(1403, 'Kab. Indragiri Hilir', 14),
(1404, 'Kab. Pelalawan', 14),
(1405, 'Kab. S I A K', 14),
(1406, 'Kab. Kampar', 14),
(1407, 'Kab. Rokan Hulu', 14),
(1408, 'Kab. Bengkalis', 14),
(1409, 'Kab. Rokan Hilir', 14),
(1410, 'Kab. Kepulauan Meranti', 14),
(1471, 'Kota Pekanbaru', 14),
(1473, 'Kota D U M A I', 14),
(1501, 'Kab. Kerinci', 15),
(1502, 'Kab. Merangin', 15),
(1503, 'Kab. Sarolangun', 15),
(1504, 'Kab. Batang Hari', 15),
(1505, 'Kab. Muaro Jambi', 15),
(1506, 'Kab. Tanjung Jabung Timur', 15),
(1507, 'Kab. Tanjung Jabung Barat', 15),
(1508, 'Kab. Tebo', 15),
(1509, 'Kab. Bungo', 15),
(1571, 'Kota Jambi', 15),
(1572, 'Kota Sungai Penuh', 15),
(1601, 'Kab. Ogan Komering Ulu', 16),
(1602, 'Kab. Ogan Komering Ilir', 16),
(1603, 'Kab. Muara Enim', 16),
(1604, 'Kab. Lahat', 16),
(1605, 'Kab. Musi Rawas', 16),
(1606, 'Kab. Musi Banyuasin', 16),
(1607, 'Kab. Banyu Asin', 16),
(1608, 'Kab. Ogan Komering Ulu Selatan', 16),
(1609, 'Kab. Ogan Komering Ulu Timur', 16),
(1610, 'Kab. Ogan Ilir', 16),
(1611, 'Kab. Empat Lawang', 16),
(1671, 'Kota Palembang', 16),
(1672, 'Kota Prabumulih', 16),
(1673, 'Kota Pagar Alam', 16),
(1674, 'Kota Lubuklinggau', 16),
(1701, 'Kab. Bengkulu Selatan', 17),
(1702, 'Kab. Rejang Lebong', 17),
(1703, 'Kab. Bengkulu Utara', 17),
(1704, 'Kab. Kaur', 17),
(1705, 'Kab. Seluma', 17),
(1706, 'Kab. Mukomuko', 17),
(1707, 'Kab. Lebong', 17),
(1708, 'Kab. Kepahiang', 17),
(1709, 'Kab. Bengkulu Tengah', 17),
(1771, 'Kota Bengkulu', 17),
(1801, 'Kab. Lampung Barat', 18),
(1802, 'Kab. Tanggamus', 18),
(1803, 'Kab. Lampung Selatan', 18),
(1804, 'Kab. Lampung Timur', 18),
(1805, 'Kab. Lampung Tengah', 18),
(1806, 'Kab. Lampung Utara', 18),
(1807, 'Kab. Way Kanan', 18),
(1808, 'Kab. Tulangbawang', 18),
(1809, 'Kab. Pesawaran', 18),
(1810, 'Kab. Pringsewu', 18),
(1811, 'Kab. Mesuji', 18),
(1812, 'Kab. Tulang Bawang Barat', 18),
(1813, 'Kab. Pesisir Barat', 18),
(1871, 'Kota Bandar Lampung', 18),
(1872, 'Kota Metro', 18),
(1901, 'Kab. Bangka', 19),
(1902, 'Kab. Belitung', 19),
(1903, 'Kab. Bangka Barat', 19),
(1904, 'Kab. Bangka Tengah', 19),
(1905, 'Kab. Bangka Selatan', 19),
(1906, 'Kab. Belitung Timur', 19),
(1971, 'Kota Pangkal Pinang', 19),
(2101, 'Kab. Karimun', 21),
(2102, 'Kab. Bintan', 21),
(2103, 'Kab. Natuna', 21),
(2104, 'Kab. Lingga', 21),
(2105, 'Kab. Kepulauan Anambas', 21),
(2171, 'Kota B A T A M', 21),
(2172, 'Kota Tanjung Pinang', 21),
(3101, 'Kab. Kepulauan Seribu', 31),
(3171, 'Kota Jakarta Selatan', 31),
(3172, 'Kota Jakarta Timur', 31),
(3173, 'Kota Jakarta Pusat', 31),
(3174, 'Kota Jakarta Barat', 31),
(3175, 'Kota Jakarta Utara', 31),
(3201, 'Kab. Bogor', 32),
(3202, 'Kab. Sukabumi', 32),
(3203, 'Kab. Cianjur', 32),
(3204, 'Kab. Bandung', 32),
(3205, 'Kab. Garut', 32),
(3206, 'Kab. Tasikmalaya', 32),
(3207, 'Kab. Ciamis', 32),
(3208, 'Kab. Kuningan', 32),
(3209, 'Kab. Cirebon', 32),
(3210, 'Kab. Majalengka', 32),
(3211, 'Kab. Sumedang', 32),
(3212, 'Kab. Indramayu', 32),
(3213, 'Kab. Subang', 32),
(3214, 'Kab. Purwakarta', 32),
(3215, 'Kab. Karawang', 32),
(3216, 'Kab. Bekasi', 32),
(3217, 'Kab. Bandung Barat', 32),
(3218, 'Kab. Pangandaran', 32),
(3271, 'Kota Bogor', 32),
(3272, 'Kota Sukabumi', 32),
(3273, 'Kota Bandung', 32),
(3274, 'Kota Cirebon', 32),
(3275, 'Kota Bekasi', 32),
(3276, 'Kota Depok', 32),
(3277, 'Kota Cimahi', 32),
(3278, 'Kota Tasikmalaya', 32),
(3279, 'Kota Banjar', 32),
(3301, 'Kab. Cilacap', 33),
(3302, 'Kab. Banyumas', 33),
(3303, 'Kab. Purbalingga', 33),
(3304, 'Kab. Banjarnegara', 33),
(3305, 'Kab. Kebumen', 33),
(3306, 'Kab. Purworejo', 33),
(3307, 'Kab. Wonosobo', 33),
(3308, 'Kab. Magelang', 33),
(3309, 'Kab. Boyolali', 33),
(3310, 'Kab. Klaten', 33),
(3311, 'Kab. Sukoharjo', 33),
(3312, 'Kab. Wonogiri', 33),
(3313, 'Kab. Karanganyar', 33),
(3314, 'Kab. Sragen', 33),
(3315, 'Kab. Grobogan', 33),
(3316, 'Kab. Blora', 33),
(3317, 'Kab. Rembang', 33),
(3318, 'Kab. Pati', 33),
(3319, 'Kab. Kudus', 33),
(3320, 'Kab. Jepara', 33),
(3321, 'Kab. Demak', 33),
(3322, 'Kab. Semarang', 33),
(3323, 'Kab. Temanggung', 33),
(3324, 'Kab. Kendal', 33),
(3325, 'Kab. Batang', 33),
(3326, 'Kab. Pekalongan', 33),
(3327, 'Kab. Pemalang', 33),
(3328, 'Kab. Tegal', 33),
(3329, 'Kab. Brebes', 33),
(3371, 'Kota Magelang', 33),
(3372, 'Kota Surakarta', 33),
(3373, 'Kota Salatiga', 33),
(3374, 'Kota Semarang', 33),
(3375, 'Kota Pekalongan', 33),
(3376, 'Kota Tegal', 33),
(3401, 'Kab. Kulon Progo', 34),
(3402, 'Kab. Bantul', 34),
(3403, 'Kab. Gunung Kidul', 34),
(3404, 'Kab. Sleman', 34),
(3471, 'Kota Yogyakarta', 34),
(3501, 'Kab. Pacitan', 35),
(3502, 'Kab. Ponorogo', 35),
(3503, 'Kab. Trenggalek', 35),
(3504, 'Kab. Tulungagung', 35),
(3505, 'Kab. Blitar', 35),
(3506, 'Kab. Kediri', 35),
(3507, 'Kab. Malang', 35),
(3508, 'Kab. Lumajang', 35),
(3509, 'Kab. Jember', 35),
(3510, 'Kab. Banyuwangi', 35),
(3511, 'Kab. Bondowoso', 35),
(3512, 'Kab. Situbondo', 35),
(3513, 'Kab. Probolinggo', 35),
(3514, 'Kab. Pasuruan', 35),
(3515, 'Kab. Sidoarjo', 35),
(3516, 'Kab. Mojokerto', 35),
(3517, 'Kab. Jombang', 35),
(3518, 'Kab. Nganjuk', 35),
(3519, 'Kab. Madiun', 35),
(3520, 'Kab. Magetan', 35),
(3521, 'Kab. Ngawi', 35),
(3522, 'Kab. Bojonegoro', 35),
(3523, 'Kab. Tuban', 35),
(3524, 'Kab. Lamongan', 35),
(3525, 'Kab. Gresik', 35),
(3526, 'Kab. Bangkalan', 35),
(3527, 'Kab. Sampang', 35),
(3528, 'Kab. Pamekasan', 35),
(3529, 'Kab. Sumenep', 35),
(3571, 'Kota Kediri', 35),
(3572, 'Kota Blitar', 35),
(3573, 'Kota Malang', 35),
(3574, 'Kota Probolinggo', 35),
(3575, 'Kota Pasuruan', 35),
(3576, 'Kota Mojokerto', 35),
(3577, 'Kota Madiun', 35),
(3578, 'Kota Surabaya', 35),
(3579, 'Kota Batu', 35),
(3601, 'Kab. Pandeglang', 36),
(3602, 'Kab. Lebak', 36),
(3603, 'Kab. Tangerang', 36),
(3604, 'Kab. Serang', 36),
(3671, 'Kota Tangerang', 36),
(3672, 'Kota Cilegon', 36),
(3673, 'Kota Serang', 36),
(3674, 'Kota Tangerang Selatan', 36),
(5101, 'Kab. Jembrana', 51),
(5102, 'Kab. Tabanan', 51),
(5103, 'Kab. Badung', 51),
(5104, 'Kab. Gianyar', 51),
(5105, 'Kab. Klungkung', 51),
(5106, 'Kab. Bangli', 51),
(5107, 'Kab. Karang Asem', 51),
(5108, 'Kab. Buleleng', 51),
(5171, 'Kota Denpasar', 51),
(5201, 'Kab. Lombok Barat', 52),
(5202, 'Kab. Lombok Tengah', 52),
(5203, 'Kab. Lombok Timur', 52),
(5204, 'Kab. Sumbawa', 52),
(5205, 'Kab. Dompu', 52),
(5206, 'Kab. Bima', 52),
(5207, 'Kab. Sumbawa Barat', 52),
(5208, 'Kab. Lombok Utara', 52),
(5271, 'Kota Mataram', 52),
(5272, 'Kota Bima', 52),
(5301, 'Kab. Sumba Barat', 53),
(5302, 'Kab. Sumba Timur', 53),
(5303, 'Kab. Kupang', 53),
(5304, 'Kab. Timor Tengah Selatan', 53),
(5305, 'Kab. Timor Tengah Utara', 53),
(5306, 'Kab. Belu', 53),
(5307, 'Kab. Alor', 53),
(5308, 'Kab. Lembata', 53),
(5309, 'Kab. Flores Timur', 53),
(5310, 'Kab. Sikka', 53),
(5311, 'Kab. Ende', 53),
(5312, 'Kab. Ngada', 53),
(5313, 'Kab. Manggarai', 53),
(5314, 'Kab. Rote Ndao', 53),
(5315, 'Kab. Manggarai Barat', 53),
(5316, 'Kab. Sumba Tengah', 53),
(5317, 'Kab. Sumba Barat Daya', 53),
(5318, 'Kab. Nagekeo', 53),
(5319, 'Kab. Manggarai Timur', 53),
(5320, 'Kab. Sabu Raijua', 53),
(5371, 'Kota Kupang', 53),
(6101, 'Kab. Sambas', 61),
(6102, 'Kab. Bengkayang', 61),
(6103, 'Kab. Landak', 61),
(6104, 'Kab. Pontianak', 61),
(6105, 'Kab. Sanggau', 61),
(6106, 'Kab. Ketapang', 61),
(6107, 'Kab. Sintang', 61),
(6108, 'Kab. Kapuas Hulu', 61),
(6109, 'Kab. Sekadau', 61),
(6110, 'Kab. Melawi', 61),
(6111, 'Kab. Kayong Utara', 61),
(6112, 'Kab. Kubu Raya', 61),
(6171, 'Kota Pontianak', 61),
(6172, 'Kota Singkawang', 61),
(6201, 'Kab. Kotawaringin Barat', 62),
(6202, 'Kab. Kotawaringin Timur', 62),
(6203, 'Kab. Kapuas', 62),
(6204, 'Kab. Barito Selatan', 62),
(6205, 'Kab. Barito Utara', 62),
(6206, 'Kab. Sukamara', 62),
(6207, 'Kab. Lamandau', 62),
(6208, 'Kab. Seruyan', 62),
(6209, 'Kab. Katingan', 62),
(6210, 'Kab. Pulang Pisau', 62),
(6211, 'Kab. Gunung Mas', 62),
(6212, 'Kab. Barito Timur', 62),
(6213, 'Kab. Murung Raya', 62),
(6271, 'Kota Palangka Raya', 62),
(6301, 'Kab. Tanah Laut', 63),
(6302, 'Kab. Kota Baru', 63),
(6303, 'Kab. Banjar', 63),
(6304, 'Kab. Barito Kuala', 63),
(6305, 'Kab. Tapin', 63),
(6306, 'Kab. Hulu Sungai Selatan', 63),
(6307, 'Kab. Hulu Sungai Tengah', 63),
(6308, 'Kab. Hulu Sungai Utara', 63),
(6309, 'Kab. Tabalong', 63),
(6310, 'Kab. Tanah Bumbu', 63),
(6311, 'Kab. Balangan', 63),
(6371, 'Kota Banjarmasin', 63),
(6372, 'Kota Banjar Baru', 63),
(6401, 'Kab. Paser', 64),
(6402, 'Kab. Kutai Barat', 64),
(6403, 'Kab. Kutai Kartanegara', 64),
(6404, 'Kab. Kutai Timur', 64),
(6405, 'Kab. Berau', 64),
(6409, 'Kab. Penajam Paser Utara', 64),
(6471, 'Kota Balikpapan', 64),
(6472, 'Kota Samarinda', 64),
(6474, 'Kota Bontang', 64),
(6501, 'Kab. Malinau', 65),
(6502, 'Kab. Bulungan', 65),
(6503, 'Kab. Tana Tidung', 65),
(6504, 'Kab. Nunukan', 65),
(6571, 'Kota Tarakan', 65),
(7101, 'Kab. Bolaang Mongondow', 71),
(7102, 'Kab. Minahasa', 71),
(7103, 'Kab. Kepulauan Sangihe', 71),
(7104, 'Kab. Kepulauan Talaud', 71),
(7105, 'Kab. Minahasa Selatan', 71),
(7106, 'Kab. Minahasa Utara', 71),
(7107, 'Kab. Bolaang Mongondow Utara', 71),
(7108, 'Kab. Siau Tagulandang Biaro', 71),
(7109, 'Kab. Minahasa Tenggara', 71),
(7110, 'Kab. Bolaang Mongondow Selatan', 71),
(7111, 'Kab. Bolaang Mongondow Timur', 71),
(7171, 'Kota Manado', 71),
(7172, 'Kota Bitung', 71),
(7173, 'Kota Tomohon', 71),
(7174, 'Kota Kotamobagu', 71),
(7201, 'Kab. Banggai Kepulauan', 72),
(7202, 'Kab. Banggai', 72),
(7203, 'Kab. Morowali', 72),
(7204, 'Kab. Poso', 72),
(7205, 'Kab. Donggala', 72),
(7206, 'Kab. Toli-toli', 72),
(7207, 'Kab. Buol', 72),
(7208, 'Kab. Parigi Moutong', 72),
(7209, 'Kab. Tojo Una-una', 72),
(7210, 'Kab. Sigi', 72),
(7271, 'Kota Palu', 72),
(7301, 'Kab. Kepulauan Selayar', 73),
(7302, 'Kab. Bulukumba', 73),
(7303, 'Kab. Bantaeng', 73),
(7304, 'Kab. Jeneponto', 73),
(7305, 'Kab. Takalar', 73),
(7306, 'Kab. Gowa', 73),
(7307, 'Kab. Sinjai', 73),
(7308, 'Kab. Maros', 73),
(7309, 'Kab. Pangkajene Dan Kepulauan', 73),
(7310, 'Kab. Barru', 73),
(7311, 'Kab. Bone', 73),
(7312, 'Kab. Soppeng', 73),
(7313, 'Kab. Wajo', 73),
(7314, 'Kab. Sidenreng Rappang', 73),
(7315, 'Kab. Pinrang', 73),
(7316, 'Kab. Enrekang', 73),
(7317, 'Kab. Luwu', 73),
(7318, 'Kab. Tana Toraja', 73),
(7322, 'Kab. Luwu Utara', 73),
(7325, 'Kab. Luwu Timur', 73),
(7326, 'Kab. Toraja Utara', 73),
(7371, 'Kota Makassar', 73),
(7372, 'Kota Parepare', 73),
(7373, 'Kota Palopo', 73),
(7401, 'Kab. Buton', 74),
(7402, 'Kab. Muna', 74),
(7403, 'Kab. Konawe', 74),
(7404, 'Kab. Kolaka', 74),
(7405, 'Kab. Konawe Selatan', 74),
(7406, 'Kab. Bombana', 74),
(7407, 'Kab. Wakatobi', 74),
(7408, 'Kab. Kolaka Utara', 74),
(7409, 'Kab. Buton Utara', 74),
(7410, 'Kab. Konawe Utara', 74),
(7471, 'Kota Kendari', 74),
(7472, 'Kota Baubau', 74),
(7501, 'Kab. Boalemo', 75),
(7502, 'Kab. Gorontalo', 75),
(7503, 'Kab. Pohuwato', 75),
(7504, 'Kab. Bone Bolango', 75),
(7505, 'Kab. Gorontalo Utara', 75),
(7571, 'Kota Gorontalo', 75),
(7601, 'Kab. Majene', 76),
(7602, 'Kab. Polewali Mandar', 76),
(7603, 'Kab. Mamasa', 76),
(7604, 'Kab. Mamuju', 76),
(7605, 'Kab. Mamuju Utara', 76),
(8101, 'Kab. Maluku Tenggara Barat', 81),
(8102, 'Kab. Maluku Tenggara', 81),
(8103, 'Kab. Maluku Tengah', 81),
(8104, 'Kab. Buru', 81),
(8105, 'Kab. Kepulauan Aru', 81),
(8106, 'Kab. Seram Bagian Barat', 81),
(8107, 'Kab. Seram Bagian Timur', 81),
(8108, 'Kab. Maluku Barat Daya', 81),
(8109, 'Kab. Buru Selatan', 81),
(8171, 'Kota Ambon', 81),
(8172, 'Kota Tual', 81),
(8201, 'Kab. Halmahera Barat', 82),
(8202, 'Kab. Halmahera Tengah', 82),
(8203, 'Kab. Kepulauan Sula', 82),
(8204, 'Kab. Halmahera Selatan', 82),
(8205, 'Kab. Halmahera Utara', 82),
(8206, 'Kab. Halmahera Timur', 82),
(8207, 'Kab. Pulau Morotai', 82),
(8271, 'Kota Ternate', 82),
(8272, 'Kota Tidore Kepulauan', 82),
(9101, 'Kab. Fakfak', 91),
(9102, 'Kab. Kaimana', 91),
(9103, 'Kab. Teluk Wondama', 91),
(9104, 'Kab. Teluk Bintuni', 91),
(9105, 'Kab. Manokwari', 91),
(9106, 'Kab. Sorong Selatan', 91),
(9107, 'Kab. Sorong', 91),
(9108, 'Kab. Raja Ampat', 91),
(9109, 'Kab. Tambrauw', 91),
(9110, 'Kab. Maybrat', 91),
(9171, 'Kota Sorong', 91),
(9401, 'Kab. Merauke', 94),
(9402, 'Kab. Jayawijaya', 94),
(9403, 'Kab. Jayapura', 94),
(9404, 'Kab. Nabire', 94),
(9408, 'Kab. Kepulauan Yapen', 94),
(9409, 'Kab. Biak Numfor', 94),
(9410, 'Kab. Paniai', 94),
(9411, 'Kab. Puncak Jaya', 94),
(9412, 'Kab. Mimika', 94),
(9413, 'Kab. Boven Digoel', 94),
(9414, 'Kab. Mappi', 94),
(9415, 'Kab. Asmat', 94),
(9416, 'Kab. Yahukimo', 94),
(9417, 'Kab. Pegunungan Bintang', 94),
(9418, 'Kab. Tolikara', 94),
(9419, 'Kab. Sarmi', 94),
(9420, 'Kab. Keerom', 94),
(9426, 'Kab. Waropen', 94),
(9427, 'Kab. Supiori', 94),
(9428, 'Kab. Mamberamo Raya', 94),
(9429, 'Kab. Nduga', 94),
(9430, 'Kab. Lanny Jaya', 94),
(9431, 'Kab. Mamberamo Tengah', 94),
(9432, 'Kab. Yalimo', 94),
(9433, 'Kab. Puncak', 94),
(9434, 'Kab. Dogiyai', 94),
(9435, 'Kab. Intan Jaya', 94),
(9436, 'Kab. Deiyai', 94),
(9471, 'Kota Jayapura', 94);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `username` varchar(30) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `uid_sso` varchar(30) NOT NULL,
  `program_studi_id` int(11) NOT NULL,
  `no_seleksi` varchar(10) NOT NULL,
  `jadwal_registrasi_id` int(11) DEFAULT NULL,
  `jadwal_tes_kesehatan_id` int(11) DEFAULT NULL,
  `jadwal_ept_id` int(11) DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`username`, `npm`, `uid_sso`, `program_studi_id`, `no_seleksi`, `jadwal_registrasi_id`, `jadwal_tes_kesehatan_id`, `jadwal_ept_id`, `created_by`, `created_at`) VALUES
('benathavia.saladdin', '1234567890', 'benathavia.saladdin', 3, '123450', 1, 2, 3, 'redita.arifin', '2017-05-10 08:00:00'),
('dwi.arief', '1234567892', 'dwi.arief', 3, '123452', 3, 2, 1, 'redita.arifin', '2017-05-10 08:00:00'),
('hardyn.adiyoso', '1234567891', 'hardyn.adiyoso', 4, '123451', 1, 2, 3, 'redita.arifin', '2017-05-10 08:00:00'),
('lia.naren', '1234567893', 'lia.naren', 4, '123453', 3, 2, 1, 'redita.arifin', '2017-05-10 08:00:00'),
('naren.jul', '1234567894', 'naren.jul', 5, '123454', 1, 2, 3, 'redita.arifin', '2017-05-10 08:00:00'),
('widiarliyanti', '1234567895', 'widiarliyanti', 6, '123455', 3, 2, 1, 'redita.arifin', '2017-05-10 08:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan_skema_pembayaran`
--

CREATE TABLE `pengajuan_skema_pembayaran` (
  `pengajuan_id` int(11) NOT NULL,
  `golongan_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `gaji_pribadi` int(11) DEFAULT NULL,
  `gaji_wali1` int(11) DEFAULT NULL,
  `gaji_wali2` int(11) DEFAULT NULL,
  `nilai_tagihan_air` int(11) DEFAULT NULL,
  `nilai_tagihan_listrik` int(11) DEFAULT NULL,
  `nilai_tagihan_telepon` int(11) DEFAULT NULL,
  `surat_keterangan_rtrw` varchar(255) DEFAULT NULL,
  `foto_rumah` varchar(255) NOT NULL,
  `slip_gaji_pribadi` varchar(255) DEFAULT NULL,
  `slip_gaji_wali1` varchar(255) DEFAULT NULL,
  `slip_gaji_wali2` varchar(255) DEFAULT NULL,
  `tagihan_air` varchar(255) DEFAULT NULL,
  `tagihan_listrik` varchar(255) DEFAULT NULL,
  `tagihan_telepon` varchar(255) DEFAULT NULL,
  `status_pengajuan` varchar(255) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengajuan_skema_pembayaran`
--

INSERT INTO `pengajuan_skema_pembayaran` (`pengajuan_id`, `golongan_id`, `username`, `gaji_pribadi`, `gaji_wali1`, `gaji_wali2`, `nilai_tagihan_air`, `nilai_tagihan_listrik`, `nilai_tagihan_telepon`, `surat_keterangan_rtrw`, `foto_rumah`, `slip_gaji_pribadi`, `slip_gaji_wali1`, `slip_gaji_wali2`, `tagihan_air`, `tagihan_listrik`, `tagihan_telepon`, `status_pengajuan`, `komentar`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 2, 'benathavia.saladdin', 5000000, 3000000, 1000000, 400000, 100000, 0, 'fr1.jpg', 'sgp1.jpg', 'sgw11.jpg', 'sgw21.jpg', NULL, 'ta1.jpg', 'tl1.jpg', 'tt1.jpg', 'Unverified', NULL, 'benathavia.saladdin', '2017-05-10 08:00:00', 'benathavia.saladdin', '2017-05-10 08:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `program_id` int(11) NOT NULL,
  `nama_program` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`program_id`, `nama_program`) VALUES
(1, 'Reguler'),
(2, 'Paralel'),
(3, 'KKI');

-- --------------------------------------------------------

--
-- Table structure for table `program_studi`
--

CREATE TABLE `program_studi` (
  `program_studi_id` int(11) NOT NULL,
  `program_id` int(11) NOT NULL,
  `fakultas_id` int(11) NOT NULL,
  `jenjang_id` int(11) NOT NULL,
  `nama_program_studi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `program_studi`
--

INSERT INTO `program_studi` (`program_studi_id`, `program_id`, `fakultas_id`, `jenjang_id`, `nama_program_studi`) VALUES
(3, 1, 3, 1, 'Biologi'),
(4, 1, 3, 1, 'Ilmu Kimia'),
(5, 1, 3, 1, 'Ilmu Fisika'),
(6, 1, 3, 2, 'Ilmu Geografi'),
(7, 2, 3, 2, 'Biologi'),
(8, 2, 3, 2, 'Ilmu Kimia'),
(9, 2, 3, 3, 'Ilmu Fisika'),
(10, 2, 3, 3, 'Ilmu Geografi'),
(11, 1, 4, 3, 'Teknik Sipil'),
(12, 1, 4, 1, 'Teknik Mesin'),
(13, 1, 4, 1, 'Teknik Elektro'),
(14, 1, 4, 1, 'Teknik Metalurgi dan'),
(15, 1, 4, 2, 'Ilmu Arsitektur'),
(16, 1, 4, 2, 'Teknik Kimia'),
(17, 1, 4, 2, 'Teknik Industri'),
(18, 1, 4, 3, 'Arsitektur Interior'),
(19, 1, 4, 3, 'Teknik Perkapalan'),
(20, 1, 4, 3, 'Teknik Lingkungan'),
(21, 1, 4, 1, 'Teknik Komputer'),
(22, 1, 4, 2, 'Teknik Bioproses');

-- --------------------------------------------------------

--
-- Table structure for table `provinsi`
--

CREATE TABLE `provinsi` (
  `provinsi_id` int(11) NOT NULL,
  `nama_provinsi` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `provinsi`
--

INSERT INTO `provinsi` (`provinsi_id`, `nama_provinsi`) VALUES
(11, 'Aceh'),
(12, 'Sumatera Utara'),
(13, 'Sumatera Barat'),
(14, 'Riau'),
(15, 'Jambi'),
(16, 'Sumatera Selata'),
(17, 'Bengkulu'),
(18, 'Lampung'),
(19, 'Kepulauan Bangk'),
(21, 'Kepulauan Riau'),
(31, 'Dki Jakarta'),
(32, 'Jawa Barat'),
(33, 'Jawa Tengah'),
(34, 'Di Yogyakarta'),
(35, 'Jawa Timur'),
(36, 'Banten'),
(51, 'Bali'),
(52, 'Nusa Tenggara B'),
(53, 'Nusa Tenggara T'),
(61, 'Kalimantan Bara'),
(62, 'Kalimantan Teng'),
(63, 'Kalimantan Sela'),
(64, 'Kalimantan Timu'),
(65, 'Kalimantan Utar'),
(71, 'Sulawesi Utara'),
(72, 'Sulawesi Tengah'),
(73, 'Sulawesi Selata'),
(74, 'Sulawesi Tengga'),
(75, 'Gorontalo'),
(76, 'Sulawesi Barat'),
(81, 'Maluku'),
(82, 'Maluku Utara'),
(91, 'Papua Barat'),
(94, 'Papua');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nama_role` varchar(20) NOT NULL,
  `flag_aktif` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `nama_role`, `flag_aktif`) VALUES
(1, 'Calon Mahasiswa', 1),
(2, 'Verifikator', 1),
(3, 'Staf Registrasi', 1),
(4, 'Staf Kesejahteraan M', 1),
(5, 'Staf Kesehatan Mahas', 1),
(6, 'Manajer Pendidikan', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rumpun`
--

CREATE TABLE `rumpun` (
  `rumpun_id` int(11) NOT NULL,
  `nama_rumpun` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rumpun`
--

INSERT INTO `rumpun` (`rumpun_id`, `nama_rumpun`) VALUES
(1, 'Sains dan Teknologi'),
(2, 'Sosial Humaniora'),
(3, 'Kesehatan');

-- --------------------------------------------------------

--
-- Table structure for table `skema_pembayaran`
--

CREATE TABLE `skema_pembayaran` (
  `golongan_id` int(11) NOT NULL,
  `jumlah_biaya_ipa` int(11) NOT NULL,
  `uang_pangkal_ipa` int(11) NOT NULL,
  `jumlah_biaya_ips` int(11) NOT NULL,
  `uang_pangkal_ips` int(11) NOT NULL,
  `jumlah_biaya_ik` int(11) NOT NULL,
  `uang_pangkal_ik` int(11) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skema_pembayaran`
--

INSERT INTO `skema_pembayaran` (`golongan_id`, `jumlah_biaya_ipa`, `uang_pangkal_ipa`, `jumlah_biaya_ips`, `uang_pangkal_ips`, `jumlah_biaya_ik`, `uang_pangkal_ik`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 7000000, 0, 5000000, 0, 10000000, 0, 'irsyadillah.nuralifa', '2017-05-10 08:00:00', 'irsyadillah.nuralifa', '2017-05-10 08:00:00'),
(2, 9500000, 3000000, 7500000, 2500000, 10000000, 5000000, 'irsyadillah.nuralifa', '2017-05-10 08:10:00', 'irsyadillah.nuralifa', '2017-05-10 08:00:00'),
(3, 12500000, 30000000, 9500000, 5000000, 15000000, 7500000, 'irsyadillah.nuralifa', '2017-05-10 08:20:00', 'irsyadillah.nuralifa', '2017-05-10 08:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `sso`
--

CREATE TABLE `sso` (
  `uid` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sso`
--

INSERT INTO `sso` (`uid`, `password`, `created_by`, `created_at`) VALUES
('anin.lia', 'bd506e41bb242cad9dda81422cf3eaa7', 'redita.arifin', '2017-05-10 08:00:00'),
('benathavia.saladdin', '9d5d33943357a75df3cd450fd8d60cac', 'redita.arifin', '2017-05-10 08:05:00'),
('dwi.arief', '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'redita.arifin', '2017-05-10 08:10:00'),
('fikri.halim', 'ffe553694f5096471590343432359e02', 'redita.arifin', '2017-05-10 08:15:00'),
('hardyn.adiyoso', 'ffe553694f5096471590343432359e02', 'redita.arifin', '2017-05-10 08:20:00'),
('irsyadillah.nuralifa', 'ffe553694f5096471590343432359e02', 'redita.arifin', '2017-05-10 08:25:00'),
('lia.naren', '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'redita.arifin', '2017-05-10 08:30:00'),
('naren.jul', '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'redita.arifin', '2017-05-10 08:35:00'),
('redita.arifin', 'ffe553694f5096471590343432359e02', 'anin.lia', '2017-05-10 08:40:00'),
('widiarliyanti', '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'redita.arifin', '2017-05-10 08:45:00'),
('wilson.mokoginta', 'ffe553694f5096471590343432359e02', 'redita.arifin', '2017-05-10 08:50:00');

-- --------------------------------------------------------

--
-- Table structure for table `staf`
--

CREATE TABLE `staf` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL,
  `uid_sso` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf`
--

INSERT INTO `staf` (`username`, `nip`, `uid_sso`) VALUES
('anin.lia', '0123456798', 'anin.lia'),
('fikri.halim', '1023456789', 'fikri.halim'),
('irsyadillah.nuralifa', '0123546789', 'irsyadillah.nuralifa'),
('redita.arifin', '0123457689', 'redita.arifin'),
('wilson.mokoginta', '0132456789', 'wilson.mokoginta');

-- --------------------------------------------------------

--
-- Table structure for table `staf_kesehatan`
--

CREATE TABLE `staf_kesehatan` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf_kesehatan`
--

INSERT INTO `staf_kesehatan` (`username`, `nip`) VALUES
('wilson.mokoginta', '0132456789');

-- --------------------------------------------------------

--
-- Table structure for table `staf_kesejahteraan`
--

CREATE TABLE `staf_kesejahteraan` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf_kesejahteraan`
--

INSERT INTO `staf_kesejahteraan` (`username`, `nip`) VALUES
('irsyadillah.nuralifa', '0123546789');

-- --------------------------------------------------------

--
-- Table structure for table `staf_manajer_pendidikan`
--

CREATE TABLE `staf_manajer_pendidikan` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf_manajer_pendidikan`
--

INSERT INTO `staf_manajer_pendidikan` (`username`, `nip`) VALUES
('fikri.halim', '1023456789');

-- --------------------------------------------------------

--
-- Table structure for table `staf_registrasi`
--

CREATE TABLE `staf_registrasi` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf_registrasi`
--

INSERT INTO `staf_registrasi` (`username`, `nip`) VALUES
('redita.arifin', '0123457689');

-- --------------------------------------------------------

--
-- Table structure for table `tingkat_pendidikan`
--

CREATE TABLE `tingkat_pendidikan` (
  `tingkat_pendidikan_id` int(11) NOT NULL,
  `nama_tingkat_pendidikan` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tingkat_pendidikan`
--

INSERT INTO `tingkat_pendidikan` (`tingkat_pendidikan_id`, `nama_tingkat_pendidikan`) VALUES
(1, 'SMA'),
(2, 'Universitas');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `id_role` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `flag_aktif` int(11) NOT NULL,
  `profile_picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `id_role`, `password`, `nama_lengkap`, `email`, `flag_aktif`, `profile_picture`) VALUES
('anin.lia', 2, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Anin Lia', 'anin.lia@gmail.com', 1, ''),
('benathavia.saladdin', 1, '$2a$06$.kOv0AaAQVQRhTwN1hT7zuH7f6R3l2J9K.aHmM6.n6JfxSIdznzve', 'Benathavia Saladdin', 'benathavia.saladdin@ui.ac.id', 1, ''),
('dwi.arief', 1, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Dwi Arief', 'dwi.arief@gmail.com', 1, ''),
('fikri.halim', 6, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Fikri Halim Perdana Kusuma', 'fikri.halim@ui.ac.id', 1, ''),
('hardyn.adiyoso', 1, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Hardyn Adiyoso Alexander', 'hardyn.adiyoso@gmail.com', 1, ''),
('irsyadillah.nuralifa', 4, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Irsyadillah Nuralifa', 'irsyadillah.nuralifa@ui.ac.id', 1, ''),
('lia.naren', 1, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Lia Naren', 'lia.naren@gmail.com', 1, ''),
('naren.jul', 1, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Naren Jul', 'naren.jul@gmail.com', 1, ''),
('redita.arifin', 3, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Redita Arifin', 'redita.arifin@ui.ac.id', 1, ''),
('widiarliyanti', 1, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Widiarliyanti', 'widiarliyanti@gmail.com', 1, ''),
('wilson.mokoginta', 5, '$2a$06$HcWwssC6E6XbFGMasMF9QODDvTn0RjHEs4Q5mGtAoqHEyiZZ.bJLe', 'Wilson Mokoginta', 'wilson.mokoginta@ui.ac.id', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `verifikator_fakultas`
--

CREATE TABLE `verifikator_fakultas` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `verifikator_fakultas`
--

INSERT INTO `verifikator_fakultas` (`username`, `nip`) VALUES
('anin.lia', '0123456798');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agama`
--
ALTER TABLE `agama`
  ADD PRIMARY KEY (`agama_id`);

--
-- Indexes for table `alamat`
--
ALTER TABLE `alamat`
  ADD PRIMARY KEY (`jalan_id`),
  ADD KEY `kota_kabupaten_id` (`kota_kabupaten_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `asuransi_kesehatan`
--
ALTER TABLE `asuransi_kesehatan`
  ADD PRIMARY KEY (`nomor_asuransi`),
  ADD KEY `username` (`username`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`biodata_id`),
  ADD KEY `username` (`username`),
  ADD KEY `jalan_id` (`jalan_id`),
  ADD KEY `agama_id` (`agama_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  ADD PRIMARY KEY (`data_kesehatan_id`),
  ADD KEY `username` (`username`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`fakultas_id`),
  ADD KEY `rumpun_id` (`rumpun_id`);

--
-- Indexes for table `ijazah`
--
ALTER TABLE `ijazah`
  ADD PRIMARY KEY (`nomor_ijazah`),
  ADD KEY `username` (`username`),
  ADD KEY `institusi_id` (`institusi_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `institusi`
--
ALTER TABLE `institusi`
  ADD PRIMARY KEY (`institusi_id`),
  ADD KEY `tingkat_pendidikan_id` (`tingkat_pendidikan_id`);

--
-- Indexes for table `jadwal_ept`
--
ALTER TABLE `jadwal_ept`
  ADD PRIMARY KEY (`jadwal_ept_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `jadwal_registrasi`
--
ALTER TABLE `jadwal_registrasi`
  ADD PRIMARY KEY (`jadwal_registrasi_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `jadwal_tes_kesehatan`
--
ALTER TABLE `jadwal_tes_kesehatan`
  ADD PRIMARY KEY (`jadwal_tes_kesehatan_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `jenjang`
--
ALTER TABLE `jenjang`
  ADD PRIMARY KEY (`jenjang_id`);

--
-- Indexes for table `kota_kabupaten`
--
ALTER TABLE `kota_kabupaten`
  ADD PRIMARY KEY (`kota_kabupaten_id`),
  ADD KEY `provinsi_id` (`provinsi_id`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`username`,`npm`),
  ADD KEY `uid_sso` (`uid_sso`),
  ADD KEY `program_studi_id` (`program_studi_id`),
  ADD KEY `jadwal_registrasi_id` (`jadwal_registrasi_id`),
  ADD KEY `jadwal_tes_kesehatan_id` (`jadwal_tes_kesehatan_id`),
  ADD KEY `jadwal_ept_id` (`jadwal_ept_id`),
  ADD KEY `created_by` (`created_by`);

--
-- Indexes for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  ADD PRIMARY KEY (`pengajuan_id`),
  ADD KEY `golongan_id` (`golongan_id`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`program_id`);

--
-- Indexes for table `program_studi`
--
ALTER TABLE `program_studi`
  ADD PRIMARY KEY (`program_studi_id`),
  ADD KEY `program_id` (`program_id`),
  ADD KEY `fakultas_id` (`fakultas_id`),
  ADD KEY `jenjang_id` (`jenjang_id`);

--
-- Indexes for table `provinsi`
--
ALTER TABLE `provinsi`
  ADD PRIMARY KEY (`provinsi_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `rumpun`
--
ALTER TABLE `rumpun`
  ADD PRIMARY KEY (`rumpun_id`);

--
-- Indexes for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  ADD PRIMARY KEY (`golongan_id`),
  ADD KEY `created_by` (`created_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `sso`
--
ALTER TABLE `sso`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `created_by` (`created_by`);

--
-- Indexes for table `staf`
--
ALTER TABLE `staf`
  ADD PRIMARY KEY (`username`,`nip`),
  ADD KEY `uid_sso` (`uid_sso`);

--
-- Indexes for table `staf_kesehatan`
--
ALTER TABLE `staf_kesehatan`
  ADD PRIMARY KEY (`username`,`nip`);

--
-- Indexes for table `staf_kesejahteraan`
--
ALTER TABLE `staf_kesejahteraan`
  ADD PRIMARY KEY (`username`,`nip`);

--
-- Indexes for table `staf_manajer_pendidikan`
--
ALTER TABLE `staf_manajer_pendidikan`
  ADD PRIMARY KEY (`username`,`nip`);

--
-- Indexes for table `staf_registrasi`
--
ALTER TABLE `staf_registrasi`
  ADD PRIMARY KEY (`username`,`nip`);

--
-- Indexes for table `tingkat_pendidikan`
--
ALTER TABLE `tingkat_pendidikan`
  ADD PRIMARY KEY (`tingkat_pendidikan_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `verifikator_fakultas`
--
ALTER TABLE `verifikator_fakultas`
  ADD PRIMARY KEY (`username`,`nip`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agama`
--
ALTER TABLE `agama`
  MODIFY `agama_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `alamat`
--
ALTER TABLE `alamat`
  MODIFY `jalan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `biodata`
--
ALTER TABLE `biodata`
  MODIFY `biodata_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  MODIFY `data_kesehatan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `fakultas`
--
ALTER TABLE `fakultas`
  MODIFY `fakultas_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `institusi`
--
ALTER TABLE `institusi`
  MODIFY `institusi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `jadwal_ept`
--
ALTER TABLE `jadwal_ept`
  MODIFY `jadwal_ept_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `jadwal_registrasi`
--
ALTER TABLE `jadwal_registrasi`
  MODIFY `jadwal_registrasi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `jadwal_tes_kesehatan`
--
ALTER TABLE `jadwal_tes_kesehatan`
  MODIFY `jadwal_tes_kesehatan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `jenjang`
--
ALTER TABLE `jenjang`
  MODIFY `jenjang_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  MODIFY `pengajuan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `program`
--
ALTER TABLE `program`
  MODIFY `program_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `program_studi`
--
ALTER TABLE `program_studi`
  MODIFY `program_studi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `rumpun`
--
ALTER TABLE `rumpun`
  MODIFY `rumpun_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  MODIFY `golongan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tingkat_pendidikan`
--
ALTER TABLE `tingkat_pendidikan`
  MODIFY `tingkat_pendidikan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `alamat`
--
ALTER TABLE `alamat`
  ADD CONSTRAINT `alamat_ibfk_1` FOREIGN KEY (`kota_kabupaten_id`) REFERENCES `kota_kabupaten` (`kota_kabupaten_id`),
  ADD CONSTRAINT `alamat_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `alamat_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `asuransi_kesehatan`
--
ALTER TABLE `asuransi_kesehatan`
  ADD CONSTRAINT `asuransi_kesehatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`),
  ADD CONSTRAINT `asuransi_kesehatan_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `asuransi_kesehatan_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `biodata`
--
ALTER TABLE `biodata`
  ADD CONSTRAINT `biodata_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`),
  ADD CONSTRAINT `biodata_ibfk_2` FOREIGN KEY (`jalan_id`) REFERENCES `alamat` (`jalan_id`),
  ADD CONSTRAINT `biodata_ibfk_3` FOREIGN KEY (`agama_id`) REFERENCES `agama` (`agama_id`),
  ADD CONSTRAINT `biodata_ibfk_4` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `biodata_ibfk_5` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  ADD CONSTRAINT `data_kesehatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`),
  ADD CONSTRAINT `data_kesehatan_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `data_kesehatan_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD CONSTRAINT `fakultas_ibfk_1` FOREIGN KEY (`rumpun_id`) REFERENCES `rumpun` (`rumpun_id`);

--
-- Constraints for table `ijazah`
--
ALTER TABLE `ijazah`
  ADD CONSTRAINT `ijazah_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`),
  ADD CONSTRAINT `ijazah_ibfk_2` FOREIGN KEY (`institusi_id`) REFERENCES `institusi` (`institusi_id`),
  ADD CONSTRAINT `ijazah_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `ijazah_ibfk_4` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `institusi`
--
ALTER TABLE `institusi`
  ADD CONSTRAINT `institusi_ibfk_1` FOREIGN KEY (`tingkat_pendidikan_id`) REFERENCES `tingkat_pendidikan` (`tingkat_pendidikan_id`);

--
-- Constraints for table `jadwal_ept`
--
ALTER TABLE `jadwal_ept`
  ADD CONSTRAINT `jadwal_ept_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `jadwal_ept_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `jadwal_registrasi`
--
ALTER TABLE `jadwal_registrasi`
  ADD CONSTRAINT `jadwal_registrasi_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `jadwal_registrasi_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `jadwal_registrasi_ibfk_3` FOREIGN KEY (`fakultas_id`) REFERENCES `fakultas` (`fakultas_id`);

--
-- Constraints for table `jadwal_tes_kesehatan`
--
ALTER TABLE `jadwal_tes_kesehatan`
  ADD CONSTRAINT `jadwal_tes_kesehatan_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `jadwal_tes_kesehatan_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `kota_kabupaten`
--
ALTER TABLE `kota_kabupaten`
  ADD CONSTRAINT `kota_kabupaten_ibfk_1` FOREIGN KEY (`provinsi_id`) REFERENCES `provinsi` (`provinsi_id`);

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `mahasiswa_ibfk_2` FOREIGN KEY (`uid_sso`) REFERENCES `sso` (`uid`),
  ADD CONSTRAINT `mahasiswa_ibfk_3` FOREIGN KEY (`program_studi_id`) REFERENCES `program_studi` (`program_studi_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_4` FOREIGN KEY (`jadwal_registrasi_id`) REFERENCES `jadwal_registrasi` (`jadwal_registrasi_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_5` FOREIGN KEY (`jadwal_tes_kesehatan_id`) REFERENCES `jadwal_tes_kesehatan` (`jadwal_tes_kesehatan_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_6` FOREIGN KEY (`jadwal_ept_id`) REFERENCES `jadwal_ept` (`jadwal_ept_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_7` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  ADD CONSTRAINT `pengajuan_skema_pembayaran_ibfk_1` FOREIGN KEY (`golongan_id`) REFERENCES `skema_pembayaran` (`golongan_id`),
  ADD CONSTRAINT `pengajuan_skema_pembayaran_ibfk_2` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`);

--
-- Constraints for table `program_studi`
--
ALTER TABLE `program_studi`
  ADD CONSTRAINT `program_studi_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`),
  ADD CONSTRAINT `program_studi_ibfk_2` FOREIGN KEY (`fakultas_id`) REFERENCES `fakultas` (`fakultas_id`);

--
-- Constraints for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  ADD CONSTRAINT `skema_pembayaran_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `skema_pembayaran_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `sso`
--
ALTER TABLE `sso`
  ADD CONSTRAINT `sso_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `staf`
--
ALTER TABLE `staf`
  ADD CONSTRAINT `staf_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `staf_ibfk_2` FOREIGN KEY (`uid_sso`) REFERENCES `sso` (`uid`);

--
-- Constraints for table `staf_kesehatan`
--
ALTER TABLE `staf_kesehatan`
  ADD CONSTRAINT `staf_kesehatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `staf` (`username`);

--
-- Constraints for table `staf_kesejahteraan`
--
ALTER TABLE `staf_kesejahteraan`
  ADD CONSTRAINT `staf_kesejahteraan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `staf` (`username`);

--
-- Constraints for table `staf_registrasi`
--
ALTER TABLE `staf_registrasi`
  ADD CONSTRAINT `staf_registrasi_ibfk_1` FOREIGN KEY (`username`) REFERENCES `staf` (`username`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Constraints for table `verifikator_fakultas`
--
ALTER TABLE `verifikator_fakultas`
  ADD CONSTRAINT `verifikator_fakultas_ibfk_1` FOREIGN KEY (`username`) REFERENCES `staf` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
