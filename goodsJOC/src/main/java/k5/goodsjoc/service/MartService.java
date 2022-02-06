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
	private final MartMapper martMapper;
	public MartService(MartMapper martMapper) {
		this.martMapper = martMapper;
	}
/**
	01.본인매장 정보조회	02.본인매장 정보수정처리	03.매장 고유코드 사용여부 체크(개발사 입장)	04.매장 등록처리(개발사 입장)
	05.매장 전체조회(개발사 입장)	06.매장 조건조회(개발사 입장)
**/
	//01.본인매장 정보조회
	public Mart getMartInfoByMartCode(String martCode) {
		return martMapper.getMartInfoByMartCode(martCode);
	}	

	//02.본인매장 정보수정처리
	public int updateMartInfo(Mart mart) {
		return martMapper.updateMartInfo(mart);
	}

	//03.매장 고유코드 사용여부 체크(개발사 입장)
	public int martCodeCheck(String martCode) {
		int result = 0;
		result += martMapper.martCodeCheck(martCode);	
		
		return result;
	}

	//04.매장 등록처리(개발사 입장)
	public int martInsertAction(Mart mart) {
		return martMapper.martInsertAction(mart);
	}

	//05.매장 전체조회(개발사 입장)
	public List<Mart> getMartList() {
		return martMapper.getMartList();
	}

	//06.매장 조건조회(개발사 입장)
	public List<Mart> getMartSearchList(Map<String, Object> paramMap) {
		return martMapper.getMartSearchList(paramMap);
	}
	
}
