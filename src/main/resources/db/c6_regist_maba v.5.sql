-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2017 at 10:42 AM
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
-- Table structure for table `alamat`
--

CREATE TABLE `alamat` (
  `jalan_id` int(11) NOT NULL,
  `kota_kabupaten_id` int(11) NOT NULL,
  `jalan` varchar(30) NOT NULL,
  `kecamatan` varchar(12) NOT NULL,
  `kelurahan` varchar(12) NOT NULL,
  `kode_pos` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alamat`
--

INSERT INTO `alamat` (`jalan_id`, `kota_kabupaten_id`, `jalan`, `kecamatan`, `kelurahan`, `kode_pos`) VALUES
(1, 1102, 'Jalan Harum', 'Bunga', 'Semerbak', '11120'),
(2, 1107, 'Jalan Wangi', 'Kembang', 'Mekar', '11121'),
(3, 1111, 'Jalan Sehat', 'Jalan Cepat', 'Jalan Ditemp', '11122'),
(4, 1117, 'Jalan Pagi', 'Jalan Sore', 'Jalan Malem', '11123'),
(5, 1201, 'Jalan Jalan', 'Dufan', 'Ancol', '11124'),
(6, 1202, 'Jalan Kehidupan', 'Kali Bolong', 'Kali Aja', '11125');

-- --------------------------------------------------------

--
-- Table structure for table `asuransi_kesehatan`
--

CREATE TABLE `asuransi_kesehatan` (
  `nomor_asuransi` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `nomor_penerbit_asuransi` varchar(30) NOT NULL,
  `expired_date` date NOT NULL,
  `scan_kartu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asuransi_kesehatan`
--

INSERT INTO `asuransi_kesehatan` (`nomor_asuransi`, `username`, `nomor_penerbit_asuransi`, `expired_date`, `scan_kartu`) VALUES
('12345678', 'benathavia.saladdin', '10001010', '2020-12-31', 'sk1.jpg'),
('24688642', 'hardyn.adiyoso', '20002020', '2021-01-01', 'sk2.jpg');

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
  `ukuran_jaket` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`biodata_id`, `username`, `jalan_id`, `tanggal_lahir`, `jenis_kelamin`, `nomor_telepon`, `kewarganegaraan`, `nomor_ktp`, `sidik_jari`, `scan_ktp`, `scan_kk`, `scan_surat_pernyataan_mahasiswa`, `status_verifikasi`, `flag_aktif`, `ukuran_jaket`) VALUES
(5, 'benathavia.saladdin', 1, '0000-00-00', 'L', '085700000001', 'WNI', '1234567890123456', 'sj1.jpg', 'sktp1.jpg', 'skk1.jpg', 'sspm1.jpg', 'Unverified', '1', 'M'),
(6, 'hardyn.adiyoso', 2, '0000-00-00', 'P', '085700000002', 'WNI', '1234567890123457', 'sj2.jpg', 'sktp2.jpg', 'skk2.jpg', 'sspm2.jpg', 'Verified', '1', 'L');

-- --------------------------------------------------------

--
-- Table structure for table `data_kesehatan`
--

CREATE TABLE `data_kesehatan` (
  `data_kesehatan_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `form_survey_kesehatan` varchar(255) NOT NULL,
  `hasil_tes_kesehatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_kesehatan`
--

INSERT INTO `data_kesehatan` (`data_kesehatan_id`, `username`, `form_survey_kesehatan`, `hasil_tes_kesehatan`) VALUES
(1, 'benathavia.saladdin', 'survey1.pdf', 'test1.pdf'),
(2, 'hardyn.adiyoso', 'survey2.pdf', 'test2.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE `fakultas` (
  `fakultas_id` int(11) NOT NULL,
  `nama_fakultas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`fakultas_id`, `nama_fakultas`) VALUES
(1, 'Kedokteran'),
(2, 'Kedokteran Gigi'),
(3, 'Matematika dan Ilmu Pengetahuan Alam'),
(4, 'Teknik'),
(5, 'Hukum'),
(6, 'Ekonomi dan Bisnis'),
(7, 'Psikologi'),
(8, 'Ilmu Pengetahuan Budaya'),
(9, 'Ilmu Pengetahuan Sosial dan Ilmu Politik'),
(10, 'Kesehatan Masyarakat'),
(11, 'Ilmu Komputer'),
(12, 'Ilmu Keperawatan'),
(13, 'Farmasi'),
(14, 'Ilmu Administrasi'),
(15, 'Vokasi'),
(16, 'Sekolah Ilmu Lingkungan'),
(17, 'Sekolah Kajian Strategik dan Global');

-- --------------------------------------------------------

--
-- Table structure for table `ijazah`
--

CREATE TABLE `ijazah` (
  `nomor_ijazah` varchar(30) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `nama_institusi` varchar(255) NOT NULL,
  `jenjang` varchar(10) NOT NULL,
  `scan_ijazah` varchar(255) NOT NULL,
  `scan_pernyataan_ijazah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ijazah`
--

INSERT INTO `ijazah` (`nomor_ijazah`, `username`, `nama_institusi`, `jenjang`, `scan_ijazah`, `scan_pernyataan_ijazah`) VALUES
('14000001', 'benathavia.saladdin', 'SMA Negeri 8 Jakarta', 'SMA', 'ijazah1.jpg', 'spi1.jpg'),
('1406123456', 'hardyn.adiyoso', 'Universitas Indonesia', 'Sarjana', 'ijazah2.jpg', 'spi2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_ept`
--

CREATE TABLE `jadwal_ept` (
  `jadwal_ept_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `timestamp_akhir` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_ept`
--

INSERT INTO `jadwal_ept` (`jadwal_ept_id`, `timestamp_awal`, `timestamp_akhir`) VALUES
(1, '2017-03-25 08:47:11', NULL),
(2, '2017-03-25 08:47:58', NULL),
(3, '2017-03-25 08:48:05', NULL),
(4, '2017-03-25 08:48:09', NULL),
(5, '2017-03-25 08:48:12', NULL),
(6, '2017-03-25 08:48:15', NULL),
(7, '2017-03-25 08:48:18', NULL),
(8, '2017-03-25 08:48:22', NULL),
(9, '2017-03-25 08:48:28', NULL),
(10, '2017-03-25 08:48:32', NULL),
(11, '2017-03-25 08:48:36', NULL),
(12, '2017-03-25 08:48:41', NULL),
(13, '2017-03-25 08:48:46', NULL),
(14, '2017-03-25 08:48:49', NULL),
(15, '2017-03-25 08:48:51', NULL),
(16, '2017-03-25 08:48:54', NULL),
(17, '2017-03-25 08:49:06', NULL),
(18, '2017-03-25 08:49:09', NULL),
(19, '2017-03-25 08:49:13', NULL),
(20, '2017-03-25 08:49:17', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_registrasi`
--

CREATE TABLE `jadwal_registrasi` (
  `jadwal_registrasi_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `timestamp_akhir` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_registrasi`
--

INSERT INTO `jadwal_registrasi` (`jadwal_registrasi_id`, `timestamp_awal`, `timestamp_akhir`) VALUES
(1, '2017-08-22 09:43:12', NULL),
(2, '2017-03-25 08:55:29', NULL),
(3, '2017-03-25 08:55:34', NULL),
(4, '2017-03-25 08:55:37', NULL),
(5, '2017-03-25 08:55:40', NULL),
(6, '2017-03-25 08:55:43', NULL),
(7, '2017-03-25 08:55:46', NULL),
(8, '2017-03-25 08:55:49', NULL),
(9, '2017-03-25 08:55:53', NULL),
(10, '2017-03-25 08:55:58', NULL),
(11, '2017-03-25 08:56:01', NULL),
(12, '2017-03-25 08:56:03', NULL),
(13, '2017-03-25 08:56:06', NULL),
(14, '2017-03-25 08:56:09', NULL),
(15, '2017-03-25 08:56:12', NULL),
(16, '2017-03-25 08:56:15', NULL),
(17, '2017-03-25 08:56:19', NULL),
(18, '2017-03-25 08:56:22', NULL),
(19, '2017-03-25 08:56:29', NULL),
(20, '2017-03-25 08:56:32', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_tes_kesehatan`
--

CREATE TABLE `jadwal_tes_kesehatan` (
  `jadwal_tes_kesehatan_id` int(11) NOT NULL,
  `timestamp_awal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `timestamp_akhir` timestamp NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal_tes_kesehatan`
--

INSERT INTO `jadwal_tes_kesehatan` (`jadwal_tes_kesehatan_id`, `timestamp_awal`, `timestamp_akhir`) VALUES
(1, '2017-03-25 08:57:22', NULL),
(2, '2017-03-25 09:39:42', NULL),
(3, '2017-03-25 09:39:46', NULL),
(4, '2017-03-25 09:39:50', NULL),
(5, '2017-03-25 09:39:55', NULL),
(6, '2017-03-25 09:39:58', NULL),
(7, '2017-03-25 09:40:01', NULL),
(8, '2017-03-25 09:40:04', NULL),
(9, '2017-03-25 09:40:07', NULL),
(10, '2017-03-25 09:40:10', NULL),
(11, '2017-03-25 09:40:14', NULL),
(12, '2017-03-25 09:40:16', NULL),
(13, '2017-03-25 09:40:18', NULL),
(14, '2017-03-25 09:40:20', NULL),
(15, '2017-03-25 09:40:23', NULL),
(16, '2017-03-25 09:40:26', NULL),
(17, '2017-03-25 09:40:30', NULL),
(18, '2017-03-25 09:40:33', NULL),
(19, '2017-03-25 09:40:36', NULL),
(20, '2017-03-25 09:40:38', NULL);

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
  `nama_kota_kabupaten` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota_kabupaten`
--

INSERT INTO `kota_kabupaten` (`kota_kabupaten_id`, `provinsi_id`, `nama_kota_kabupaten`) VALUES
(1101, 11, 'Kab. Simeulue'),
(1102, 11, 'Kab. Aceh Singk'),
(1103, 11, 'Kab. Aceh Selat'),
(1104, 11, 'Kab. Aceh Tengg'),
(1105, 11, 'Kab. Aceh Timur'),
(1106, 11, 'Kab. Aceh Tenga'),
(1107, 11, 'Kab. Aceh Barat'),
(1108, 11, 'Kab. Aceh Besar'),
(1109, 11, 'Kab. Pidie'),
(1110, 11, 'Kab. Bireuen'),
(1111, 11, 'Kab. Aceh Utara'),
(1112, 11, 'Kab. Aceh Barat'),
(1113, 11, 'Kab. Gayo Lues'),
(1114, 11, 'Kab. Aceh Tamia'),
(1115, 11, 'Kab. Nagan Raya'),
(1116, 11, 'Kab. Aceh Jaya'),
(1117, 11, 'Kab. Bener Meri'),
(1118, 11, 'Kab. Pidie Jaya'),
(1171, 11, 'Kota Banda Aceh'),
(1172, 11, 'Kota Sabang'),
(1173, 11, 'Kota Langsa'),
(1174, 11, 'Kota Lhokseumaw'),
(1175, 11, 'Kota Subulussal'),
(1201, 12, 'Kab. Nias'),
(1202, 12, 'Kab. Mandailing'),
(1203, 12, 'Kab. Tapanuli S'),
(1204, 12, 'Kab. Tapanuli T'),
(1205, 12, 'Kab. Tapanuli U'),
(1206, 12, 'Kab. Toba Samos'),
(1207, 12, 'Kab. Labuhan Ba'),
(1208, 12, 'Kab. Asahan'),
(1209, 12, 'Kab. Simalungun'),
(1210, 12, 'Kab. Dairi'),
(1211, 12, 'Kab. Karo'),
(1212, 12, 'Kab. Deli Serda'),
(1213, 12, 'Kab. Langkat'),
(1214, 12, 'Kab. Nias Selat'),
(1215, 12, 'Kab. Humbang Ha'),
(1216, 12, 'Kab. Pakpak Bha'),
(1217, 12, 'Kab. Samosir'),
(1218, 12, 'Kab. Serdang Be'),
(1219, 12, 'Kab. Batu Bara'),
(1220, 12, 'Kab. Padang Law'),
(1221, 12, 'Kab. Padang Law'),
(1222, 12, 'Kab. Labuhan Ba'),
(1223, 12, 'Kab. Labuhan Ba'),
(1224, 12, 'Kab. Nias Utara'),
(1225, 12, 'Kab. Nias Barat'),
(1271, 12, 'Kota Sibolga'),
(1272, 12, 'Kota Tanjung Ba'),
(1273, 12, 'Kota Pematang S'),
(1274, 12, 'Kota Tebing Tin'),
(1275, 12, 'Kota Medan'),
(1276, 12, 'Kota Binjai'),
(1277, 12, 'Kota Padangsidi'),
(1278, 12, 'Kota Gunungsito'),
(1301, 13, 'Kab. Kepulauan '),
(1302, 13, 'Kab. Pesisir Se'),
(1303, 13, 'Kab. Solok'),
(1304, 13, 'Kab. Sijunjung'),
(1305, 13, 'Kab. Tanah Data'),
(1306, 13, 'Kab. Padang Par'),
(1307, 13, 'Kab. Agam'),
(1308, 13, 'Kab. Lima Puluh'),
(1309, 13, 'Kab. Pasaman'),
(1310, 13, 'Kab. Solok Sela'),
(1311, 13, 'Kab. Dharmasray'),
(1312, 13, 'Kab. Pasaman Ba'),
(1371, 13, 'Kota Padang'),
(1372, 13, 'Kota Solok'),
(1373, 13, 'Kota Sawah Lunt'),
(1374, 13, 'Kota Padang Pan'),
(1375, 13, 'Kota Bukittingg'),
(1376, 13, 'Kota Payakumbuh'),
(1377, 13, 'Kota Pariaman'),
(1401, 14, 'Kab. Kuantan Si'),
(1402, 14, 'Kab. Indragiri '),
(1403, 14, 'Kab. Indragiri '),
(1404, 14, 'Kab. Pelalawan'),
(1405, 14, 'Kab. S I A K'),
(1406, 14, 'Kab. Kampar'),
(1407, 14, 'Kab. Rokan Hulu'),
(1408, 14, 'Kab. Bengkalis'),
(1409, 14, 'Kab. Rokan Hili'),
(1410, 14, 'Kab. Kepulauan '),
(1471, 14, 'Kota Pekanbaru'),
(1473, 14, 'Kota D U M A I'),
(1501, 15, 'Kab. Kerinci'),
(1502, 15, 'Kab. Merangin'),
(1503, 15, 'Kab. Sarolangun'),
(1504, 15, 'Kab. Batang Har'),
(1505, 15, 'Kab. Muaro Jamb'),
(1506, 15, 'Kab. Tanjung Ja'),
(1507, 15, 'Kab. Tanjung Ja'),
(1508, 15, 'Kab. Tebo'),
(1509, 15, 'Kab. Bungo'),
(1571, 15, 'Kota Jambi'),
(1572, 15, 'Kota Sungai Pen'),
(1601, 16, 'Kab. Ogan Komer'),
(1602, 16, 'Kab. Ogan Komer'),
(1603, 16, 'Kab. Muara Enim'),
(1604, 16, 'Kab. Lahat'),
(1605, 16, 'Kab. Musi Rawas'),
(1606, 16, 'Kab. Musi Banyu'),
(1607, 16, 'Kab. Banyu Asin'),
(1608, 16, 'Kab. Ogan Komer'),
(1609, 16, 'Kab. Ogan Komer'),
(1610, 16, 'Kab. Ogan Ilir'),
(1611, 16, 'Kab. Empat Lawa'),
(1671, 16, 'Kota Palembang'),
(1672, 16, 'Kota Prabumulih'),
(1673, 16, 'Kota Pagar Alam'),
(1674, 16, 'Kota Lubuklingg'),
(1701, 17, 'Kab. Bengkulu S'),
(1702, 17, 'Kab. Rejang Leb'),
(1703, 17, 'Kab. Bengkulu U'),
(1704, 17, 'Kab. Kaur'),
(1705, 17, 'Kab. Seluma'),
(1706, 17, 'Kab. Mukomuko'),
(1707, 17, 'Kab. Lebong'),
(1708, 17, 'Kab. Kepahiang'),
(1709, 17, 'Kab. Bengkulu T'),
(1771, 17, 'Kota Bengkulu'),
(1801, 18, 'Kab. Lampung Ba'),
(1802, 18, 'Kab. Tanggamus'),
(1803, 18, 'Kab. Lampung Se'),
(1804, 18, 'Kab. Lampung Ti'),
(1805, 18, 'Kab. Lampung Te'),
(1806, 18, 'Kab. Lampung Ut'),
(1807, 18, 'Kab. Way Kanan'),
(1808, 18, 'Kab. Tulangbawa'),
(1809, 18, 'Kab. Pesawaran'),
(1810, 18, 'Kab. Pringsewu'),
(1811, 18, 'Kab. Mesuji'),
(1812, 18, 'Kab. Tulang Baw'),
(1813, 18, 'Kab. Pesisir Ba'),
(1871, 18, 'Kota Bandar Lam'),
(1872, 18, 'Kota Metro'),
(1901, 19, 'Kab. Bangka'),
(1902, 19, 'Kab. Belitung'),
(1903, 19, 'Kab. Bangka Bar'),
(1904, 19, 'Kab. Bangka Ten'),
(1905, 19, 'Kab. Bangka Sel'),
(1906, 19, 'Kab. Belitung T'),
(1971, 19, 'Kota Pangkal Pi'),
(2101, 21, 'Kab. Karimun'),
(2102, 21, 'Kab. Bintan'),
(2103, 21, 'Kab. Natuna'),
(2104, 21, 'Kab. Lingga'),
(2105, 21, 'Kab. Kepulauan '),
(2171, 21, 'Kota B A T A M'),
(2172, 21, 'Kota Tanjung Pi'),
(3101, 31, 'Kab. Kepulauan '),
(3171, 31, 'Kota Jakarta Se'),
(3172, 31, 'Kota Jakarta Ti'),
(3173, 31, 'Kota Jakarta Pu'),
(3174, 31, 'Kota Jakarta Ba'),
(3175, 31, 'Kota Jakarta Ut'),
(3201, 32, 'Kab. Bogor'),
(3202, 32, 'Kab. Sukabumi'),
(3203, 32, 'Kab. Cianjur'),
(3204, 32, 'Kab. Bandung'),
(3205, 32, 'Kab. Garut'),
(3206, 32, 'Kab. Tasikmalay'),
(3207, 32, 'Kab. Ciamis'),
(3208, 32, 'Kab. Kuningan'),
(3209, 32, 'Kab. Cirebon'),
(3210, 32, 'Kab. Majalengka'),
(3211, 32, 'Kab. Sumedang'),
(3212, 32, 'Kab. Indramayu'),
(3213, 32, 'Kab. Subang'),
(3214, 32, 'Kab. Purwakarta'),
(3215, 32, 'Kab. Karawang'),
(3216, 32, 'Kab. Bekasi'),
(3217, 32, 'Kab. Bandung Ba'),
(3218, 32, 'Kab. Pangandara'),
(3271, 32, 'Kota Bogor'),
(3272, 32, 'Kota Sukabumi'),
(3273, 32, 'Kota Bandung'),
(3274, 32, 'Kota Cirebon'),
(3275, 32, 'Kota Bekasi'),
(3276, 32, 'Kota Depok'),
(3277, 32, 'Kota Cimahi'),
(3278, 32, 'Kota Tasikmalay'),
(3279, 32, 'Kota Banjar'),
(3301, 33, 'Kab. Cilacap'),
(3302, 33, 'Kab. Banyumas'),
(3303, 33, 'Kab. Purbalingg'),
(3304, 33, 'Kab. Banjarnega'),
(3305, 33, 'Kab. Kebumen'),
(3306, 33, 'Kab. Purworejo'),
(3307, 33, 'Kab. Wonosobo'),
(3308, 33, 'Kab. Magelang'),
(3309, 33, 'Kab. Boyolali'),
(3310, 33, 'Kab. Klaten'),
(3311, 33, 'Kab. Sukoharjo'),
(3312, 33, 'Kab. Wonogiri'),
(3313, 33, 'Kab. Karanganya'),
(3314, 33, 'Kab. Sragen'),
(3315, 33, 'Kab. Grobogan'),
(3316, 33, 'Kab. Blora'),
(3317, 33, 'Kab. Rembang'),
(3318, 33, 'Kab. Pati'),
(3319, 33, 'Kab. Kudus'),
(3320, 33, 'Kab. Jepara'),
(3321, 33, 'Kab. Demak'),
(3322, 33, 'Kab. Semarang'),
(3323, 33, 'Kab. Temanggung'),
(3324, 33, 'Kab. Kendal'),
(3325, 33, 'Kab. Batang'),
(3326, 33, 'Kab. Pekalongan'),
(3327, 33, 'Kab. Pemalang'),
(3328, 33, 'Kab. Tegal'),
(3329, 33, 'Kab. Brebes'),
(3371, 33, 'Kota Magelang'),
(3372, 33, 'Kota Surakarta'),
(3373, 33, 'Kota Salatiga'),
(3374, 33, 'Kota Semarang'),
(3375, 33, 'Kota Pekalongan'),
(3376, 33, 'Kota Tegal'),
(3401, 34, 'Kab. Kulon Prog'),
(3402, 34, 'Kab. Bantul'),
(3403, 34, 'Kab. Gunung Kid'),
(3404, 34, 'Kab. Sleman'),
(3471, 34, 'Kota Yogyakarta'),
(3501, 35, 'Kab. Pacitan'),
(3502, 35, 'Kab. Ponorogo'),
(3503, 35, 'Kab. Trenggalek'),
(3504, 35, 'Kab. Tulungagun'),
(3505, 35, 'Kab. Blitar'),
(3506, 35, 'Kab. Kediri'),
(3507, 35, 'Kab. Malang'),
(3508, 35, 'Kab. Lumajang'),
(3509, 35, 'Kab. Jember'),
(3510, 35, 'Kab. Banyuwangi'),
(3511, 35, 'Kab. Bondowoso'),
(3512, 35, 'Kab. Situbondo'),
(3513, 35, 'Kab. Probolingg'),
(3514, 35, 'Kab. Pasuruan'),
(3515, 35, 'Kab. Sidoarjo'),
(3516, 35, 'Kab. Mojokerto'),
(3517, 35, 'Kab. Jombang'),
(3518, 35, 'Kab. Nganjuk'),
(3519, 35, 'Kab. Madiun'),
(3520, 35, 'Kab. Magetan'),
(3521, 35, 'Kab. Ngawi'),
(3522, 35, 'Kab. Bojonegoro'),
(3523, 35, 'Kab. Tuban'),
(3524, 35, 'Kab. Lamongan'),
(3525, 35, 'Kab. Gresik'),
(3526, 35, 'Kab. Bangkalan'),
(3527, 35, 'Kab. Sampang'),
(3528, 35, 'Kab. Pamekasan'),
(3529, 35, 'Kab. Sumenep'),
(3571, 35, 'Kota Kediri'),
(3572, 35, 'Kota Blitar'),
(3573, 35, 'Kota Malang'),
(3574, 35, 'Kota Probolingg'),
(3575, 35, 'Kota Pasuruan'),
(3576, 35, 'Kota Mojokerto'),
(3577, 35, 'Kota Madiun'),
(3578, 35, 'Kota Surabaya'),
(3579, 35, 'Kota Batu'),
(3601, 36, 'Kab. Pandeglang'),
(3602, 36, 'Kab. Lebak'),
(3603, 36, 'Kab. Tangerang'),
(3604, 36, 'Kab. Serang'),
(3671, 36, 'Kota Tangerang'),
(3672, 36, 'Kota Cilegon'),
(3673, 36, 'Kota Serang'),
(3674, 36, 'Kota Tangerang '),
(5101, 51, 'Kab. Jembrana'),
(5102, 51, 'Kab. Tabanan'),
(5103, 51, 'Kab. Badung'),
(5104, 51, 'Kab. Gianyar'),
(5105, 51, 'Kab. Klungkung'),
(5106, 51, 'Kab. Bangli'),
(5107, 51, 'Kab. Karang Ase'),
(5108, 51, 'Kab. Buleleng'),
(5171, 51, 'Kota Denpasar'),
(5201, 52, 'Kab. Lombok Bar'),
(5202, 52, 'Kab. Lombok Ten'),
(5203, 52, 'Kab. Lombok Tim'),
(5204, 52, 'Kab. Sumbawa'),
(5205, 52, 'Kab. Dompu'),
(5206, 52, 'Kab. Bima'),
(5207, 52, 'Kab. Sumbawa Ba'),
(5208, 52, 'Kab. Lombok Uta'),
(5271, 52, 'Kota Mataram'),
(5272, 52, 'Kota Bima'),
(5301, 53, 'Kab. Sumba Bara'),
(5302, 53, 'Kab. Sumba Timu'),
(5303, 53, 'Kab. Kupang'),
(5304, 53, 'Kab. Timor Teng'),
(5305, 53, 'Kab. Timor Teng'),
(5306, 53, 'Kab. Belu'),
(5307, 53, 'Kab. Alor'),
(5308, 53, 'Kab. Lembata'),
(5309, 53, 'Kab. Flores Tim'),
(5310, 53, 'Kab. Sikka'),
(5311, 53, 'Kab. Ende'),
(5312, 53, 'Kab. Ngada'),
(5313, 53, 'Kab. Manggarai'),
(5314, 53, 'Kab. Rote Ndao'),
(5315, 53, 'Kab. Manggarai '),
(5316, 53, 'Kab. Sumba Teng'),
(5317, 53, 'Kab. Sumba Bara'),
(5318, 53, 'Kab. Nagekeo'),
(5319, 53, 'Kab. Manggarai '),
(5320, 53, 'Kab. Sabu Raiju'),
(5371, 53, 'Kota Kupang'),
(6101, 61, 'Kab. Sambas'),
(6102, 61, 'Kab. Bengkayang'),
(6103, 61, 'Kab. Landak'),
(6104, 61, 'Kab. Pontianak'),
(6105, 61, 'Kab. Sanggau'),
(6106, 61, 'Kab. Ketapang'),
(6107, 61, 'Kab. Sintang'),
(6108, 61, 'Kab. Kapuas Hul'),
(6109, 61, 'Kab. Sekadau'),
(6110, 61, 'Kab. Melawi'),
(6111, 61, 'Kab. Kayong Uta'),
(6112, 61, 'Kab. Kubu Raya'),
(6171, 61, 'Kota Pontianak'),
(6172, 61, 'Kota Singkawang'),
(6201, 62, 'Kab. Kotawaring'),
(6202, 62, 'Kab. Kotawaring'),
(6203, 62, 'Kab. Kapuas'),
(6204, 62, 'Kab. Barito Sel'),
(6205, 62, 'Kab. Barito Uta'),
(6206, 62, 'Kab. Sukamara'),
(6207, 62, 'Kab. Lamandau'),
(6208, 62, 'Kab. Seruyan'),
(6209, 62, 'Kab. Katingan'),
(6210, 62, 'Kab. Pulang Pis'),
(6211, 62, 'Kab. Gunung Mas'),
(6212, 62, 'Kab. Barito Tim'),
(6213, 62, 'Kab. Murung Ray'),
(6271, 62, 'Kota Palangka R'),
(6301, 63, 'Kab. Tanah Laut'),
(6302, 63, 'Kab. Kota Baru'),
(6303, 63, 'Kab. Banjar'),
(6304, 63, 'Kab. Barito Kua'),
(6305, 63, 'Kab. Tapin'),
(6306, 63, 'Kab. Hulu Sunga'),
(6307, 63, 'Kab. Hulu Sunga'),
(6308, 63, 'Kab. Hulu Sunga'),
(6309, 63, 'Kab. Tabalong'),
(6310, 63, 'Kab. Tanah Bumb'),
(6311, 63, 'Kab. Balangan'),
(6371, 63, 'Kota Banjarmasi'),
(6372, 63, 'Kota Banjar Bar'),
(6401, 64, 'Kab. Paser'),
(6402, 64, 'Kab. Kutai Bara'),
(6403, 64, 'Kab. Kutai Kart'),
(6404, 64, 'Kab. Kutai Timu'),
(6405, 64, 'Kab. Berau'),
(6409, 64, 'Kab. Penajam Pa'),
(6471, 64, 'Kota Balikpapan'),
(6472, 64, 'Kota Samarinda'),
(6474, 64, 'Kota Bontang'),
(6501, 65, 'Kab. Malinau'),
(6502, 65, 'Kab. Bulungan'),
(6503, 65, 'Kab. Tana Tidun'),
(6504, 65, 'Kab. Nunukan'),
(6571, 65, 'Kota Tarakan'),
(7101, 71, 'Kab. Bolaang Mo'),
(7102, 71, 'Kab. Minahasa'),
(7103, 71, 'Kab. Kepulauan '),
(7104, 71, 'Kab. Kepulauan '),
(7105, 71, 'Kab. Minahasa S'),
(7106, 71, 'Kab. Minahasa U'),
(7107, 71, 'Kab. Bolaang Mo'),
(7108, 71, 'Kab. Siau Tagul'),
(7109, 71, 'Kab. Minahasa T'),
(7110, 71, 'Kab. Bolaang Mo'),
(7111, 71, 'Kab. Bolaang Mo'),
(7171, 71, 'Kota Manado'),
(7172, 71, 'Kota Bitung'),
(7173, 71, 'Kota Tomohon'),
(7174, 71, 'Kota Kotamobagu'),
(7201, 72, 'Kab. Banggai Ke'),
(7202, 72, 'Kab. Banggai'),
(7203, 72, 'Kab. Morowali'),
(7204, 72, 'Kab. Poso'),
(7205, 72, 'Kab. Donggala'),
(7206, 72, 'Kab. Toli-toli'),
(7207, 72, 'Kab. Buol'),
(7208, 72, 'Kab. Parigi Mou'),
(7209, 72, 'Kab. Tojo Una-u'),
(7210, 72, 'Kab. Sigi'),
(7271, 72, 'Kota Palu'),
(7301, 73, 'Kab. Kepulauan '),
(7302, 73, 'Kab. Bulukumba'),
(7303, 73, 'Kab. Bantaeng'),
(7304, 73, 'Kab. Jeneponto'),
(7305, 73, 'Kab. Takalar'),
(7306, 73, 'Kab. Gowa'),
(7307, 73, 'Kab. Sinjai'),
(7308, 73, 'Kab. Maros'),
(7309, 73, 'Kab. Pangkajene'),
(7310, 73, 'Kab. Barru'),
(7311, 73, 'Kab. Bone'),
(7312, 73, 'Kab. Soppeng'),
(7313, 73, 'Kab. Wajo'),
(7314, 73, 'Kab. Sidenreng '),
(7315, 73, 'Kab. Pinrang'),
(7316, 73, 'Kab. Enrekang'),
(7317, 73, 'Kab. Luwu'),
(7318, 73, 'Kab. Tana Toraj'),
(7322, 73, 'Kab. Luwu Utara'),
(7325, 73, 'Kab. Luwu Timur'),
(7326, 73, 'Kab. Toraja Uta'),
(7371, 73, 'Kota Makassar'),
(7372, 73, 'Kota Parepare'),
(7373, 73, 'Kota Palopo'),
(7401, 74, 'Kab. Buton'),
(7402, 74, 'Kab. Muna'),
(7403, 74, 'Kab. Konawe'),
(7404, 74, 'Kab. Kolaka'),
(7405, 74, 'Kab. Konawe Sel'),
(7406, 74, 'Kab. Bombana'),
(7407, 74, 'Kab. Wakatobi'),
(7408, 74, 'Kab. Kolaka Uta'),
(7409, 74, 'Kab. Buton Utar'),
(7410, 74, 'Kab. Konawe Uta'),
(7471, 74, 'Kota Kendari'),
(7472, 74, 'Kota Baubau'),
(7501, 75, 'Kab. Boalemo'),
(7502, 75, 'Kab. Gorontalo'),
(7503, 75, 'Kab. Pohuwato'),
(7504, 75, 'Kab. Bone Bolan'),
(7505, 75, 'Kab. Gorontalo '),
(7571, 75, 'Kota Gorontalo'),
(7601, 76, 'Kab. Majene'),
(7602, 76, 'Kab. Polewali M'),
(7603, 76, 'Kab. Mamasa'),
(7604, 76, 'Kab. Mamuju'),
(7605, 76, 'Kab. Mamuju Uta'),
(8101, 81, 'Kab. Maluku Ten'),
(8102, 81, 'Kab. Maluku Ten'),
(8103, 81, 'Kab. Maluku Ten'),
(8104, 81, 'Kab. Buru'),
(8105, 81, 'Kab. Kepulauan '),
(8106, 81, 'Kab. Seram Bagi'),
(8107, 81, 'Kab. Seram Bagi'),
(8108, 81, 'Kab. Maluku Bar'),
(8109, 81, 'Kab. Buru Selat'),
(8171, 81, 'Kota Ambon'),
(8172, 81, 'Kota Tual'),
(8201, 82, 'Kab. Halmahera '),
(8202, 82, 'Kab. Halmahera '),
(8203, 82, 'Kab. Kepulauan '),
(8204, 82, 'Kab. Halmahera '),
(8205, 82, 'Kab. Halmahera '),
(8206, 82, 'Kab. Halmahera '),
(8207, 82, 'Kab. Pulau Moro'),
(8271, 82, 'Kota Ternate'),
(8272, 82, 'Kota Tidore Kep'),
(9101, 91, 'Kab. Fakfak'),
(9102, 91, 'Kab. Kaimana'),
(9103, 91, 'Kab. Teluk Wond'),
(9104, 91, 'Kab. Teluk Bint'),
(9105, 91, 'Kab. Manokwari'),
(9106, 91, 'Kab. Sorong Sel'),
(9107, 91, 'Kab. Sorong'),
(9108, 91, 'Kab. Raja Ampat'),
(9109, 91, 'Kab. Tambrauw'),
(9110, 91, 'Kab. Maybrat'),
(9171, 91, 'Kota Sorong'),
(9401, 94, 'Kab. Merauke'),
(9402, 94, 'Kab. Jayawijaya'),
(9403, 94, 'Kab. Jayapura'),
(9404, 94, 'Kab. Nabire'),
(9408, 94, 'Kab. Kepulauan '),
(9409, 94, 'Kab. Biak Numfo'),
(9410, 94, 'Kab. Paniai'),
(9411, 94, 'Kab. Puncak Jay'),
(9412, 94, 'Kab. Mimika'),
(9413, 94, 'Kab. Boven Digo'),
(9414, 94, 'Kab. Mappi'),
(9415, 94, 'Kab. Asmat'),
(9416, 94, 'Kab. Yahukimo'),
(9417, 94, 'Kab. Pegunungan'),
(9418, 94, 'Kab. Tolikara'),
(9419, 94, 'Kab. Sarmi'),
(9420, 94, 'Kab. Keerom'),
(9426, 94, 'Kab. Waropen'),
(9427, 94, 'Kab. Supiori'),
(9428, 94, 'Kab. Mamberamo '),
(9429, 94, 'Kab. Nduga'),
(9430, 94, 'Kab. Lanny Jaya'),
(9431, 94, 'Kab. Mamberamo '),
(9432, 94, 'Kab. Yalimo'),
(9433, 94, 'Kab. Puncak'),
(9434, 94, 'Kab. Dogiyai'),
(9435, 94, 'Kab. Intan Jaya'),
(9436, 94, 'Kab. Deiyai'),
(9471, 94, 'Kota Jayapura');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `username` varchar(30) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `uid_sso` varchar(30) NOT NULL,
  `jenjang_id` int(11) NOT NULL,
  `no_seleksi` varchar(10) NOT NULL,
  `jadwal_registrasi_id` int(11) NOT NULL,
  `jadwal_tes_kesehatan_id` int(11) NOT NULL,
  `jadwal_ept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`username`, `npm`, `uid_sso`, `jenjang_id`, `no_seleksi`, `jadwal_registrasi_id`, `jadwal_tes_kesehatan_id`, `jadwal_ept_id`) VALUES
('benathavia.saladdin', '1123456798', 'benathavia.saladdin', 1, '123450', 1, 1, 1),
('hardyn.adiyoso', '1234567890', 'hardyn.adiyoso', 1, '123450', 1, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan_skema_pembayaran`
--

CREATE TABLE `pengajuan_skema_pembayaran` (
  `pengajuan_id` int(11) NOT NULL,
  `golongan_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `gaji_pribadi` int(11) DEFAULT NULL,
  `gaji_wali1` int(11) NOT NULL,
  `gaji_wali2` int(11) DEFAULT NULL,
  `nilai_tagihan_air` int(11) NOT NULL,
  `nilai_tagihan_listrik` int(11) NOT NULL,
  `nilai_tagihan_telepon` int(11) DEFAULT NULL,
  `surat_keterangan_rtrw` varchar(255) NOT NULL,
  `foto_rumah` varchar(255) NOT NULL,
  `slip_gaji_pribadi` varchar(255) DEFAULT NULL,
  `slip_gaji_wali1` varchar(255) NOT NULL,
  `slip_gaji_wali2` varchar(255) DEFAULT NULL,
  `tagihan_air` varchar(255) NOT NULL,
  `tagihan_listrik` varchar(255) NOT NULL,
  `tagihan_telepon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengajuan_skema_pembayaran`
--

INSERT INTO `pengajuan_skema_pembayaran` (`pengajuan_id`, `golongan_id`, `username`, `gaji_pribadi`, `gaji_wali1`, `gaji_wali2`, `nilai_tagihan_air`, `nilai_tagihan_listrik`, `nilai_tagihan_telepon`, `surat_keterangan_rtrw`, `foto_rumah`, `slip_gaji_pribadi`, `slip_gaji_wali1`, `slip_gaji_wali2`, `tagihan_air`, `tagihan_listrik`, `tagihan_telepon`) VALUES
(1, 2, 'benathavia.saladdin', 5000000, 3000000, 1000000, 400000, 100000, 0, 'fr1.jpg', 'sgp1.jpg', 'sgw11.jpg', 'sgw21.jpg', NULL, 'ta1.jpg', 'tl1.jpg', 'tt1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `program_id` int(11) NOT NULL,
  `nama_jenjang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`program_id`, `nama_jenjang`) VALUES
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
  `nama_program_studi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `program_studi`
--

INSERT INTO `program_studi` (`program_studi_id`, `program_id`, `fakultas_id`, `nama_program_studi`) VALUES
(3, 1, 3, 'Biologi'),
(4, 1, 3, 'Ilmu Kimia'),
(5, 1, 3, 'Ilmu Fisika'),
(6, 1, 3, 'Ilmu Geografi'),
(7, 2, 3, 'Biologi'),
(8, 2, 3, 'Ilmu Kimia'),
(9, 2, 3, 'Ilmu Fisika'),
(10, 2, 3, 'Ilmu Geografi'),
(11, 1, 4, 'Teknik Sipil'),
(12, 1, 4, 'Teknik Mesin'),
(13, 1, 4, 'Teknik Elektro'),
(14, 1, 4, 'Teknik Metalurgi dan'),
(15, 1, 4, 'Ilmu Arsitektur'),
(16, 1, 4, 'Teknik Kimia'),
(17, 1, 4, 'Teknik Industri'),
(18, 1, 4, 'Arsitektur Interior'),
(19, 1, 4, 'Teknik Perkapalan'),
(20, 1, 4, 'Teknik Lingkungan'),
(21, 1, 4, 'Teknik Komputer'),
(22, 1, 4, 'Teknik Bioproses');

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
-- Table structure for table `skema_pembayaran`
--

CREATE TABLE `skema_pembayaran` (
  `golongan_id` int(11) NOT NULL,
  `jumlah_biaya` int(11) NOT NULL,
  `uang_pangkal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skema_pembayaran`
--

INSERT INTO `skema_pembayaran` (`golongan_id`, `jumlah_biaya`, `uang_pangkal`) VALUES
(1, 4000000, 0),
(2, 6000000, 1000000),
(3, 7500000, 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `sso`
--

CREATE TABLE `sso` (
  `uid` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sso`
--

INSERT INTO `sso` (`uid`, `password`) VALUES
('benathavia.saladdin', '9d5d33943357a75df3cd450fd8d60cac'),
('fikri.halim', 'ffe553694f5096471590343432359e02'),
('hardyn.adiyoso', 'ffe553694f5096471590343432359e02'),
('irsyadillah.nuralifa', 'ffe553694f5096471590343432359e02'),
('redita.arifin', 'ffe553694f5096471590343432359e02'),
('wilson.mokoginta', 'ffe553694f5096471590343432359e02');

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
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `id_role` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `flag_aktif` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `id_role`, `password`, `nama_lengkap`, `email`, `flag_aktif`) VALUES
('anin.lia', 1, 'bd506e41bb242cad9dda81422cf3eaa7', 'Anin Lia', 'anin.lia@gmail.com', 1),
('benathavia.saladdin', 1, 'b5ee34d0d6a8182ce8a4fd856a0df63c', 'Benathavia Saladdin', 'benathavia.saladdin@ui.ac.id', 1),
('dwi.arief', 1, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Dwi Arief', 'dwi.arief@gmail.com', 1),
('fikri.halim', 6, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Fikri Halim Perdana Kusuma', 'fikri.halim@ui.ac.id', 1),
('hardyn.adiyoso', 1, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Hardyn Adiyoso Alexander', 'hardyn.adiyoso@gmail.com', 1),
('irsyadillah.nuralifa', 4, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Irsyadillah Nuralifa', 'irsyadillah.nuralifa@ui.ac.id', 1),
('lia.naren', 1, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Lia Naren', 'lia.naren@gmail.com', 1),
('naren.jul', 1, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Naren Jul', 'naren.jul@gmail.com', 1),
('redita.arifin', 3, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Redita Arifin', 'redita.arifin@ui.ac.id', 1),
('widiarliyanti', 1, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Widiarliyanti', 'widiarliyanti@gmail.com', 1),
('wilson.mokoginta', 5, 'f4f38da5bddf4b24e6330a31dd0303d2', 'Wilson Mokoginta', 'wilson.mokoginta@ui.ac.id', 1);

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
('fikri.halim', '0123456798');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alamat`
--
ALTER TABLE `alamat`
  ADD PRIMARY KEY (`jalan_id`),
  ADD KEY `kota_kabupaten_id` (`kota_kabupaten_id`);

--
-- Indexes for table `asuransi_kesehatan`
--
ALTER TABLE `asuransi_kesehatan`
  ADD PRIMARY KEY (`nomor_asuransi`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`biodata_id`),
  ADD KEY `username` (`username`),
  ADD KEY `jalan_id` (`jalan_id`);

--
-- Indexes for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  ADD PRIMARY KEY (`data_kesehatan_id`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`fakultas_id`);

--
-- Indexes for table `ijazah`
--
ALTER TABLE `ijazah`
  ADD PRIMARY KEY (`nomor_ijazah`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `jadwal_ept`
--
ALTER TABLE `jadwal_ept`
  ADD PRIMARY KEY (`jadwal_ept_id`);

--
-- Indexes for table `jadwal_registrasi`
--
ALTER TABLE `jadwal_registrasi`
  ADD PRIMARY KEY (`jadwal_registrasi_id`);

--
-- Indexes for table `jadwal_tes_kesehatan`
--
ALTER TABLE `jadwal_tes_kesehatan`
  ADD PRIMARY KEY (`jadwal_tes_kesehatan_id`);

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
  ADD KEY `jenjang_id` (`jenjang_id`),
  ADD KEY `jadwal_registrasi_id` (`jadwal_registrasi_id`),
  ADD KEY `jadwal_tes_kesehatan_id` (`jadwal_tes_kesehatan_id`),
  ADD KEY `jadwal_ept_id` (`jadwal_ept_id`);

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
  ADD KEY `fakultas_id` (`fakultas_id`);

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
-- Indexes for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  ADD PRIMARY KEY (`golongan_id`);

--
-- Indexes for table `sso`
--
ALTER TABLE `sso`
  ADD PRIMARY KEY (`uid`);

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
-- Indexes for table `staf_registrasi`
--
ALTER TABLE `staf_registrasi`
  ADD PRIMARY KEY (`username`,`nip`);

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
-- AUTO_INCREMENT for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  MODIFY `golongan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `alamat`
--
ALTER TABLE `alamat`
  ADD CONSTRAINT `alamat_ibfk_1` FOREIGN KEY (`kota_kabupaten_id`) REFERENCES `kota_kabupaten` (`kota_kabupaten_id`);

--
-- Constraints for table `asuransi_kesehatan`
--
ALTER TABLE `asuransi_kesehatan`
  ADD CONSTRAINT `asuransi_kesehatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`);

--
-- Constraints for table `biodata`
--
ALTER TABLE `biodata`
  ADD CONSTRAINT `biodata_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`),
  ADD CONSTRAINT `biodata_ibfk_2` FOREIGN KEY (`jalan_id`) REFERENCES `alamat` (`jalan_id`);

--
-- Constraints for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  ADD CONSTRAINT `data_kesehatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`);

--
-- Constraints for table `ijazah`
--
ALTER TABLE `ijazah`
  ADD CONSTRAINT `ijazah_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`username`);

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
  ADD CONSTRAINT `mahasiswa_ibfk_3` FOREIGN KEY (`jenjang_id`) REFERENCES `jenjang` (`jenjang_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_4` FOREIGN KEY (`jadwal_registrasi_id`) REFERENCES `jadwal_registrasi` (`jadwal_registrasi_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_5` FOREIGN KEY (`jadwal_tes_kesehatan_id`) REFERENCES `jadwal_tes_kesehatan` (`jadwal_tes_kesehatan_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_6` FOREIGN KEY (`jadwal_ept_id`) REFERENCES `jadwal_ept` (`jadwal_ept_id`);

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
