package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Sales;

@Mapper
public interface SalesMapper {
	
	//매출 전체 조회
	public List<Sales> getSalesList();
	}


