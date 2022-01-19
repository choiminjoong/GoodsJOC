package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Sales;

@Mapper
public interface SalesMapper {
	
	//매출 전체 조회
	public List<Sales> getSalesList();
	
	//매출 조건검색
	public List<Sales> getSalesListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);

	//상품 모달
	public List<Map<String, Object>> getGoodsList(String martCode);
	
	
}