package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Goods;
import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {

	
	private final GoodsMapper goodsMapper;
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	

	
	public List<Goods> getGoodsList(String martCode){ 
		
		return goodsMapper.getGoodsList(martCode); 
	}
	
	
	public List<GoodsCate> getGoodsCateList(String martCode){
		return goodsMapper.getGoodsCateList(martCode);
	}

	//상품 조건검색
	public List<Goods> getSearchGoodsList(Map<String, Object> paramMap){
		return goodsMapper.getSearchGoodsList(paramMap);
	}

	public List<Map<String, Object>> goodsCateModal() {
		return goodsMapper.goodsCateModal();
	}


}

