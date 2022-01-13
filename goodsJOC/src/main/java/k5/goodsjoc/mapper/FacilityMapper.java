package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Shelf;
import k5.goodsjoc.dto.Showcase;
import k5.goodsjoc.dto.Warehouse;

@Mapper
public interface FacilityMapper {
	
	//창고정보 조회
	public List<Warehouse> getWarehouseList(String martCode);
	//판매진열대 전체 조회
	public List<Showcase> getShowcaseList(String martCode);
	//창고 목록 조회
	public List<Warehouse> getWarehouseListByMartCode(String martCode);

	//창고 등록
	public int warehouseInsert(Warehouse warehouse);
	//창고 진열대 등록
	public int shelfInsert(Shelf shelf);
	//판매 진열대 등록
	public int showcaseInsert(Showcase showcase);
	
	//창고,창고진열대,창고구분 검색(오대성)
	public List<Warehouse> getSearchWarehouseList(String searchWarehouse, String martCode);
	//판매 진열대 검색(오대성)
	public List<Showcase> getSearchShowcaseList(String searchShowcase, String martCode);

}
