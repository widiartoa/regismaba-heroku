package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;

public interface JadwalService {

	JadwalEptModel selectJadwalEpt(int jadwal_ept_id);

	JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id);

	JadwalRegisModel selectJadwalRegis(int jadwal_registrasi_id);

	String parseTimestampAwalRegis(JadwalRegisModel jadwalRegis);

	String parseTimestampAkhirRegis(JadwalRegisModel jadwalRegis);

	String parseWaktuRegis(JadwalRegisModel jadwalRegis);

	String parseHariRegis(JadwalRegisModel jadwalRegis);
}
