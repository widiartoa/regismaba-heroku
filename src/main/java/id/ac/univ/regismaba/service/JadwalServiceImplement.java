package id.ac.univ.regismaba.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.JadwalMapper;
import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JadwalServiceImplement implements JadwalService {

	@Autowired
	JadwalMapper jadwalMapper;
	
	@Override
	public JadwalEptModel selectJadwalEpt(int jadwal_ept_id) {
		// TODO Auto-generated method stub
		log.info ("select jadwal ept with id {}", jadwal_ept_id);
		return jadwalMapper.selectJadwalEpt(jadwal_ept_id);
	}

	@Override
	public JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id) {
		// TODO Auto-generated method stub
		log.info ("select jadwal tes kesehatan with id {}", jadwal_tes_kesehatan_id);
		return jadwalMapper.selectJadwalKesehatan(jadwal_tes_kesehatan_id);
	}

	@Override
	public JadwalRegisModel selectJadwalRegis(int jadwal_registrasi_id) {
		// TODO Auto-generated method stub
		log.info ("select jadwal registrasi with id {}", jadwal_registrasi_id);
		return jadwalMapper.selectJadwalRegis(jadwal_registrasi_id);
	}

	@Override
	public String parseHariRegis(JadwalRegisModel jadwalRegis) {
		// TODO Auto-generated method stub
		Date tsa = jadwalRegis.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("EEE");
		String hari = dateFormat.format(tsa);
		return hari;
	}

	@Override
	public String parseHariTesKes(JadwalKesehatanModel jadwalKesehatan) {
		// TODO Auto-generated method stub
		Date tsa = jadwalKesehatan.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("EEE");
		String hari = dateFormat.format(tsa);
		return hari;
	}

	@Override
	public String parseHariEpt(JadwalEptModel jadwalEpt) {
		// TODO Auto-generated method stub
		Date tsa = jadwalEpt.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("EEE");
		String hari = dateFormat.format(tsa);
		return hari;
	}
	
	@Override
	public String parseWaktuRegis(JadwalRegisModel jadwalRegis) {
		// TODO Auto-generated method stub
		Date tsa = jadwalRegis.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		String waktu = dateFormat.format(tsa);
		return waktu;
	}

	@Override
	public String parseWaktuTesKes(JadwalKesehatanModel jadwalKesehatan) {
		// TODO Auto-generated method stub
		Date tsa = jadwalKesehatan.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		String waktu = dateFormat.format(tsa);
		return waktu;
	}

	@Override
	public String parseWaktuEpt(JadwalEptModel jadwalEpt) {
		// TODO Auto-generated method stub
		Date tsa = jadwalEpt.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		String waktu = dateFormat.format(tsa);
		return waktu;
	}

	@Override
	public String parseTimestampAwalRegis(JadwalRegisModel jadwalRegis) {
		// TODO Auto-generated method stub
		Date tsa = jadwalRegis.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAwal = dateFormat.format(tsa);
		return waktuAwal;
	}

	@Override
	public String parseTimestampAwalTesKes(JadwalKesehatanModel jadwalKesehatan) {
		// TODO Auto-generated method stub
		Date tsa = jadwalKesehatan.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAwal = dateFormat.format(tsa);
		return waktuAwal;
	}

	@Override
	public String parseTimestampAwalEpt(JadwalEptModel jadwalEpt) {
		// TODO Auto-generated method stub
		Date tsa = jadwalEpt.getTimestamp_awal();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAwal = dateFormat.format(tsa);
		return waktuAwal;
	}
	
	@Override
	public String parseTimestampAkhirRegis(JadwalRegisModel jadwalRegis) {
		// TODO Auto-generated method stub
		Date tsa = jadwalRegis.getTimestamp_akhir();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAkhir = dateFormat.format(tsa);
		return waktuAkhir;
	}
	
	@Override
	public String parseTimestampAkhirTesKes(JadwalKesehatanModel jadwalKesehatan) {
		// TODO Auto-generated method stub
		Date tsa = jadwalKesehatan.getTimestamp_akhir();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAkhir = dateFormat.format(tsa);
		return waktuAkhir;
	}

	@Override
	public String parseTimestampAkhirEpt(JadwalEptModel jadwalEpt) {
		// TODO Auto-generated method stub
		Date tsa = jadwalEpt.getTimestamp_akhir();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String waktuAkhir = dateFormat.format(tsa);
		return waktuAkhir;
	}

}
