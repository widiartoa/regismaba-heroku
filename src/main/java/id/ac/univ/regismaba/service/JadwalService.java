package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;

public interface JadwalService {

	JadwalEptModel selectJadwalEpt(int jadwal_ept_id);

	JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id);

	JadwalRegisModel selectJadwalRegis(int jadwal_registrasi_id);

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