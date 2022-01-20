package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Mart;

@Mapper
public interface MartMapper {

	//자신의 마트정보 보기 조회(martInfo)
	public Mart getMartInfoByMartCode(String martCode);
	
	//자신의 마트정보 수정하기(martUpdate)
	public int updateMartInfo(Mart mart);

	//마트코드 사용유무 체크
	public int martCodeCheck(String martCode);
	//마트 등록
	public int martInsertAction(Mart mart);
	//마트리스트
	public List<Mart> getMartList();
	//매장 조건검색
	public List<Mart> getMartSearchList(Map<String, Object> paramMap);
}
