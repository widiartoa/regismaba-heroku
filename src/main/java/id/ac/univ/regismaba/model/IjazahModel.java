package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IjazahModel
{
    String nomor_ijazah;
    String username;
    int institusi_id;
    String jenjang;
    String scan_ijazah;
    String scan_pernyataan_ijazah;
	String created_at;
	String created_by;
	String updated_by;
	String updated_at;
}
