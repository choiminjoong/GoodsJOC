package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.GoodsReturn;
import k5.goodsjoc.mapper.GoodsReturnMapper;

@Service
@Transactional
public class GoodsReturnService {
	
	private final GoodsReturnMapper goodsReturnMapper;
	public GoodsReturnService(GoodsReturnMapper goodsReturnMapper) {
		this.goodsReturnMapper = goodsReturnMapper;
	}
	
	//반품 조회
	public List<GoodsReturn> getGoodsReturnList(String martCode){
		return goodsReturnMapper.getGoodsReturnList(martCode);
	}
	//반품 검색
	public List<GoodsReturn> getSearchGoodsReturnList(String martCode, String searchKey, String searchValue, String startDt, String endDt){
		return goodsReturnMapper.getSearchGoodsReturnList(martCode, searchKey, searchValue, startDt, endDt);
	}
	//월별 건수 및 금액 조회
	public List<Map<String, Object>> getReturnPriceTotalInfo(String martCode){
		return goodsReturnMapper.getReturnPriceTotalInfo(martCode);
	}
	//반품(상품) 모달
	public List<Map<String, Object>> getGoodsReturnModal(String martCode) {
		return goodsReturnMapper.getGoodsReturnModal(martCode);
	}
	//반품 등록
	public int addreturnAction(GoodsReturn goodsReturn) {
		return goodsReturnMapper.addreturnAction(goodsReturn);
	}
	
}
