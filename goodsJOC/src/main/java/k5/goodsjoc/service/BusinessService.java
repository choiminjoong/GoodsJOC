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
/**
	01.거래처 등록처리	02.거래처 전체조회	03.거래처 조건조회	04.특정 거래처 정보조회	05.거래처 정보 수정처리
**/
	//01.거래처 등록처리
	public int businessInsert(Business business) {
		return businessMapper.businessInsert(business);
	}
	
	//02.거래처 전체조회
	public List<Business> getBusinessList(String martCode){
		return businessMapper.getBusinessList(martCode);
	}

	//03.거래처 조건조회
	public List<Business> getBusinessListBySearchKey(String searchKey, String searchValue, String startDt, String endDt) {
		return businessMapper.getBusinessListBySearchKey(searchKey, searchValue, startDt, endDt);
	}

	//04.특정 거래처 정보조회
	public Business getBusinessInfoByCode(String businessCode) {		
		return businessMapper.getBusinessInfoByCode(businessCode);
	}

	//05.거래처 정보 수정처리
	public int updateBusinessInfo(Business business) {

		return businessMapper.updateBusinessInfo(business);
	}
	
	//거래처 삭제
	public int businessDeleteAction(String businessCode) {
		return businessMapper.businessDeleteAction(businessCode);
	}

}