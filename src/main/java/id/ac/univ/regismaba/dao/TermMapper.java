package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.TermModel;

@Mapper
public interface TermMapper {

	@Select("select * from term")
	List<TermModel> selectAllTerm();
	
	@Select("select * from term where term_id = #{term_id}")
	TermModel selectTerm(@Param("term_id") int term_id);
}
