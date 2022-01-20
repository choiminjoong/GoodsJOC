package k5.goodsjoc.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Mart;
import k5.goodsjoc.mapper.MartMapper;

@Service
@Transactional
public class MartService {
	
	private MartMapper martMapper;
	public MartService(MartMapper martMapper) {
		this.martMapper = martMapper;
	}

	
	public int updateMartInfo(Mart mart) {
		
		return martMapper.updateMartInfo(mart);
	}
	
	//매장정보 조회
	public Mart getMartInfoByMartCode(String martCode) {

		return martMapper.getMartInfoByMartCode(martCode);
	}

	//마트코드 사용여부체크
	public int martCodeCheck(String martCode) {
		int result = 0;
		result += martMapper.martCodeCheck(martCode);	
		
		return result;
	}

	//매장 등록처리
	public int martInsertAction(Mart mart) {
		return martMapper.martInsertAction(mart);
	}


	public List<Mart> getMartList() {
		return martMapper.getMartList();
	}


	public List<Mart> getMartSearchList(Map<String, Object> paramMap) {
		return martMapper.getMartSearchList(paramMap);
	}
	
}
