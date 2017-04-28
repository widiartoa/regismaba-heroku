package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;

@Mapper
public interface StatistikManagerMapper {

	@Select("select f.nama_fakultas as jenis_rekap, count(*) as jumlah from fakultas f, program_studi p, "
			+ "mahasiswa m, where f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id and "
			+ "f.fakultas_id=#{fakultas_id}")
	StatistikManagerModel selectPemilihFakultas(@Param("fakultas_id") int fakultas_id);
	
	@Select("select p.nama_program_studi as jenis_rekap, count(*) as jumlah from program_studi p, mahasiswa m "
			+ "where p.program_studi_id=m.program_studi_id and p.program_studi_id={program_studi_id}")
	StatistikManagerModel selectPemilihProdi(@Param("program_studi_id") int program_studi_id);
	
	@Select("select j.nama_jenjang as jenis_rekap, count(*) as jumlah from jenjang j, program_studi p, "
			+ "mahasiswa m where j.jenjang_id=p.jenjang_id and p.program_studi_id=m.program_studi_id and "
			+ "j.jenjang_id={jenjang_id}")
	StatistikManagerModel selectJenjang(@Param("jenjang_id") int jenjang_id);
	
	@Select("select p.nama_program as jenis_rekap, count(*) as jumlah from program p, program_studi s, "
			+ "mahasiswa m where p.program_id=s.program_id and s.program_studi_id=m.program_studi_id and "
			+ "p.program_id={program_id}")
	StatistikManagerModel selectProgram(@Param("program_id") int program_id);
	
	@Select("select distinct f.fakultas_id, f.nama_fakultas from fakultas f, program_studi p, mahasiswa m where "
			+ "f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id")
	List<FakultasModel> getFaculties();
	
	@Select("select distinct * from program_studi p, mahasiswa m where p.program_studi_id=m.program_studi_id")
	List<ProgramStudiModel> getMajors();
	
	@Select("select distinct * from jenjang j, program_studi p, mahasiswa m where j.jenjang_id=p.jenjang_id and "
			+ "p.program_studi_id=m.program_studi_id")
	List<JenjangModel> getLevels();
	
	@Select("select distinct * from program p, program_studi s, mahasiswa m where p.program_id=s.program_id and "
			+ "s.program_studi_id=m.program_studi_id")
	List<ProgramModel> getPrograms();
}
