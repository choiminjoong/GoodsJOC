package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.GoodsCate;
import k5.goodsjoc.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	
	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	public List<GoodsCate> getGoodsCateList(){
		return goodsMapper.getGoodsCateList();
		
	}
}
