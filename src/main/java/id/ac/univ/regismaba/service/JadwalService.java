package id.ac.univ.regismaba.service;

import java.text.ParseException;
import java.util.List;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.UrutanAssignJadwalModel;

public interface JadwalService {

	JadwalEptModel selectJadwalEpt(int jadwal_ept_id);

	JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id);

	JadwalRegisModel selectJadwalRegis(int jadwal_registrasi_id);

	void insertJadwalRegis(String hari, String waktu_awal, String waktu_akhir, int kapasitas) throws ParseException;

	List<JadwalRegisModel> selectAllJadwalRegis();

	List<JadwalRegisModel> selectAllJadwalRegisAsc();

	List<JadwalKesehatanModel> selectAllJadwalTesKes();

	List<JadwalEptModel> selectAllJadwalEpt();

	void deleteJadwalRegis(int jadwal_registrasi_id);

	void insertUrutanAssign(UrutanAssignJadwalModel uaj);

	void resetAssignJadwal(int tahun_ajaran_id);

	void assignJadwalReg(List<JadwalRegisModel> jadwalList, int indexJadwalList, int kapasitasSisa,
			List<MahasiswaModel> mahasiswaList, int totalJadwalAssigned, String created_by);

	/*
	 * parsings method
	 */

	String parseHariRegis(JadwalRegisModel jadwalRegis);

	String parseHariTesKes(JadwalKesehatanModel jadwalKesehatan);

	String parseHariEpt(JadwalEptModel jadwalEpt);

	String parseWaktuRegis(JadwalRegisModel jadwalRegis);

	String parseWaktuTesKes(JadwalKesehatanModel jadwalKesehatan);

	String parseWaktuEpt(JadwalEptModel jadwalEpt);

	String parseTimestampAwalRegis(JadwalRegisModel jadwalRegis);

	String parseTimestampAwalTesKes(JadwalKesehatanModel jadwalKesehatan);

	String parseTimestampAwalEpt(JadwalEptModel jadwalEpt);

	String parseTimestampAkhirRegis(JadwalRegisModel jadwalRegis);

	String parseTimestampAkhirTesKes(JadwalKesehatanModel jadwalKesehatan);

	String parseTimestampAkhirEpt(JadwalEptModel jadwalEpt);
}
