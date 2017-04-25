
package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;

@Mapper
public interface InstitusiMapper {
	@Select("select institusi_id, nama_institusi from institusi")
	List<InstitusiModel> selectAllInstitusi();
	
	@Select("select institusi_id, nama_institusi from institusi where tingkat_pendidikan_id=#{tingkat_pendidikan_id}")
	List<InstitusiModel> selectInstitusiByTingkatPendidikanId(int provinsi_id);
	
	@Select("SELECT * FROM institusi WHERE institusi_id=#{institusi_id}")
	@Results(value = {
		@Result(property="nama_institusi", column="nama_institusi"),
		@Result(property="tingkat_pendidikan_id", column="tingkat_pendidikan_id"),
	})
	InstitusiModel selectInstitusi(int institusi_id);
}
