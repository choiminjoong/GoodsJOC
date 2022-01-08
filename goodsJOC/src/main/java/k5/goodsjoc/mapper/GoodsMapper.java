package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;

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

	public Goods getGoodsInfoByBarcode(String barcode);

}
