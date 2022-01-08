package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Business;
import k5.goodsjoc.mapper.BusinessMapper;

@Service
@Transactional
public class BusinessService {
	
	private final BusinessMapper businessMapper;
	public BusinessService(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}
	
	// 거래처 전체 조회
	public List<Business> getBusinessList(String martCode){
		return businessMapper.getBusinessList(martCode);
	}
	
	// 거래처 단일 정보 조회
	public Business getBusinessInfoByCode(String businessCode) {		
		return businessMapper.getBusinessInfoByCode(businessCode);
	}
	
	// 거래처 정보 수정
	public int updateBusinessInfo(Business business) {	
		return businessMapper.updateBusinessInfo(business);
	}

	public List<Business> getBusinessListBySearchKey(String searchKey, String searchValue) {
		return businessMapper.getBusinessListBySearchKey(searchKey, searchValue);
	}
}
