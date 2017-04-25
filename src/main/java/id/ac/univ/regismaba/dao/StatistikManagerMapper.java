package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.StatistikManagerModel;

@Mapper
public interface StatistikManagerMapper {

	@Select("")
	StatistikManagerModel selectStatistikFakultas();
}
