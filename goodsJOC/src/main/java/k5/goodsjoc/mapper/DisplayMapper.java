package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DisplayMapper {
	
	//매입전체 조회
	public List<Map<String, Object>> getDisplayList(String martCode);
	
}
