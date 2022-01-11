package k5.goodsjoc.mapper;


import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Warehousing;


@Mapper
public interface WarehousingMapper {
	
	//입고 등록
	public int warehousingInsert(Warehousing warehousing);

}

