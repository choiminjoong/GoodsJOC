package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.dto.SalesDetail;

@Mapper
public interface SalesMapper {
	
	//매출 전체 조회
	public List<Sales> getSalesList(String martCode);
	
	//매출 조건검색
	public List<Sales> getSalesListBySearchKey(String searchKey, String searchValue, String startDt, String endDt);

	//상품 모달
	public List<Map<String, Object>> getGoodsList(String martCode);

	//매출등록화면
	public int salesInsert(Sales sales);

	//월별 매출 및 건수
	public List<Map<String, Object>> getSalesTotalInfo(String martCode);

	//매출등록
	public int addsalesAction(Sales sales);
	//매출상세 조회 Ajax
	public List<SalesDetail> getSalesDetailList(String salesCode);
	//판매취소정보 Ajax
	public Sales getSalesCanselInfo(String salesCode);


}