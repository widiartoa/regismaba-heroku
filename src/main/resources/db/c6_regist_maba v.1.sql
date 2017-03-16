-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2017 at 06:46 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `asuransi_kesehatan`
--

CREATE TABLE `asuransi_kesehatan` (
  `nomor_asuransi` varchar(30) NOT NULL,
  `nomor_penerbit_asuransi` varchar(30) NOT NULL,
  `expired_date` date NOT NULL,
  `scan_kartu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `berkuliah`
--

CREATE TABLE `berkuliah` (
  `username` varchar(30) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `jenjang_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `biodata_id` int(11) NOT NULL,
  `data_kesehatan_id` int(11) NOT NULL,
  `nomor_ijazah` varchar(30) NOT NULL,
  `nomor_asuransi` varchar(30) NOT NULL,
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
  `flag_aktif` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `data_kesehatan`
--

CREATE TABLE `data_kesehatan` (
  `data_kesehatan_id` int(11) NOT NULL,
  `form_survey_kesehatan` varchar(255) NOT NULL,
  `hasil_tes_kesehatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE `fakultas` (
  `fakultas_id` int(11) NOT NULL,
  `nama_fakultas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ijazah`
--

CREATE TABLE `ijazah` (
  `nomor_ijazah` varchar(30) NOT NULL,
  `nama_institusi` varchar(255) NOT NULL,
  `jenjang` varchar(10) NOT NULL,
  `scan_ijazah` varchar(255) NOT NULL,
  `scan_pernyataan_ijazah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_ept`
--

CREATE TABLE `jadwal_ept` (
  `jadwal_ept_id` int(11) NOT NULL,
  `timestamp_awal` date NOT NULL,
  `timestamp_akhir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_registrasi`
--

CREATE TABLE `jadwal_registrasi` (
  `jadwal_registrasi_id` int(11) NOT NULL,
  `timestamp_awal` date NOT NULL,
  `timestamp_akhir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_tes_kesehatan`
--

CREATE TABLE `jadwal_tes_kesehatan` (
  `jadwal_tes_kesehatan_id` int(11) NOT NULL,
  `timestamp_awal` date NOT NULL,
  `timestamp_akhir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jenjang`
--

CREATE TABLE `jenjang` (
  `jenjang_id` int(11) NOT NULL,
  `nama_jenjang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kota_kabupaten`
--

CREATE TABLE `kota_kabupaten` (
  `kota_kabupaten_id` int(11) NOT NULL,
  `provinsi_id` int(11) NOT NULL,
  `nama_kota_kabupaten` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `username` varchar(30) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `uid_sso` varchar(30) NOT NULL,
  `biodata_id` int(11) NOT NULL,
  `jenjang_id` int(11) NOT NULL,
  `pengajuan_id` int(11) NOT NULL,
  `no_seleksi` varchar(10) NOT NULL,
  `jadwal_registrasi_id` int(11) NOT NULL,
  `jadwal_tes_kesehatan_id` int(11) NOT NULL,
  `jadwal_ept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan_skema_pembayaran`
--

CREATE TABLE `pengajuan_skema_pembayaran` (
  `pengajuan_id` int(11) NOT NULL,
  `golongan_id` int(11) NOT NULL,
  `surat_keterangan_rtrw` varchar(255) NOT NULL,
  `foto_rumah` varchar(255) NOT NULL,
  `slip_gaji_pribadi` varchar(255) NOT NULL,
  `slip_gaji_wali1` varchar(255) NOT NULL,
  `slip_gaji_wali2` varchar(255) NOT NULL,
  `tagihan_air` varchar(255) NOT NULL,
  `tagihan_listrik` varchar(255) NOT NULL,
  `tagihan_telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `program_id` int(11) NOT NULL,
  `nama_jenjang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `program_pada_prodi`
--

CREATE TABLE `program_pada_prodi` (
  `program_id` int(11) NOT NULL,
  `prodi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Table structure for table `provinsi`
--

CREATE TABLE `provinsi` (
  `provinsi_id` int(11) NOT NULL,
  `nama_provinsi` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nama_role` varchar(20) NOT NULL,
  `flag_aktif` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `skema_pembayaran`
--

CREATE TABLE `skema_pembayaran` (
  `golongan_id` int(11) NOT NULL,
  `jumlah_biaya` int(11) NOT NULL,
  `uang_pangkal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sso`
--

CREATE TABLE `sso` (
  `uid` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staf`
--

CREATE TABLE `staf` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL,
  `uid_sso` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staf_kesehatan`
--

CREATE TABLE `staf_kesehatan` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staf_kesejahteraan`
--

CREATE TABLE `staf_kesejahteraan` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staf_registrasi`
--

CREATE TABLE `staf_registrasi` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Table structure for table `verifikator_fakultas`
--

CREATE TABLE `verifikator_fakultas` (
  `username` varchar(30) NOT NULL,
  `nip` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`nomor_asuransi`);

--
-- Indexes for table `berkuliah`
--
ALTER TABLE `berkuliah`
  ADD PRIMARY KEY (`username`,`npm`,`jenjang_id`),
  ADD KEY `jenjang_id` (`jenjang_id`);

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`biodata_id`),
  ADD KEY `data_kesehatan_id` (`data_kesehatan_id`),
  ADD KEY `nomor_ijazah` (`nomor_ijazah`),
  ADD KEY `nomor_asuransi` (`nomor_asuransi`),
  ADD KEY `jalan_id` (`jalan_id`);

--
-- Indexes for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  ADD PRIMARY KEY (`data_kesehatan_id`);

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`fakultas_id`);

--
-- Indexes for table `ijazah`
--
ALTER TABLE `ijazah`
  ADD PRIMARY KEY (`nomor_ijazah`);

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
  ADD KEY `biodata_id` (`biodata_id`),
  ADD KEY `jenjang_id` (`jenjang_id`),
  ADD KEY `pengajuan_id` (`pengajuan_id`),
  ADD KEY `jadwal_registrasi_id` (`jadwal_registrasi_id`),
  ADD KEY `jadwal_tes_kesehatan_id` (`jadwal_tes_kesehatan_id`),
  ADD KEY `jadwal_ept_id` (`jadwal_ept_id`);

--
-- Indexes for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  ADD PRIMARY KEY (`pengajuan_id`),
  ADD KEY `golongan_id` (`golongan_id`);

--
-- Indexes for table `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`program_id`);

--
-- Indexes for table `program_pada_prodi`
--
ALTER TABLE `program_pada_prodi`
  ADD PRIMARY KEY (`program_id`,`prodi_id`),
  ADD KEY `prodi_id` (`prodi_id`);

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
-- AUTO_INCREMENT for table `data_kesehatan`
--
ALTER TABLE `data_kesehatan`
  MODIFY `data_kesehatan_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fakultas`
--
ALTER TABLE `fakultas`
  MODIFY `fakultas_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jadwal_ept`
--
ALTER TABLE `jadwal_ept`
  MODIFY `jadwal_ept_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jadwal_registrasi`
--
ALTER TABLE `jadwal_registrasi`
  MODIFY `jadwal_registrasi_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jadwal_tes_kesehatan`
--
ALTER TABLE `jadwal_tes_kesehatan`
  MODIFY `jadwal_tes_kesehatan_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jenjang`
--
ALTER TABLE `jenjang`
  MODIFY `jenjang_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  MODIFY `pengajuan_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `program`
--
ALTER TABLE `program`
  MODIFY `program_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `program_studi`
--
ALTER TABLE `program_studi`
  MODIFY `program_studi_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `skema_pembayaran`
--
ALTER TABLE `skema_pembayaran`
  MODIFY `golongan_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `alamat`
--
ALTER TABLE `alamat`
  ADD CONSTRAINT `alamat_ibfk_1` FOREIGN KEY (`kota_kabupaten_id`) REFERENCES `kota_kabupaten` (`kota_kabupaten_id`);

--
-- Constraints for table `berkuliah`
--
ALTER TABLE `berkuliah`
  ADD CONSTRAINT `berkuliah_ibfk_1` FOREIGN KEY (`username`,`npm`) REFERENCES `mahasiswa` (`username`, `npm`),
  ADD CONSTRAINT `berkuliah_ibfk_2` FOREIGN KEY (`jenjang_id`) REFERENCES `jenjang` (`jenjang_id`);

--
-- Constraints for table `biodata`
--
ALTER TABLE `biodata`
  ADD CONSTRAINT `biodata_ibfk_1` FOREIGN KEY (`data_kesehatan_id`) REFERENCES `data_kesehatan` (`data_kesehatan_id`),
  ADD CONSTRAINT `biodata_ibfk_2` FOREIGN KEY (`nomor_ijazah`) REFERENCES `ijazah` (`nomor_ijazah`),
  ADD CONSTRAINT `biodata_ibfk_3` FOREIGN KEY (`nomor_asuransi`) REFERENCES `asuransi_kesehatan` (`nomor_asuransi`),
  ADD CONSTRAINT `biodata_ibfk_4` FOREIGN KEY (`jalan_id`) REFERENCES `alamat` (`jalan_id`);

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
  ADD CONSTRAINT `mahasiswa_ibfk_3` FOREIGN KEY (`biodata_id`) REFERENCES `biodata` (`biodata_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_4` FOREIGN KEY (`jenjang_id`) REFERENCES `jenjang` (`jenjang_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_5` FOREIGN KEY (`pengajuan_id`) REFERENCES `pengajuan_skema_pembayaran` (`pengajuan_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_6` FOREIGN KEY (`jadwal_registrasi_id`) REFERENCES `jadwal_registrasi` (`jadwal_registrasi_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_7` FOREIGN KEY (`jadwal_tes_kesehatan_id`) REFERENCES `jadwal_tes_kesehatan` (`jadwal_tes_kesehatan_id`),
  ADD CONSTRAINT `mahasiswa_ibfk_8` FOREIGN KEY (`jadwal_ept_id`) REFERENCES `jadwal_ept` (`jadwal_ept_id`);

--
-- Constraints for table `pengajuan_skema_pembayaran`
--
ALTER TABLE `pengajuan_skema_pembayaran`
  ADD CONSTRAINT `pengajuan_skema_pembayaran_ibfk_1` FOREIGN KEY (`golongan_id`) REFERENCES `skema_pembayaran` (`golongan_id`);

--
-- Constraints for table `program_pada_prodi`
--
ALTER TABLE `program_pada_prodi`
  ADD CONSTRAINT `program_pada_prodi_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`),
  ADD CONSTRAINT `program_pada_prodi_ibfk_2` FOREIGN KEY (`prodi_id`) REFERENCES `program_studi` (`program_studi_id`);

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
