package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitusiModel {
	int institusi_id;
    String nama_institusi;
    int tingkat_pendidikan_id;
}
