package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Business;

@Mapper
public interface BusinessMapper {
	
	// 거래처 전체 조회
	public List<Business> getBusinessList(String martCode);
	
	
}

