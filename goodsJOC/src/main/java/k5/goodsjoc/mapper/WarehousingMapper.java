package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Warehousing;


@Mapper
public interface WarehousingMapper {
	
	
	// 입고 검색
	public List<Warehousing> getWarehousingListBySearchKey(String searchKey, String searchValue);

}

