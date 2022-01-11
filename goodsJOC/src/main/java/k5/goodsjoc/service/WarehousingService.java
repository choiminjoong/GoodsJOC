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
	

	public List<Warehousing> getWarehousingListBySearchKey(String searchKey, String searchValue) {
		return warehousingMapper.getWarehousingListBySearchKey(searchKey, searchValue);
	}
}
