package k5.goodsjoc.service;


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
	
	public int warehousingInsert(Warehousing warehousing) {
		return warehousingMapper.warehousingInsert(warehousing);
		
	}

	
}
