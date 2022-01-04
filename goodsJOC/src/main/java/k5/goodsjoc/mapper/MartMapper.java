package k5.goodsjoc.mapper;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Mart;

@Mapper
public interface MartMapper {

	//자신의 마트정보 보기 조회(martInfo)
	public Mart getMartInfoByMartCode(String martCode);
	
	
}
