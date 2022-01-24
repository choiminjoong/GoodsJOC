package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Disposal;
import k5.goodsjoc.mapper.DisposalMapper;

@Service
@Transactional
public class DisposalService {
	
	private final DisposalMapper disposalMapper;
	public DisposalService(DisposalMapper disposalMapper) {
		this.disposalMapper = disposalMapper;
	}
	//폐기 조회(오대성)
	public List<Disposal> getDisposalList(String martCode){
		return disposalMapper.getDisposalList(martCode);
	}
	
	//폐기 검색(오대성)
	public List<Disposal> getDisposalBySearch(String searchKey, String searchValue, String martCode, String startDt, String endDt) {
		return disposalMapper.getDisposalBySearch(searchKey, searchValue, martCode, startDt, endDt);
	}
	
	
}
