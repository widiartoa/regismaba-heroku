package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.RumpunModel;

@Mapper
public interface RumpunMapper {

	@Select("select r.rumpun_id, r.nama_rumpun from mahasiswa m, program_studi p, fakultas f, rumpun r where "
			+ "r.rumpun_id=f.rumpun_id and f.fakultas_id=p.fakultas_id and "
			+ "p.program_studi_id=m.program_studi_id and m.username=#{username}")
	@Results(value = {
			 @Result(property="rumpun_id", column="rumpun_id"),
			 @Result(property="nama_rumpun", column="nama_rumpun")
			})
	RumpunModel getRumpun(@Param("username") String username);
}
