package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatistikManagerMapper {

	@Select("")
	void selectStatistikFakultas();
}
