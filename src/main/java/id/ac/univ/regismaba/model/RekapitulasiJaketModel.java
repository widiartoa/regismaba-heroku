package id.ac.univ.regismaba.model;

import lombok.Data;

@Data
public class RekapitulasiJaketModel {

	String jenis_rekap; //bisa untuk menyimpan size atau fakultas
	int jumlah;
	int fakultas_id;
	String nama_fakultas;
}
