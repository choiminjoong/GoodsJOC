package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.dto.PurchasePrice;
import k5.goodsjoc.dto.SalesPrice;

@Mapper
public interface GoodsMapper {
	

	//상품리스트 조회(카테고리+상품) 
	public List<Goods> getGoodsList(String martCode);
	
	//카테고리 등록
	public int addGoodsCate(GoodsCate goodsCate);
	//카테고리 조회
	public List<GoodsCate> getGoodsCateList(String martCode);

	public List<Goods> getSearchGoodsList(Map<String, Object> paramMap);

	public List<Map<String, Object>> goodsCateModal();

	//단일 상품정보 조회
	public Goods getGoodsInfoByBarcode(String barcode);

	//단일상품 매입가 리스트
	public List<PurchasePrice> getPurchasePriceListByBarcode(String barcode);
	//단일상품 판매가 리스트
	public List<SalesPrice> getSalesPriceListByBarcode(String barcode);

	//상품 판매단가 수정
	public int updateGoodsPrice(String barcode, String salesPrice);

	public int addSalesPrice(Map<String, Object> paramMap);

	public List<Map<String, Object>> getCategoryList(String martCode);

}
