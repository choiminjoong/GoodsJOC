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
	//매입 조회(오대성)
	public List<Map<String, Object>> getDisplayList(String martCode){
		return displayMapper.getDisplayList(martCode);
	}
	
}