package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DataKesehatanModel {
	int data_kesehatan_id;
	String form_survey_kesehatan;
	String hasil_tes_kesehatan;
}
