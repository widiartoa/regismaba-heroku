package id.ac.univ.regismaba.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class StatistikSkemaModel {
	
	String nama;
	ArrayList<StatistikManagerSummaryModel> objects;
	
	public StatistikSkemaModel (String nama) {
		
		this.nama = nama;
	}
	
}
