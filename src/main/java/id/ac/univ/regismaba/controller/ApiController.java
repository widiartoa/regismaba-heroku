package id.ac.univ.regismaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.service.KotaKabupatenService;

@Controller
public class ApiController {
	@Autowired
	KotaKabupatenService kotaKabupatenService;

	@RequestMapping(value = "/api/provinsi/{provinsi_id}", method = RequestMethod.GET)
	public @ResponseBody String getKotaKabupatenByProvinsiId(@PathVariable(value = "provinsi_id") int provinsi_id) {
		StringBuilder sb = new StringBuilder();
		List<KotaKabupatenModel> listOfKotaKabupaten = kotaKabupatenService
				.selectKotaKabupatenByProvinsiId(provinsi_id);

		sb.append("[");
		for (KotaKabupatenModel kotaKabupaten : listOfKotaKabupaten) {
			sb.append("{");
			sb.append("\"id\" : ").append(kotaKabupaten.getKota_kabupaten_id()).append(",");
			sb.append("\"nama\" : \"").append(kotaKabupaten.getNama_kota_kabupaten()).append("\"");
			sb.append("},");
		}
		if (listOfKotaKabupaten.size() > 0)
			sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
