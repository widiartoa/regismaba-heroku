package id.ac.univ.regismaba.service;

import java.util.List;
import id.ac.univ.regismaba.model.TingkatRoleModel;

public interface TingkatRoleService {

	TingkatRoleModel selectTRM(int tingkat_role_id);

	List<TingkatRoleModel> selectAllTRM();
}

