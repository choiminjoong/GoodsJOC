package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.GoodsReturn;




@Mapper
public interface GoodsReturnMapper {
	
	 //반품 조회
	public List<GoodsReturn> getGoodsReturnList(String martCode);
	//반품 검색
	public List<GoodsReturn> getSearchGoodsReturnList(String martCode, String searchKey, String searchValue,  String startDt, String endDt);
	//월별 매출 및 건수
	public List<Map<String, Object>> getReturnPriceTotalInfo(String martCode);
	//반품(상품) 모달
	public List<Map<String, Object>> getGoodsReturnModal(String martCode);
	//반품등록
	public int addreturnAction(GoodsReturn goodsReturn);

	
}
