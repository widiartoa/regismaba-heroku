package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DataKesehatanModel {
	int data_kesehatan_id;
	public String form_survey_kesehatan;
	public String hasil_tes_kesehatan;
}
