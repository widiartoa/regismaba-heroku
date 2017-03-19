package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.DataKesehatanMapper;
import id.ac.univ.regismaba.model.DataKesehatanModel;


@Service
public class DataKesehatanServiceImplement implements DataKesehatanService {
	@Autowired
	DataKesehatanMapper dataKesehatanMapper;
	
	@Override
	public void insertDataKesehatan(DataKesehatanModel dataKesehatan) {
		// TODO Auto-generated method stub
		dataKesehatanMapper.insertDataKesehatan(dataKesehatan);
	}

	@Override
	public int selectDataKesehatanId(DataKesehatanModel dataKesehatan) {
		// TODO Auto-generated method stub
		int id = dataKesehatanMapper.selectDataKesehatanId(dataKesehatan);
		return id;
	}

}
