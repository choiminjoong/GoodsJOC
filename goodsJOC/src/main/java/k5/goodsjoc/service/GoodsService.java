package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.dto.PurchasePrice;
import k5.goodsjoc.dto.SalesPrice;
import k5.goodsjoc.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	private final GoodsMapper goodsMapper;
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
/**
	01.카테고리 전체조회	02.카테고리 등록처리	03.카테고리 수정처리	04.카테고리 삭제 전 상품의 분류를 미지정으로 수정처리 
	05.카테고리 삭제처리	06.카테고리 조건검색 화면	07.바코드 사용여부 체크	08.상품등록처리		09.바코드로 상품정보 가져오기	
	10.상품정보 수정처리	11.상품 삭제처리		12.상품 전체조회		13.카테고리 선택 모달 Ajax		14.상품 조건검색
	15.특정 상품 매입가 조회	16.특정 상품 판매가 조회	17.상품 판매가 수정	18.수정된 판매가 기록
**/	
	//01.카테고리 전체조회
	public List<GoodsCate> getGoodsCateList(String martCode){
		return goodsMapper.getGoodsCateList(martCode);
	}

	//02.카테고리 등록처리
	public int goodsCateInsertAction(GoodsCate goodsCate) {
		return goodsMapper.goodsCateInsertAction(goodsCate);
	}

	//03.카테고리 수정처리
	public int goodsCateUpdate(GoodsCate goodsCate) {
		return goodsMapper.goodsCateUpdate(goodsCate);
	}

	//04.카테고리 삭제 전 상품의 분류를 미지정으로 수정처리
	public int updateGoodsCategoryCode(String categoryCode) {
		int result = 0;
		result += goodsMapper.updateGoodsCategoryCode(categoryCode);
		return result;
	}

	//05.카테고리 삭제처리
	public int goodsCateDeleteAction(String categoryCode) {
		return goodsMapper.goodsCateDeleteAction(categoryCode);
	}

	//06.카테고리 조건검색 화면
	public List<GoodsCate> getSearchGoodsCateList(String searchCate, String martCode) {
		return goodsMapper.getSearchGoodsCateList(searchCate, martCode);
	}
	
	//07.바코드 사용여부 체크
	public int goodsCheckByBarcode(String barcode) {
		int result = 0;
		result += goodsMapper.goodsCheckByBarcode(barcode);
		
		return result;
	}
	
	//08.상품등록처리
	public int addGoodsAction(Goods goods) {
		return goodsMapper.addGoodsAction(goods);
	}

	//09.바코드로 상품정보 가져오기
	public Goods getGoodsInfoByBarcode(String barcode) {
		return goodsMapper.getGoodsInfoByBarcode(barcode);
	}

	//10.상품정보 수정처리
	public int goodsUpdateAction(Goods goods) {
		return goodsMapper.goodsUpdateAction(goods);
	}
	
	//11.상품 삭제처리
	public int deleteGoods(String barcode) {
		return goodsMapper.deleteGoods(barcode);
	}

	//12.상품 전체조회
	public List<Goods> getGoodsList(String martCode){ 		
		return goodsMapper.getGoodsList(martCode); 
	}

	//13.카테고리 선택 모달 Ajax
	public List<Map<String, Object>> getCategoryList(String martCode) {

		return goodsMapper.getCategoryList(martCode);
	}
	
	//14.상품 조건검색
	public List<Goods> getSearchGoodsList(Map<String, Object> paramMap){
		return goodsMapper.getSearchGoodsList(paramMap);
	}

	//15.특정 상품 매입가 조회
	public List<PurchasePrice> getPurchasePriceListByBarcode(String barcode) {
		return goodsMapper.getPurchasePriceListByBarcode(barcode);
	}
	
	//16.특정 상품 판매가 조회
	public List<SalesPrice> getSalesPriceListByBarcode(String barcode) {
		return goodsMapper.getSalesPriceListByBarcode(barcode);
	}

	//17.상품 판매가 수정
	public int updateGoodsPrice(String barcode, String salesPrice) {
		return goodsMapper.updateGoodsPrice(barcode, salesPrice);
	}

	//18.수정된 판매가 기록
	public int addSalesPrice(Map<String, Object> paramMap) {
		return goodsMapper.addSalesPrice(paramMap);
	}


}

