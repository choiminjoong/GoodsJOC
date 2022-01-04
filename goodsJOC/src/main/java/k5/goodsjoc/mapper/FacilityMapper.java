package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Showcase;

@Mapper
public interface FacilityMapper {

	//판매진열대 전체 조회
	public List<Showcase> getShowcaseList();

}
