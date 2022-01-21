package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;





@Mapper
public interface DisplayMapper {
	
	//재고이동 전체 조회
	public List<Map<String, Object>> getDisplayList(String martCode);
	
	//재고이동 검색
	 public List<Map<String, Object>> getDisplayBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt);
	
	
}
