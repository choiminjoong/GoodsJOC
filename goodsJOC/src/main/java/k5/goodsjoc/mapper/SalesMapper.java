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

	//월별 매출 및 건수
	public List<Map<String, Object>> getSalesTotalInfo(String martCode);

<<<<<<< HEAD
=======
	//매출등록
	public int addsalesAction(Sales sales);
	
>>>>>>> refs/heads/develop
	//매출상세 조회 Ajax
	public List<SalesDetail> getSalesDetailList(String salesCode);
	
	//판매취소정보 Ajax
	public Sales getSalesCanselInfo(String salesCode);
	
	//영수증 취소처리
	public void receiptCanselAction(String id, String salesCode);
	//매출 조건검색
	public List<Sales> getSearchSalesList(Map<String, Object> paramMap);

	//1.주문번호 자동등록
	public String getReceiptNumber(String sessionMartCode);
	//2.매출등록
	public int salesInsertAction(Sales sales);
	//3.등록할 판매코드 검색
	public String getSalesCode(Sales sales);
	//4.매출상세등록
	public int salesDetailInertAction(SalesDetail salesDetail);
	//5.상품수량 업데이트
	public int goodsShowcaseQTYUpdate(String barcode, String qty);


}