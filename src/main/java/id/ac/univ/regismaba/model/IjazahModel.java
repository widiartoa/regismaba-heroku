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
    String nama_institusi;
    String jenjang;
    String scan_ijazah;
    String scan_pernyataan_ijazah;
}
