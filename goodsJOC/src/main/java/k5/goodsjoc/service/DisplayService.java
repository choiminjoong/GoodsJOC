package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.mapper.DisplayMapper;

@Service
@Transactional
public class DisplayService {
	
	private final DisplayMapper displayMapper;
	public DisplayService(DisplayMapper displayMapper) {
		this.displayMapper = displayMapper;
	}
	//재고이동 조회(오대성)
	public List<Map<String, Object>> getDisplayList(String martCode){
		return displayMapper.getDisplayList(martCode);
	}
	//재고이동 검색
	public List<Map<String, Object>> getDisplayBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt) {
		return displayMapper.getDisplayBySearchKey(searchKey, searchValue, martCode, startDt, endDt);
	}
	
	
	
	
}
