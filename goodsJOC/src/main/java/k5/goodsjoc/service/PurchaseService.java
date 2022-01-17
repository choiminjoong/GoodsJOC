package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Purchase;
import k5.goodsjoc.mapper.PurchaseMapper;

@Service
@Transactional
public class PurchaseService {
	
	private final PurchaseMapper purchaseMapper;
	public PurchaseService(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}
	//매입 조회(오대성)
	public List<Purchase> getPurchaseList(String martCode){
		return purchaseMapper.getPurchaseList(martCode);
	}
	//매입 검색
	public List<Purchase> getPurchaseBySearchKey(String searchKey, String searchValue, String martCode, String startDt, String endDt) {
		return purchaseMapper.getPurchaseBySearchKey(searchKey, searchValue, martCode, startDt, endDt);
	}

}
