package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramStudiModel {
	int program_studi_id;
	int program_id;
	int fakultas_id;
	String nama_program_studi;
}
