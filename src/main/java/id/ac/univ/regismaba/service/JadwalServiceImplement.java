package id.ac.univ.regismaba.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.JadwalMapper;
import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.TahunAjaranModel;
import id.ac.univ.regismaba.model.UrutanAssignJadwalModel;
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
		JadwalEptModel jadwalEpt = jadwalMapper.selectJadwalEpt(jadwal_ept_id);

		String hariEpt = this.parseHariEpt(jadwalEpt);
		String waktuEpt = this.parseWaktuEpt(jadwalEpt);
		String timestampAwalEpt = this.parseTimestampAwalEpt(jadwalEpt);
		String timestampAkhirEpt = this.parseTimestampAkhirEpt(jadwalEpt);

		jadwalEpt.setHari(hariEpt);
		jadwalEpt.setTanggal(waktuEpt);
		jadwalEpt.setWaktu_awal(timestampAwalEpt);
		jadwalEpt.setWaktu_akhir(timestampAkhirEpt);

		return jadwalEpt;
	}

	@Override
	public JadwalKesehatanModel selectJadwalKesehatan(int jadwal_tes_kesehatan_id) {
		// TODO Auto-generated method stub
		log.info("select jadwal tes kesehatan with id {}", jadwal_tes_kesehatan_id);
		JadwalKesehatanModel jadwalTesKes = jadwalMapper.selectJadwalKesehatan(jadwal_tes_kesehatan_id);

		String hariTesKes = this.parseHariTesKes(jadwalTesKes);
		String waktuTesKes = this.parseWaktuTesKes(jadwalTesKes);
		String timestampAwalTesKes = this.parseTimestampAwalTesKes(jadwalTesKes);
		String timestampAkhirTesKes = this.parseTimestampAkhirTesKes(jadwalTesKes);

		jadwalTesKes.setHari(hariTesKes);
		jadwalTesKes.setTanggal(waktuTesKes);
		jadwalTesKes.setWaktu_awal(timestampAwalTesKes);
		jadwalTesKes.setWaktu_akhir(timestampAkhirTesKes);

		return jadwalTesKes;
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

		}

		return jadwalRegisList;
	}

	@Override
	public List<JadwalRegisModel> selectAllJadwalRegisAsc() {
		// TODO Auto-generated method stub
		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		log.info("select all jadwal registrasi on tahun ajaran {} term {}", tahunAjaranSaatIni.getTahun_ajaran(),
				tahunAjaranSaatIni.getTerm_id());
		List<JadwalRegisModel> jadwalRegisList = jadwalMapper
				.selectAllJadwalRegisbyTahunAjaranSortAsc(tahunAjaranSaatIni.getTahun_ajaran_id());
		return jadwalRegisList;
	}

	@Override
	public List<JadwalKesehatanModel> selectAllJadwalTesKes() {
		// TODO Auto-generated method stub

		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		log.info("select all jadwal registrasi on tahun ajaran {} term {}", tahunAjaranSaatIni.getTahun_ajaran(),
				tahunAjaranSaatIni.getTerm_id());
		List<JadwalKesehatanModel> jadwalTesKesList = jadwalMapper
				.selectAllJadwalTesKesbyTahunAjaran(tahunAjaranSaatIni.getTahun_ajaran_id());

		for (JadwalKesehatanModel jadwalTesKes : jadwalTesKesList) {
			String hariTesKes = this.parseHariTesKes(jadwalTesKes);
			String waktuTesKes = this.parseWaktuTesKes(jadwalTesKes);
			String timestampAwalTesKes = this.parseTimestampAwalTesKes(jadwalTesKes);
			String timestampAkhirTesKes = this.parseTimestampAkhirTesKes(jadwalTesKes);

			jadwalTesKes.setHari(hariTesKes);
			jadwalTesKes.setTanggal(waktuTesKes);
			jadwalTesKes.setWaktu_awal(timestampAwalTesKes);
			jadwalTesKes.setWaktu_akhir(timestampAkhirTesKes);

		}

		return jadwalTesKesList;
	}

	@Override
	public List<JadwalEptModel> selectAllJadwalEpt() {
		// TODO Auto-generated method stub

		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		log.info("select all jadwal registrasi on tahun ajaran {} term {}", tahunAjaranSaatIni.getTahun_ajaran(),
				tahunAjaranSaatIni.getTerm_id());
		List<JadwalEptModel> jadwalEptList = jadwalMapper
				.selectAllJadwalEptbyTahunAjaran(tahunAjaranSaatIni.getTahun_ajaran_id());

		for (JadwalEptModel jadwalEpt : jadwalEptList) {
			String hariEpt = this.parseHariEpt(jadwalEpt);
			String waktuEpt = this.parseWaktuEpt(jadwalEpt);
			String timestampAwalEpt = this.parseTimestampAwalEpt(jadwalEpt);
			String timestampAkhirEpt = this.parseTimestampAkhirEpt(jadwalEpt);

			jadwalEpt.setHari(hariEpt);
			jadwalEpt.setTanggal(waktuEpt);
			jadwalEpt.setWaktu_awal(timestampAwalEpt);
			jadwalEpt.setWaktu_akhir(timestampAkhirEpt);

		}

		return jadwalEptList;
	}

	@Override
	public void insertJadwalRegis(String hari, String waktu_awal, String waktu_akhir, int kapasitas)
			throws ParseException {
		// TODO Auto-generated method stub

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();

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
		jadwalRegis.setCreated_by(user);
		jadwalRegis.setUpdated_by(user);
		jadwalRegis.setTahun_ajaran_id(tahunAjaranSaatIni.getTahun_ajaran_id());

		jadwalMapper.insertJadwalRegis(jadwalRegis);
	}

	@Override
	public void deleteJadwalRegis(int jadwal_registrasi_id) {
		// TODO Auto-generated method stub
		if (jadwalMapper.selectJadwalRegis(jadwal_registrasi_id) != null) {
			log.info("delete jadwal registrasi dengan id {}", jadwal_registrasi_id);
			jadwalMapper.deleteJadwalRegis(jadwal_registrasi_id);
		} else {
			log.info("tidak ada jadwal registrasi dengan id {}", jadwal_registrasi_id);
		}
	}

	@Override
	public void insertUrutanAssign(UrutanAssignJadwalModel uaj) {
		// TODO Auto-generated method stub
		jadwalMapper.insertUrutanAssign(uaj);
	}

	@Override
	public void resetAssignJadwal(int tahun_ajaran_id) {
		// TODO Auto-generated method stub
		jadwalMapper.resetAssignJadwal(tahun_ajaran_id);
		jadwalMapper.resetUrutanAssignJadwal(tahun_ajaran_id);
	}

	/*
	 * @param jadwal_registrasi_id sebagai penunjuk saat ini sedang menggunakan
	 * jadwal yang mana
	 */
	@Override
	public void assignJadwalReg(List<JadwalRegisModel> jadwalList, int indexJadwalList, int kapasitasSisa,
			List<MahasiswaModel> mahasiswaList, int totalJadwalAssigned, String created_by) {
		if (totalJadwalAssigned < mahasiswaList.size()) {
			if (kapasitasSisa > 0) {
				if (indexJadwalList < jadwalList.size()) {

					TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();

					MahasiswaModel mahasiswa = mahasiswaList.get(totalJadwalAssigned);
					JadwalRegisModel jadwal = jadwalList.get(indexJadwalList);
					log.info("mahasiswa dengan npm {} fakultas id {}", mahasiswa.getNpm(), mahasiswa.getFakultas_id());
					jadwalMapper.assignJadwalReg(mahasiswa.getFakultas_id(), mahasiswa.getNpm(),
							jadwal.getJadwal_registrasi_id(), tahunAjaranSaatIni.getTahun_ajaran_id(), created_by);
					log.info("mahasiswa dengan npm {} diberikan jadwal dengan id {}", mahasiswa.getNpm(),
							jadwal.getJadwal_registrasi_id());

					assignJadwalReg(jadwalList, indexJadwalList, kapasitasSisa - 1, mahasiswaList,
							totalJadwalAssigned + 1, created_by);
				}
			} else {
				if (indexJadwalList + 1 < jadwalList.size()) {
					log.info("kapasitas jadwal sisa {} pindah ke jadwal id {} dengan kapasitas {}", kapasitasSisa,
							jadwalList.get(indexJadwalList + 1).getJadwal_registrasi_id(),
							jadwalList.get(indexJadwalList + 1).getKapasitas());
					assignJadwalReg(jadwalList, indexJadwalList + 1, jadwalList.get(indexJadwalList + 1).getKapasitas(),
							mahasiswaList, totalJadwalAssigned, created_by);
				}
			}
		}
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
