package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.dto.SalesDetail;
import k5.goodsjoc.mapper.SalesMapper;

@Service
@Transactional
public class SalesService {
	
	private final SalesMapper salesMapper;
	public SalesService(SalesMapper salesMapper) {
		this.salesMapper = salesMapper;
	}
	//매출 전체조회
	public List<Sales> getSalesList(){
		return salesMapper.getSalesList();
	}
	
	//매출 조건 검색
	public List<Sales> getSalesListBySearchKey(String searchKey, String searchValue, String startDt, String endDt) {
		return salesMapper.getSalesListBySearchKey(searchKey, searchValue, startDt, endDt);
	}
	
	//영수증 모달
	public List<SalesDetail> getsalesDetailList() {
		return salesMapper.getsalesDetailList();
	}

	
}
