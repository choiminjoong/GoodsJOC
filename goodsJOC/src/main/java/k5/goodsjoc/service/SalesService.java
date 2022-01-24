package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.dto.SalesDetail;
import k5.goodsjoc.mapper.SalesMapper;

@Service
@Transactional
public class SalesService {
	
	private final SalesMapper salesMapper;
	public SalesService(SalesMapper salesMapper) {
		this.salesMapper = salesMapper;
	}
	//매출 전체조회
	public List<Sales> getSalesList(String martCode){
		return salesMapper.getSalesList(martCode);
	}
	
	//매출 조건 검색
	public List<Sales> getSalesListBySearchKey(String searchKey, String searchValue, String startDt, String endDt) {
		return salesMapper.getSalesListBySearchKey(searchKey, searchValue, startDt, endDt);
	}
	
	//상품검색모달
	public List<Map<String, Object>> getGoodsList(String martCode) {
		return salesMapper.getGoodsList(martCode);
	}
	
	//매출등록화면
	public int salesInsert(Sales sales) {
		return salesMapper.salesInsert(sales);
	}
	//월별 건수 및 금액 조회
	public List<Map<String, Object>> getSalesTotalInfo(String martCode){
		return salesMapper.getSalesTotalInfo(martCode);
	}
	
	//매출등록
	public int addsalesAction(Sales sales) {
		return salesMapper.addsalesAction(sales);
	}
	//매출상세 Ajax
	public List<SalesDetail> getSalesDetailList(String salesCode) {
		return salesMapper.getSalesDetailList(salesCode);
	}
	//판매취소정보
	public Sales getSalesCanselInfo(String salesCode) {
		return salesMapper.getSalesCanselInfo(salesCode);
	}
	public void receiptCanselAction(String id, String salesCode) {
		salesMapper.receiptCanselAction(id, salesCode);
	}
	public List<Sales> getSearchSalesList(Map<String, Object> paramMap) {
		return salesMapper.getSearchSalesList(paramMap);
	}
}
