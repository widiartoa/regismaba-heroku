package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.RekapitulasiJaketModel;

@Mapper
public interface RekapitulasiJaketMapper {

	@Select("select ukuran_jaket as jenis_rekap, count(*) as jumlah from biodata where ukuran_jaket=#{ukuran_jaket}")
	RekapitulasiJaketModel selectRekapJaket(@Param("ukuran_jaket") String ukuran_jaket);
	
	@Select("select f.nama_fakultas as jenis_rekap, count(*) as jumlah from fakultas f, program_studi p, "
			+ "mahasiswa m where f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id and"
			+ "f.nama_fakultas=#{nama_fakultas}")
	RekapitulasiJaketModel selectRekapFakultas(@Param("nama_fakultas") String nama_fakultas);
	
	@Select("select distinct ukuran_jaket from biodata")
	List<String> getSizes();
	
	@Select("select distinct f.nama_fakultas from fakultas f, program_studi p, mahasiswa m where "
			+ "f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id")
	List<String> getFaculties();
}
