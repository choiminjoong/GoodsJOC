package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.dto.SalesDetail;

@Mapper
public interface SalesMapper {
	
	//매출 전체 조회
	public List<Sales> getSalesList();
	
	//매출 조건검색
	public List<Sales> getSalesListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);
	
	//영수증 모달
	public List<SalesDetail> getsalesDetailList();
	
	
}