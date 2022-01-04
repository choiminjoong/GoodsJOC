package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.GoodsCate;

@Mapper
public interface GoodsMapper {

	//카테고리 조회
	public List<GoodsCate> getGoodsCateList();
}
