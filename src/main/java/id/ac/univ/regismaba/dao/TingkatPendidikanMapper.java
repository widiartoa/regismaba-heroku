
package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.TingkatPendidikanModel;

@Mapper
public interface TingkatPendidikanMapper {
	@Select("select tingkat_pendidikan_id, nama_tingkat_pendidikan from tingkat_pendidikan")
	List<TingkatPendidikanModel> selectAllTingkatPendidikan();
	
	@Select("SELECT * FROM tingkat_pendidikan WHERE tingkat_pendidikan_id=#{tingkat_pendidikan_id}")
	@Results(value = {
		@Result(property="nama_tingkat_pendidikan", column="nama_tingkat_pendidikan"),
	})
	TingkatPendidikanModel selectTingkatPendidikan(int tingkat_pendidikan_id);
}
