package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Business;
import k5.goodsjoc.mapper.BusinessMapper;

@Service
@Transactional
public class BusinessService {
	
	private final BusinessMapper businessMapper;
	public BusinessService(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}
	
	public List<Business> getBusinessList(String martCode){
		return businessMapper.getBusinessList(martCode);
		
	}	
}
