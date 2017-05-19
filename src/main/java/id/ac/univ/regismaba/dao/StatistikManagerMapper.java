package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JalurModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;

@Mapper
public interface StatistikManagerMapper {

	@Select("select f.nama_fakultas as jenis_rekap, count(*) as jumlah from fakultas f, program_studi p, "
			+ "mahasiswa m where f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id and "
			+ "f.fakultas_id=#{fakultas_id} group by f.nama_fakultas")
	StatistikManagerModel selectPemilihFakultas(@Param("fakultas_id") int fakultas_id);
	
	@Select("select p.nama_program_studi as jenis_rekap, count(*) as jumlah from program_studi p, mahasiswa m "
			+ "where p.program_studi_id=m.program_studi_id and p.program_studi_id=#{program_studi_id} "
			+ "group by p.nama_program_studi")
	StatistikManagerModel selectPemilihProdi(@Param("program_studi_id") int program_studi_id);
	
	@Select("select j.nama_jenjang as jenis_rekap, count(*) as jumlah from jenjang j, program_studi p, "
			+ "mahasiswa m where j.jenjang_id=p.jenjang_id and p.program_studi_id=m.program_studi_id and "
			+ "j.jenjang_id=#{jenjang_id} group by j.nama_jenjang")
	StatistikManagerModel selectJenjang(@Param("jenjang_id") int jenjang_id);
	
	@Select("select p.nama_program as jenis_rekap, count(*) as jumlah from program p, program_studi s, "
			+ "mahasiswa m where p.program_id=s.program_id and s.program_studi_id=m.program_studi_id and "
			+ "p.program_id=#{program_id} group by p.nama_program")
	StatistikManagerModel selectProgram(@Param("program_id") int program_id);
	
	@Select("select j.nama_jalur as jenis_rekap, count(*) as jumlah from jalur j, mahasiswa m where "
			+ "j.jalur_id=m.jalur_id and j.jalur_id=#{jalur_id} group by j.nama_jalur")
	StatistikManagerModel selectJalur(@Param("jalur_id") int jalur_id);
	
	@Select("select distinct f.fakultas_id, f.nama_fakultas from fakultas f, program_studi p, mahasiswa m where "
			+ "f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id")
	List<FakultasModel> getFaculties();
	
	@Select("select distinct p.program_studi_id, p.nama_program_studi from program_studi p, mahasiswa m where p.program_studi_id=m.program_studi_id")
	List<ProgramStudiModel> getMajors();
	
	@Select("select distinct j.jenjang_id, j.nama_jenjang from jenjang j, program_studi p, mahasiswa m where j.jenjang_id=p.jenjang_id and "
			+ "p.program_studi_id=m.program_studi_id")
	List<JenjangModel> getLevels();
	
	@Select("select distinct p.program_id, p.nama_program from program p, program_studi s, mahasiswa m where p.program_id=s.program_id and "
			+ "s.program_studi_id=m.program_studi_id")
	List<ProgramModel> getPrograms();
	
	@Select("select distinct j.jalur_id, j.nama_jalur from jalur j, mahasiswa m where j.jalur_id=m.jalur_id")
	List<JalurModel> getPaths();
	
	@Select("select f.nama_fakultas as jenis_rekap, count(*) as jumlah from fakultas f, program_studi p, "
			+ "mahasiswa m, biodata b, pengajuan_skema_pembayaran s where f.fakultas_id=p.fakultas_id and "
			+ "p.program_studi_id=m.program_studi_id and m.username=b.username and m.username=s.username and "
			+ "b.sidik_jari is not null and f.fakultas_id=#{fakultas_id} group by f.nama_fakultas")
	StatistikManagerModel selectRegistranFakultas(@Param("fakultas_id") int fakultas_id);
	
	@Select("select p.nama_program_studi as jenis_rekap, count(*) as jumlah from program_studi p, mahasiswa m, "
			+ "biodata b, pengajuan_skema_pembayaran s where p.program_studi_id=m.program_studi_id and "
			+ "m.username=b.username and m.username=s.username and b.sidik_jari is not null and "
			+ "p.program_studi_id=#{program_studi_id} group by p.nama_program_studi")
	StatistikManagerModel selectRegistranProdi(@Param("program_studi_id") int program_studi_id);
	
	@Select("select j.nama_jenjang as jenis_rekap, count(*) as jumlah from jenjang j, program_studi p, "
			+ "mahasiswa m, biodata b, pengajuan_skema_pembayaran s where j.jenjang_id=p.jenjang_id and "
			+ "p.program_studi_id=m.program_studi_id and m.username=b.username and m.username=s.username and "
			+ "b.sidik_jari is not null and j.jenjang_id=#{jenjang_id} group by j.nama_jenjang")
	StatistikManagerModel selectRegistranJenjang(@Param("jenjang_id") int jenjang_id);
	
	@Select("select p.nama_program as jenis_rekap, count(*) as jumlah from program p, program_studi s, "
			+ "mahasiswa m, biodata b, pengajuan_skema_pembayaran psp where p.program_id=s.program_id and "
			+ "s.program_studi_id=m.program_studi_id and m.username=b.username and m.username=psp.username and "
			+ "b.sidik_jari is not null and p.program_id=#{program_id} group by p.nama_program")
	StatistikManagerModel selectRegistranProgram(@Param("program_id") int program_id);
	
	@Select("select j.nama_jalur as jenis_rekap, count(*) as jumlah from jalur j, "
			+ "mahasiswa m, biodata b, pengajuan_skema_pembayaran psp where "
			+ "m.username=b.username and m.username=psp.username and j.jalur_id=m.jalur_id and "
			+ "b.sidik_jari is not null and j.jalur_id=#{jalur_id} group by j.nama_jalur")
	StatistikManagerModel selectRegistranJalur(@Param("jalur_id") int jalur_id);
	
	@Select("select nama_fakultas as nama, "
			+ "(select count(*) from mahasiswa m, program_studi p, fakultas f where m.program_studi_id=p.program_studi_id and p.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) as total, "
			+ "(select count(*) from mahasiswa m, program_studi p, fakultas f, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and p.fakultas_id=f.fakultas_id and m.username=b.username and m.username=s.username and b.sidik_jari is not null and f.fakultas_id=#{fakultas_id}) as regis, "
			+ "((select count(*) from mahasiswa m, program_studi p, fakultas f where m.program_studi_id=p.program_studi_id and p.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) - "
			+ "(select count(*) from mahasiswa m, program_studi p, fakultas f, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and p.fakultas_id=f.fakultas_id and m.username=b.username and m.username=s.username and b.sidik_jari is not null and f.fakultas_id=#{fakultas_id})) as non_regis "
			+ "from fakultas where fakultas_id=#{fakultas_id}")
	StatistikManagerSummaryModel summaryFaculty(@Param("fakultas_id") int fakultas_id);
	
	@Select("select nama_program_studi as nama, "
			+ "(select count(*) from mahasiswa m, program_studi p where m.program_studi_id=p.program_studi_id and p.program_studi_id=#{program_studi_id}) as total, "
			+ "(select count(*) from mahasiswa m, program_studi p, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.program_studi_id=#{program_studi_id}) as regis, "
			+ "((select count(*) from mahasiswa m, program_studi p where m.program_studi_id=p.program_studi_id and p.program_studi_id=#{program_studi_id}) - "
			+ "(select count(*) from mahasiswa m, program_studi p, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.program_studi_id=#{program_studi_id})) as non_regis "
			+ "from program_studi where program_studi_id=#{program_studi_id}")
	StatistikManagerSummaryModel summaryMajor(@Param("program_studi_id") int program_studi_id);
	
	@Select("select nama_jenjang as nama, "
			+ "(select count(*) from mahasiswa m, program_studi p, jenjang j where m.program_studi_id=p.program_studi_id and p.jenjang_id=j.jenjang_id and j.jenjang_id=#{jenjang_id}) as total, "
			+ "(select count(*) from mahasiswa m, program_studi p, jenjang j, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.jenjang_id=j.jenjang_id and j.jenjang_id=#{jenjang_id}) as regis, "
			+ "((select count(*) from mahasiswa m, program_studi p, jenjang j where m.program_studi_id=p.program_studi_id and p.jenjang_id=j.jenjang_id and j.jenjang_id=#{jenjang_id}) - "
			+ "(select count(*) from mahasiswa m, program_studi p, jenjang j, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.jenjang_id=j.jenjang_id and j.jenjang_id=#{jenjang_id})) as non_regis "
			+ "from jenjang where jenjang_id=#{jenjang_id}")
	StatistikManagerSummaryModel summaryLevel(@Param("jenjang_id") int jenjang_id);
	
	@Select("select nama_program as nama, "
			+ "(select count(*) from mahasiswa m, program_studi p, program r where m.program_studi_id=p.program_studi_id and p.program_id=r.program_id and r.program_id=#{program_id}) as total, "
			+ "(select count(*) from mahasiswa m, program_studi p, program r, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.program_id=r.program_id and r.program_id=#{program_id}) as regis, "
			+ "((select count(*) from mahasiswa m, program_studi p, program r where m.program_studi_id=p.program_studi_id and p.program_id=r.program_id and r.program_id=#{program_id}) - "
			+ "(select count(*) from mahasiswa m, program_studi p, program r, biodata b, pengajuan_skema_pembayaran s where m.program_studi_id=p.program_studi_id and m.username=b.username and m.username=s.username and p.program_id=r.program_id and r.program_id=#{program_id})) as non_regis "
			+ "from program where program_id=#{program_id}")
	StatistikManagerSummaryModel summaryProgram(@Param("program_id") int program_id);
	
	@Select("select nama_jalur as nama, "
			+ "(select count(*) from mahasiswa m, jalur j where j.jalur_id=m.jalur_id and j.jalur_id=#{jalur_id}) as total, "
			+ "(select count(*) from mahasiswa m, jalur j, biodata b, pengajuan_skema_pembayaran s where m.jalur_id=j.jalur_id and m.username=b.username and m.username=s.username and j.jalur_id=#{jalur_id}) as regis, "
			+ "((select count(*) from mahasiswa m, jalur j where j.jalur_id=m.jalur_id and j.jalur_id=#{jalur_id}) - "
			+ "(select count(*) from mahasiswa m, jalur j, biodata b, pengajuan_skema_pembayaran s where m.jalur_id=j.jalur_id and m.username=b.username and m.username=s.username and j.jalur_id=#{jalur_id})) as non_regis "
			+ "from jalur where jalur_id=#{jalur_id}")
	StatistikManagerSummaryModel summaryPath(@Param("jalur_id") int jalur_id);
}
