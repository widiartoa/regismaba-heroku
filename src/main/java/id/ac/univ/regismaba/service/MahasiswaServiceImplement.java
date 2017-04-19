package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.MahasiswaMapper;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MahasiswaServiceImplement implements MahasiswaService{
	
	@Autowired
	MahasiswaMapper mahasiswaMapper;
	
	@Override
	public MahasiswaModel selectMahasiswa(String npm) {
		// TODO Auto-generated method stub
		log.info ("select mahasiswa with npm {}", npm);
		return mahasiswaMapper.selectMahasiswa(npm);
	}

	@Override
	public List<MahasiswaModel> selectAllMahasiswa() {
		// TODO Auto-generated method stub
		log.info ("select all mahasiswa");
		List<MahasiswaModel> mahasiswas = mahasiswaMapper.selectAllMahasiswa();
		for (MahasiswaModel mahasiswa : mahasiswas){
			mahasiswa.setNama_lengkap(mahasiswaMapper.selectNamaLengkap(mahasiswa.getUsername()));
			BiodataModel biodataMhs = mahasiswaMapper.selectBiodataMahasiswa(mahasiswa.getUsername());
			mahasiswa.setBiodata(biodataMhs);
			ProgramStudiModel program_studi = mahasiswaMapper.selectProgramStudiMahasiswa(mahasiswa.getProgram_studi_id());
			mahasiswa.setProgram_studi(program_studi);
			mahasiswa.setProgram(mahasiswaMapper.selectProgramMahasiswa(program_studi.getProgram_id()));
			mahasiswa.setFakultas(mahasiswaMapper.selectFakultasMahasiswa(program_studi.getFakultas_id()));
			mahasiswa.setJenjang(mahasiswaMapper.selectJenjangMahasiswa(program_studi.getJenjang_id()));
		}
		return mahasiswas;
	}

	@Override
	public void insertBiodataMahasiswa(String npm, String biodata_id) {
		// TODO Auto-generated method stub
		log.info ("insert biodata to mahasiswa with npm {}", npm);
		mahasiswaMapper.insertBiodataMahasiswa(npm, biodata_id);
	}

	@Override
	public void insertJenjangMahasiswa(String npm, String jenjang_id) {
		// TODO Auto-generated method stub
		log.info ("insert jenjang to mahasiswa with npm {}", npm);
		mahasiswaMapper.insertJenjangMahasiswa(npm, jenjang_id);
	}

	@Override
	public void insertPengajuanMahasiswa(String npm, String pengajuan_id) {
		// TODO Auto-generated method stub
		log.info ("insert pengajuan to mahasiswa with npm {}", npm);
		mahasiswaMapper.insertPengajuanMahasiswa(npm, pengajuan_id);
	}

	@Override
	public void updateBiodataMahasiswa(String npm, String biodata_id) {
		// TODO Auto-generated method stub
		log.info ("update biodata mahasiswa with npm {}", npm);
		mahasiswaMapper.updateBiodataMahasiswa(npm, biodata_id);
	}

	@Override
	public void updateJenjangMahasiswa(String npm, String jenjang_id) {
		// TODO Auto-generated method stub
		log.info ("update jenjang mahasiswa with npm {}", npm);
		mahasiswaMapper.updateJenjangMahasiswa(npm, jenjang_id);
	}

	@Override
	public void updatePengajuanMahasiswa(String npm, String pengajuan_id) {
		// TODO Auto-generated method stub
		log.info ("update pengajuan mahasiswa with npm {}", npm);
		mahasiswaMapper.updatePengajuanMahasiswa(npm, pengajuan_id);
	}

    @Override
    public MahasiswaModel loginMahasiswa (String username, String password)
    {
        return mahasiswaMapper.loginMahasiswa (username, password);
    }

	@Override
	public MahasiswaModel selectMahasiswaByUsername(String username) {
		// TODO Auto-generated method stub
		log.info ("select mahasiswa with username {}", username);
		return mahasiswaMapper.selectMahasiswaByUsername(username);
	}
}
