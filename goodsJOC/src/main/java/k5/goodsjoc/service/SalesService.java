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
	
	//월별 건수 및 금액 조회
	public List<Map<String, Object>> getSalesTotalInfo(String martCode){
		return salesMapper.getSalesTotalInfo(martCode);
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
	
	//1.최근 주문번호+1
	public String getReceiptNumber(String sessionMartCode) {
		return salesMapper.getReceiptNumber(sessionMartCode);
	}
	//2.매출등록 	
	public int salesInsertAction(Sales sales) {
		int result = 0;
		result += salesMapper.salesInsertAction(sales);
		
		return result;
	}
	//3.등록할 판매코드 검색
	public String getSalesCode(Sales sales) {
		return salesMapper.getSalesCode(sales);
	}
	//4.매출상세등록
	public int salesDetailInertAction(SalesDetail salesDetail) {
		int result = 0;
		result += salesMapper.salesDetailInertAction(salesDetail);
		
		return result;
	}
	//5.상품수량 업데이트
	public int goodsShowcaseQTYUpdate(String barcode, String qty) {
		int result = 0;
		result += salesMapper.goodsShowcaseQTYUpdate(barcode, qty);
		
		return result;
	}

}
