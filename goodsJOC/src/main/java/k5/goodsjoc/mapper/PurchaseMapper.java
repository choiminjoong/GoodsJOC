package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.Purchase;

@Mapper
public interface PurchaseMapper {
	
	//매입전체 조회
	public List<Purchase> getPurchaseList(String martCode);
	
	//매입 검색
	public List<Purchase> getPurchaseBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt);

	//modal 거래명세서 조회
	public List<Purchase> getPurchaseDetailList(String martCode);

	public List<Purchase> getPurchaseListByOrderCode(String orderCode);

	}
