package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.RekapitulasiJaketModel;

@Mapper
public interface RekapitulasiJaketMapper {

	@Select("select ukuran_jaket as jenis_rekap, count(*) as jumlah from biodata where ukuran_jaket=#{ukuran_jaket}")
	RekapitulasiJaketModel selectRekapUkuran(@Param("ukuran_jaket") String ukuran_jaket);
	
	@Select("select f.nama_fakultas as jenis_rekap, count(*) as jumlah from fakultas f, program_studi p, "
			+ "mahasiswa m where f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id and "
			+ "f.fakultas_id=#{fakultas_id}")
	RekapitulasiJaketModel selectRekapFakultas(@Param("fakultas_id") int fakultas_id);
	
	@Select("select distinct ukuran_jaket from biodata")
	List<String> getSizes();
	
	@Select("select distinct f.fakultas_id, f.nama_fakultas from fakultas f, program_studi p, mahasiswa m where "
			+ "f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id")
	List<FakultasModel> getFaculties();
	
	@Select("select f.fakultas_id as fakultas_id, f.nama_fakultas as nama_fakultas, b.ukuran_jaket "
			+ "as jenis_rekap, count(*) as jumlah from biodata b, mahasiswa m, program_studi p, "
			+ "fakultas f where b.username=m.username and m.program_studi_id=p.program_studi_id and "
			+ "p.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id} group by b.ukuran_jaket")
	RekapitulasiJaketModel selectUkuranOfFakultas(@Param("fakultas_id") int fakultas_id);
}
