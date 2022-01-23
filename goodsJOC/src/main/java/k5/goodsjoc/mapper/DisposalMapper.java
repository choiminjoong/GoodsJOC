package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Disposal;


@Mapper
public interface DisposalMapper {
	
	//폐기 전체 조회
	public List<Disposal> getDisposalList(String martCode);
	
	//폐기 검색(오대성)
	public List<Disposal> getDisposalBySearch(String searchKey, String searchValue, String martCode, String startDt, String endDt);
	
}
