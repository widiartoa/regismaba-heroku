package id.ac.univ.regismaba.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CrossRekapJaketModel {

	int fakultas_id;
	String nama_fakultas;
	ArrayList<RekapitulasiJaketModel> rjm;
}
