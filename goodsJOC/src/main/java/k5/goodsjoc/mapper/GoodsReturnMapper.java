package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.GoodsReturn;




@Mapper
public interface GoodsReturnMapper {
	
	 //반품 조회
	public List<GoodsReturn> getGoodsReturnList(String martCode);
	//반품 검색
	public List<GoodsReturn> getSearchGoodsReturnList(String martCode, String searchKey, String searchValue,  String startDt, String endDt);
	

	
}
