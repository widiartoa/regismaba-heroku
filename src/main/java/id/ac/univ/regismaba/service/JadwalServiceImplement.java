package id.ac.univ.regismaba.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.JadwalMapper;
import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.TahunAjaranModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JadwalServiceImplement implements JadwalService {

	@Autowired
	JadwalMapper jadwalMapper;

	@Autowired
	TahunAjaranService tahunAjaranService;

	@Override
	public JadwalEptModel selectJadwalEpt(int jadwal_ept_id) {
		// TODO Auto-generated method stub
		log.info("select jadwal ept with id {}", jadwal_ept_id);
		return jadwalMapper.selectJadwalEpt(jadwal_ept_id);
	}

	@Override
	public JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id) {
		// TODO Auto-generated method stub
		log.info("select jadwal tes kesehatan with id {}", jadwal_tes_kesehatan_id);
		return jadwalMapper.selectJadwalKesehatan(jadwal_tes_kesehatan_id);
	}

	@Override
	public JadwalRegisModel selectJadwalRegis(int jadwal_registrasi_id) {
		// TODO Auto-generated method stub
		log.info("select jadwal registrasi with id {}", jadwal_registrasi_id);
		JadwalRegisModel jadwalRegis = jadwalMapper.selectJadwalRegis(jadwal_registrasi_id);

		String hariRegis = this.parseHariRegis(jadwalRegis);
		String waktuRegis = this.parseWaktuRegis(jadwalRegis);
		String timestampAwalRegis = this.parseTimestampAwalRegis(jadwalRegis);
		String timestampAkhirRegis = this.parseTimestampAkhirRegis(jadwalRegis);

		jadwalRegis.setHari(hariRegis);
		jadwalRegis.setTanggal(waktuRegis);
		jadwalRegis.setWaktu_awal(timestampAwalRegis);
		jadwalRegis.setWaktu_akhir(timestampAkhirRegis);

		return jadwalRegis;
	}

	@Override
	public List<JadwalRegisModel> selectAllJadwalRegis() {
		// TODO Auto-generated method stub

		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		log.info("select all jadwal registrasi on tahun ajaran {} term {}", tahunAjaranSaatIni.getTahun_ajaran(),
				tahunAjaranSaatIni.getTerm_id());
		List<JadwalRegisModel> jadwalRegisList = jadwalMapper
				.selectAllJadwalRegisbyTahunAjaran(tahunAjaranSaatIni.getTahun_ajaran_id());

		for (JadwalRegisModel jadwalRegis : jadwalRegisList) {
			String hariRegis = this.parseHariRegis(jadwalRegis);
			String waktuRegis = this.parseWaktuRegis(jadwalRegis);
			String timestampAwalRegis = this.parseTimestampAwalRegis(jadwalRegis);
			String timestampAkhirRegis = this.parseTimestampAkhirRegis(jadwalRegis);

			jadwalRegis.setHari(hariRegis);
			jadwalRegis.setTanggal(waktuRegis);
			jadwalRegis.setWaktu_awal(timestampAwalRegis);
			jadwalRegis.setWaktu_akhir(timestampAkhirRegis);

			if (!(jadwalRegis.getFakultas_id() > 0)) {
				jadwalRegis.setFakultas("fakultas belum ditentukan");
			}
		}

		return jadwalRegisList;
	}

	@Override
	public void insertJadwalRegis(String hari, String waktu_awal, String waktu_akhir, int kapasitas)
			throws ParseException {
		// TODO Auto-generated method stub

		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date timestamp_awal = format.parse(hari + " " + waktu_awal);
		Date timestamp_akhir = format.parse(hari + " " + waktu_akhir);
		log.info("insert jadwal registrasi dengan waktu awal {} dan waktu akhir {}", timestamp_awal, timestamp_akhir);

		JadwalRegisModel jadwalRegis = new JadwalRegisModel();
		jadwalRegis.setKapasitas(kapasitas);
		jadwalRegis.setTanggal(hari);
		jadwalRegis.setWaktu_awal(waktu_awal);
		jadwalRegis.setWaktu_akhir(waktu_akhir);
		jadwalRegis.setTimestamp_awal(timestamp_awal);
		jadwalRegis.setTimestamp_akhir(timestamp_akhir);
		jadwalRegis.setCreated_by("redita.arifin");
		jadwalRegis.setUpdated_by("redita.arifin");
		jadwalRegis.setTahun_ajaran_id(tahunAjaranSaatIni.getTahun_ajaran_id());

		jadwalMapper.insertJadwalRegis(jadwalRegis);
	}

	/**
	 * Parsing Methods
	 *
	 */

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
