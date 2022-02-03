package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Mart;

@Mapper
public interface MartMapper {
/**
	01.본인매장 정보조회	02.본인매장 정보수정처리	03.매장 고유코드 사용여부 체크(개발사 입장)	04.매장 등록처리(개발사 입장)
	05.매장 전체조회(개발사 입장)	06.매장 조건조회(개발사 입장)
**/
	//01.본인매장 정보조회
	public Mart getMartInfoByMartCode(String martCode);
	
	//02.본인매장 정보수정처리
	public int updateMartInfo(Mart mart);

	//03.매장 고유코드 사용여부 체크(개발사 입장)
	public int martCodeCheck(String martCode);
	
	//04.매장 등록처리(개발사 입장)
	public int martInsertAction(Mart mart);

	//05.매장 전체조회(개발사 입장)
	public List<Mart> getMartList();

	//06.매장 조건조회(개발사 입장)
	public List<Mart> getMartSearchList(Map<String, Object> paramMap);
	
}
