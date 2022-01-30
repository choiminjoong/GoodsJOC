package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Business;

@Mapper
public interface BusinessMapper {
/**
	01.거래처 등록처리	02.거래처 전체조회	03.거래처 조건조회	04.특정 거래처 정보조회	05.거래처 정보 수정처리
**/	
	//01.거래처 등록처리
	public int businessInsert(Business business);
	
	//02.거래처 전체조회
	public List<Business> getBusinessList(String martCode);

	//03.거래처 조건조회
	public List<Business> getBusinessListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);

	//04.특정 거래처 정보조회
	public Business getBusinessInfoByCode(String businessCode);
	
	//05.거래처 정보 수정처리
	public int updateBusinessInfo(Business business);
	

	
	//거래처 삭제
	public int deleteBusiness(String businessCode);

}

