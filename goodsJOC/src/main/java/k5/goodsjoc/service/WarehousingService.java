package k5.goodsjoc.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Warehousing;
import k5.goodsjoc.mapper.WarehousingMapper;

@Service
@Transactional
public class WarehousingService {
	
	private final WarehousingMapper warehousingMapper;
	public WarehousingService(WarehousingMapper warehousingMapper) {
		this.warehousingMapper = warehousingMapper;
	}
	
	//입고 등록
	public int warehousingInsert(Warehousing warehousing) {
		return warehousingMapper.warehousingInsert(warehousing);
	}
	
	//입고 조회 (오대성)
	public List<Warehousing> getWarehousingList(String martCode){
	      return warehousingMapper.getWarehousingList(martCode);

	}
	//입고 검색(오대성)
	  public List<Warehousing> getWarehousingBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt) {
			return warehousingMapper.getWarehousingBySearchKey(searchKey, searchValue, martCode, startDt, endDt);
		}
}
