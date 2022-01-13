package k5.goodsjoc.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Warehousing;


@Mapper
public interface WarehousingMapper {
	
	//입고 등록
	public int warehousingInsert(Warehousing warehousing);
	
	//입고 조회
	public List<Warehousing> getWarehousingList();
}

