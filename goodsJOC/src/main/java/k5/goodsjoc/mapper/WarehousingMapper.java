package k5.goodsjoc.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Warehousing;


@Mapper
public interface WarehousingMapper {
	
	//입고 등록
	public int warehousingInsert(Warehousing warehousing);
	
	//입고 조회
	public List<Warehousing> getWarehousingList(String martCode);
	
	//입고 검색(오대성)
	public List<Warehousing> getWarehousingBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt);
}

