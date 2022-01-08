package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Sales;
import k5.goodsjoc.mapper.SalesMapper;

@Service
@Transactional
public class SalesService {
	
	private final SalesMapper salesMapper;
	public SalesService(SalesMapper salesMapper) {
		this.salesMapper = salesMapper;
	}
	public List<Sales> getSalesList(){
		return salesMapper.getSalesList();
	}
}
