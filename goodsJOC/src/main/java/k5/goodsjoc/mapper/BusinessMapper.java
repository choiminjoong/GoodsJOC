package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Business;

@Mapper
public interface BusinessMapper {
	
	// 거래처 전체 조회
	public List<Business> getBusinessList(String martCode);
	
	// 거래처 정보 단일조회
	public Business getBusinessInfoByCode(String businessCode);
	
	// 거래처 목록 검색
	public List<Business> getBusinessListBySearchKey(String searchKey, String searchValue);
	
	// 거래처 정보 수정`
	public int updateBusinessInfo(Business business);
	
	//거래처 등록
	public int businessInsert(Business business);
	

}

